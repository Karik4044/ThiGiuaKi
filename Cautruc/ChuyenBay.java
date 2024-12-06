package Cautruc;

import java.util.Arrays;

public class ChuyenBay {

    //Thuoc tinh
    private String machuyenbay;
    private String sanbaydi;
    private String sanbayden;
    private String ngaybay;
    private String giobay;
    private int sogheEconomy;
    private int sogheBusiness;
    private int sogheFirst;
    private Ghe[] danhsachghe;
    private char trangthai;
    private Ticket[] danhsachve;
    private double khoangcachbay;

    //Phuong thuc
    //Constructor
    public ChuyenBay(String machuyenbay, String sanbaydi, String sanbayden, String ngaybay, String giobay, int sogheEconomy, int sogheFirst, Ghe[] danhsachghe, char trangthai, Ticket[] danhsachve, double khoangcachbay) {
        this.machuyenbay = machuyenbay;
        this.sanbaydi = sanbaydi;
        this.sanbayden = sanbayden;
        this.ngaybay = ngaybay;
        this.giobay = giobay;
        this.sogheEconomy = sogheEconomy;
        this.sogheFirst = sogheFirst;
        this.danhsachghe = danhsachghe;
        this.trangthai = trangthai;
        this.danhsachve = danhsachve;
        this.khoangcachbay = khoangcachbay;
    }

    public ChuyenBay(String maChuyenBay, String diemKhoiHanh, String diemDen, String thoiGianKhoiHanh, int soGhe) {
        this.machuyenbay = maChuyenBay;
        this.sanbaydi = diemKhoiHanh;
        this.sanbayden = diemDen;
        this.ngaybay = thoiGianKhoiHanh;
    }

    //Setter & Getter

    public String getMachuyenbay() {
        return machuyenbay;
    }

    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }

    public String getSanbaydi() {
        return sanbaydi;
    }

    public void setSanbaydi(String sanbaydi) {
        this.sanbaydi = sanbaydi;
    }

    public String getSanbayden() {
        return sanbayden;
    }

    public void setSanbayden(String sanbayden) {
        this.sanbayden = sanbayden;
    }

    public String getNgaybay() {
        return ngaybay;
    }

    public void setNgaybay(String ngaybay) {
        this.ngaybay = ngaybay;
    }

    public String getGiobay() {
        return giobay;
    }

    public void setGiobay(String giobay) {
        this.giobay = giobay;
    }

    public int getSogheEconomy() {
        return sogheEconomy;
    }

    public void setSogheEconomy(int sogheEconomy) {
        this.sogheEconomy = sogheEconomy;
    }

    public int getSogheBusiness() {
        return sogheBusiness;
    }

    public void setSogheBusiness(int sogheBusiness) {
        this.sogheBusiness = sogheBusiness;
    }

    public int getSogheFirst() {
        return sogheFirst;
    }

    public void setSogheFirst(int sogheFirst) {
        this.sogheFirst = sogheFirst;
    }

    public Ghe[] getDanhsachghe() {
        return danhsachghe;
    }

    public void setDanhsachghe(Ghe[] danhsachghe) {
        this.danhsachghe = danhsachghe;
    }

    public char getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(char trangthai) {
        this.trangthai = trangthai;
    }

    public Ticket[] getDanhsachve() {
        return danhsachve;
    }

    public void setDanhsachve(Ticket[] danhsachve) {
        this.danhsachve = danhsachve;
    }

    public double getKhoangcachbay() {
        return khoangcachbay;
    }

    public void setKhoangcachbay(double khoangcachbay) {
        this.khoangcachbay = khoangcachbay;
    }

    //Kiem tra ghe trong
    public boolean kiemTraGheTrong(char hangghe) {
        for(Ghe ghe : danhsachghe){
            if(ghe != null && ghe.getHangghe() == hangghe && !ghe.isTrangthai()) {
                return true;
            }
        }
        return false;
    }

    //Dat ghe
    public boolean datGhe(String maghe) {
        for(Ghe ghe : danhsachghe){
            if(ghe != null && ghe.getMaghe().equals(maghe) && !ghe.isTrangthai()) {
                ghe.setTrangthai(true);
                return true;
            }
        }
        return false;
    }

    //Huy ghe
    public boolean huyGhe(String maghe) {
        for(Ghe ghe : danhsachghe) {
            if (ghe.getMaghe().equals(maghe)) {
                ghe.setTrangthai(false); //Mark la ghe da dc huy
                System.out.println("Ghe " + maghe + " da huy");
                return true; // Ghe da huy thanh cong
            }
            else {
                System.out.println("Ghe " + maghe + " trong");
                return false; // Ghe chua duoc dat
            }
        }
        System.out.println("Khong tim thay ma so cua ghe " + maghe);
        return false; // Khong tim thay ghe
    }

    //Dat ve
    public boolean datVe(String maHanhKhach, char hangGhe) {
        for (Ghe ghe : danhsachghe) {
            if (ghe != null && ghe.getHangghe() == hangGhe && !ghe.isTrangthai()) {
                ghe.setTrangthai(true); // Đánh dấu ghế đã được đặt
                System.out.println("Đặt vé thành công cho hành khách " + maHanhKhach);
                return true; // Đặt vé thành công
            }
        }
        return false; // Không thể đặt vé (hết ghế trống)
    }

    //Kiem tra trang thai chuyen bay
    public boolean isCancelled() {
        return trangthai == 'C';
    }


    //toString
    @Override
    public String toString() {
        return "ChuyenBay{" +
                "machuyenbay='" + machuyenbay + '\'' +
                ", sanbaydi='" + sanbaydi + '\'' +
                ", sanbayden='" + sanbayden + '\'' +
                ", ngaybay='" + ngaybay + '\'' +
                ", giobay='" + giobay + '\'' +
                ", sogheEconomy=" + sogheEconomy +
                ", sogheBusiness=" + sogheBusiness +
                ", sogheFirst=" + sogheFirst +
                ", danhsachghe=" + Arrays.toString(danhsachghe) +
                ", trangthai=" + trangthai +
                ", danhsachve=" + Arrays.toString(danhsachve) +
                ", khoangcachbay=" + khoangcachbay +
                '}';
    }
}
