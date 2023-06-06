/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phanmemquanlynhanvien.button;

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class NutXoaNhanVien extends JButton {

    private ButtonFont buttonFont;
    private ButtonSize buttonSize;

    public NutXoaNhanVien() {

        /**
         * set font of NutThemNhanVien
         */
        buttonFont = new ButtonFont();

        /**
         * set size of NutThemNhanVien
         */
        buttonSize = new ButtonSize();

        this.setText("XOA NHAN VIEN");
        this.setBounds(0, 400, buttonSize.getWIDTH(), buttonSize.getHEIGHT());
        this.setFocusable(false);
        this.setFont(buttonFont.getButtonFont());
    }
}
