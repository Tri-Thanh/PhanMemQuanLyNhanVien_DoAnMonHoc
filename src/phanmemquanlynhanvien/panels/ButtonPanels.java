package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import phanmemquanlynhanvien.classes.DoanhNghiep;
import phanmemquanlynhanvien.classes.KetNoiDatabase;

import phanmemquanlynhanvien.button.NutChinhSuaNhanVien;
import phanmemquanlynhanvien.button.NutThemNhanVien;
import phanmemquanlynhanvien.button.NutXemDanhSachThanhVienNhom;
import phanmemquanlynhanvien.button.NutXemNhanVien;
import phanmemquanlynhanvien.button.NutXoaNhanVien;
import phanmemquanlynhanvien.frame.NewMainFrame;

public class ButtonPanels extends JPanel implements ActionListener {

    private NutXemNhanVien nutXemNhanVien;
    private NutThemNhanVien nutThemNhanVien;
    private NutXoaNhanVien nutXoaNhanVien;
    private NutChinhSuaNhanVien nutChinhSuaNhanVien;
    private NutXemDanhSachThanhVienNhom nutXemDanhSachThanhVienNhom;
    private List<JButton> danhSachButton;

    private KetNoiDatabase dB;
    private TimKiemPanel timKiemPanel;
    private DanhSachNhanVienPanel danhSachNhanVienPanel;
    private RightPanel rightPanel;
    private DoanhNghiep doanhNghiep;
    private ThemNhanVienPanel themNhanVienPanel;
    private Location location;
    private PanelSize size;
    private ChonNhanVienCapNhat chonNhanVienCapNhatPanel;
    private XoaNhanVienPanel xoaNhanVienPanel;
    private DanhSachThanhVienPanels danhSachThanhVienPanel;

    private final Color disabledColor = Color.DARK_GRAY;
    private final int WIDTH = 300;
    private final int HEIGHT = 1000;

    public ButtonPanels() {
        /**
         * set location (x, y) of ButtonPanels
         */
        location = new Location();
        location.setX(0);
        location.setY(0);

        /**
         * Set size (WIDTH, HEIGHT) of ButtonPanels
         */
        size = new PanelSize();
        size.setWIDTH(300);
        size.setHEIGHT(1000);

        /**
         * Cai dat thong so cua ButtonsPanels
         */
        this.setLayout(null);
        this.setBounds(location.getX(), location.getY(), size.getWIDTH(), size.getHEIGHT());

        /**
         * Khoi tao 5 doi tuong cua 5 nut bam va them vao ButtonPanels
         */
        nutXemNhanVien = new NutXemNhanVien();
        nutXemNhanVien.addActionListener(this);
        this.add(nutXemNhanVien);

        nutThemNhanVien = new NutThemNhanVien();
        nutThemNhanVien.addActionListener(this);
        this.add(nutThemNhanVien);

        nutXoaNhanVien = new NutXoaNhanVien();
        nutXoaNhanVien.addActionListener(this);
        this.add(nutXoaNhanVien);

        nutChinhSuaNhanVien = new NutChinhSuaNhanVien();
        nutChinhSuaNhanVien.addActionListener(this);
        this.add(nutChinhSuaNhanVien);

        nutXemDanhSachThanhVienNhom = new NutXemDanhSachThanhVienNhom();
        nutXemDanhSachThanhVienNhom.addActionListener(this);
        this.add(nutXemDanhSachThanhVienNhom);

        /**
         * Them cac nut bam vua tao vao danhSachButton
         */
        danhSachButton = new ArrayList<>();
        danhSachButton.add(nutXemNhanVien);
        danhSachButton.add(nutThemNhanVien);
        danhSachButton.add(nutXoaNhanVien);
        danhSachButton.add(nutChinhSuaNhanVien);
        danhSachButton.add(nutXemDanhSachThanhVienNhom);

    }

    /**
     *
     * @return
     */
    public NutXemNhanVien getNutXemNhanVien() {
        return nutXemNhanVien;
    }

    /**
     *
     * @return
     */
    public NutThemNhanVien getNutThemNhanVien() {
        return nutThemNhanVien;
    }

    /**
     *
     * @return
     */
    public NutXoaNhanVien getNutXoaNhanVien() {
        return nutXoaNhanVien;
    }

    /**
     *
     * @return
     */
    public NutChinhSuaNhanVien getNutChinhSuaNhanVien() {
        return nutChinhSuaNhanVien;
    }

