package Cautruc;

public class Ticket {
    private String mave;
    private String machuyenbay;
    private String maghe;
    private char hangghe;
    private double giave;
    private char trangthaive;
    private HanhKhach hanhkhach;
    private String ngaydatve;

    //Constructor
    public Ticket(String mave, String machuyenbay, String maghe, char hangghe, double giave, char trangthaive, HanhKhach hanhkhach, String ngaydatve) {
        this.mave = mave;
        this.machuyenbay = machuyenbay;
        this.maghe = maghe;
        this.hangghe = hangghe;
        this.giave = giave;
        this.trangthaive = trangthaive;
        this.hanhkhach = hanhkhach;
        this.ngaydatve = ngaydatve;
    }

    //Setter & Getter
    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMachuyenbay() {
        return machuyenbay;
    }

    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }

    public String getMaghe() {
        return maghe;
    }

    public void setMaghe(String maghe) {
        this.maghe = maghe;
    }

    public char getHangghe() {
        return hangghe;
    }

    public void setHangghe(char hangghe) {
        this.hangghe = hangghe;
    }

    public double getGiave() {
        return giave;
    }

    public void setGiave(double giave) {
        this.giave = giave;
    }

    public char getTrangthaive() {
        return trangthaive;
    }

    public void setTrangthaive(char trangthaive) {
        this.trangthaive = trangthaive;
    }

    public HanhKhach getHanhkhach() {
        return hanhkhach;
    }

    public void setHanhkhach(HanhKhach hanhkhach) {
        this.hanhkhach = hanhkhach;
    }

    public String getNgaydatve() {
        return ngaydatve;
    }

    public void setNgaydatve(String ngaydatve) {
        this.ngaydatve = ngaydatve;
    }

    //Tinh gia theo hang ghe
    public double Tinhgiave(char hangghe) {
        double giave = 0;
        switch (hangghe) {
            case 'Y':
                giave = 1000000;
                break;
            case 'B':
                giave = 3000000;
                break;
            case 'F':
                giave = 5000000;
                break;
            default:
                throw new IllegalArgumentException("Hang ghe khong hop le");
        }
        // Áp dụng giảm giá theo hạng thẻ
        switch (hanhkhach.getHangthethanhvien()) {
            case 'S':
                giave *= 0.95;
                break;
            case 'G':
                giave *= 0.90;
                break;
        }
        return giave;
    }

    //Tinh phi doi ve
    public double tinhPhiDoiVe() {
        return giave * 0.1; // 10% gia ve
    }

    //toString
    @Override
    public String toString() {
        return "Ticket{" +
                "mave='" + mave + '\'' +
                ", machuyenbay='" + machuyenbay + '\'' +
                ", maghe='" + maghe + '\'' +
                ", hangghe=" + hangghe +
                ", giave=" + giave +
                ", trangthaive=" + trangthaive +
                ", hanhkhach=" + hanhkhach +
                ", ngaydatve='" + ngaydatve + '\'' +
                '}';
    }
}
