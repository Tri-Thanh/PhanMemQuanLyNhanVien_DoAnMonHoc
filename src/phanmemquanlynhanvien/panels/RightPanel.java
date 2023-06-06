/**
 * RightPanel: contain TimKienmPanel & ViewPanel (DanhSachNhanVienPanel,...)
 */
package phanmemquanlynhanvien.panels;

import javax.swing.JPanel;

public class RightPanel extends JPanel {

    private JPanel firstPanel, secondPanel;

    private PanelSize size;
    private Location location;

    public RightPanel() {
        /**
         * Set WIDTH & HEIGHT of RightPanel
         */
        size = new PanelSize();
        size.setWIDTH(1200);
        size.setHEIGHT(1000);

        /**
         * Set location of RightPanel
         */
        location = new Location();
        location.setX(300);
        location.setY(0);

        this.setBounds(location.getX(), location.getY(), size.getWIDTH(), size.getHEIGHT());
        this.setLayout(null);
    }

    public RightPanel(JPanel firstPanel, JPanel secondPanel) {
        this.firstPanel = firstPanel;
        this.secondPanel = secondPanel;

        /**
         * Set WIDTH & HEIGHT of RightPanel
         */
        size = new PanelSize();
        size.setWIDTH(1200);
        size.setHEIGHT(1000);

        /**
         * Set location of RightPanel
         */
        location = new Location();
        location.setX(300);
        location.setY(0);

        this.setBounds(location.getX(), location.getY(), size.getWIDTH(), size.getHEIGHT());
        this.setLayout(null);
        this.add(firstPanel);
        this.add(secondPanel);
    }

    public RightPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;

        /**
         * Set WIDTH & HEIGHT of RightPanel
         */
        size = new PanelSize();
        size.setWIDTH(1200);
        size.setHEIGHT(1000);

        /**
         * Set location of RightPanel
         */
        location = new Location();
        location.setX(300);
        location.setY(0);

        this.setBounds(location.getX(), location.getY(), size.getWIDTH(), size.getHEIGHT());
        this.setLayout(null);
        this.add(firstPanel);
    }
}
