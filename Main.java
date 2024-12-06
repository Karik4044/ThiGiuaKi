import Cautruc.*;
import MenuChuongTrinh.*;
import XuLyNghiepVu.*;
import XuLyThongKe.*;
import XuLyTimKiemvaSapXep.*;

public class Main {
    public static void main(String[] args) {
        HangBay hangBay1 = new HangBay("HB001", "Hang Bay A", new ChuyenBay[10], new HanhKhach[20], new double[]{1000000, 3000000, 5000000});
        HangBay hangBay2 = new HangBay("HB002", "Hang Bay B", new ChuyenBay[10], new HanhKhach[20], new double[]{1000000, 3000000, 5000000});
        HangBay hangBay3 = new HangBay("HB003", "Hang Bay C", new ChuyenBay[10], new HanhKhach[20], new double[]{1000000, 3000000, 5000000});

        // Tao mot so chuyen bay mau
        ChuyenBay chuyenBay1 = new ChuyenBay("CB0001", "SGN", "HN", "01/01/2024", "10:00", 120, 40, new Ghe[120], 'S', new Ticket[100], 1000);
        ChuyenBay chuyenBay2 = new ChuyenBay("CB0002", "HN", "DN", "02/01/2024", "12:00", 120, 40, new Ghe[120], 'S', new Ticket[100], 800);

        // Them chuyen bay vao hang bay
        hangBay1.themChuyenBay(chuyenBay1);
        hangBay1.themChuyenBay(chuyenBay2);

        // Tao mot so hanh khach mau
        HanhKhach hanhKhach1 = new HanhKhach("KH001", "Nguyen Van A", 1990, "12345678", "HB001", "MT001", 0, 'B', new Ticket[5], "HCM");
        HanhKhach hanhKhach2 = new HanhKhach("KH002", "Tran Thi B", 1985, "87654321", "HB002", "MT002", 15000, 'S', new Ticket[5], "HCM");

        // Them hanh khach vao hang bay
        hangBay1.themHanhKhach(hanhKhach1);
        hangBay1.themHanhKhach(hanhKhach2);

        // Khoi dong menu quan ly
        QuanLyDatVe quanLyDatVe = new QuanLyDatVe(); // Tao doi tuong quan ly dat ve
        QuanLyChuyenBay quanLyChuyenBay = new QuanLyChuyenBay(quanLyDatVe, hangBay1); // Truyen vao tham so
        quanLyChuyenBay.hienThiMenu();
    }
}