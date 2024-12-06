package Cautruc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HanhKhach implements IHanhKhach{
    private String id;
    private String Tenhanhkhach;
    private int namsinh;
    private String sohochieu;
    private String idhangbay;
    private String mathethanhvien;
    private double sodamtichluy;
    private char hangthethanhvien;
    private Ticket[] danhsachvedadat;
    private static int sovetoida = 5;
    private String diachi;

    //Constructor
    public HanhKhach(String id, String tenhanhkhach, int namsinh, String sohochieu, String idhangbay, String mathethanhvien, double sodamtichluy, char hangthethanhvien, Ticket[] danhsachvedadat, String diachi) {
        this.id = id;
        Tenhanhkhach = tenhanhkhach;
        this.namsinh = namsinh;
        this.sohochieu = sohochieu;
        this.idhangbay = idhangbay;
        this.mathethanhvien = mathethanhvien;
        this.sodamtichluy = sodamtichluy;
        this.hangthethanhvien = hangthethanhvien;
        this.danhsachvedadat = danhsachvedadat;
        this.diachi = diachi;
    }

    public HanhKhach(String id, String ten) {
        this.id = id;
        this.Tenhanhkhach = ten;
    }

    //Phuong thuc
    //Setter & getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenhanhkhach() {
        return Tenhanhkhach;
    }

    public void setTenhanhkhach(String tenhanhkhach) {
        Tenhanhkhach = tenhanhkhach;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getSohochieu() {
        return sohochieu;
    }

    public void setSohochieu(String sohochieu) {
        this.sohochieu = sohochieu;
    }

    public String getIdhangbay() {
        return idhangbay;
    }

    public void setIdhangbay(String idhangbay) {
        this.idhangbay = idhangbay;
    }

    public String getMathethanhvien() {
        return mathethanhvien;
    }

    public void setMathethanhvien(String mathethanhvien) {
        this.mathethanhvien = mathethanhvien;
    }

    public double getSodamtichluy() {
        return sodamtichluy;
    }

    public void setSodamtichluy(double sodamtichluy) {
        this.sodamtichluy = sodamtichluy;
    }

    public char getHangthethanhvien() {
        return hangthethanhvien;
    }

    public void setHangthethanhvien(char hangthethanhvien) {
        this.hangthethanhvien = hangthethanhvien;
    }

    public Ticket[] getDanhsachvedadat() {
        return danhsachvedadat;
    }

    public void setDanhsachvedadat(Ticket[] danhsachvedadat) {
        this.danhsachvedadat = danhsachvedadat;
    }

    public static int getSovetoida() {
        return sovetoida;
    }

    public static void setSovetoida(int sovetoida) {
        HanhKhach.sovetoida = sovetoida;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    //Kiem tra tuoi co tren 18 khong
    public boolean kiemTraTuoi() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return (currentYear - namsinh) > 18;
    }

    //Dat ve
    @Override
    public boolean datve(String maChuyenBay, char hangGhe) {
        //Kiem tra tuoi de dat ve
        if (!kiemTraTuoi()) {
            System.out.println("Hành khách chưa đủ tuổi để đặt vé.");
            return false;
        }
        // Kiểm tra số vé đã đặt
        if (demSoVeDaDat() >= sovetoida) {
            System.out.println("Đã đạt số vé tối đa!");
            return false;
        }

        // Kiểm tra thời gian đặt vé
        if (!kiemTraThoiGianDatVe(maChuyenBay)) {
            System.out.println("Không thể đặt vé trước giờ bay dưới 2 giờ!");
            return false;
        }

        // Tạo vé mới
        Ticket veeMoi = taoVeMoi(maChuyenBay, hangGhe);
        if (veeMoi == null) {
            return false;
        }

        // Thêm vào danh sách vé
        return themVaoDS(veeMoi);
    }

    private int demSoVeDaDat() {
        int count = 0;
        for (Ticket ve : danhsachvedadat) {
            if (ve != null && ve.getTrangthaive() == 'B') {
                count++;
            }
        }
        return count;
    }
    private boolean kiemTraThoiGianDatVe(String maChuyenBay) {
        //Kiem tra thoi gian
        return true; // Giả sử luôn hợp lệ
    }

    private Ticket taoVeMoi(String maChuyenBay, char hangGhe) {
        // Tạo mã vé mới
        String maVe = "V" + String.format("%05d", demSoVeDaDat() + 1);

        // Xác định mã ghế (giả sử cố định là "Y01A")
        String maGhe = "Y01A";

        // Tính giá vé dựa trên hạng ghế
        double giaVe = new Ticket("", "", "", ' ', 0, ' ', null, "").Tinhgiave(hangGhe);

        // Xác định trạng thái vé (giả sử 'B' là booked - đã đặt)
        char trangThaiVe = 'B';

        // Ngày đặt vé hiện tại
        String ngayDatVe = getCurrentDate();

        // Giả sử `this` là đối tượng `HanhKhach`
        return new Ticket(maVe, maChuyenBay, maGhe, hangGhe, giaVe, trangThaiVe, this, ngayDatVe);
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
    }

    private boolean themVaoDS(Ticket ve) {
        for (int i = 0; i < danhsachvedadat.length; i++) {
            if (danhsachvedadat[i] == null) {
                danhsachvedadat[i] = ve;
                return true;
            }
        }
        return false;
    }


    //Huy ve
    @Override
    public double Huyve(String maVe) {
        for (int i = 0; i < danhsachvedadat.length; i++) {
            if (danhsachvedadat[i] != null && danhsachvedadat[i].getMave().equals(maVe)) {
                Ticket ve = danhsachvedadat[i];
                double hoanTra = 0;

                // Giả sử kiểm tra thời gian hủy (cần cài đặt logic cụ thể)
                boolean coThoiGianHuy = kiemTraThoiGianHuy(ve.getNgaydatve());
                if (coThoiGianHuy) {
                    hoanTra = ve.getGiave() * 0.7; // Hoàn trả 70% giá vé
                    ve.setTrangthaive('C'); // Đánh dấu vé là đã hủy
                    danhsachvedadat[i] = null; // Xóa vé khỏi danh sách
                    System.out.println("Hủy vé thành công. Hoàn trả: " + hoanTra + " VND");
                } else {
                    System.out.println("Không thể hủy vé trong thời gian này.");
                }
                return hoanTra; // Trả lại số tiền hoàn trả
            }
        }
        System.out.println("Không tìm thấy vé với mã: " + maVe);
        return 0; // Trả lại 0 nếu không tìm thấy vé
    }

    private boolean kiemTraThoiGianHuy(String ngayDatVe) {
        // Cần cài đặt logic kiểm tra thời gian hủy vé
        // Ví dụ: kiểm tra xem vé có thể hủy nếu còn trước 2 giờ so với giờ bay
        return true; // Giả sử luôn hợp lệ
    }

    //Doi ve
    @Override
    public double Doive(String maVeCu, String maChuyenBayMoi) {
        for (int i = 0; i < danhsachvedadat.length; i++) {
            if (danhsachvedadat[i] != null && danhsachvedadat[i].getMave().equals(maVeCu)) {
                Ticket veCu = danhsachvedadat[i];

                // Hủy vé cũ
                double hoanTra = Huyve(maVeCu);

                // Tạo vé mới
                Ticket veMoi = taoVeMoi(maChuyenBayMoi, veCu.getHangghe());
                if (veMoi != null) {
                    themVaoDS(veMoi);
                    System.out.println("Đổi vé thành công.");
                    return hoanTra; // Trả lại số tiền hoàn trả từ vé cũ
                }
                return 0; // Trả lại 0 nếu không thể tạo vé mới
            }
        }
        System.out.println("Không tìm thấy vé với mã: " + maVeCu);
        return 0; // Trả lại 0 nếu không tìm thấy vé
    }

    //Kiem tra trang thai ve
    @Override
    public char Kiemtratrangthai(String mave) {
        for(Ticket ve : danhsachvedadat) {
            if (ve != null && ve.getMave().equals(mave)) {
                return ve.getTrangthaive(); //Tra ve trang thai ve
            }
        }
        System.out.println("Khong tim thay ve voi ma: " + mave);
        return 'N'; //Tra ve 'N' neu khong tim thay
    }

    //Tinh toan dam bay
    @Override
    public void tichluydambay(double khoangcach, char hangghe) {
        double hesohangghe;
        switch (hangghe) { //Phan loai muc he so hang ghe
            case 'Y':
                hesohangghe = 1.0;
                break;
            case 'B':
                hesohangghe = 1.5;
                break;
            case 'F':
                hesohangghe = 2.0;
                break;
            default:
                throw new IllegalArgumentException("He so hang ghe khong hop le");
        }
        double dambay = khoangcach * hesohangghe;
        this.sodamtichluy += dambay; //Tinh tong so dam tich luy
        if(this.sodamtichluy < 10000) {
            this.hangthethanhvien = 'B';
        }
        else if(this.sodamtichluy >= 10000 && dambay < 50000) {
            this.hangthethanhvien = 'S';
        }
        else if(this.sodamtichluy >= 50000) {
            this.hangthethanhvien = 'G';
        }
        System.out.println("Dam bay tich luy: " + dambay + " dam");
        System.out.println("Tong dam bay hien tai: " + this.sodamtichluy + " dam");
        System.out.println("Hang the hien tai: " + this.hangthethanhvien);
    }

    //Nang hang the thanh vien
    public void nanghangthe() {
        if(this.hangthethanhvien == 'B' && this.sodamtichluy >= 10000) {
            this.hangthethanhvien = 'S';
            System.out.println("Nang hang the thanh vien len Silver.");
        }
        else if(this.hangthethanhvien == 'S' && this.sodamtichluy >= 50000) {
            this.hangthethanhvien = 'G';
            System.out.println("Nang hang the thanh vien len Gold.");
        }
        else {
            System.out.println("Khong du dieu kien nang the thanh vien");
        }
    }

    //toString

    @Override
    public String toString() {
        return "HanhKhach{" +
                "id='" + id + '\'' +
                ", Tenhanhkhach='" + Tenhanhkhach + '\'' +
                ", namsinh=" + namsinh +
                ", sohochieu='" + sohochieu + '\'' +
                ", idhangbay='" + idhangbay + '\'' +
                ", mathethanhvien='" + mathethanhvien + '\'' +
                ", sodamtichluy=" + sodamtichluy +
                ", hangthethanhvien=" + hangthethanhvien +
                ", danhsachvedadat=" + Arrays.toString(danhsachvedadat) +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
