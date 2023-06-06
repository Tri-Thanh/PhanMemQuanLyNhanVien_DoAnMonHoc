package phanmemquanlynhanvien.panels;

import java.util.logging.Logger;

public class Location {
    private int x;
    private int y;

    public Location() {
    }

    /**
     * 
     * @param x
     * @param y 
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @return 
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @return 
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    
    
}
