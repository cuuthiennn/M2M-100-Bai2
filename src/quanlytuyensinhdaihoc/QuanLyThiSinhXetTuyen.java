package quanlytuyensinhdaihoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.ElementNotExistException;

public class QuanLyThiSinhXetTuyen {
	List<ThiSinh> danhSachThiSinh;

	public QuanLyThiSinhXetTuyen() {
		this.danhSachThiSinh = new ArrayList<>();
	}

	public QuanLyThiSinhXetTuyen(List<ThiSinh> danhSachThiSinh) {
		this.danhSachThiSinh = danhSachThiSinh;
	}

	public List<ThiSinh> getDanhSachThiSinh(){
		return this.danhSachThiSinh;
	}
	
	public void addThiSinh(ThiSinh thiSinh) {
		if (null == thiSinh) {
			throw new IllegalArgumentException("Thi sinh khong duoc phep null!!");
		}
		this.danhSachThiSinh.add(thiSinh);
	}

	public void removeThiSinh(Long soBaoDanh) {
		int index = 0;
		for (ThiSinh thiSinh : this.danhSachThiSinh) {
			if (thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
				this.danhSachThiSinh.remove(index);
				return;
			}
			index++;
		}
		throw new ElementNotExistException("Thi sinh can xoa khong ton tai!!");
	}
	
	public void updateThiSinh(ThiSinh thiSinhUpdate) {
		for (ThiSinh thiSinh : this.danhSachThiSinh) {
			if (thiSinh.getSoBaoDanh().equals(thiSinhUpdate.getSoBaoDanh())) {
				thiSinh.setHoTen(thiSinhUpdate.getHoTen());
				thiSinh.setGioTinh(thiSinhUpdate.getGioTinh().equals("Nam") ? 1 : 0);
				thiSinh.setNamSinh(thiSinhUpdate.getNamSinh());
				thiSinh.setQueQuan(thiSinhUpdate.getQueQuan());
				thiSinh.setDiemThi(thiSinhUpdate.getDiemThi());
				return;
			}
		}
		throw new ElementNotExistException("Thi sinh can update khong ton tai!!");
	}
	
	public void updataNguyenVongChoThiSinh(Long soBaoDanh, String maNguyenVongMuonDoi, String maTruongMuonDoi, NguyenVong nguyenVongUpdata) {
		for (ThiSinh thiSinh : danhSachThiSinh) {
			if(thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
				nguyenVongUpdata.setDiemXetTuyen(thiSinh.getDiemXetTuyen(nguyenVongUpdata.getKhoiSetTuyen()) + thiSinh.getDiemUuTien());
				thiSinh.updateNguyenVong(maNguyenVongMuonDoi, maTruongMuonDoi, nguyenVongUpdata);
				return;
			}
		}
		throw new ElementNotExistException("Thi sinh can updata nguyen vong khong ton tai!!");
	}
	
	public boolean checkNguyenVongIsExistInsideThiSinh(String maNganh) {
		for (ThiSinh thiSinh : danhSachThiSinh) {
			if(thiSinh.getSoThuTuNguyenVong(maNganh) != 0) {
				return true;
			}
		}
		return false;
	}
	
	public QuanLyThiSinhXetTuyen getThiSinhTrungTuyenByMaNganh(String maNganh, float diemChuan) {
		if(!checkNguyenVongIsExistInsideThiSinh(maNganh)) {
			throw new ElementNotExistException("Nguyen vong khong ton tai!!");
		}
		QuanLyThiSinhXetTuyen result = new QuanLyThiSinhXetTuyen();
		for (ThiSinh thiSinh : danhSachThiSinh) {
			if(thiSinh.checkNguyenVongChungTuyen(maNganh, diemChuan) != null) {
				result.addThiSinh(thiSinh);
			}
		}
		return result;
	}
	
	public int printThiSinhBySoBaoDanh(long soBaoDanh) {
		int count = 0;
		for (ThiSinh thiSinh : danhSachThiSinh) {
			if(thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
				thiSinh.printThiSinh();
				return count;
			}
			count++;
		}
		throw new ElementNotExistException("Thi sinh khong ton tai!!");
	}
	
	public void printDanhSachThiSinh() {
		for (ThiSinh thiSinh : danhSachThiSinh) {
			thiSinh.printThiSinh();
		}
	}
}
