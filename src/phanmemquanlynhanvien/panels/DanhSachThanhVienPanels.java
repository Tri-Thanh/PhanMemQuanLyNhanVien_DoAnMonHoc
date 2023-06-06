package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import phanmemquanlynhanvien.classes.ThanhVienNhom;

public class DanhSachThanhVienPanels extends JPanel {

    private HashMap<String, String> danhSachThanhVien;
    private JLabel tenLb, maSinhVienLb;
    private JLabel tenThanhVienLb, maSinhVienThanhVienLb;
    private Location location;
    private PanelSize size;
    private ThanhVienNhom thanhVien;

    private final String[] DANH_SACH_TEN_THANH_VIEN = {"Le Tri Thanh", "Nguyen Ba Tan", "Phan Van Tam", "Le Tuan Hung", "Le Dai Hung"};
    private final String[] DANH_SACH_MA_SINH_VIEN = {"N19DCVT061", "N19DCVT052", "N19DCVT050", "N19DCVT015", "N19DCVT014"};
    private final int LB_WIDTH = 600;
    private final int LB_HEIGHT = 180;
    private final int HEADING_HEGHT = 100;
    private final Font LB_FONT = new Font("San Serif", Font.BOLD, 40);
    private final Color LB_BACKGROUND = Color.CYAN;
    private final Color LB_FOREGROUND = Color.BLACK;
    private final LineBorder LB_LINE_BORDER = new LineBorder(Color.BLACK, 3);

    private int TEN_THANH_LB_X = 0;
    private int TEN_THANH_VIEN_LABEL_Y = 100;
    private int MA_SINH_VIEN_LB_X = 600;
    private int MA_SINH_VIEN_LB_Y = 100;

    public DanhSachThanhVienPanels() {
        /**
         * tao danh sach thanh vien: Key: MSSV Value: Ten Sinh vien
         */
        danhSachThanhVien = new HashMap<>();
        for (int i = 0; i < DANH_SACH_MA_SINH_VIEN.length; i++) {
            thanhVien = new ThanhVienNhom();
            thanhVien.setMaSinhVien(DANH_SACH_MA_SINH_VIEN[i]);
            thanhVien.setTenSinhVien(DANH_SACH_TEN_THANH_VIEN[i]);
            danhSachThanhVien.put(thanhVien.getMaSinhVien(), thanhVien.getTenSinhVien());
        }

        /**
         * set size of DanhSachThanhVienPanels
         */
        size = new PanelSize();
        size.setWIDTH(1200);
        size.setHEIGHT(1000);
        this.setSize(size.getWIDTH(), size.getHEIGHT());

        /**
         * Set location of DanhSachThanhVienPanels
         */
        location = new Location();
        location.setX(0);
        location.setY(0);
        this.setLocation(location.getX(), location.getY());

        /**
         * Set layout of DanhSachThanhVienPanels
         */
        this.setLayout(null);

        /**
         * tenLb
         */
        tenLb = new JLabel("TEN THANH VIEN");
        tenLb.setBounds(0, 0, LB_WIDTH, HEADING_HEGHT);
        tenLb.setFont(LB_FONT);
        tenLb.setHorizontalAlignment(JLabel.CENTER);
        tenLb.setBackground(LB_BACKGROUND);
        tenLb.setOpaque(true);
        tenLb.setForeground(LB_FOREGROUND);
        tenLb.setBorder(LB_LINE_BORDER);
        this.add(tenLb);

        /**
         * maSinhVienLb
         */
        maSinhVienLb = new JLabel("MSSV");
        maSinhVienLb.setBounds(600, 0, LB_WIDTH, HEADING_HEGHT);
        maSinhVienLb.setFont(LB_FONT);
        maSinhVienLb.setHorizontalAlignment(JLabel.CENTER);
        maSinhVienLb.setBackground(LB_BACKGROUND);
        maSinhVienLb.setOpaque(true);
        maSinhVienLb.setForeground(LB_FOREGROUND);
        maSinhVienLb.setBorder(LB_LINE_BORDER);
        this.add(maSinhVienLb);

        configureTenThanhVienLb(danhSachThanhVien);
        configureMaSinhVienLb(danhSachThanhVien);
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getDanhSachThanhVien() {
        return danhSachThanhVien;
    }

    /**
     *
     * @param danhSachThanhVien
     */
    public void setDanhSachThanhVien(HashMap<String, String> danhSachThanhVien) {
        this.danhSachThanhVien = danhSachThanhVien;
    }

    /**
     *
     * @param danhSachThanhVien
     */
    private void configureTenThanhVienLb(HashMap<String, String> danhSachThanhVien) {
        for (String tenThanhVien : danhSachThanhVien.values()) {
            tenThanhVienLb = new JLabel(tenThanhVien);
            tenThanhVienLb.setBounds(TEN_THANH_LB_X, TEN_THANH_VIEN_LABEL_Y, LB_WIDTH, LB_HEIGHT);
            tenThanhVienLb.setFont(LB_FONT);
            tenThanhVienLb.setHorizontalAlignment(JLabel.CENTER);
            tenThanhVienLb.setBackground(LB_BACKGROUND);
            tenThanhVienLb.setOpaque(true);
            tenThanhVienLb.setForeground(LB_FOREGROUND);
            tenThanhVienLb.setBorder(LB_LINE_BORDER);
            TEN_THANH_VIEN_LABEL_Y += LB_HEIGHT;
            this.add(tenThanhVienLb);
        }
    }

    private void configureMaSinhVienLb(HashMap<String, String> danhSachNhanVien) {
        for (String maSinhVien : danhSachThanhVien.keySet()) {
            maSinhVienThanhVienLb = new JLabel(maSinhVien);
            maSinhVienThanhVienLb.setBounds(MA_SINH_VIEN_LB_X, MA_SINH_VIEN_LB_Y, LB_WIDTH, LB_HEIGHT);
            maSinhVienThanhVienLb.setFont(LB_FONT);
            maSinhVienThanhVienLb.setHorizontalAlignment(JLabel.CENTER);
            maSinhVienThanhVienLb.setBackground(LB_BACKGROUND);
            maSinhVienThanhVienLb.setOpaque(true);
            maSinhVienThanhVienLb.setForeground(LB_FOREGROUND);
            maSinhVienThanhVienLb.setBorder(LB_LINE_BORDER);
            this.add(maSinhVienThanhVienLb);
            MA_SINH_VIEN_LB_Y += LB_HEIGHT;
        }
    }
}
