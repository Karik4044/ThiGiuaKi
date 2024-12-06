package Cautruc;

public class Ghe {

    //Thuoc tinh
    private String maghe;
    private char hangghe;
    private boolean trangthai;
    private double giacoban;

    //Phuong thuc
    //Constructor
    public Ghe(String maghe, char hangghe, boolean trangthai, double giacoban) {
        this.maghe = maghe;
        this.hangghe = hangghe;
        this.trangthai = trangthai;
        this.giacoban = giacoban;
    }

    //Setter & Getter

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

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public double getGiacoban() {
        return giacoban;
    }

    public void setGiacoban(double giacoban) {
        this.giacoban = giacoban;
    }

    //toString()
    @Override
    public String toString() {
        return "Ghe{" +
                "maghe='" + maghe + '\'' +
                ", hangghe=" + hangghe +
                ", trangthai=" + trangthai +
                ", giacoban=" + giacoban +
                '}';
    }
}
