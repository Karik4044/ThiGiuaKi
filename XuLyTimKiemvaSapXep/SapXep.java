package XuLyTimKiemvaSapXep;

import Cautruc.HanhKhach;
import Cautruc.ChuyenBay;
public class SapXep {
    // Sắp xếp hành khách theo dặm bay
    public void sapXepTheoDamBay(HanhKhach[] ds) {
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = 0; j < ds.length - i - 1; j++) {
                if (ds[j].getSodamtichluy() < ds[j+1].getSodamtichluy()) {
                    // Hoán đổi
                    HanhKhach temp = ds[j];
                    ds[j] = ds[j+1];
                    ds[j+1] = temp;
                }
            }
        }
    }
}
