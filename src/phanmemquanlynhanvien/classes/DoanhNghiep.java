package phanmemquanlynhanvien.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoanhNghiep {
    private String[] danhSachMaNhanVien;
    private List<NhanVien> danhSachNhanVien;
    private KetNoiDatabase dB;

    private String[] danhSachPhongBan = {"IT", "HR", "MKT", 
        "SALE", "SEC", "ACT"};
    
    public DoanhNghiep() {
        dB = new KetNoiDatabase();
        this.setDanhSachNhanVien(dB.layThongTinNhanVienTuDb());
        this.setDanhSachMaNhanVien(dB.layDanhSachMaNhanVienTuDb());
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
     * @return 
     */
    public String[] getDanhSachPhongBan() {
        return danhSachPhongBan;
    }

    /**
     * 
     * @return 
     */
    public String[] getDanhSachMaNhanVien() {
        return danhSachMaNhanVien;
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
     * @param danhSachPhongBan 
     */
    public void setDanhSachPhongBan(String[] danhSachPhongBan) {
        this.danhSachPhongBan = danhSachPhongBan;
    }

    /**
     * 
     * @param danhSachMaNhanVien 
     */
    public void setDanhSachMaNhanVien(String[] danhSachMaNhanVien) {
        this.danhSachMaNhanVien = danhSachMaNhanVien;
    }
    
    /**
     * 
     * @param maNhanVien
     * @return 
     */
    public NhanVien timThongTinNhanVien(String maNhanVien){
        for(NhanVien nhanVien : danhSachNhanVien){
            if(nhanVien.getMaNhanVien().equals(maNhanVien)){
                return nhanVien;
            }
        }
        return null;
    }
}
