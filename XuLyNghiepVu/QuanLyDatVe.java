package XuLyNghiepVu;

import Cautruc.HanhKhach;
import Cautruc.ChuyenBay;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDatVe {
    private List<HanhKhach> danhSachHanhKhach = new ArrayList<>();
    private List<ChuyenBay> danhSachChuyenBay = new ArrayList<>();

    // Thực hiện đặt vé
    public boolean thucHienDatVe(String maHanhKhach, String maChuyenBay, char hangGhe) {
        // Tìm hành khách
        HanhKhach hk = timHanhKhach(maHanhKhach);
        if (hk == null) {
            System.out.println("Không tìm thấy hành khách!");
            return false;
        }

        // Kiểm tra chuyến bay
        ChuyenBay cb = timChuyenBay(maChuyenBay);
        if (cb == null) {
            System.out.println("Không tìm thấy chuyến bay!");
            return false;
        }

        // Kiểm tra ghế trống
        if (!cb.kiemTraGheTrong(hangGhe)) {
            System.out.println("Hết ghế loại " + hangGhe);
            return false;
        }

        // Thực hiện đặt vé
        return cb.datVe(maHanhKhach, hangGhe);
    }

    // Tìm hành khách
    private HanhKhach timHanhKhach(String maHanhKhach) {
        for (HanhKhach hk : danhSachHanhKhach) {
            if (hk.getId().equals(maHanhKhach)) {
                return hk;
            }
        }
        return null;
    }

    // Tìm chuyến bay
    private ChuyenBay timChuyenBay(String maChuyenBay) {
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getMachuyenbay().equals(maChuyenBay)) {
                return cb;
            }
        }
        return null;
    }

    // Thêm hành khách vào danh sách
    public void themHanhKhach(HanhKhach hanhKhach) {
        danhSachHanhKhach.add(hanhKhach);
    }

    // Thêm chuyến bay vào danh sách
    public void themChuyenBay(ChuyenBay chuyenBay) {
        danhSachChuyenBay.add(chuyenBay);
    }

}
