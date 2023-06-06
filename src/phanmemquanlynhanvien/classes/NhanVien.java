package phanmemquanlynhanvien.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien {

    private String maNhanVien;
    private Long maDinhDanh;
    private String tenNhanVien;
    private NgaySinh ngaySinh;
    private String gioiTinh;
    private NgayVaoLam ngayVaoLam;
    private String chucVu;
    private String diaChi;
    private String soDienThoai;
    private String maPhongBan;
    private Integer luongCoBan;

    /*
    CONSTRUCTOR
     */
    public NhanVien() {
    }

    public NhanVien(String maNV,
            Long maDinhDanh,
            String tenNV,
            NgaySinh ngaySinh,
            String gioiTinh,
            NgayVaoLam ngayVaoLam,
            String chucVu,
            String diaChi,
            String soDienThoai,
            String maPhongBan,
            Integer luongCoBan) {
        this.maNhanVien = maNV;
        this.maDinhDanh = maDinhDanh;
        this.tenNhanVien = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.ngayVaoLam = ngayVaoLam;
        this.chucVu = chucVu;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maPhongBan = maPhongBan;
        this.luongCoBan = luongCoBan;
    }

    /**
     * @return
     */
    public String getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @return
     */
    public Long getMaDinhDanh() {
        return maDinhDanh;
    }

    /**
     *
     * @return
     */
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    /**
     *
     * @return
     */
    public NgaySinh getNgaySinh() {
        return ngaySinh;
    }

    /**
     *
     * @return
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     *
     * @return
     */
    public NgayVaoLam getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     *
     * @return
     */
    public String getChucVu() {
        return chucVu;
    }

    /**
     *
     * @return
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     *
     * @return
     */
    public String getSoDienThoai() {
        return soDienThoai;
    }

    /**
     *
     * @return
     */
    public String getMaPhongBan() {
        return maPhongBan;
    }

    /**
     *
     * @return
     */
    public Integer getLuongCoBan() {
        return luongCoBan;
    }

    /**
     * @param maNV
     */
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    /**
     *
     * @param maDinhDanh
     */
    public void setMaDinhDanh(Long maDinhDanh) {
        this.maDinhDanh = maDinhDanh;
    }

    /**
     *
     * @param tenNV
     */
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    /**
     *
     * @param ngaySinh
     */
    public void setNgaySinh(NgaySinh ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     *
     * @param gioiTinh
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     *
     * @param ngayVaoLam
     */
    public void setNgayVaoLam(NgayVaoLam ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     *
     * @param chucVu
     */
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    /**
     *
     * @param diaChi
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     *
     * @param soDienThoai
     */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    /**
     *
     * @param maPhongBan
     */
    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    /**
     *
     * @param luongCoBan
     */
    public void setLuongCoBan(Integer luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

//    /**
//     * *
//     * METHODS
//     */
//    /**
//     * nhapThongTinNhanVien(): lay thong tin nhan vien tu database
//     */
//    public void nhapThongTinNhanVien() {
//        KetNoiDatabase dB = new KetNoiDatabase();
//        String query = "SELECT * FROM danh_sach_nhan_vien";
//
//        try {
//            ResultSet rs = dB.statement.executeQuery(query);
//
//            while (rs.next()) {
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    
}
