/**
 * ThemNhanVienPanel:
 *      - Cho nguoi dung nhap cac thong tin cua nhan vien
 *      - nutThem: nhan nutThem, cac thong tin da nhap se duoc luu vao co so du lieu
 *      - nutReset: reset cac thong tin da nhap
 */
package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import phanmemquanlynhanvien.classes.KetNoiDatabase;

public class ThemNhanVienPanel extends JPanel implements ActionListener {

    private JComboBox chonPhongBan,
            chonNgaySinh, chonThangSinh, chonNamSinh, chonGioiTinh,
            chonNgayVaoLam, chonThangVaoLam, chonNamVaoLam,
            chonChucVu;
    private JLabel heading,
            chonPhongBanLabel, tenNhanVienLabel,
            maNhanVienLabel, maNhanVien,
            maDinhDanhLabel, maDinhDanh,
            ngaySinhLabel, gioiTinhLabel,
            sdtLabel, ngayVaoLamLabel,
            chucVuLabel, luongCoBanLabel, luongCoBan,
            diaChiLabel;
    private JTextField tenNhanVienTF,
            dienMaNhanVien, dienMaDinhDanh,
            dienSDT, dienDiaChi;

    private JButton nutThemNhanVien, nutResetThongTin;
    private Location location;
    private PanelSize panelSize;

