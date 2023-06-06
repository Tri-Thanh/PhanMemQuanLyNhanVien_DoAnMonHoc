package phanmemquanlynhanvien.frame;

import java.awt.Image;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import phanmemquanlynhanvien.classes.DoanhNghiep;

import phanmemquanlynhanvien.panels.ButtonPanels;
import phanmemquanlynhanvien.panels.DanhSachNhanVienPanel;
import phanmemquanlynhanvien.panels.DanhSachThanhVienPanels;
import phanmemquanlynhanvien.panels.RightPanel;
import phanmemquanlynhanvien.panels.TimKiemPanel;

public class NewMainFrame extends JFrame {

    private ButtonPanels buttonPanels;
    private DanhSachNhanVienPanel danhSachNhanVienPanel;
    private RightPanel rightPanel;
    
    private DoanhNghiep doanhNghiep;

    private final int WIDTH = 1500;
    private final int HEIGHT = 1000;
    private final int X = 250;
    private final int Y = 30;

    public NewMainFrame() {
        rightPanel = new RightPanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);
        this.setResizable(false);
        this.setLayout(null);

        buttonPanels = new ButtonPanels();
        this.add(buttonPanels);

        this.setVisible(true);
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new NewMainFrame();
    }

    /**
     *
     * @param newPanel
     */
    public void changePanel(JPanel newPanel) {
        this.getContentPane().remove(rightPanel);
        rightPanel = (RightPanel) newPanel;
        this.getContentPane().add(rightPanel);

        // refresh JFrame
        revalidate();
        repaint();
    }
}
