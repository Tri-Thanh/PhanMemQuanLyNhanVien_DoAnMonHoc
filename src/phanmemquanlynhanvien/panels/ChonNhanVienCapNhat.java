package phanmemquanlynhanvien.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.proteanit.sql.DbUtils;
import phanmemquanlynhanvien.classes.KetNoiDatabase;
import phanmemquanlynhanvien.panels.SetThongTinPanels;

public class ChonNhanVienCapNhat extends JPanel implements ActionListener{

    private JLabel headingLabel, phongBanLabel, maNhanVienLabel, tenNhanVienLabel, ten_nhan_vien;
    private JComboBox chonPhongBan, chonMaNhanVien;
    private JButton nutCapNhat;

    private SetThongTinPanels thongTinNhanVien;

    private final int LABEL_WIDTH = 200;
    private final int LABEL_HEIGHT = 100;
    private final int BOX_WIDTH = 250;
    private final int BOX_HEIGHT = 50;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 50;
    private final String TEXT_FONT = "San Serif";
    private final int TEXT_SIZE = 30;
    private final Font DEFAULT_FONT = new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE);

    public ChonNhanVienCapNhat() {

        this.setBounds(0, 0, 1200, 1000);
        this.setLayout(null);

        thongTinNhanVien = new SetThongTinPanels();

        /**
         * HEADING
         */
        headingLabel = new JLabel("CAP NHAT NHAN VIEN");
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

        chonPhongBan = new JComboBox(thongTinNhanVien.getDanhSachPb());
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

        chonMaNhanVien = new JComboBox(thongTinNhanVien.layDanhSachMaNhanVien());
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
        nutCapNhat = new JButton("Cap nhat");
        nutCapNhat.setBounds(ten_nhan_vien.getX(), ten_nhan_vien.getY() + LABEL_HEIGHT, chonMaNhanVien.getWidth(), BUTTON_HEIGHT);
        nutCapNhat.setFocusable(false);
        nutCapNhat.setFont(DEFAULT_FONT);
        nutCapNhat.addActionListener(this);
        this.add(nutCapNhat);
    }
    
    /**
     * GETTER
     */
    public JButton getNutCapNhat(){
        return nutCapNhat;
    }
    
    
    
    /**
     * METHODs
     */
    
    /**
     * getMaNhanVien: String
     */
    public String getMaNhanVien(){
        return (String) chonMaNhanVien.getSelectedItem();
    }
    
    /**
     * getPhongBan: String
     */
    public String getPhongBan(){
        return  (String) chonPhongBan.getSelectedItem();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == nutCapNhat){
            Container container = this.getParent();
            
            CapNhatNhanVienPanels capNhatNhanVien = new CapNhatNhanVienPanels((String)chonPhongBan.getSelectedItem(), (String)chonMaNhanVien.getSelectedItem());
            capNhatNhanVien.setVisible(true);
            container.remove(this);
            container.add(capNhatNhanVien);
            
            container.validate();
            container.repaint();
            
        }
    }
}
