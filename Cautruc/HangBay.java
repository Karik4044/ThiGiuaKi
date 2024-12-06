package Cautruc;

import java.util.Arrays;

public class HangBay {

    //Thuoc tinh
    private String id;
    private String tenHangbay;
    private ChuyenBay[] danhsachchuyenbay;
    private HanhKhach[] danhsachhanhkhach;
    private double[] banggiacoban;

    //Phuong thuc
    //Constructor
    public HangBay(String id, String tenHangbay, ChuyenBay[] danhsachchuyenbay, HanhKhach[] danhsachhanhkhach, double[] banggiacoban) {
        this.id = id;
        this.tenHangbay = tenHangbay;
        this.danhsachchuyenbay = danhsachchuyenbay;
        this.danhsachhanhkhach = danhsachhanhkhach;
        this.banggiacoban = banggiacoban;
    }

    //Setter & Getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenHangbay() {
        return tenHangbay;
    }

    public void setTenHangbay(String tenHangbay) {
        this.tenHangbay = tenHangbay;
    }

    public ChuyenBay[] getDanhsachchuyenbay() {
        return danhsachchuyenbay;
    }

    public void setDanhsachchuyenbay(ChuyenBay[] danhsachchuyenbay) {
        this.danhsachchuyenbay = danhsachchuyenbay;
    }

    public HanhKhach[] getDanhsachhanhkhach() {
        return danhsachhanhkhach;
    }

    public void setDanhsachhanhkhach(HanhKhach[] danhsachhanhkhach) {
        this.danhsachhanhkhach = danhsachhanhkhach;
    }

    public double[] getBanggiacoban() {
        return banggiacoban;
    }

    public void setBanggiacoban(double[] banggiacoban) {
        this.banggiacoban = banggiacoban;
    }

    //Them chuyen bay
    public void themChuyenBay(ChuyenBay chuyenBay) {
        for (int i = 0; i < danhsachchuyenbay.length; i++) {
            if (danhsachchuyenbay[i] == null) {
                danhsachchuyenbay[i] = chuyenBay;
                return;
            }
        }
        System.out.println("Khong the them chuyen bay. Danh sach chuyen bay da day.");
    }

    //Xoa chuyen bay
    public void xoaChuyenBay(String maChuyenBay) {
        for(int i = 0; i < danhsachchuyenbay.length; i++) {
            if(danhsachchuyenbay[i] != null && danhsachchuyenbay[i].getMachuyenbay().equals(maChuyenBay)) {
                danhsachchuyenbay[i] = null;
                System.out.println("Da xoa chuyen bay " + maChuyenBay);
            }
        }
    }

    //Tim chuyen bay(Theo ma)
    public ChuyenBay timChuyenBay(String maChuyenBay) {
        for(ChuyenBay chuyenBay : danhsachchuyenbay) {
            if(chuyenBay != null && chuyenBay.getMachuyenbay().equals(maChuyenBay)) {
                return chuyenBay;
            }
        }
        System.out.println("Khong tim thay chuyen bay voi ma " + maChuyenBay);
        return null;
    }

    //Them hanh khach
    public void themHanhKhach(HanhKhach HanhKhach) {
        for(int i = 0; i < danhsachhanhkhach.length; i++) {
            if(danhsachhanhkhach[i] == null) {
                danhsachhanhkhach[i] = HanhKhach;
                return;
            }
        }
        System.out.println("Khong the them hanh khac. Danh sach cua ban da day.");
    }

    //Xoa hanh khach
    public void xoaHanhKhach(HanhKhach HanhKhach) {
        for(int i = 0; i < danhsachhanhkhach.length; i++) {
            if(danhsachhanhkhach[i] != null && danhsachhanhkhach[i].getId().equals(HanhKhach)) {
                danhsachhanhkhach[i] = null;
                return;
            }
        }
        System.out.println("Khong the tim thay hanh khach voi ma " + HanhKhach);
    }

    //Tim hanh khach theo ma(id)
    public HanhKhach timHanhKhach(String maHanhKhach) {
        for(HanhKhach hanhKhach : danhsachhanhkhach) {
            if(hanhKhach != null && hanhKhach.getId().equals(maHanhKhach)) {
                return hanhKhach;
            }
        }
        System.out.println("Khong tim thay hanh khach voi (id) " + maHanhKhach);
        return null;
    }

    //Tong doanh thu
    public double Tongdoanhthu() {
        double Sum = 0;
        for(ChuyenBay chuyenbay : danhsachchuyenbay) {
            if(chuyenbay != null) {
                for(Ticket ve : chuyenbay.getDanhsachve()) {
                    if(ve != null && ve.getTrangthaive() == 'B') {
                        Sum += ve.getGiave();
                    }
                }
            }
        }
        return Sum;
    }

    //toString

    @Override
    public String toString() {
        return "HangBay{" +
                "id='" + id + '\'' +
                ", tenHangbay='" + tenHangbay + '\'' +
                ", danhsachchuyenbay=" + Arrays.toString(danhsachchuyenbay) +
                ", danhsachhanhkhach=" + Arrays.toString(danhsachhanhkhach) +
                ", banggiacoban=" + Arrays.toString(banggiacoban) +
                '}';
    }
}
