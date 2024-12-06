package XuLyTimKiemvaSapXep;

import java.util.Arrays;
import Cautruc.ChuyenBay;

public class TimKiem {
    // Tìm chuyến bay theo nhiều tiêu chí
    public ChuyenBay[] timChuyenBay(String ngayBay, String sanBayDi, String sanBayDen, ChuyenBay[] danhSachChuyenBay) {
        ChuyenBay[] ketQua = new ChuyenBay[100];
        int count = 0;

        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb != null &&
                    cb.getNgaybay().equals(ngayBay) &&
                    cb.getSanbaydi().equals(sanBayDi) &&
                    cb.getSanbayden().equals(sanBayDen)) {
                ketQua[count++] = cb;
            }
        }

        return Arrays.copyOf(ketQua, count);
    }
}
