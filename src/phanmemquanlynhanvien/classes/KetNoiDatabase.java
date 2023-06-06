package phanmemquanlynhanvien.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import phanmemquanlynhanvien.classes.NhanVien;

public class KetNoiDatabase {

    public Connection connection;
    public Statement statement;

    private String url = "jdbc:mysql://localhost:3306/quanlynhanvien";
    private String userName = "root";
    private String password = "phungsobuda";

    public KetNoiDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    /**
     * METHODS: layThongTinNhanVienTuDb()
     *
     * @return List<NhanVien> as danhSachNhanVien
     */
    public List<NhanVien> layThongTinNhanVienTuDb() {

        List<NhanVien> danhSachNhanVien;

        try {
            danhSachNhanVien = new ArrayList<>();
            KetNoiDatabase dB = new KetNoiDatabase();

            String query = "SELECT * FROM danh_sach_nhan_vien";

            ResultSet rs = dB.statement.executeQuery(query);

            while (rs.next()) {
                /**
                 * ngay_sinh trong database dinh dang la: d(d)/mm/yyyy - Tach
                 * ngay_sinh trong database thanh: ngaySinh, thangSinh, namSinh
                 */
                String[] ngayThangNamSinh = rs.getString("ngay_sinh").split("/");
                String ngaySinh = ngayThangNamSinh[0];
                String thangSinh = ngayThangNamSinh[1];
                String namSinh = ngayThangNamSinh[2];

                /**
                 * ngay_vao_lam trong database dinh dang la: d(d)/mm/yyyy - Tach
                 * ngay_vao_lam trong database thanh: ngayVaoLam, thangVaoLam,
                 * namVaoLam
                 */
                String[] ngayThangNamVaoLam = rs.getString("ngay_vao_lam").split("/");
                String ngayVaoLam = ngayThangNamVaoLam[0];
                String thangVaoLam = ngayThangNamVaoLam[1];
                String namVaoLam = ngayThangNamVaoLam[2];

                NhanVien nhanVien = new NhanVien();

                nhanVien.setMaNhanVien(rs.getString("ma_nhan_vien"));
                nhanVien.setMaDinhDanh(Long.parseLong(rs.getString("ma_dinh_danh")));
                nhanVien.setTenNhanVien(rs.getString("ten_nhan_vien"));
                nhanVien.setNgaySinh(new NgaySinh(Integer.parseInt(ngaySinh), Integer.parseInt(thangSinh), Integer.parseInt(namSinh)));
                nhanVien.setGioiTinh(rs.getString("gioi_tinh"));
                nhanVien.setChucVu(rs.getString("chuc_vu"));
                nhanVien.setNgayVaoLam(new NgayVaoLam(Integer.parseInt(ngayVaoLam), Integer.parseInt(thangVaoLam), Integer.parseInt(namVaoLam)));
                nhanVien.setSoDienThoai(rs.getString("so_dien_thoai"));
                nhanVien.setDiaChi(rs.getString("dia_chi"));
                nhanVien.setMaPhongBan(rs.getString("ma_phong_ban"));
                nhanVien.setLuongCoBan(Integer.parseInt(rs.getString("luong_co_ban")));

                danhSachNhanVien.add(nhanVien);
            }
            rs.close();
            return danhSachNhanVien;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*
    layDanhSachMaNhanVien(): String[]
     */
    public String[] layDanhSachMaNhanVienTuDb() {

        ArrayList<String> dsMaNhanVien = new ArrayList<>();
        try {
            String query = "SELECT ma_nhan_vien FROM danh_sach_nhan_vien";
            KetNoiDatabase dB = new KetNoiDatabase();
            ResultSet rs = dB.statement.executeQuery(query);
            while (rs.next()) {
                dsMaNhanVien.add(rs.getString("ma_nhan_vien"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arrayMaNhanVien = new String[dsMaNhanVien.size()];
        dsMaNhanVien.toArray(arrayMaNhanVien);
        return arrayMaNhanVien;
    }
}
