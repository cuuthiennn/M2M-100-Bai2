package quanlytuyensinhdaihoc;

public class DiemThi {
	private float toan;
	private float ngoaingu;
	private float nguVan;
	private float sinhHoc;
	private float vatLy;
	private float hoaHoc;
	private float diaLy;
	private float lichSu;
	
	public DiemThi() {
		
	}

	public DiemThi(float toan, float ngoaingu, float nguVan, float sinhHoc, float vatLy, float hoaHoc, float diaLy,
			float lichSu) {
		super();
		this.setToan(toan);
		this.setNgoaingu(ngoaingu);
		this.setNguVan(nguVan);
		this.setSinhHoc(sinhHoc);
		this.setVatLy(vatLy);
		this.setHoaHoc(hoaHoc);
		this.setDiaLy(diaLy);
		this.setLichSu(lichSu);
	}

	public void setToan(float toan) {
		this.toan = toan > 0f ? toan : 0f;
	}

	public void setNgoaingu(float ngoaingu) {
		this.ngoaingu = ngoaingu > 0f ? ngoaingu : 0f;
	}

	public void setNguVan(float nguVan) {
		this.nguVan = nguVan > 0f ? nguVan : 0f;
	}

	public void setSinhHoc(float sinhHoc) {
		this.sinhHoc = sinhHoc > 0f ? sinhHoc : 0f;
	}

	public void setVatLy(float vatLy) {
		this.vatLy = vatLy > 0f ? vatLy : 0f;
	}

	public void setHoaHoc(float hoaHoc) {
		this.hoaHoc = hoaHoc > 0f ? hoaHoc : 0f;
	}

	public void setDiaLy(float diaLy) {
		this.diaLy = diaLy > 0f ? diaLy : 0f;
	}

	public void setLichSu(float lichSu) {
		this.lichSu = lichSu > 0f ? lichSu : 0f;
	}
	
	public float getDiemTheoKhoi(String khoiSetTuyen) {
		if("A" == khoiSetTuyen) {
			return this.toan + this.vatLy + this.hoaHoc;
		}
		if("B" == khoiSetTuyen) {
			return this.toan + this.hoaHoc + this.sinhHoc;
		}
		if("C" == khoiSetTuyen) {
			return this.nguVan + this.lichSu + this.diaLy;
		}
		if("D" == khoiSetTuyen) {
			return this.nguVan + this.toan + this.ngoaingu;
		}
		throw new IllegalArgumentException("Khoi set tuyen khong trung khop!!");
	}

	@Override
	public String toString() {
		return "DiemThi [toan: " + toan + ", ngoaingu: " + ngoaingu + ", nguVan: " + nguVan + ", sinhHoc: " + sinhHoc
				+ ", vatLy: " + vatLy + ", hoaHoc: " + hoaHoc + ", diaLy: " + diaLy + ", lichSu: " + lichSu + "]";
	}
}
