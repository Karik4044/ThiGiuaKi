package XuLyNghiepVu;

import java.util.ArrayList;
import Cautruc.Ticket;

public class QuanLyHuyVe {
    private ArrayList<Ticket> danhSachVe; // Danh sach ve

    public QuanLyHuyVe(ArrayList<Ticket> danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public Ticket timVe(String maVe) {
        for (Ticket ve : danhSachVe) {
            if (ve.getMave().equals(maVe)) {
                return ve; // Tra ve neu tim thay
            }
        }
        return null; // Khong tim thay ve
    }

    // Tinh gio truoc khi bay
    public int tinhSoGioTruocBay(Ticket ve) {
        String ngayBay = ve.getNgaydatve();
        return 25; // Gia su con 25h truoc khi bay
    }

    public double thucHienHuyVe(String maVe) {
        // Tim ve
        Ticket ve = timVe(maVe);
        if (ve == null) {
            System.out.println("Khong tim thay ve!");
            return 0;
        }

        // Kiem tra thoi gian
        int soGioTruocBay = tinhSoGioTruocBay(ve);

        // Tinh tien hoan
        double tienHoan = 0;
        if (soGioTruocBay >= 24) {
            tienHoan = ve.getGiave() * 0.7;
        } else {
            tienHoan = ve.getGiave() * 0.5;
        }

        // Cap nhat trang thai ve
        ve.setTrangthaive('C');

        return tienHoan;
    }
}