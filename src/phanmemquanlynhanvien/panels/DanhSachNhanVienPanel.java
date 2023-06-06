package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import phanmemquanlynhanvien.classes.KetNoiDatabase;

public class DanhSachNhanVienPanel extends JPanel {

    private JTable bangDanhSachNhanVien;
    private JScrollPane scrollPane;
    private KetNoiDatabase dB;

    public DanhSachNhanVienPanel() {
        this.setBounds(0, 200, 1200, 800);
        this.setLayout(null);
        
        /*
        bangDanhSachNhanVien:
            - chua thong tin ve nhan vien
         */
        bangDanhSachNhanVien = new JTable();
        
        /**
         * scrollPane:
         *  - chua bangDanhSachNhanVien
         */
        scrollPane = new JScrollPane();
        
    }

    /**
     * 
     * @param bangDanhSachNhanVien 
     */
    public void setBangDanhSachNhanVien(JTable bangDanhSachNhanVien) {
        this.bangDanhSachNhanVien = bangDanhSachNhanVien;
    }
    
    /**
     * 
     * @return 
     */
    public JTable getBangDanhSachNhanVien() {
        return bangDanhSachNhanVien;
    }
    
    /*
    taoDanhSachNhanVien
     */
    public void taoDanhSachNhanVien(JTable table) {
        try {
            table = new JTable();
            dB = new KetNoiDatabase();
            ResultSet rs = dB.statement.executeQuery("SELECT * FROM danh_sach_nhan_vien");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1190, 760);

        this.add(scrollPane);
    }

    /*
    refreshTable(): display database base on selected Item in JComboBox
     */
    public void refreshTable(String column, String selectedItem) {

        String query = "SELECT * FROM danh_sach_nhan_vien WHERE " + column + " = '" + selectedItem + "'";
        try {
            dB = new KetNoiDatabase();
            ResultSet rs = dB.statement.executeQuery(query);
            bangDanhSachNhanVien.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scrollPane.setViewportView(bangDanhSachNhanVien);
        System.out.println("TRUE");
    }

    public void refreshTableAndFindNameEmp(String column, String textField) {
        String query = "SELECT * FROM danh_sach_nhan_vien WHERE lower(" + column + ") LIKE '%" + textField.toLowerCase() + "%' ";

        try {
            dB = new KetNoiDatabase();
            ResultSet rs = dB.statement.executeQuery(query);
            bangDanhSachNhanVien.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scrollPane.setViewportView(bangDanhSachNhanVien);
    }
    
    /**
     *
     * @param newPanel
     */
    public void changeBangDanhSachNhanVien(JTable newBangDanhSachNhanVien) {
        this.remove(bangDanhSachNhanVien);
        bangDanhSachNhanVien = (JTable) newBangDanhSachNhanVien;
        this.taoDanhSachNhanVien(newBangDanhSachNhanVien);

        // refresh JFrame
        revalidate();
        repaint();
    }
}
