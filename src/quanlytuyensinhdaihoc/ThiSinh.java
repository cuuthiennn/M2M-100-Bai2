package quanlytuyensinhdaihoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import exception.ElementNotExistException;

public class ThiSinh {
	private Long soBaoDanh;
	private String hoTen;
	private int gioTinh; // 1 la nam 0 la nu
	private int namSinh;
	private String queQuan;
	private DiemThi diemThi;
	private float diemUuTien;
	private List<NguyenVong> danhSachNguyenVong;
	Scanner scan;

	public ThiSinh() {
		this.danhSachNguyenVong = new ArrayList<>();
	}

	public ThiSinh(Long soBaoDanh, String hoTen, int gioTinh, int namSinh, String queQuan, DiemThi diemThi,
			float diemUuTien, NguyenVong nguyenVong) {
		super();
		this.soBaoDanh = soBaoDanh;
		this.hoTen = hoTen;
		this.setGioTinh(gioTinh);
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.setDiemThi(diemThi);
		this.setDiemUuTien(diemUuTien);
		this.danhSachNguyenVong = new ArrayList<>();
		nguyenVong.setDiemXetTuyen(diemUuTien + diemThi.getDiemTheoKhoi(nguyenVong.getKhoiSetTuyen()));
		this.addNguyenVongChoThiSinh(nguyenVong);
	}