    private final int DEFAULT_HEIGHT = 100;
    private final int LABEL_WIDTH = 200;
    private final int TF_WIDTH = 350;
    private final String TEXT_FONT = "San Serif";
    private final int TEXT_SIZE = 30;
    private final int STEP = 40;
    private final int SPACING = 25;
    private final Font DEFAULT_TEXT_FONT = new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE);

    private Random random;
    private String[] dsPhongBan = {"IT", "HR", "MKT",
        "SALE", "SEC", "ACT"};
    private final String[] dsChucVu = {"Nhan vien", "Leader", "Pho Phong", "Truong Phong"};
    private final String[] gioiTinh = {"Nam", "Nu"};
    private String[] ngay;
    private String[] thang;
    private String[] nam;
    private String[] namHoatDong;
    private String ma_phong_ban, ten_nhan_vien,
            ma_nhan_vien, ma_dinh_danh,
            ngay_sinh, gioi_tinh,
            chuc_vu, ngay_vao_lam,
            so_dien_thoai, luong_co_ban,
            dia_chi;

    public ThemNhanVienPanel() {
        random = new Random();

        /**
         * Set location of ThemNhanVienPanel
         */
        location = new Location();
        location.setX(00);
        location.setY(0);
        /**
         * Set size of ThemNhanVienPanel
         */
        panelSize = new PanelSize();
        panelSize.setWIDTH(1200);
        panelSize.setHEIGHT(1000);

        ngay = new String[30];
        taoNgayThangNam(ngay);
        thang = new String[12];
        taoNgayThangNam(thang);
        nam = new String[66];
        taoNgayThangNam(nam);
        namHoatDong = new String[24];
        taoNgayThangNam(namHoatDong);

        this.setBounds(location.getX(), location.getY(), panelSize.getWIDTH(), panelSize.getHEIGHT());
        this.setLayout(null);

        nutThemNhanVien = new JButton("XAC NHAN");
        this.add(nutThemNhanVien);

        heading = new JLabel("THEM NHAN VIEN");
        heading.setBounds(300, 0, LABEL_WIDTH + 400, DEFAULT_HEIGHT);
        heading.setFont(new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE + 20));
        heading.setHorizontalAlignment(JLabel.CENTER);
        this.add(heading);

        /*
        1st Row
            - include: chon phong ban va ten nhan vien
         */
        chonPhongBanLabel = new JLabel("Phong Ban");
        chonPhongBanLabel.setBounds(0, 100 + STEP, LABEL_WIDTH, DEFAULT_HEIGHT);
        chonPhongBanLabel.setFont(DEFAULT_TEXT_FONT);
        chonPhongBanLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(chonPhongBanLabel);

        chonPhongBan = new JComboBox(dsPhongBan);
        chonPhongBan.setFont(DEFAULT_TEXT_FONT);
        chonPhongBan.setBounds(200, 100 + STEP, TF_WIDTH, 100);
        chonPhongBan.setBackground(Color.WHITE);
        chonPhongBan.addActionListener(e -> {
            String chonPB = (String) chonPhongBan.getSelectedItem();
            int randomNumber = random.nextInt(900000) + 100000;
            maNhanVien.setText(chonPB + randomNumber);
            maNhanVien.setForeground(Color.red);
        });
        chonPhongBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLuongCoBan(luongCoBan);
            }
        });
        this.add(chonPhongBan);

        tenNhanVienLabel = new JLabel("Ten");
        tenNhanVienLabel.setBounds(550, 100 + STEP, LABEL_WIDTH, DEFAULT_HEIGHT);
        tenNhanVienLabel.setHorizontalAlignment(JLabel.CENTER);
        tenNhanVienLabel.setFont(DEFAULT_TEXT_FONT);
        this.add(tenNhanVienLabel);

        tenNhanVienTF = new JTextField();
        tenNhanVienTF.setBounds(750, 100 + STEP, TF_WIDTH, DEFAULT_HEIGHT);
        tenNhanVienTF.setFont(DEFAULT_TEXT_FONT);
        this.add(tenNhanVienTF);

        /*
        2nd Row: include maNhanVien va maDinhDanh
         */
        maNhanVienLabel = new JLabel("Ma Nhan Vien");
        maNhanVienLabel.setBounds(0, 200 + STEP + SPACING, LABEL_WIDTH, DEFAULT_HEIGHT);
        maNhanVienLabel.setFont(DEFAULT_TEXT_FONT);
        maNhanVienLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(maNhanVienLabel);

        maNhanVien = new JLabel();
        maNhanVien.setBounds(LABEL_WIDTH, 200 + STEP + SPACING, TF_WIDTH, DEFAULT_HEIGHT);
        maNhanVien.setFont(DEFAULT_TEXT_FONT);
        maNhanVien.setHorizontalAlignment(JLabel.CENTER);
        this.add(maNhanVien);

        maDinhDanhLabel = new JLabel("Ma Dinh Danh");
        maDinhDanhLabel.setBounds(LABEL_WIDTH + TF_WIDTH, 200 + STEP + SPACING,
                LABEL_WIDTH, DEFAULT_HEIGHT);
        maDinhDanhLabel.setFont(DEFAULT_TEXT_FONT);
        maDinhDanhLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(maDinhDanhLabel);

        maDinhDanh = new JLabel();
        taoMaDinhDanh(maDinhDanh);
        maDinhDanh.setBounds(2 * LABEL_WIDTH + TF_WIDTH, 200 + STEP + SPACING,
                TF_WIDTH, DEFAULT_HEIGHT);
        maDinhDanh.setFont(DEFAULT_TEXT_FONT);
        maDinhDanh.setHorizontalAlignment(JLabel.CENTER);
        maDinhDanh.setForeground(Color.red);
        this.add(maDinhDanh);

        /*
        3rd Row: ngaySinh va gioiTinh
         */
        ngaySinhLabel = new JLabel("Ngay Sinh");
        ngaySinhLabel.setBounds(0, 3 * DEFAULT_HEIGHT + STEP + SPACING, LABEL_WIDTH, DEFAULT_HEIGHT);
        ngaySinhLabel.setFont(DEFAULT_TEXT_FONT);
        ngaySinhLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(ngaySinhLabel);

        chonNgaySinh = new JComboBox(ngay);
        chonNgaySinh.setBounds(LABEL_WIDTH, 3 * DEFAULT_HEIGHT + STEP + SPACING,
                100, DEFAULT_HEIGHT);
        chonNgaySinh.setFont(DEFAULT_TEXT_FONT);
        chonNgaySinh.setBackground(Color.WHITE);
        this.add(chonNgaySinh);

        chonThangSinh = new JComboBox(thang);
        chonThangSinh.setBounds(LABEL_WIDTH + 115, 3 * DEFAULT_HEIGHT + STEP + SPACING,
                100, DEFAULT_HEIGHT);
        chonThangSinh.setFont(DEFAULT_TEXT_FONT);
        chonThangSinh.setBackground(Color.WHITE);
        this.add(chonThangSinh);

        chonNamSinh = new JComboBox(nam);
        chonNamSinh.setBounds(LABEL_WIDTH + 230, 3 * DEFAULT_HEIGHT + STEP + SPACING,
                100, DEFAULT_HEIGHT);
        chonNamSinh.setSelectedIndex(65);
        chonNamSinh.setFont(DEFAULT_TEXT_FONT);
        chonNamSinh.setBackground(Color.WHITE);
        this.add(chonNamSinh);

        gioiTinhLabel = new JLabel("Gioi Tinh");
        gioiTinhLabel.setBounds(LABEL_WIDTH + TF_WIDTH, 3 * DEFAULT_HEIGHT + STEP + SPACING,
                LABEL_WIDTH, DEFAULT_HEIGHT);
        gioiTinhLabel.setFont(DEFAULT_TEXT_FONT);
        gioiTinhLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(gioiTinhLabel);

        chonGioiTinh = new JComboBox(gioiTinh);
        chonGioiTinh.setBounds(2 * LABEL_WIDTH + TF_WIDTH, 3 * DEFAULT_HEIGHT + STEP + SPACING,
                LABEL_WIDTH, DEFAULT_HEIGHT);
        chonGioiTinh.setFont(DEFAULT_TEXT_FONT);
        chonGioiTinh.setBackground(Color.WHITE);
        this.add(chonGioiTinh);

        /*
        4th Row: gom so dien thoai va ngay vao lam
         */
        sdtLabel = new JLabel("SDT");
        sdtLabel.setBounds(0, (4 * DEFAULT_HEIGHT) + STEP + 2 * SPACING, LABEL_WIDTH, DEFAULT_HEIGHT);
        sdtLabel.setFont(DEFAULT_TEXT_FONT);
        sdtLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(sdtLabel);

        dienSDT = new JTextField("0");
        dienSDT.setBounds(LABEL_WIDTH, 4 * DEFAULT_HEIGHT + STEP + 2 * SPACING, TF_WIDTH, DEFAULT_HEIGHT);
        dienSDT.setFont(DEFAULT_TEXT_FONT);
        dienSDT.setHorizontalAlignment(JLabel.LEFT);
        this.add(dienSDT);

        ngayVaoLamLabel = new JLabel("Ngay Vao Lam");
        ngayVaoLamLabel.setBounds(LABEL_WIDTH + TF_WIDTH, 4 * DEFAULT_HEIGHT + STEP + 2 * SPACING,
                LABEL_WIDTH, DEFAULT_HEIGHT);
        ngayVaoLamLabel.setFont(new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE - 5));
        ngayVaoLamLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(ngayVaoLamLabel);

        chonNgayVaoLam = new JComboBox(ngay);
        chonNgayVaoLam.setBounds(2 * LABEL_WIDTH + TF_WIDTH, 4 * DEFAULT_HEIGHT + STEP + 2 * SPACING,
                100, DEFAULT_HEIGHT);
        chonNgayVaoLam.setFont(DEFAULT_TEXT_FONT);
        chonNgayVaoLam.setBackground(Color.WHITE);
        this.add(chonNgayVaoLam);

        chonThangVaoLam = new JComboBox(thang);
        chonThangVaoLam.setBounds(2 * LABEL_WIDTH + TF_WIDTH + 115, 4 * DEFAULT_HEIGHT + STEP + 2 * SPACING,
                100, DEFAULT_HEIGHT);
        chonThangVaoLam.setFont(DEFAULT_TEXT_FONT);
        chonThangVaoLam.setBackground(Color.WHITE);
        this.add(chonThangVaoLam);

        chonNamVaoLam = new JComboBox(namHoatDong);
        chonNamVaoLam.setBounds(2 * LABEL_WIDTH + TF_WIDTH + 230, 4 * DEFAULT_HEIGHT + STEP + 2 * SPACING,
                100, DEFAULT_HEIGHT);
        chonNamVaoLam.setSelectedIndex(23);
        chonNamVaoLam.setFont(DEFAULT_TEXT_FONT);
        chonNamVaoLam.setBackground(Color.WHITE);
        this.add(chonNamVaoLam);

        /*
        5th: bao gom chuc vu va luong co ban
         */
        chucVuLabel = new JLabel("Chuc Vu");
        chucVuLabel.setBounds(0, 5 * DEFAULT_HEIGHT + STEP + 3 * SPACING, LABEL_WIDTH, DEFAULT_HEIGHT);
        chucVuLabel.setFont(DEFAULT_TEXT_FONT);
        chucVuLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(chucVuLabel);

        chonChucVu = new JComboBox(dsChucVu);
        chonChucVu.setBounds(LABEL_WIDTH, 5 * DEFAULT_HEIGHT + STEP + 3 * SPACING, TF_WIDTH, DEFAULT_HEIGHT);
        chonChucVu.setFont(DEFAULT_TEXT_FONT);
        chonChucVu.setBackground(Color.WHITE);
        chonChucVu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLuongCoBan(luongCoBan);
            }
        });
        this.add(chonChucVu);

        luongCoBanLabel = new JLabel("LuongCoBan");
        luongCoBanLabel.setBounds(TF_WIDTH + LABEL_WIDTH, 5 * DEFAULT_HEIGHT + STEP + 3 * SPACING,
                LABEL_WIDTH, DEFAULT_HEIGHT);
        luongCoBanLabel.setFont(DEFAULT_TEXT_FONT);
        luongCoBanLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(luongCoBanLabel);

        luongCoBan = new JLabel();
        luongCoBan.setBounds(TF_WIDTH + 2 * LABEL_WIDTH, 5 * DEFAULT_HEIGHT + STEP + 3 * SPACING,
                TF_WIDTH, DEFAULT_HEIGHT);
        luongCoBan.setFont(DEFAULT_TEXT_FONT);
        luongCoBan.setHorizontalAlignment(JLabel.CENTER);
        this.add(luongCoBan);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPhongBan = (String) chonPhongBan.getSelectedItem();
                String selectedChucVu = (String) chonChucVu.getSelectedItem();

                // Calculate the salary based on the selected items
                double soLuongCoBan = 0.0;
                switch (selectedPhongBan) {
                    case "IT":
                        soLuongCoBan += 8000000;
                        break;
                    case "HR":
                        soLuongCoBan += 4000000;
                        break;
                    case "MKT":
                        soLuongCoBan += 4500000;
                        break;
                    case "SALE":
                        soLuongCoBan += 3800000;
                        break;
                    case "SEC":
                        soLuongCoBan += 34000000;
                        break;
                    case "ACT":
                        soLuongCoBan += 4055000;
                        break;
                    default:
                        break;
                }

                switch (selectedChucVu) {
                    case "Nhan Vien":
                        soLuongCoBan += 0;
                        break;
                    case "Leader":
                        soLuongCoBan += soLuongCoBan * 0.1;
                        break;
                    case "Pho Phong":
                        soLuongCoBan += soLuongCoBan * 0.2;
                        break;
                    case "Truong Phong":
                        soLuongCoBan += soLuongCoBan * 0.35;
                        break;
                    default:
                        break;
                }

                // Set the label text based on the selected items and additional conditions
                luongCoBan.setText("" + luongCoBan);
            }
        };

        chonPhongBan.addActionListener(listener);
        chonChucVu.addActionListener(listener);

        /*
        6th Row: gom dia chi
         */
        diaChiLabel = new JLabel("Dia chi");
        diaChiLabel.setBounds(0, 6 * DEFAULT_HEIGHT + STEP + 4 * SPACING, LABEL_WIDTH, DEFAULT_HEIGHT);
        diaChiLabel.setFont(DEFAULT_TEXT_FONT);
        diaChiLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(diaChiLabel);

        dienDiaChi = new JTextField();
        dienDiaChi.setBounds(LABEL_WIDTH, 6 * DEFAULT_HEIGHT + STEP + 4 * SPACING,
                LABEL_WIDTH + 2 * TF_WIDTH, DEFAULT_HEIGHT);
        dienDiaChi.setFont(DEFAULT_TEXT_FONT);
        dienDiaChi.setHorizontalAlignment(JLabel.LEFT);
        dienDiaChi.setBackground(Color.WHITE);
        this.add(dienDiaChi);

        /*
        7th Row: gom nutResetThongTin va nutThemNhanVien
         */
        nutThemNhanVien = new JButton("Xac Nhan");
        nutThemNhanVien.setBounds(2 * LABEL_WIDTH + TF_WIDTH, 7 * DEFAULT_HEIGHT + STEP + 5 * SPACING - 15, LABEL_WIDTH, DEFAULT_HEIGHT);
        nutThemNhanVien.setFont(DEFAULT_TEXT_FONT);
        nutThemNhanVien.setHorizontalAlignment(JLabel.CENTER);
        nutThemNhanVien.setFocusable(false);
        nutThemNhanVien.addActionListener(this);
        this.add(nutThemNhanVien);

        nutResetThongTin = new JButton("RESET");
        nutResetThongTin.setBounds(2 * LABEL_WIDTH - 100, 7 * DEFAULT_HEIGHT + STEP + 5 * SPACING - 15, LABEL_WIDTH, DEFAULT_HEIGHT);
        nutResetThongTin.setFont(DEFAULT_TEXT_FONT);
        nutResetThongTin.setHorizontalAlignment(JLabel.CENTER);
        nutResetThongTin.setFocusable(false);
        nutResetThongTin.addActionListener(this);
        this.add(nutResetThongTin);
    }

    /*
    SETTER
     */
    public void setHeading(JLabel heading) {
        this.heading = heading;
    }

    public void setNutReset(JButton newButton) {
        this.nutResetThongTin = newButton;
    }

    public void setNutXacNhan(JButton newButton) {
        this.nutThemNhanVien = newButton;
    }

    /*
    GETTER
     */
    public JLabel getHeading() {
        return heading;
    }

    public String[] getDanhSachChucVu() {
        return dsChucVu;
    }

    public String[] getDanhSachPb() {
        return dsPhongBan;
    }

    public JComboBox getChonPhongBan() {
        return chonPhongBan;
    }

    public JComboBox getChonNgaySinh() {
        return chonNgaySinh;
    }

    public JComboBox getChonThangSinh() {
        return chonThangSinh;
    }

    public JComboBox getChonNamSinh() {
        return chonNamSinh;
    }

    public JComboBox getChonGioiTinh() {
        return chonGioiTinh;
    }

    public JComboBox getChonNgayVaoLam() {
        return chonNgayVaoLam;
    }

    public JComboBox getChonThangVaoLam() {
        return chonThangVaoLam;
    }

    public JComboBox getChonNamVaoLam() {
        return chonNamVaoLam;
    }

    public JComboBox getChonChucVu() {
        return chonChucVu;
    }

    public JLabel getLuongCoBan() {
        return luongCoBan;
    }

    public JTextField getTenNhanVienTF() {
        return tenNhanVienTF;
    }

    public JLabel getMaNhanVien() {
        return maNhanVien;
    }

    public JLabel getMaDinhDanh() {
        return maDinhDanh;
    }

    public JTextField getDienSDT() {
        return dienSDT;
    }

    public JTextField getDienDiaChi() {
        return dienDiaChi;
    }

    public JButton getNutReset() {
        return nutResetThongTin;
    }

    public JButton getNutThemNhanVien() {
        return nutThemNhanVien;
    }

    /*
    METHOD:
     */
    // taoDinhDanh():
    //    - Tao ngau nhien maDinhDanh: random so  co 12 chu so tu 0 - 9
    //        vd:  012123456789  
    private void taoMaDinhDanh(JLabel label) {
        label.setText("" + (random.nextLong(900000000000L) + 100000000000L));
    }

    /*
    layDanhSachMaNhanVien(): String[]
     */
    public String[] layDanhSachMaNhanVien() {

        ArrayList<String> dsMaNhanVien = new ArrayList<>();
        try {
            String query = "SELECT ma_nhan_vien FROM danh_sach_nhan_vien";
            KetNoiDatabase dB = new KetNoiDatabase();
            ResultSet rs = dB.statement.executeQuery(query);
            while (rs.next()) {
                dsMaNhanVien.add(rs.getString("ma_nhan_vien"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arrayMaNhanVien = new String[dsMaNhanVien.size()];
        dsMaNhanVien.toArray(arrayMaNhanVien);
        return arrayMaNhanVien;
    }

    /*
    Tao Ngay/Thang/Nam sinh de chon
     */ private void taoNgayThangNam(String[] arr) {
        if (arr.length == 30 || arr.length == 12) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1 + "";
            }
        } else if (arr.length == 24) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 2000 + i + "";
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1940 + i + "";
            }
        }
    }

    /*
    resetThongTinNhanVien(): void
     */
    private void resetThongTin() {
        chonPhongBan.setSelectedIndex(0);
        tenNhanVienTF.setText("");
        maNhanVien.setText("");
        taoMaDinhDanh(maDinhDanh);
        chonNgaySinh.setSelectedIndex(0);
        chonThangSinh.setSelectedIndex(0);
        chonNamSinh.setSelectedIndex(0);
        dienSDT.setText("0");
        chonNgayVaoLam.setSelectedIndex(0);
        chonThangVaoLam.setSelectedIndex(0);
        chonNamVaoLam.setSelectedIndex(0);
        chonChucVu.setSelectedIndex(0);
        luongCoBan.setText("");
        dienDiaChi.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nutResetThongTin) {
            resetThongTin();
        }

        if (ae.getSource() == nutThemNhanVien) {
            ma_phong_ban = (String) chonPhongBan.getSelectedItem();
            ten_nhan_vien = tenNhanVienTF.getText();
            ma_nhan_vien = maNhanVien.getText();
            ma_dinh_danh = maDinhDanh.getText();
            gioi_tinh = (String) chonGioiTinh.getSelectedItem();
            ngay_sinh = (String) chonNgaySinh.getSelectedItem() + "/" + chonThangSinh.getSelectedItem() + "/" + chonNamSinh.getSelectedItem();
            so_dien_thoai = dienSDT.getText();
            ngay_vao_lam = (String) chonNgayVaoLam.getSelectedItem() + "/" + chonThangVaoLam.getSelectedItem() + "/" + chonNamVaoLam.getSelectedItem();
            chuc_vu = (String) chonChucVu.getSelectedItem();
            luong_co_ban = luongCoBan.getText();
            dia_chi = dienDiaChi.getText();
            try {
                KetNoiDatabase dB = new KetNoiDatabase();
                String query = "INSERT INTO danh_sach_nhan_vien "
                        + "VALUES ("
                        + " '" + ma_nhan_vien + "',"
                        + " '" + ma_dinh_danh + "',"
                        + " '" + ten_nhan_vien + "',"
                        + " '" + ngay_sinh + "',"
                        + " '" + gioi_tinh + "',"
                        + " '" + chuc_vu + "',"
                        + " '" + ngay_vao_lam + "',"
                        + " '" + so_dien_thoai + "',"
                        + " '" + dia_chi + "',"
                        + " '" + ma_phong_ban + "',"
                        + " '" + luong_co_ban + "')";
                dB.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "THEM THANH CONG");
                resetThongTin();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param label
     */
    private void setLuongCoBan(JLabel label) {
        long luongCoBan = 0;
        String dieuKien1 = (String) chonChucVu.getSelectedItem();
        String dieuKien2 = (String) chonPhongBan.getSelectedItem();

        switch (dieuKien2) {
            case "IT":
                luongCoBan += 8000000L;
                break;
            case "HR":
                luongCoBan += 4000000L;
                break;
            case "MKT":
                luongCoBan += 4500000L;
                break;
            case "SALE":
                luongCoBan += 3800000L;
                break;
            case "SEC":
                luongCoBan += 3400000L;
                break;
            case "ACT":
                luongCoBan += 4055000L;
                break;
            default:
                break;
        }

        switch (dieuKien1) {
            case "Nhan Vien":
                luongCoBan += 0;
                break;
            case "Leader":
                luongCoBan += (luongCoBan * 10L) / 100L;
                break;
            case "Pho Phong":
                luongCoBan += (luongCoBan * 20L) / 100L;
                break;
            case "Truong Phong":
                luongCoBan += (luongCoBan * 35L) / 100L;
                break;
            default:
                break;
        }

        label.setText(Long.toString(luongCoBan));
        luongCoBan = 0;
    }

}
