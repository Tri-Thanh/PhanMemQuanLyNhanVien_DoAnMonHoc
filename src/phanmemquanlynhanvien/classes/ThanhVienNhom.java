package phanmemquanlynhanvien.classes;

public class ThanhVienNhom {

    private String tenSinhVien, maSinhVien;

    public ThanhVienNhom() {
    }

    /**
     * 
     * @param name
     * @param maSinhVien 
     */
    public ThanhVienNhom(String tenSinhVien, String maSinhVien) {
        this.tenSinhVien = tenSinhVien;
        this.maSinhVien = maSinhVien;
    }

    /**
     * 
     * @return 
     */
    public String getTenSinhVien() {
        return tenSinhVien;
    }

    /**
     * 
     * @return 
     */
    public String getMaSinhVien() {
        return maSinhVien;
    }

    /**
     * 
     * @param name 
     */
    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    /**
     * 
     * @param maSinhVien 
     */
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
}
