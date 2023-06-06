package phanmemquanlynhanvien.button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import phanmemquanlynhanvien.classes.DoanhNghiep;

import phanmemquanlynhanvien.classes.KetNoiDatabase;
import phanmemquanlynhanvien.classes.NgaySinh;
import phanmemquanlynhanvien.classes.NgayVaoLam;
import phanmemquanlynhanvien.classes.NhanVien;

public class NutXemNhanVien extends JButton{

    private DoanhNghiep doanhNghiep;
    private ButtonSize buttonSize;
    private ButtonFont buttonFont;
    
    public NutXemNhanVien() {
        
        buttonSize = new ButtonSize();
        buttonFont = new ButtonFont();
        
        /**
         * Configure NutXemNhanVien
         */
        this.setText("DANH SACH NHAN VIEN");
        this.setBounds(0, 0, buttonSize.getWIDTH(), buttonSize.getHEIGHT());
        this.setFocusable(false);
        this.setFont(buttonFont.getButtonFont());
    }
}
