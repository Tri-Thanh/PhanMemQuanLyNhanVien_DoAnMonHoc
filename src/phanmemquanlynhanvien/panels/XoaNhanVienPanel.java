package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import phanmemquanlynhanvien.classes.DoanhNghiep;
import phanmemquanlynhanvien.classes.KetNoiDatabase;
import phanmemquanlynhanvien.frame.NewMainFrame;

public class XoaNhanVienPanel extends JPanel implements ActionListener {

    private JLabel headingLabel, phongBanLabel, maNhanVienLabel, tenNhanVienLabel, ten_nhan_vien;
    private JComboBox chonPhongBan, chonMaNhanVien;
    private JButton nutXoa;
    private Location location;
    private PanelSize panelSize;
    private RightPanel rightPanel;

    private DoanhNghiep doanhNghiep;

    private final int LABEL_WIDTH = 200;
    private final int LABEL_HEIGHT = 100;
    private final int BOX_WIDTH = 250;
    private final int BOX_HEIGHT = 50;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 50;
    private final String TEXT_FONT = "San Serif";
    private final int TEXT_SIZE = 30;
    private final Font DEFAULT_FONT = new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE);

    public XoaNhanVienPanel() {

        doanhNghiep = new DoanhNghiep();

        /**
         * Set location of XoaNhanVienPanel
         */
        location = new Location();
        location.setX(0);
        location.setY(0);

        /**
         * Set size of XoaNhanVienPanel
         */
        panelSize = new PanelSize();
        panelSize.setWIDTH(1200);
        panelSize.setHEIGHT(1000);

        /**
         * Configure XoaNhanVienPanel
         */
        this.setLocation(location.getX(), location.getY());
        this.setSize(panelSize.getWIDTH(), panelSize.getHEIGHT());
        this.setLayout(null);

        /**
         * HEADING
         */
        headingLabel = new JLabel("XOA NHAN VIEN");
        headingLabel.setBounds(300, 0, LABEL_WIDTH + 400, LABEL_HEIGHT);
        headingLabel.setFont(new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE + 20));
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(headingLabel);

        /**
         * 1st: PHONG BAN + CHON PHONG BAN
         */
        phongBanLabel = new JLabel("Phong ban");
        phongBanLabel.setBounds(50, 2 * LABEL_HEIGHT, LABEL_WIDTH + 50, LABEL_HEIGHT);
        phongBanLabel.setFont(DEFAULT_FONT);
        phongBanLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(phongBanLabel);

        chonPhongBan = new JComboBox(doanhNghiep.getDanhSachPhongBan());
        chonPhongBan.setBounds(phongBanLabel.getX() + LABEL_WIDTH + 75, phongBanLabel.getY() + 25, BOX_WIDTH, BOX_HEIGHT);
        chonPhongBan.setFont(DEFAULT_FONT);
        chonPhongBan.setBackground(Color.WHITE);
        chonPhongBan.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaPhongBan = (String) e.getItem();
                // clear the current items in the xoaPanel.getTimKiemTheoMaNhanVien() dropdown
                chonMaNhanVien.removeAllItems();
                // query the database for ma_nhan_vien belonging to the selected ma_phong_ban
                try {
                    KetNoiDatabase dB = new KetNoiDatabase();
                    String query = "SELECT ma_nhan_vien FROM danh_sach_nhan_vien WHERE ma_phong_ban = ?";
                    PreparedStatement pstmt = dB.connection.prepareStatement(query);
                    pstmt.setString(1, selectedMaPhongBan);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        chonMaNhanVien.addItem(rs.getString("ma_nhan_vien"));
                    }
                    chonMaNhanVien.setEnabled(true);
                    rs.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(chonPhongBan);

        /**
         * 2nd Row: MA NHAN VIEN + Chon Ma Nhan vien
         */
        maNhanVienLabel = new JLabel("Ma nhan vien");
        maNhanVienLabel.setBounds(phongBanLabel.getX(), phongBanLabel.getY() + LABEL_HEIGHT,
                phongBanLabel.getWidth(), phongBanLabel.getHeight());
        maNhanVienLabel.setFont(DEFAULT_FONT);
        maNhanVienLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(maNhanVienLabel);

        chonMaNhanVien = new JComboBox(doanhNghiep.getDanhSachMaNhanVien());
        chonMaNhanVien.setBounds(chonPhongBan.getX(), maNhanVienLabel.getY() + 25, BOX_WIDTH, BOX_HEIGHT);
        chonMaNhanVien.setFont(DEFAULT_FONT);
        chonMaNhanVien.setBackground(Color.WHITE);
        chonMaNhanVien.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaNhanVien = (String) e.getItem();
                String query = "SELECT ten_nhan_vien FROM danh_sach_nhan_vien WHERE ma_nhan_vien = ?";

                try {
                    KetNoiDatabase dB = new KetNoiDatabase();
                    PreparedStatement preStatement = dB.connection.prepareStatement(query);
                    preStatement.setString(1, selectedMaNhanVien);
                    ResultSet rs = preStatement.executeQuery();
                    if (rs.next()) {
                        ten_nhan_vien.setText(rs.getString("ten_nhan_vien"));
                        ten_nhan_vien.setOpaque(true);
                    }
                    rs.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        chonMaNhanVien.setEnabled(false);
        this.add(chonMaNhanVien);

        /**
         * 3rd Row: TEN NHAN VIEN + set Ten nhan vien
         */
        tenNhanVienLabel = new JLabel("Ten Nhan vien");
        tenNhanVienLabel.setBounds(maNhanVienLabel.getX(), maNhanVienLabel.getY() + LABEL_HEIGHT,
                maNhanVienLabel.getWidth(), maNhanVienLabel.getHeight());
        tenNhanVienLabel.setFont(DEFAULT_FONT);
        tenNhanVienLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(tenNhanVienLabel);

        ten_nhan_vien = new JLabel();
        ten_nhan_vien.setBounds(chonMaNhanVien.getX(), tenNhanVienLabel.getY() + 25,
                chonMaNhanVien.getWidth() + LABEL_WIDTH, chonMaNhanVien.getHeight());
        ten_nhan_vien.setFont(DEFAULT_FONT);
        ten_nhan_vien.setBackground(Color.BLACK);
        ten_nhan_vien.setOpaque(false);
        ten_nhan_vien.setForeground(Color.GREEN);
        this.add(ten_nhan_vien);

        /**
         * 4th: Nut Cap nhat
         */
        nutXoa = new JButton("Xoa");
        nutXoa.setBounds(ten_nhan_vien.getX(), ten_nhan_vien.getY() + LABEL_HEIGHT, chonMaNhanVien.getWidth(), BUTTON_HEIGHT);
        nutXoa.setFocusable(false);
        nutXoa.setFont(DEFAULT_FONT);
        nutXoa.addActionListener(this);
        this.add(nutXoa);
    }
    
    /**
     * 
     * @return 
     */
    public JButton getNutXoa(){
        return nutXoa;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nutXoa) {
            try {
                KetNoiDatabase dB = new KetNoiDatabase();
                String query = "DELETE FROM danh_sach_nhan_vien WHERE ma_nhan_vien = ?";
                PreparedStatement preStatement = dB.connection.prepareStatement(query);
                preStatement.setString(1, ((String) chonMaNhanVien.getSelectedItem()));
                preStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "DA XOA!!!!");

                preStatement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
