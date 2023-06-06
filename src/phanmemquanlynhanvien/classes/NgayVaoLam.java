package phanmemquanlynhanvien.classes;

import java.util.Random;

public class NgayVaoLam {

    private Integer ngayVaoLam, thangVaoLam, namVaoLam;

    /**
     *
     * @param ngayVaoLam
     * @param thangVaoLam
     * @param namVaoLam
     */
    public NgayVaoLam(Integer ngayVaoLam, Integer thangVaoLam, Integer namVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
        this.thangVaoLam = thangVaoLam;
        this.namVaoLam = namVaoLam;
    }

    /**
     * 
     * @return 
     */
    public Integer getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     * 
     * @return 
     */
    public Integer getThangVaoLam() {
        return thangVaoLam;
    }

    /**
     * 
     * @return 
     */
    public Integer getNamVaoLam() {
        return namVaoLam;
    }

    /**
     * 
     * @param ngayVaoLam 
     */
    public void setNgayVaoLam(Integer ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * 
     * @param thangVaoLam 
     */
    public void setThangVaoLam(Integer thangVaoLam) {
        this.thangVaoLam = thangVaoLam;
    }

    /**
     * 
     * @param namVaoLam 
     */
    public void setNamVaoLam(Integer namVaoLam) {
        this.namVaoLam = namVaoLam;
    }

}
