package quanlytuyensinhdaihoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.ElementNotExistException;

public class QuanLyGiamThi {
	List<GiamThi> danhSachGiamThi;

	public QuanLyGiamThi() {
		this.danhSachGiamThi = new ArrayList<>();
	}

	public void addGiamThi(GiamThi giamThi) {
		if (null == giamThi) {
			throw new IllegalArgumentException("Giam thi khong duoc phep null!!");
		}
		this.danhSachGiamThi.add(giamThi);
	}
	
	public void removeGiamThi(String maGiamThi) {
		int index = 0; 
		for (GiamThi giamThi : danhSachGiamThi) {
			if(giamThi.getMaGiamThi().equals(maGiamThi)) {
				this.danhSachGiamThi.remove(index);
				return;
			}
			index++;
		}
		throw new ElementNotExistException("Giam thi khong ton tai!!");
	}
	
	public void updateGiamThi(GiamThi giamThiUpdate) {
		for (GiamThi giamThi : danhSachGiamThi) {
			if(giamThi.getMaGiamThi().equals(giamThiUpdate.getMaGiamThi())) {
				giamThi.setHoTen(giamThiUpdate.getHoTen());
				giamThi.setDonViCongTac(giamThiUpdate.getDonViCongTac());
				giamThi.setGioTinh(giamThiUpdate.getGioTinh().equals("Nam") ? 1 :0);
				giamThi.setNamSinh(giamThiUpdate.getNamSinh());
				giamThi.setQueQuan(giamThiUpdate.getQueQuan());
				return;
			}
		}
		throw new ElementNotExistException("Giam thi khong ton tai!!");
	}
	
	public void printDanhSachGiamThi() {
		for (GiamThi giamThi : danhSachGiamThi) {
			System.out.println(giamThi.toString());
		}
	}
	
	public void printDanhSachGiamThiByQueQuan(String queQuan) {
		for (GiamThi giamThi : danhSachGiamThi) {
			if(giamThi.getQueQuan().equals(queQuan)) {
				System.out.println(giamThi.toString());
			}
			return;
		}
		throw new ElementNotExistException("Khong ton tai!!");
	}
}
