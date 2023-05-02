package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import exception.ElementNotExistException;
import quanlytuyensinhdaihoc.DiemThi;
import quanlytuyensinhdaihoc.GiamThi;
import quanlytuyensinhdaihoc.NguyenVong;
import quanlytuyensinhdaihoc.QuanLyGiamThi;
import quanlytuyensinhdaihoc.QuanLyThiSinhXetTuyen;
import quanlytuyensinhdaihoc.ThiSinh;

public class Test{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		QuanLyThiSinhXetTuyen danhSachThiSinh = new QuanLyThiSinhXetTuyen();
		QuanLyGiamThi danhSachGiamThi = new QuanLyGiamThi();
		HashMap<String, QuanLyThiSinhXetTuyen> danhSachChungTuyen = new HashMap<>();

		GiamThi giamThi1 = new GiamThi("GT1", "Đại học A", "Nguyễn Văn A", 1, 1987, "TP HCM");
		GiamThi giamThi2 = new GiamThi("GT2", "Đại học A", "Nguyễn Văn B", 0, 1992, "Cà Mau");
		GiamThi giamThi3 = new GiamThi("GT3", "Đại học B", "Nguyễn Văn C", 0, 1990, "An Giang");
		GiamThi giamThi4 = new GiamThi("GT4", "Đại học B", "Nguyễn Văn D", 1, 1991, "TP HCM");

		danhSachGiamThi.addGiamThi(giamThi4);
		danhSachGiamThi.addGiamThi(giamThi3);
		danhSachGiamThi.addGiamThi(giamThi2);
		danhSachGiamThi.addGiamThi(giamThi1);

		DiemThi diemThi1 = new DiemThi(7.5f, 7.8f, 6f, 7.5f, 8f, 8f, 6f, 6f);
		NguyenVong nguyenVong1 = new NguyenVong("MN1", "CNTT", "CN1", "A", 0f);
		ThiSinh thiSinh1 = new ThiSinh(1892l, "Vũ Trọng A", 1, 2005, "Bình Định", diemThi1, 1f, nguyenVong1);

		DiemThi diemThi2 = new DiemThi(5f, 8f, 6f, 7.5f, 7f, 6f, 9.2f, 9f);
		NguyenVong nguyenVong2 = new NguyenVong("MN2", "QTKD", "KD2", "B", 0f);
		ThiSinh thiSinh2 = new ThiSinh(1786l, "Vũ Trọng B", 0, 2005, "TP HCM", diemThi2, 0f, nguyenVong2);

		DiemThi diemThi3 = new DiemThi(7.5f, 7.8f, 6f, 7.5f, 8f, 8f, 6f, 6f);
		NguyenVong nguyenVong3 = new NguyenVong("MN3", "NNA", "NNA1", "C", 0f);
		ThiSinh thiSinh3 = new ThiSinh(1567l, "Vũ Trọng C", 0, 2005, "Bình Phước", diemThi3, 1f, nguyenVong3);

		DiemThi diemThi4 = new DiemThi(10f, 7.8f, 6f, 7.5f, 8f, 10f, 6f, 6f);
		NguyenVong nguyenVong4 = new NguyenVong("MN4", "CNTT", "CN4", "D", 0f);
		ThiSinh thiSinh4 = new ThiSinh(1328l, "Vũ Trọng D", 1, 2005, "Nghệ An", diemThi4, 1f, nguyenVong4);
		thiSinh4.addNguyenVongChoThiSinh(new NguyenVong("MN1", "CNTT", "CN1", "A", 0f));

		danhSachThiSinh.addThiSinh(thiSinh4);
		danhSachThiSinh.addThiSinh(thiSinh3);
		danhSachThiSinh.addThiSinh(thiSinh2);
		danhSachThiSinh.addThiSinh(thiSinh1);

