package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import phanmemquanlynhanvien.classes.DoanhNghiep;
import phanmemquanlynhanvien.panels.SetThongTinPanels;

public class TimKiemPanel extends JPanel {

    private JComboBox timKiemTheoPb, timKiemTheoMaNhanVien;
    private JTextField timKiemTheoTen;
    private SetThongTinPanels thongTinNhanVien;
    
    private JLabel timKiemTheoPbLabel, timKiemTheoMaNvLabel;
    private JButton nutTimKiemTheoTen;
    private Image image, searchButtonIcon;
    private ImageIcon icon;
    private JLabel soLuongNhanVien, so_luong_nhan_vien;

    private DoanhNghiep doanhNghiep;
    private DanhSachNhanVienPanel danhSachNhanVienPanel;

    private final int COMDO_WIDTH = 200;
    private final int COMBO_HEIGHT = 50;
    private final int BUTTON_WIDTH = 53;
    private final int BUTTON_HEIGHT = 50;
    private final int TEXT_SIZE = 30;
    private final String TEXT_FONT = "San Serif";
    private final Font DEFAULT_FONT = new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE);

    public TimKiemPanel() {

        /**
         * Initialized Object
         */
        doanhNghiep = new DoanhNghiep();
        
        // Scacle searchButtonIcon
        icon = new ImageIcon("ImageFile/SearchButton.png");
        searchButtonIcon = icon.getImage();
        searchButtonIcon = searchButtonIcon.getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT, Image.SCALE_SMOOTH);

        this.setBounds(0, 0, 1200, 200);
        this.setLayout(null);

        timKiemTheoPbLabel = new JLabel("Phong ban");
        timKiemTheoPbLabel.setBounds(50, 50, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoPbLabel.setFont(DEFAULT_FONT);
        timKiemTheoPbLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(timKiemTheoPbLabel);

        timKiemTheoPb = new JComboBox(doanhNghiep.getDanhSachPhongBan());
        timKiemTheoPb.setBounds(275, 50, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoPb.setBackground(Color.WHITE);
        timKiemTheoPb.setFont(DEFAULT_FONT);
        this.add(timKiemTheoPb);

        timKiemTheoMaNvLabel = new JLabel("Ma nhan vien");
        timKiemTheoMaNvLabel.setBounds(50, 75 + COMBO_HEIGHT, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoMaNvLabel.setFont(DEFAULT_FONT);
        timKiemTheoMaNvLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(timKiemTheoMaNvLabel);

        timKiemTheoMaNhanVien = new JComboBox(doanhNghiep.getDanhSachMaNhanVien());
        timKiemTheoMaNhanVien.setBounds(275, 75 + COMBO_HEIGHT, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoMaNhanVien.setBackground(Color.WHITE);
        timKiemTheoMaNhanVien.setFont(DEFAULT_FONT);
        this.add(timKiemTheoMaNhanVien);

        timKiemTheoTen = new JTextField();
        timKiemTheoTen.setBounds(275 + 2 * COMDO_WIDTH - 50, 50, 2 * COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoTen.setFont(DEFAULT_FONT);
        timKiemTheoTen.setBackground(Color.WHITE);
        this.add(timKiemTheoTen);

        nutTimKiemTheoTen = new JButton();
        nutTimKiemTheoTen.setIcon(new ImageIcon(searchButtonIcon));
        nutTimKiemTheoTen.setBounds(275 + 2 * COMDO_WIDTH - 50 + 2 * COMDO_WIDTH + 25, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
        nutTimKiemTheoTen.setFont(DEFAULT_FONT);
        nutTimKiemTheoTen.setBackground(Color.WHITE);
        this.add(nutTimKiemTheoTen);
        
        
    }

    /**
     * 
     * @return 
     */
    public JComboBox getTimKiemTheoPb() {
        return timKiemTheoPb;
    }

    /**
     * 
     * @return 
     */
    public JComboBox getTimKiemTheoMaNhanVien() {
        return timKiemTheoMaNhanVien;
    }

    /**
     * 
     * @return 
     */
    public JTextField getTimKiemTheoTen() {
        return timKiemTheoTen;
    }

    /**
     * 
     * @return 
     */
    public JButton getNutTimKiemTheoTen() {
        return nutTimKiemTheoTen;
    }
}
