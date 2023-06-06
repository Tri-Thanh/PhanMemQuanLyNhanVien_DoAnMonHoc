package phanmemquanlynhanvien.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import phanmemquanlynhanvien.classes.KetNoiDatabase;
import phanmemquanlynhanvien.panels.SetThongTinPanels;

public class XoaNhanVienPanels extends JPanel implements ActionListener {

    private SetThongTinPanels thongTinNhanVien;

    private JComboBox timKiemTheoPb, timKiemTheoMaNhanVien;
    private DanhSachNhanVienPanel danhSachNhanVienPanel;
    
    private JLabel timKiemTheoPbLabel, timKiemTheoMaNvLabel,
            tenNhanVienLabel, ten_nhan_vien;
    private JButton nutXoaNhanVien, nutReset;

    private final int COMDO_WIDTH = 200;
    private final int COMBO_HEIGHT = 50;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 50;
    private final int TEXT_SIZE = 30;
    private final String TEXT_FONT = "San Serif";
    private final Font DEFAULT_FONT = new Font(TEXT_FONT, Font.BOLD, TEXT_SIZE);

    /*
    CONSTRUCTOR
     */
    public XoaNhanVienPanels() {

        thongTinNhanVien = new SetThongTinPanels();

        this.setBounds(0, 0, 1200, 300);
        this.setLayout(null);

        timKiemTheoPbLabel = new JLabel("Phong ban");
        timKiemTheoPbLabel.setBounds(50, 50, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoPbLabel.setFont(DEFAULT_FONT);
        timKiemTheoPbLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(timKiemTheoPbLabel);

        danhSachNhanVienPanel = new DanhSachNhanVienPanel();
        danhSachNhanVienPanel.taoDanhSachNhanVien(danhSachNhanVienPanel.getBangDanhSachNhanVien());
        danhSachNhanVienPanel.setVisible(true);
        this.add(danhSachNhanVienPanel);

        timKiemTheoPb = new JComboBox(thongTinNhanVien.getDanhSachPb());
        timKiemTheoPb.setBounds(275, 50, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoPb.setBackground(Color.WHITE);
        timKiemTheoPb.setFont(DEFAULT_FONT);
        this.add(timKiemTheoPb);

        timKiemTheoMaNvLabel = new JLabel("Ma nhan vien");
        timKiemTheoMaNvLabel.setBounds(50, 75 + COMBO_HEIGHT, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoMaNvLabel.setFont(DEFAULT_FONT);
        timKiemTheoMaNvLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(timKiemTheoMaNvLabel);

        timKiemTheoMaNhanVien = new JComboBox(thongTinNhanVien.layDanhSachMaNhanVien());
        timKiemTheoMaNhanVien.setBounds(275, 75 + COMBO_HEIGHT, COMDO_WIDTH, COMBO_HEIGHT);
        timKiemTheoMaNhanVien.setBackground(Color.WHITE);
        timKiemTheoMaNhanVien.setFont(DEFAULT_FONT);
        timKiemTheoMaNhanVien.setEnabled(false);
        timKiemTheoMaNhanVien.setVisible(false);
        this.add(timKiemTheoMaNhanVien);
        
        nutReset = new JButton("Reset");
        nutReset.setBounds(275 + COMDO_WIDTH + 100, 75, BUTTON_WIDTH, BUTTON_HEIGHT);
        nutReset.setFont(DEFAULT_FONT);
        nutReset.setFocusable(false);
        this.add(nutReset);

        nutXoaNhanVien = new JButton("Xoa Nhan vien");
        nutXoaNhanVien.setBounds(300 + COMDO_WIDTH + BUTTON_WIDTH + 100, 75, 100 + BUTTON_WIDTH, BUTTON_HEIGHT);
        nutXoaNhanVien.setFont(DEFAULT_FONT);
        nutXoaNhanVien.setFocusable(false);
        this.add(nutXoaNhanVien);
    }

    /**
     * GETTER
     */
    public JComboBox getTimKiemTheoPb() {
        return timKiemTheoPb;
    }

    public JComboBox getTimKiemTheoMaNhanVien() {
        return timKiemTheoMaNhanVien;
    }

    public JButton getNutXoaNhanVien() {
        return nutXoaNhanVien;
    }

    public JButton getNutReset() {
        return nutReset;
    }

    /**
     * SETTER
     */
    /**
     * METHODs
     */
    /**
     * resetPanel(): void
     */
    private void resetPanel() {
        Container container = getParent();
        if (container != null) {
            container.remove(this);
            container.add(new XoaNhanVienPanels());
            container.validate();
            container.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nutReset) {
            resetPanel();
        }
    }

}
