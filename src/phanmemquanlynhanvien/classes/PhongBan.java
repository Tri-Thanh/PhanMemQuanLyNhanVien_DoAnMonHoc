package phanmemquanlynhanvien.classes;

import java.util.List;
import phanmemquanlynhanvien.classes.NhanVien;

public class PhongBan {

    private List<NhanVien> danhSachNhanVien;

    public PhongBan() {
    }

    /**
     *
     * @param danhSachNhanVien
     */
    public PhongBan(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    /**
     *
     * @return
     */
    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    /**
     *
     * @param danhSachNhanVien
     */
    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    /**
     *
     * @param nhanVien to themNhanVien()
     */
    public void themNhanVien(NhanVien nhanVien) {
        this.danhSachNhanVien.add(nhanVien);
    }

    /**
     *
     * @param maNhanVien to xoaNhanVien()
     */
    public void xoaNhanVien(String maNhanVien) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMaNhanVien().equals(maNhanVien)) {
                danhSachNhanVien.remove(nhanVien);
                break;
            }
        }
    }
    
    /**
     * 
     * @param maNhanVien
     * @return 
     */
    public NhanVien timKiemNhanVien(String maNhanVien){
        for(NhanVien nhanVien : danhSachNhanVien){
            if(nhanVien.getMaNhanVien().equals(maNhanVien)){
                return nhanVien;
            }
        }
        return null;
    }
}
