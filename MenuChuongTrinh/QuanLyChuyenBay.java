package MenuChuongTrinh;

import Cautruc.HangBay;
import Cautruc.HanhKhach;
import Cautruc.ChuyenBay;
import XuLyNghiepVu.QuanLyDatVe;

import java.util.Scanner;

public class QuanLyChuyenBay {

    private HangBay hangBay;
    private QuanLyDatVe quanLyDatVe; // De quan ly dat ve
    private Scanner sc;

    public QuanLyChuyenBay(QuanLyDatVe quanLyDatVe, HangBay hangBay) {
        this.quanLyDatVe = quanLyDatVe;
        this.hangBay = hangBay;
        this.sc = new Scanner(System.in);
    }


    public void hienThiMenu() {
        int luaChon;
        do {
            System.out.println("\n=== QUAN LY CHUYEN BAY ===");
            System.out.println("1. Them chuyen bay");
            System.out.println("2. Xoa chuyen bay");
            System.out.println("3. Hien thi danh sach chuyen bay");
            System.out.println("4. Tim kiem chuyen bay");
            System.out.println("5. Quan ly hanh khach");
            System.out.println("0. Quay lai");

            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    themChuyenBay();
                    break;
                case 2:
                    xoaChuyenBay();
                    break;
                case 3:
                    hienThiDanhSachChuyenBay();
                    break;
                case 4:
                    timKiemChuyenBay();
                    break;
                case 5:
                    menuQuanLyHanhKhach();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
    }

    private void themChuyenBay() {
        System.out.print("Nhap ma chuyen bay: ");
        String maChuyenBay = sc.next();
        System.out.print("Nhap diem khoi hanh: ");
        String diemKhoiHanh = sc.next();
        System.out.print("Nhap diem den: ");
        String diemDen = sc.next();
        System.out.print("Nhap thoi gian khoi hanh: ");
        String thoiGianKhoiHanh = sc.next();
        System.out.print("Nhap so ghe: ");
        int soGhe = sc.nextInt();

        ChuyenBay chuyenBay = new ChuyenBay(maChuyenBay, diemKhoiHanh, diemDen, thoiGianKhoiHanh, soGhe);
        hangBay.themChuyenBay(chuyenBay);
        System.out.println("Them chuyen bay thanh cong!");
    }

    private void xoaChuyenBay() {
        System.out.print("Nhap ma chuyen bay can xoa: ");
        String maChuyenBay = sc.next();
        hangBay.xoaChuyenBay(maChuyenBay);
    }

    private void hienThiDanhSachChuyenBay() {
        System.out.println("Danh sach chuyen bay:");
        for (ChuyenBay chuyenBay : hangBay.getDanhsachchuyenbay()) {
            if (chuyenBay != null) {
                System.out.println(chuyenBay);
            }
        }
    }

    private void timKiemChuyenBay() {
        System.out.print("Nhap ma chuyen bay can tim: ");
        String maChuyenBay = sc.next();
        ChuyenBay chuyenBay = hangBay.timChuyenBay(maChuyenBay);
        if (chuyenBay != null) {
            System.out.println("Thong tin chuyen bay: " + chuyenBay);
        }
    }

    private void menuQuanLyHanhKhach() {
        System.out.println("\n=== QUAN LY HANH KHACH ===");
        System.out.println("1. Them hanh khach");
        System.out.println("2. Xoa hanh khach");
        System.out.println("3. Hien thi danh sach hanh khach");
        System.out.println("4. Tim kiem hanh khach");
        System.out.println("0. Quay lai");

        System.out.print("Nhap lua chon: ");
        int luaChon = sc.nextInt();
        switch (luaChon) {
            case 1:
                themHanhKhach();
                break;
            case 2:
                xoaHanhKhach();
                break;
            case 3:
                hienThiDanhSachHanhKhach();
                break;
            case 4:
                timKiemHanhKhach();
                break;
            case 0:
                System.out.println("Quay lai menu quan ly chuyen bay.");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    private void themHanhKhach() {
        System.out.print("Nhap ID hanh khach: ");
        String id = sc.next();
        System.out.print("Nhap ten hanh khach: ");
        String ten = sc.next();
        HanhKhach hanhKhach = new HanhKhach(id, ten);
        hangBay.themHanhKhach(hanhKhach);
        System.out.println("Them hanh khach thanh cong!");
    }

    private void xoaHanhKhach() {
        System.out.print("Nhap ID hanh khach can xoa: ");
        String id = sc.next();
        hangBay.xoaHanhKhach(new HanhKhach(id, ""));
    }

    private void hienThiDanhSachHanhKhach() {
        System.out.println("Danh sach hanh khach:");
        for (HanhKhach hanhKhach : hangBay.getDanhsachhanhkhach()) {
            if (hanhKhach != null) {
                System.out.println(hanhKhach);
            }
        }
    }

    private void timKiemHanhKhach() {
        System.out.print("Nhap ID hanh khach can tim: ");
        String id = sc.next();
        HanhKhach hanhKhach = hangBay.timHanhKhach(id);
        if (hanhKhach != null) {
            System.out.println("Thong tin hanh khach: " + hanhKhach);
        }
    }
}