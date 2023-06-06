
package phanmemquanlynhanvien.classes;

public class NgaySinh{
    private Integer ngaySinh, thangSinh, namSinh;

    public NgaySinh(int ngaySinh, int thangSinh, int namSinh) {
        this.ngaySinh = ngaySinh;
        this.thangSinh = thangSinh;
        this.namSinh = namSinh;
    }

    /**
     * 
     * @return 
     */
    public Integer getNgaySinh() {
        return ngaySinh;
    }

    /**
     * 
     * @return 
     */
    public Integer getThangSinh() {
        return thangSinh;
    }

    /**
     * 
     * @return 
     */
    public Integer getNamSinh() {
        return namSinh;
    }

    /**
     * 
     * @param ngaySinh 
     */
    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * 
     * @param thangSinh 
     */
    public void setThangSinh(int thangSinh) {
        this.thangSinh = thangSinh;
    }

    /**
     * 
     * @param namSinh 
     */
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    } 
}
