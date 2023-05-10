package unittest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.ElementNotExistException;
import quanlytuyensinhdaihoc.DiemThi;
import quanlytuyensinhdaihoc.NguyenVong;
import quanlytuyensinhdaihoc.QuanLyThiSinhXetTuyen;
import quanlytuyensinhdaihoc.ThiSinh;

public class TestQuanLySinhVienXetTuyen {
	
	QuanLyThiSinhXetTuyen danhSachThiSinh;
	
	@BeforeEach
	void initialize() {
		danhSachThiSinh = new QuanLyThiSinhXetTuyen();
		DiemThi diemThi2 = new DiemThi(5f, 8f, 6f, 7.5f, 7f, 6f, 9.2f, 9f);
		NguyenVong nguyenVong2 = new NguyenVong("MN2", "QTKD", "KD2", "B", 0f);
		ThiSinh thiSinh2 = new ThiSinh(1786l, "Vũ Trọng B", 0, 2005, "TP HCM", diemThi2, 0f, nguyenVong2);
		
		danhSachThiSinh.addThiSinh(thiSinh2);
	}
	
	@AfterEach
	void delete() {
		danhSachThiSinh.getDanhSachThiSinh().clear();
	}
	
	@Test
	void testAddThiSinh() {
		
		
		int expected = 1;
		int actual = danhSachThiSinh.getDanhSachThiSinh().size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testExceptionAddThiSinh() throws Exception{
		try {
			danhSachThiSinh.addThiSinh(null);
			fail("Not throw an exception");
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	void testRemoveThiSinh() {
		danhSachThiSinh.removeThiSinh(1786l);
		
		int expected = 0;
		int actual = danhSachThiSinh.getDanhSachThiSinh().size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testExceptionRemoveThiSinh() throws Exception{
		try {
			danhSachThiSinh.removeThiSinh(1l);
			fail("Not throw an exception");
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e instanceof ElementNotExistException);
		}
	}
	
	@Test
	void testExceptionUpdateThiSinh() throws Exception{
		try {
			ThiSinh thiSinh = new ThiSinh();
			danhSachThiSinh.updateThiSinh(thiSinh);
			fail("Not throw an exception");
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e instanceof ElementNotExistException);
		}
	}
	
	@Test
	void testUpdateThiSinh() {
		DiemThi diemThi2 = new DiemThi(5f, 8f, 6f, 7.5f, 7f, 6f, 9.2f, 9f);
		NguyenVong nguyenVong2 = new NguyenVong("MN2", "QTKD", "KD2", "B", 0f);
		ThiSinh thiSinhUpdate = new ThiSinh(1786l, "Vũ Trọng A", 0, 2005, "TP HCM", diemThi2, 0f, nguyenVong2);
		danhSachThiSinh.updateThiSinh(thiSinhUpdate);
		
		String expectedName = "Vũ Trọng A";
		String actualName = danhSachThiSinh.getThiSinhBySoBaoDanh(1786l).getHoTen();
		
		assertEquals(expectedName, actualName);
	}
	
	@Test
	void testExceptionUpdateNguyenVongChoThiSinh() throws Exception{
		try {
			danhSachThiSinh.updataNguyenVongChoThiSinh(null, null, null, null);
			fail("Not throw an exception");
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e instanceof ElementNotExistException);
		}
	}
	
	@Test
	void testUpdateNguyenVongChoThiSinh() {
		NguyenVong expected = new NguyenVong("MN", "CNTT", "CN", "A", 0f);
		
		danhSachThiSinh.updataNguyenVongChoThiSinh(1786l, "MN2", "KD2", expected);
		
		NguyenVong actualNguyenVong = danhSachThiSinh.getThiSinhBySoBaoDanh(1786l).getNguyenVong(expected.getMaNganh(), expected.getMaTruong());
		
		assertEquals(expected, actualNguyenVong);	
	}
	
	@Test
	void testCheckNguyenVongisExist() {
		boolean expected = true;
		
		boolean actual = danhSachThiSinh.checkNguyenVongIsExistInsideThiSinh("MN2");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testExceptionGetThiSinhTrungTuyen() throws Exception{
		try {
			danhSachThiSinh.getThiSinhTrungTuyenByMaNganh("CN", 0f);
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e instanceof ElementNotExistException);
		}
	}
	
	@Test
	void testGetThiSinhTrungTuyen() {
		DiemThi diemThi2 = new DiemThi(5f, 8f, 6f, 7.5f, 7f, 6f, 9.2f, 9f);
		NguyenVong nguyenVong2 = new NguyenVong("MN2", "QTKD", "KD2", "B", 0f);
		ThiSinh thiSinh2 = new ThiSinh(1786l, "Vũ Trọng B", 0, 2005, "TP HCM", diemThi2, 0f, nguyenVong2);
		
		QuanLyThiSinhXetTuyen expected = new QuanLyThiSinhXetTuyen();
		expected.addThiSinh(thiSinh2);
		
		QuanLyThiSinhXetTuyen actual = danhSachThiSinh.getThiSinhTrungTuyenByMaNganh("MN2", 1f);
		
		assertEquals(expected, actual);
	}
}
