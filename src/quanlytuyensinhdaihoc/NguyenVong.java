package quanlytuyensinhdaihoc;

public class NguyenVong {
	private String maNganh;
	private String tenNganh;
	private String maTruong;
	private String khoiSetTuyen;
	private float diemXetTuyen;

	public NguyenVong() {

	}

	public NguyenVong(String maNganh, String tenNganh, String maTruong, String khoiSetTuyen, float diemThi) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.maTruong = maTruong;
		this.khoiSetTuyen = khoiSetTuyen;
		this.diemXetTuyen = diemThi;
	}
	
	public String getMaNganh() {
		return maNganh;
	}

	public String getMaTruong() {
		return maTruong;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public String getKhoiSetTuyen() {
		return khoiSetTuyen;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public void setKhoiSetTuyen(String khoiSetTuyen) {
		this.khoiSetTuyen = khoiSetTuyen;
	}

	public void setMaTruong(String maTruong) {
		this.maTruong = maTruong;
	}

	public void setDiemXetTuyen(float diemThi) {
		this.diemXetTuyen = diemThi > 0f ? diemThi : 0f;
	}
	
	public float getDiemXetTuyen() {
		return diemXetTuyen;
	}
	
	@Override
	public String toString() {
		return "NguyenVong [maNganh: " + maNganh + ", tenNganh: " + tenNganh + ", maTruong: " + maTruong
				+ ", khoiSetTuyen: " + khoiSetTuyen + ", diemThi: " + diemXetTuyen + "]";
	}
}
