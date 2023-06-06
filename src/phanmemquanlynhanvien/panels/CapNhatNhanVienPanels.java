package phanmemquanlynhanvien.panels;

import phanmemquanlynhanvien.panels.ChonNhanVienCapNhat;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JPanel;
import phanmemquanlynhanvien.classes.KetNoiDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import phanmemquanlynhanvien.panels.ThemNhanVienPanel;

public class CapNhatNhanVienPanels extends JPanel implements ActionListener {

    private String selectedPb, selectedMaNhanVien;

    private ThemNhanVienPanel capNhatNhanVien;
    private KetNoiDatabase dB;

    public CapNhatNhanVienPanels(String selectedPb, String selectedMaNhanVien) {

        dB = new KetNoiDatabase();
        this.selectedPb = selectedPb;
        this.selectedMaNhanVien = selectedMaNhanVien;

        this.setBounds(0, 0, 1200, 1000);
        this.setLayout(null);

        capNhatNhanVien = new ThemNhanVienPanel();
        capNhatNhanVien.setBounds(0, 0, 1200, 1000);
        capNhatNhanVien.getHeading().setText("CAP NHAT NHAN VIEN");
        try {
            String query = "SELECT * FROM danh_sach_nhan_vien WHERE ma_nhan_vien = ?";

            PreparedStatement preStatement = dB.connection.prepareStatement(query);
            preStatement.setString(1, selectedMaNhanVien);
            ResultSet rs = preStatement.executeQuery();
            if (rs.next()) {
                capNhatNhanVien.getChonPhongBan().setSelectedItem(rs.getString("ma_phong_ban"));
                capNhatNhanVien.getTenNhanVienTF().setText(rs.getString("ten_nhan_vien"));
                capNhatNhanVien.getMaNhanVien().setText(rs.getString("ma_nhan_vien"));
                capNhatNhanVien.getMaDinhDanh().setText(rs.getString("ma_dinh_danh"));
                capNhatNhanVien.getChonGioiTinh().setSelectedItem(rs.getString("gioi_tinh"));
                capNhatNhanVien.getDienSDT().setText(rs.getString("so_dien_thoai"));
                capNhatNhanVien.getDienDiaChi().setText(rs.getString("dia_chi"));
                capNhatNhanVien.getChonChucVu().setSelectedItem(rs.getString("chuc_vu"));

                capNhatNhanVien.getNutReset().setText("Tro ve");
                capNhatNhanVien.getNutReset().removeActionListener(capNhatNhanVien);
                capNhatNhanVien.getNutReset().addActionListener(this);

                capNhatNhanVien.getNutThemNhanVien().setText("Cap nhat");
                capNhatNhanVien.getNutThemNhanVien().removeActionListener(capNhatNhanVien);
                capNhatNhanVien.getNutThemNhanVien().addActionListener(this);

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.add(capNhatNhanVien);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == capNhatNhanVien.getNutReset()) {
            Container container = this.getParent();

            ChonNhanVienCapNhat chonNhanVien = new ChonNhanVienCapNhat();
            container.remove(this);
            container.add(chonNhanVien);
            container.validate();
            container.repaint();
        }

        if (ae.getSource() == capNhatNhanVien.getNutThemNhanVien()) {
            String query = "UPDATE danh_sach_nhan_vien "
                    + "SET ma_nhan_vien = ?,"
                    + "ma_dinh_danh = ?,"
                    + "ten_nhan_vien = ?,"
                    + "ngay_sinh = ?,"
                    + "gioi_tinh = ?,"
                    + "chuc_vu  = ?,"
                    + "ngay_vao_lam = ?,"
                    + "so_dien_thoai = ?,"
                    + "dia_chi = ?,"
                    + "ma_phong_ban = ?,"
                    + "luong_co_ban = ? "
                    + "WHERE ma_nhan_vien = ?";
            try {
                PreparedStatement preStatement = dB.connection.prepareStatement(query);
                preStatement.setString(1, (String) capNhatNhanVien.getMaNhanVien().getText());
                preStatement.setString(2, (String) capNhatNhanVien.getMaDinhDanh().getText());
                preStatement.setString(3, (String) capNhatNhanVien.getTenNhanVienTF().getText());
                preStatement.setString(4, (String) capNhatNhanVien.getChonNgaySinh().getSelectedItem()
                        + "/" + (String) capNhatNhanVien.getChonThangSinh().getSelectedItem()
                        + "/" + (String) capNhatNhanVien.getChonNamSinh().getSelectedItem());
                preStatement.setString(5, (String) capNhatNhanVien.getChonGioiTinh().getSelectedItem());
                preStatement.setString(6, (String) capNhatNhanVien.getChonChucVu().getSelectedItem());
                preStatement.setString(7, (String) capNhatNhanVien.getChonNgayVaoLam().getSelectedItem()
                        + "/" + (String) capNhatNhanVien.getChonThangVaoLam().getSelectedItem()
                        + "/" + (String) capNhatNhanVien.getChonNamVaoLam().getSelectedItem());
                preStatement.setString(8, (String) capNhatNhanVien.getDienSDT().getText());
                preStatement.setString(9, (String) capNhatNhanVien.getDienDiaChi().getText());
                preStatement.setString(10, (String) capNhatNhanVien.getChonPhongBan().getSelectedItem());
                preStatement.setString(11, (String) capNhatNhanVien.getLuongCoBan().getText());
                preStatement.setString(12, (String) capNhatNhanVien.getMaNhanVien().getText());
                preStatement.executeUpdate();

                JOptionPane.showMessageDialog(null,"CAP NHAT THANH CONG");
                
                Container container = this.getParent();

                ChonNhanVienCapNhat chonNhanVien = new ChonNhanVienCapNhat();
                container.remove(this);
                container.add(chonNhanVien);
                container.validate();
                container.repaint();
                
            } catch (SQLException ex) {
                Logger.getLogger(CapNhatNhanVienPanels.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
