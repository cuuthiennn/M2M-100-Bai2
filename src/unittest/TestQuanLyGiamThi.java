package unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import quanlytuyensinhdaihoc.GiamThi;
import quanlytuyensinhdaihoc.QuanLyGiamThi;

public class TestQuanLyGiamThi {
	QuanLyGiamThi danhSachGiamThi;

	@BeforeEach
	void initialize() {
		GiamThi giamThi = new GiamThi("GT1", "Đại học A", "Nguyễn Văn A", 1, 1987, "TP HCM");
		List<GiamThi> danhSachGiamThi = new ArrayList<>();
		danhSachGiamThi.add(giamThi);
		this.danhSachGiamThi = new QuanLyGiamThi(danhSachGiamThi);
	}

	@AfterEach
	void delete() {
		this.danhSachGiamThi = null;
	}
	
	@Test
	void testAddGiamThi() {
		GiamThi giamThi = new GiamThi("GT2", "Đại học A", "Nguyễn Văn B", 0, 1992, "Cà Mau");
		
		this.danhSachGiamThi.addGiamThi(giamThi);
		
		int expectedSize = 2;
		
		int actualSize = this.danhSachGiamThi.getDanhSachGiamThi().size();
		
		assertEquals(expectedSize, actualSize);
	}
}