		int luaChonMenu;
		do {
			menu();
			System.out.print("Nhap lua chon de tiep tuc: ");
			luaChonMenu = scan.nextInt();
			switch (luaChonMenu) {
			case 1:
				ThiSinh inputThiSinh = new ThiSinh();
				System.out.print("Nhap so bao danh: ");
				inputThiSinh.setSoBaoDanh(scan.nextLong());
				System.out.print("Nhap ho va ten: ");
				inputThiSinh.setHoTen(scan.nextLine());
				System.out.print("Nhap gioi tinh(0 la nu 1 la nam): ");
				inputThiSinh.setGioTinh(scan.nextInt());
				System.out.print("Nhap nam sinh: ");
				inputThiSinh.setNamSinh(scan.nextInt());
				System.out.print("Nhap que quan: ");
				inputThiSinh.setQueQuan(scan.nextLine());
				System.out.println("Nhap diem thi: ");
				float toan, ngoaingu, nguVan, sinhHoc, vatLy, hoaHoc, diaLy, lichSu;
				System.out.print("Toan: ");
				toan = scan.nextFloat();
				System.out.print("Ngoai ngu: ");
				ngoaingu = scan.nextFloat();
				System.out.print("Ngu van: ");
				nguVan = scan.nextFloat();
				System.out.print("Sinh hoc: ");
				sinhHoc = scan.nextFloat();
				System.out.print("Vat ly: ");
				vatLy = scan.nextFloat();
				System.out.print("Hoa hoc: ");
				hoaHoc = scan.nextFloat();
				System.out.print("Dia ly: ");
				diaLy = scan.nextFloat();
				System.out.print("Lich su: ");
				lichSu = scan.nextFloat();
				inputThiSinh.setDiemThi(new DiemThi(toan, ngoaingu, nguVan, sinhHoc, vatLy, hoaHoc, diaLy, lichSu));
				danhSachThiSinh.addThiSinh(inputThiSinh);
				break;
			case 2:
				GiamThi inputGiamThi = new GiamThi();
				System.out.print("Nhap ma giam thi: ");
				inputGiamThi.setMaGiamThi(scan.next());
				System.out.print("Nhap ho va ten: ");
				inputGiamThi.setHoTen(scan.nextLine());
				System.out.print("Nhap don vi cong tac: ");
				inputGiamThi.setDonViCongTac(scan.nextLine());
				System.out.print("Nhap gioi tinh(0 la nu 1 la nam): ");
				inputGiamThi.setGioTinh(scan.nextByte());
				System.out.print("Nhap nam sinh: ");
				inputGiamThi.setNamSinh(scan.nextInt());
				System.out.print("Nhap que quan: ");
				inputGiamThi.setQueQuan(scan.nextLine());
				danhSachGiamThi.addGiamThi(inputGiamThi);
				break;
			case 3:
				System.out.print("Nhap so bao danh thi sinh muon them nguyen vong: ");
				long soBaoDanh = scan.nextLong();
				for (ThiSinh thiSinh : danhSachThiSinh.getDanhSachThiSinh()) {
					if (thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
						NguyenVong inputNguyenVong = new NguyenVong();
						System.out.print("Nhap ma nganh: ");
						inputNguyenVong.setMaNganh(scan.next());
						System.out.print("Nhap ten nganh: ");
						inputNguyenVong.setTenNganh(scan.nextLine());
						System.out.print("Nhap ma truong: ");
						inputNguyenVong.setMaTruong(scan.next());
						System.out.print("Nhap khoi xet tuyen: ");
						inputNguyenVong.setKhoiSetTuyen(scan.next());
						float diemSo = thiSinh.getDiemThi().getDiemTheoKhoi(inputNguyenVong.getKhoiSetTuyen())
								+ thiSinh.getDiemUuTien();
						inputNguyenVong.setDiemXetTuyen(diemSo);
						thiSinh.addNguyenVongChoThiSinh(inputNguyenVong);
						break;
					}
				}
				throw new ElementNotExistException("Thi sinh khong ton tai!!");
			case 4:
				ThiSinh updateThiSinh = new ThiSinh();
				System.out.print("Nhap so bao danh thi sinh muon updata: ");
				updateThiSinh.setSoBaoDanh(scan.nextLong());
				System.out.print("Nhap ho va ten: ");
				updateThiSinh.setHoTen(scan.nextLine());
				System.out.print("Nhap gioi tinh(0 la nu 1 la nam): ");
				updateThiSinh.setGioTinh(scan.nextInt());
				System.out.print("Nhap nam sinh: ");
				updateThiSinh.setNamSinh(scan.nextInt());
				System.out.print("Nhap que quan: ");
				updateThiSinh.setQueQuan(scan.nextLine());
				System.out.println("Nhap diem thi: ");
				float toanUpdate, ngoainguUpdate, nguVanUpdate, sinhHocUpdate, vatLyUpdate, hoaHocUpdate, diaLyUpdate, lichSuUpdate;
				System.out.print("Toan: ");
				toanUpdate = scan.nextFloat();
				System.out.print("Ngoai ngu: ");
				ngoainguUpdate = scan.nextFloat();
				System.out.print("Ngu van: ");
				nguVanUpdate = scan.nextFloat();
				System.out.print("Sinh hoc: ");
				sinhHocUpdate = scan.nextFloat();
				System.out.print("Vat ly: ");
				vatLyUpdate = scan.nextFloat();
				System.out.print("Hoa hoc: ");
				hoaHocUpdate = scan.nextFloat();
				System.out.print("Dia ly: ");
				diaLyUpdate = scan.nextFloat();
				System.out.print("Lich su: ");
				lichSuUpdate = scan.nextFloat();
				updateThiSinh.setDiemThi(new DiemThi(toanUpdate, ngoainguUpdate, nguVanUpdate, sinhHocUpdate, vatLyUpdate, hoaHocUpdate, diaLyUpdate, lichSuUpdate));
				danhSachThiSinh.updateThiSinh(updateThiSinh);
				break;
			case 5:
				GiamThi updateGiamThi = new GiamThi();
				System.out.print("Nhap ma giam thi muon updata: ");
				updateGiamThi.setMaGiamThi(scan.next());
				scan.next();
				System.out.print("Nhap ho va ten: ");
				updateGiamThi.setHoTen(scan.nextLine());
				System.out.print("Nhap don vi cong tac: ");
				updateGiamThi.setDonViCongTac(scan.nextLine());
				System.out.print("Nhap gioi tinh(0 la nu 1 la nam): ");
				updateGiamThi.setGioTinh(scan.nextByte());
				System.out.print("Nhap nam sinh: ");
				updateGiamThi.setNamSinh(scan.nextInt());
				System.out.print("Nhap que quan: ");
				updateGiamThi.setQueQuan(scan.nextLine());
				danhSachGiamThi.updateGiamThi(updateGiamThi);
				break;
			case 6:
				System.out.print("Nhap so bao danh thi sinh muon updata nguyen vong: ");
				long soBaoDanhUpdataNguyenVong = scan.nextLong();
				System.out.print("Nhap ma nganh muon updata: ");
				String updateMaNganh = scan.next();
				scan.next();
				System.out.print("Nhap ma truong de update: ");
				String updateMaTruong = scan.nextLine();
				NguyenVong updateNguyenVong = new NguyenVong();
				System.out.print("Nhap ma nganh: ");
				updateNguyenVong.setMaNganh(scan.next());
				scan.next();
				System.out.print("Nhap ten nganh: ");
				updateNguyenVong.setTenNganh(scan.nextLine());
				System.out.print("Nhap ma truong: ");
				updateNguyenVong.setMaTruong(scan.next());
				scan.next();
				System.out.print("Nhap khoi xet tuyen: ");
				updateNguyenVong.setKhoiSetTuyen(scan.next());
				updateNguyenVong.setDiemXetTuyen(0f);
				danhSachThiSinh.updataNguyenVongChoThiSinh(soBaoDanhUpdataNguyenVong, updateMaNganh, updateMaTruong, updateNguyenVong);
				break;
			case 7:
				System.out.print("Nhap so bao danh thi sinh muon xoa: ");
				long soBaoDanhRemove = scan.nextLong();
				danhSachThiSinh.removeThiSinh(soBaoDanhRemove);
				break;
			case 8:
				System.out.print("Nhap ma giam thi muon remove: ");
				String maGiapThiRemove = scan.next();
				danhSachGiamThi.removeGiamThi(maGiapThiRemove);
				break;
			case 9:
				System.out.print("Nhap so bao danh thi sinh muon xoa nguyen vong: ");
				long soBaoDanhXoaNguyenVong = scan.nextLong();
				for (ThiSinh a : danhSachThiSinh.getDanhSachThiSinh()) {
					if (a.getSoBaoDanh().equals(soBaoDanhXoaNguyenVong)) {
						System.out.print("Nhap ");
						break;
					}
				}
				throw new ElementNotExistException("Thi sinh khong ton tai!!");
			case 10:
				danhSachThiSinh.printDanhSachThiSinh();
				break;
			case 11:
				danhSachGiamThi.printDanhSachGiamThi();
				break;
			case 12:
				System.out.print("Nhap so bao danh thi sinh: ");
				long soBaoDanhPrint = scan.nextLong();
				danhSachThiSinh.printThiSinhBySoBaoDanh(soBaoDanhPrint);
				break;
			case 13:
				System.out.print("Nhap so bao danh thi sinh: ");
				long soBaoDanhSwap = scan.nextLong();
				int sttThiSinh = danhSachThiSinh.printThiSinhBySoBaoDanh(soBaoDanhSwap);
				System.out.print("Nhap so thu tu nguyen vong muon doi: ");
				int sttNguyenVongMuonDoi = scan.nextInt();
				int sttNguyenVongCanDoi = scan.nextInt();
				danhSachThiSinh.getDanhSachThiSinh().get(sttThiSinh).swapNguyenVong(sttNguyenVongMuonDoi,
						sttNguyenVongCanDoi);
				break;
			case 14:
				String maNganh;
				float diemChuan;
				System.out.print("Nhap ma nganh: ");
				maNganh = scan.next();
				if (!danhSachThiSinh.checkNguyenVongIsExistInsideThiSinh(maNganh)) {
					System.err.println("Ma nganh khong to tai!!");
					break;
				}
				System.out.print("Nhap diem chuan: ");
				diemChuan = scan.nextFloat();
				Boolean isExistMaNganhIntoChungTuyen = danhSachChungTuyen.get(maNganh) != null ? true : false;
				if (isExistMaNganhIntoChungTuyen) {
					System.out.println("Da ton tai!!");
					System.out.println("Press 0 to update or any to exit");
					int checkToContinue = scan.nextInt();
					if (0 != checkToContinue) {
						break;
					}
					danhSachChungTuyen.remove(maNganh);
				}
				danhSachChungTuyen.put(maNganh, danhSachThiSinh.getThiSinhTrungTuyenByMaNganh(maNganh, diemChuan));
				danhSachChungTuyen.get(maNganh).printDanhSachThiSinh();
				break;
			case 15:
				System.out.print("Nhap ma nganh: ");
				String maNganhIsPrinting = scan.next();
				Boolean isExistMaNganh = danhSachChungTuyen.get(maNganhIsPrinting) != null ? true : false;
				if (!isExistMaNganh) {
					System.out.println("Ma nganh khong ton tai!!");
					break;
				}
				danhSachChungTuyen.get(maNganhIsPrinting).printDanhSachThiSinh();
				break;
			case 16:
				danhSachChungTuyen.forEach((key, value) -> {
					value.printDanhSachThiSinh();
				});
				break;
			case 17:
				System.out.print("Nhap ma Nganh muon sap xep: ");
				String maNganhIsSapXep = scan.next();
				Boolean isExistMaNganhSapXep = danhSachChungTuyen.get(maNganhIsSapXep) != null ? true : false;
				if (!isExistMaNganhSapXep) {
					System.out.println("Ma nganh khong ton tai!!");
					break;
				}
				List<ThiSinh> result = danhSachChungTuyen.get(maNganhIsSapXep).getDanhSachThiSinh();
				Collections.sort(result, new Comparator<ThiSinh>() {
					@Override
					public int compare(ThiSinh o1, ThiSinh o2) {
		                return Float.compare(o2.getNguyenVong(maNganhIsSapXep).getDiemXetTuyen(), o1.getNguyenVong(maNganhIsSapXep).getDiemXetTuyen());
		            }
				} );
				danhSachChungTuyen.replace(maNganhIsSapXep, new QuanLyThiSinhXetTuyen(result));
				break;
			case 18:
				danhSachGiamThi.printDanhSachGiamThiByQueQuan("TP HCM");
				break;
			default:
				break;
			}
		} while (luaChonMenu != 0);
	}

	public static void menu() {
		System.out.println("===================== MENU =====================");
		System.out.println("1.Nhap thi sinh.");
		System.out.println("2.Nhap giam thi.");
		System.out.println("3.Nhap nguyen vong cho thi sinh.");
		System.out.println("4.Updata thi sinh.");
		System.out.println("5.Update giam thi.");
		System.out.println("6.Updata nguyen vong cho thi sinh.");
		System.out.println("7.Xoa thi sinh.");
		System.out.println("8.Xoa giam thi");
		System.out.println("9.Xoa nguyen vong cho thi sinh.");
		System.out.println("10.Xuat danh sach thi sinh.");
		System.out.println("11.Xuat danh sach giam thi.");
		System.out.println("12.Xuat thi sinh theo so bao danh.");
		System.out.println("13.Thay doi thu tu nguyen vong cho thi sinh.");
		System.out.println("14.Tao danh sach thi sinh chung tuyen theo ma nganh va diem chuan.");
		System.out.println("15.Xuat danh sach thi sinh chung tuyen theo ma nganh.");
		System.out.println("16.Xuat all thi sinh chung tuyen.");
		System.out.println("17.Sap xep danh sach tuy chon theo diem giam dan.");
		System.out.println("18.Xuat danh sach giam thi que o TP HCM.");
		System.out.println("0.Thoat.");
	}
}
