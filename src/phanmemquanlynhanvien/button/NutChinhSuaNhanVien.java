/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phanmemquanlynhanvien.button;

import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class NutChinhSuaNhanVien extends JButton {

    private ButtonFont buttonFont;
    private ButtonSize buttonSize;

    public NutChinhSuaNhanVien() {
        /**
         * set font of NutThemNhanVien
         */
        buttonFont = new ButtonFont();

        /**
         * set size of NutThemNhanVien
         */
        buttonSize = new ButtonSize();

        this.setText("CAP NHAT THONG TIN");
        this.setBounds(0, 600, buttonSize.getWIDTH(), buttonSize.getHEIGHT());
        this.setFocusable(false);
        this.setFont(buttonFont.getButtonFont());
    }
}
