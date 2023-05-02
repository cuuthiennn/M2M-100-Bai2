package quanlytuyensinhdaihoc;

public class GiamThi {
	private String maGiamThi;
	private String donViCongTac;
	private String hoTen;
	private int gioTinh; //1 la nam 0 la nu
	private int namSinh;
	private String queQuan;

	public GiamThi(String maGiamThi, String donViCongTac, String hoTen, int gioTinh, int namSinh, String queQuan) {
		super();
		this.maGiamThi = maGiamThi;
		this.donViCongTac = donViCongTac;
		this.hoTen = hoTen;
		this.setGioTinh(gioTinh);
		this.setNamSinh(namSinh);
		this.queQuan = queQuan;
	}

	@Override
	public String toString() {
		return "GiamThi [maGiamThi: " + maGiamThi + ", donViCongTac: " + donViCongTac + ", hoTen: " + hoTen + ", gioTinh: "
				+ (gioTinh > 0 ? "Nam" : "Nu") + ", namSinh: " + namSinh + ", queQuan: " + queQuan + "]";
	}

	public GiamThi() {

	}

	public String getMaGiamThi() {
		return maGiamThi;
	}

	public void setMaGiamThi(String maGiamThi) {
		this.maGiamThi = maGiamThi;
	}

	public String getDonViCongTac() {
		return donViCongTac;
	}

	public void setDonViCongTac(String donViCongTac) {
		this.donViCongTac = donViCongTac;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioTinh() {
		return gioTinh > 0 ? "Nam" : "Nu";
	}

	public void setGioTinh(int gioTinh) {
		this.gioTinh = gioTinh > 0 ? 1 : 0;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh > 0 ? namSinh : 0;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

}
