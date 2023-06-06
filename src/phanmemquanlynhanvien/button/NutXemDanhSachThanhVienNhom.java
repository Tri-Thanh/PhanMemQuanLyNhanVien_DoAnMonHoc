package phanmemquanlynhanvien.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;

import phanmemquanlynhanvien.classes.ThanhVienNhom;

public class NutXemDanhSachThanhVienNhom extends JButton {

    private ButtonSize size = new ButtonSize();
    
    private final int X = 0;
    private final int Y = 800;

    public NutXemDanhSachThanhVienNhom() {

        /**
         * configure cac thuoc tinh cua NutXemDanhSachThanhVien
         */
        this.setText("DANH SACH THANH VIEN");
        this.setBounds(X, Y, size.getWIDTH(), size.getHEIGHT());
        this.setFocusable(false);
        this.setFont(new Font("Ink Free", Font.BOLD, 20));
    }

}
