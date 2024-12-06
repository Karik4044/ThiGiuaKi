package MenuChuongTrinh;

import Cautruc.HangBay;
import Cautruc.HanhKhach;
import Cautruc.ChuyenBay;
import Cautruc.Ticket;
import XuLyNghiepVu.QuanLyDatVe;
import XuLyNghiepVu.QuanLyHuyVe;

import java.lang.Exception.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyChuyenBay {

    private HangBay hangBay;
    private QuanLyDatVe quanLyDatVe;
    private QuanLyHuyVe quanLyHuyVe;// De quan ly dat ve
    private Scanner sc;
    private Ticket ticket;

    public QuanLyChuyenBay(QuanLyDatVe quanLyDatVe, HangBay hangBay, Ticket ticket) {
        this.quanLyDatVe = quanLyDatVe;
        this.hangBay = hangBay;
        this.ticket = ticket;  // Initialize the ticket object
        this.sc = new Scanner(System.in);
    }

    public QuanLyChuyenBay(QuanLyDatVe quanLyDatVe, HangBay hangBay1) {
        this.quanLyDatVe = quanLyDatVe;
        this.hangBay = hangBay1;
        this.sc = new Scanner(System.in);
    }


    public void hienThiMenu() {
        int luaChon = -1;
        do {
            System.out.println("\n=== QUAN LY DAT VE MAY BAY ===");
            System.out.println("1. Quan ly hanh khach");
            System.out.println("2. Quan ly chuyen bay");
            System.out.println("3. Dat ve");
            System.out.println("4. Huy ve");
            System.out.println("5. Thong ke");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");
            try {
                luaChon = sc.nextInt();

                switch (luaChon) {
                    case 1:
                        menuQuanLyHanhKhach();
                        break;
                    case 2:
                        menuQuanLyChuyenBay();
                        break;
                    case 3:
                        menuDatVe();
                        break;
                    case 4:
                        menuHuyVe();
                        break;
                    case 5:
                        menuThongKe();
                        break;
                    case 0:
                        System.out.println("Tam biet!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lua chon khong hop le!");
                sc.nextLine();
            }
        } while (luaChon != 0);
    }

    public void menuQuanLyChuyenBay() {
        int luaChon = -1;

        do {
            System.out.println("\n=== QUAN LY CHUYEN BAY ===");
            System.out.println("1. Them chuyen bay");
            System.out.println("2. Xoa chuyen bay");
            System.out.println("3. Hien thi danh sach chuyen bay");
            System.out.println("4. Tim kiem chuyen bay");
            System.out.println("5. Quan ly hanh khach");
            System.out.println("0. Quay lai");

            System.out.print("Nhap lua chon: ");
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Lua chon khong hop le!");
                sc.nextLine();
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
        System.out.print("Nhap thoi gian khoi hanh (dd/MM/yyyy HH:mm): ");
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
        System.out.println("Danh sach chuyen bay :");
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
        } else {
            System.out.println("Khong tim thay chuyen bay voi ma: " + maChuyenBay);
        }
    }

    private void menuQuanLyHanhKhach() {
        int luaChon = -1;

        do {
            System.out.println("\n=== QUAN LY HANH KHACH ===");
            System.out.println("1. Them hanh khach");
            System.out.println("2. Xoa hanh khach");
            System.out.println("3. Hien thi danh sach hanh khach");
            System.out.println("4. Tim kiem hanh khach");
            System.out.println("0. Quay lai");

            System.out.print("Nhap lua chon: ");
            try {
                luaChon = sc.nextInt();

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
            } catch(InputMismatchException e) {
                System.out.println("Lua chon khong hop le!");
                sc.nextLine();
            }
        } while (luaChon != 0);
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
        System.out.println("Xoa hanh khach thanh cong!");
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
        } else {
            System.out.println("Khong co hanh khach voi ID: " + id);
        }
    }

    //Huy ve
    private void menuDatVe() {
        System.out.print("Nhập mã hành khách: ");
        String maHanhKhach = sc.next();
        System.out.print("Nhập mã chuyến bay: ");
        String maChuyenBay = sc.next();
        System.out.print("Nhập hạng ghế (Y/B/F): ");
        char hangGhe = sc.next().charAt(0);
        if (quanLyDatVe.thucHienDatVe(maHanhKhach, maChuyenBay, hangGhe)) {
            System.out.println("Đặt vé thành công!");
        } else {
            System.out.println("Đặt vé không thành công!");
        }
    }

    private void menuHuyVe() {
        System.out.print("Nhập mã vé cần hủy: ");
        String maVe = sc.next();
        double hoanTra = quanLyHuyVe.thucHienHuyVe(maVe);
        if (hoanTra > 0) {
            System.out.println("Hủy vé thành công! Số tiền hoàn trả: " + hoanTra + " VND");
        } else {
            System.out.println("Hủy vé không thành công!");
        }
    }

    private void menuThongKe() {
        int luaChon = -1;
        System.out.println("\n=== THONG KE ===");
        System.out.println("1. Thong ke so luong chuyen bay");
        System.out.println("2. Thong ke so luong hanh khach");
        System.out.println("3. Thong ke doanh thu");
        System.out.println("0. Quay lai");

        System.out.print("Nhap lua chon: ");
        try{
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    thongKeSoLuongChuyenBay();
                    break;
                case 2:
                    thongKeSoLuongHanhKhach();
                    break;
                case 3:
                    thongKeDoanhThu();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }catch (InputMismatchException e) {
            System.out.println("Lua chon khong hop le!");
            sc.nextLine();
        }
    }

    private void thongKeSoLuongChuyenBay() {
        int soLuongChuyenBay = hangBay.getDanhsachchuyenbay().length; // Giả sử bạn có phương thức này
        System.out.println("So luong chuyen bay hien co: " + soLuongChuyenBay);
    }

    private void thongKeSoLuongHanhKhach() {
        int soLuongHanhKhach = hangBay.getDanhsachhanhkhach().length; // Giả sử bạn có phương thức này
        System.out.println("So luong hanh khach hien co: " + soLuongHanhKhach);
    }

    private void thongKeDoanhThu() {
        double tongDoanhThu = 0.0;

        // Check if the ticket object or its attributes are null
        if (ticket != null && ticket.getHanhkhach() != null) {
            for (Ticket ve : ticket.getHanhkhach().getDanhsachvedadat()) {
                tongDoanhThu += ve.getGiave();  // Assuming getGiave() is a method that returns the ticket price
            }
            System.out.println("Tong doanh thu: " + tongDoanhThu + " VND");
        } else {
            System.out.println("Danh sach ve hoac hanh khach chua duoc khoi tao.");
        }
    }

}
