package phanmemquanlynhanvien.labels;

import java.awt.Font;

public class LabelFont {
    
    private final int DEFAULT_WIDTH = 200;
    private final int DEFAULT_HEIGHT = 100;
    private final int DEFAULT_FONT_SIZE = 30;
    
    private String defaultFont = "San Serif";
    
    private Font font;

    public LabelFont(){
        font = new Font(defaultFont, Font.BOLD, DEFAULT_FONT_SIZE);
    }
    
    /**
     * 
     * @return 
     */
    public Font getFont() {
        return font;
    }

    /**
     * 
     * @return 
     */
    public int getDEFAULT_WIDTH() {
        return DEFAULT_WIDTH;
    }

    /**
     * 
     * @return 
     */
    public int getDEFAULT_HEIGHT() {
        return DEFAULT_HEIGHT;
    }

    /**
     * 
     * @return 
     */
    public String getDefaultFont() {
        return defaultFont;
    }

    /**
     * 
     * @return 
     */
    public int getDEFAULT_FONT_SIZE() {
        return DEFAULT_FONT_SIZE;
    }

    /**
     * 
     * @param font 
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * 
     * @param DEFAULT_FONT 
     */
    public void setDefaultFont(String defaultFont) {
        this.defaultFont = defaultFont;
    }
    
    
}