    /**
     *
     * @return
     */
    public NutXemDanhSachThanhVienNhom getNutXemDanhSachThanhVienNhom() {
        return nutXemDanhSachThanhVienNhom;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        /**
         * Neu nhan nutXemNhanVien: - rightPanel se hien thi timKiemPanel &
         * DanhSanhNhanVienPanel - khi chon 1 item trong o phongBan,
         * DanhSachNhanVienPanel se hien thi lai danh sach - khi chon 1 item
         * trong o maNhanVien, DanhSachNhanVienPanel se hien thi lai danh sach -
         * khi nhan nut tim kiem, DanhSachNhanVienPanel se hien thi lai danh
         * sach theo ten da nhap
         */
        if (ae.getSource() == nutXemNhanVien) {
            danhSachNhanVienPanel = new DanhSachNhanVienPanel();
            danhSachNhanVienPanel.taoDanhSachNhanVien(danhSachNhanVienPanel.getBangDanhSachNhanVien());
            danhSachNhanVienPanel.setVisible(true);

            timKiemPanel = new TimKiemPanel();
            timKiemPanel.getTimKiemTheoPb().addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedMaPhongBan = (String) e.getItem();
                    timKiemPanel.getTimKiemTheoMaNhanVien().removeAllItems();
                    try {
                        dB = new KetNoiDatabase();
                        String query = "SELECT ma_nhan_vien FROM danh_sach_nhan_vien WHERE ma_phong_ban = ?";
                        PreparedStatement pstmt = dB.connection.prepareStatement(query);
                        pstmt.setString(1, selectedMaPhongBan);
                        ResultSet rs = pstmt.executeQuery();
                        while (rs.next()) {
                            timKiemPanel.getTimKiemTheoMaNhanVien().addItem(rs.getString("ma_nhan_vien"));
                        }
                        danhSachNhanVienPanel.refreshTable("ma_phong_ban", (String) timKiemPanel.getTimKiemTheoPb().getSelectedItem());
                        timKiemPanel.getTimKiemTheoMaNhanVien().setEnabled(true);
                        timKiemPanel.getTimKiemTheoMaNhanVien().setVisible(true);
                        rs.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            timKiemPanel.getTimKiemTheoMaNhanVien().setVisible(false);
            timKiemPanel.getTimKiemTheoMaNhanVien().addItemListener(e -> {
                danhSachNhanVienPanel.refreshTable("ma_nhan_vien", (String) timKiemPanel.getTimKiemTheoMaNhanVien().getSelectedItem());
            }
            );
            timKiemPanel.getNutTimKiemTheoTen().addActionListener(e -> {
                danhSachNhanVienPanel.refreshTableAndFindNameEmp("ten_nhan_vien", timKiemPanel.getTimKiemTheoTen().getText());
            });

            disabledButtonClicked(nutXemNhanVien);

            rightPanel = new RightPanel(timKiemPanel, (JPanel) danhSachNhanVienPanel);

            NewMainFrame mainFrame = (NewMainFrame) SwingUtilities.getWindowAncestor(ButtonPanels.this);
            mainFrame.changePanel(rightPanel);
        }

        if (ae.getSource() == nutThemNhanVien) {
            disabledButtonClicked(nutThemNhanVien);
            
            themNhanVienPanel = new ThemNhanVienPanel();

            rightPanel = new RightPanel(themNhanVienPanel);
            NewMainFrame mainFrame = (NewMainFrame) SwingUtilities.getWindowAncestor(ButtonPanels.this);
            mainFrame.changePanel(rightPanel);
        }

        if (ae.getSource() == nutXoaNhanVien) {
            disabledButtonClicked(nutXoaNhanVien);

            xoaNhanVienPanel = new XoaNhanVienPanel();

            rightPanel = new RightPanel(xoaNhanVienPanel);

            NewMainFrame mainFrame = (NewMainFrame) SwingUtilities.getWindowAncestor(ButtonPanels.this);
            mainFrame.changePanel(rightPanel);

        }

        if (ae.getSource() == nutChinhSuaNhanVien) {
            disabledButtonClicked(nutChinhSuaNhanVien);

            chonNhanVienCapNhatPanel = new ChonNhanVienCapNhat();

            rightPanel = new RightPanel(chonNhanVienCapNhatPanel);

            NewMainFrame mainFrame = (NewMainFrame) SwingUtilities.getWindowAncestor(ButtonPanels.this);
            mainFrame.changePanel(rightPanel);
        }

        if (ae.getSource() == nutXemDanhSachThanhVienNhom) {
            disabledButtonClicked(nutXemDanhSachThanhVienNhom);

            danhSachThanhVienPanel = new DanhSachThanhVienPanels();

            rightPanel = new RightPanel(danhSachThanhVienPanel);

            NewMainFrame mainFrame = (NewMainFrame) SwingUtilities.getWindowAncestor(ButtonPanels.this);
            mainFrame.changePanel(rightPanel);
        }

    }

    /**
     *
     * @param buttonClicked
     */
    public void disabledButtonClicked(JButton buttonClicked) {
//        Component[] components = this.getComponents();
//        for (Component component : this.getComponents()) {
//            if (component instanceof JButton && component != buttonClicked) {
//                component.setBackground(null);
//                component.setEnabled(true);
//            } else {
//                buttonClicked.setBackground(disabledColor);
//                buttonClicked.setEnabled(false);
//            }
//        }
        /**
         * Neu button truyen vao la mot trong cac nut bam thi: nut bam disabled
         */
        for (int i = 0; i < danhSachButton.size(); i++) {
            if (danhSachButton.get(i).equals(buttonClicked)) {
                danhSachButton.get(i).setEnabled(false);
                danhSachButton.get(i).setBackground(disabledColor);
                danhSachButton.get(i).setOpaque(true);
            } else {
                danhSachButton.get(i).setEnabled(true);
                danhSachButton.get(i).setBackground(null);
                danhSachButton.get(i).setOpaque(false);
            }
        }
    }
}
