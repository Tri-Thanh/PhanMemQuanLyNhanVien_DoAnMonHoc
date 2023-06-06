package phanmemquanlynhanvien.panels;


public class PanelSize {
    private int WIDTH, HEIGHT;
    
    public PanelSize(){}

    /**
     * 
     * @param WIDTH 
     */
    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    /**
     * 
     * @param HEIGHT 
     */
    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    /**
     * 
     * @return 
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * 
     * @return 
     */
    public int getHEIGHT() {
        return HEIGHT;
    }
}
