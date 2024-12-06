package XuLyThongKe;

import Cautruc.Ticket;

public class ThongKe {
    //Thong ke doanh thu
    public double thongKeDoanhThu(String ngayBatDau, String ngayKetThuc, Ticket[] danhSachVe) {
        double tongDoanhThu = 0;

        for (Ticket ve : danhSachVe) {
            if (ve != null &&
                    ve.getTrangthaive() == 'B' &&
                    namTrongKhoang(ve.getNgaydatve(), ngayBatDau, ngayKetThuc)) {
                tongDoanhThu += ve.getGiave();
            }
        }

        return tongDoanhThu;
    }

    //Thong ke doanh thi theo chuyen bay
    public double thongKeDoanhThuTheoChuyenBay(String maChuyenBay, Ticket[] danhSachVe) {
        double tongDoanhThuchuyenbay = 0;

        for (Ticket ve : danhSachVe) {
            if (ve != null && ve.getMachuyenbay().equals(maChuyenBay) && ve.getTrangthaive() == 'B') {
                tongDoanhThuchuyenbay += ve.getGiave();
            }
        }

        return tongDoanhThuchuyenbay;
    }
    private boolean namTrongKhoang(String ngay, String batDau, String ketThuc) {
        // Code kiểm tra ngày
        return true; // Giả sử luôn hợp lệ
    }
}