	public String getHoTen() {
		return hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public DiemThi getDiemThi() {
		return diemThi;
	}

	public float getDiemUuTien() {
		return diemUuTien;
	}

	public float getDiemXetTuyen(String khoiXetTuyen) {
		return diemUuTien + diemThi.getDiemTheoKhoi(khoiXetTuyen);
	}

	public List<NguyenVong> getDanhSachNguyenVong() {
		return danhSachNguyenVong;
	}

	public void setSoBaoDanh(Long soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public Long getSoBaoDanh() {
		return soBaoDanh;
	}

	public String getGioTinh() {
		return gioTinh > 0 ? "Nam" : "Nu";
	}

	public void setGioTinh(int gioTinh) {
		this.gioTinh = gioTinh > 0 ? 1 : 0;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh > 0 ? namSinh : 0;
	}

	public void setDiemUuTien(float diemUuTien) {
		this.diemUuTien = diemUuTien > 0f ? diemUuTien : 0f;
	}

	public void setDiemThi(DiemThi diemThi) {
		this.diemThi = diemThi;
	}

	public void addNguyenVongChoThiSinh(NguyenVong nguyenVong) {
		if (nguyenVong == null) {
			throw new IllegalArgumentException("Nguyen vong chuyen vao khong duoc phep null!");
		}
		nguyenVong.setDiemXetTuyen(this.diemUuTien + this.diemThi.getDiemTheoKhoi(nguyenVong.getKhoiSetTuyen()));
		this.danhSachNguyenVong.add(nguyenVong);
	}

	public void addNguyenVongChoThiSinh(List<NguyenVong> nguyenVong) {
		if (nguyenVong == null) {
			throw new IllegalArgumentException("Nguyen vong chuyen vao khong duoc phep null!");
		}
		this.danhSachNguyenVong = nguyenVong;
	}

	public void removeNguyenVong(String maNganh, String maTruong) {
		int index = 0;
		for (NguyenVong nguyenVong : danhSachNguyenVong) {
			if (nguyenVong.getMaNganh().equals(maNganh) && nguyenVong.getMaTruong().equals(maTruong)) {
				this.danhSachNguyenVong.remove(index);
				return;
			}
			index++;
		}
		throw new ElementNotExistException("Nguyen vong khong ton tai!!");
	}

	public void updateNguyenVong(String maNguyenVongMuonDoi, String maTruongMuonDoi, NguyenVong nguyenVongUpdata) {
		for (NguyenVong nguyenVong : danhSachNguyenVong) {
			if (nguyenVong.getMaNganh().equals(maNguyenVongMuonDoi)
					&& nguyenVong.getMaTruong().equals(maTruongMuonDoi)) {
				nguyenVong.setMaNganh(nguyenVongUpdata.getMaNganh());
				nguyenVong.setTenNganh(nguyenVongUpdata.getTenNganh());
				nguyenVong.setMaTruong(nguyenVongUpdata.getMaTruong());
				nguyenVong.setKhoiSetTuyen(nguyenVongUpdata.getKhoiSetTuyen());
				nguyenVong.setDiemXetTuyen(
						this.diemThi.getDiemTheoKhoi(nguyenVongUpdata.getKhoiSetTuyen()) + this.diemUuTien);
				return;
			}
		}
		throw new ElementNotExistException("Nguyen vong khong ton tai!!");
	}

	public void swapNguyenVong(int sttNguyenVongSoMot, int sttNguyenVongSoHai) {
		if (danhSachNguyenVong.size() > sttNguyenVongSoHai || danhSachNguyenVong.size() > sttNguyenVongSoMot) {
			NguyenVong tempNguyenVong = danhSachNguyenVong.get(sttNguyenVongSoMot);
			
			danhSachNguyenVong.set(sttNguyenVongSoMot, danhSachNguyenVong.get(sttNguyenVongSoHai));
			danhSachNguyenVong.set(sttNguyenVongSoHai, tempNguyenVong);
			return;
		}
		throw new ArrayIndexOutOfBoundsException("Nguyen vong khong ton tai!!");
	}

	public int getSoThuTuNguyenVong(String maNganh) {
		int result = 0;
		for (NguyenVong nguyenVong : danhSachNguyenVong) {
			if (nguyenVong.getMaNganh().equals(maNganh)) {
				return result + 1;
			}
			result++;
		}
		throw new ElementNotExistException("Nguyen vong khong ton tai!!");
	}

	public NguyenVong getNguyenVong(String maNganh) {
		NguyenVong result;
		for (NguyenVong nguyenVong : danhSachNguyenVong) {
			if (nguyenVong.getMaNganh().equals(maNganh)) {
				result = nguyenVong;
				return result;
			}
		}
		throw new ElementNotExistException("Nguyen vong khong ton tai!!");
	}
	
	public NguyenVong getNguyenVong(String maNganh, String maTruong) {
		NguyenVong result;
		for (NguyenVong nguyenVong : danhSachNguyenVong) {
			if (nguyenVong.getMaNganh().equals(maNganh) 
					&& nguyenVong.getMaTruong().equals(maTruong)) {
				result = nguyenVong;
				return result;
			}
		}
		throw new ElementNotExistException("Nguyen vong khong ton tai!!");
	}

	public NguyenVong checkNguyenVongChungTuyen(String maNganh, float diem) {
		NguyenVong result = new NguyenVong();
		for (NguyenVong nguyenVong : danhSachNguyenVong) {
			if (nguyenVong.getMaNganh().equals(maNganh) && nguyenVong.getDiemXetTuyen() > diem) {
				result = nguyenVong;
				return result;
			}
		}
		return null;
	}

	public void printThiSinh() {
		System.out.println("So bao danh: " + this.soBaoDanh);
		System.out.println("Ho va ten: " + this.hoTen);
		System.out.println("Gioi tinh: " + this.getGioTinh());
		System.out.println("Nam sinh: " + this.namSinh);
		System.out.println("Que quan: " + this.queQuan);
		System.out.println(this.diemThi.toString());
		System.out.println("Diem uu tien: " + this.diemUuTien);
		this.danhSachNguyenVong.forEach(item -> System.out.println(item.toString()));
	}

	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		ThiSinh soSanh = (ThiSinh) o;
		boolean result = soSanh.getDiemUuTien() == this.diemUuTien
						&& soSanh.getGioTinh().equals(this.getGioTinh())
						&& soSanh.getHoTen().equals(this.hoTen)
						&& soSanh.getNamSinh() == this.namSinh
						&& soSanh.getQueQuan().equals(this.queQuan)
						&& soSanh.getSoBaoDanh().equals(this.soBaoDanh);
		return result;
	}
}
