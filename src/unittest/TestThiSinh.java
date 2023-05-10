package unittest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.ElementNotExistException;
import quanlytuyensinhdaihoc.DiemThi;
import quanlytuyensinhdaihoc.NguyenVong;
import quanlytuyensinhdaihoc.ThiSinh;

public class TestThiSinh {
	ThiSinh thiSinh;
	
	@BeforeEach
	void initialize() {
		DiemThi diemThi = new DiemThi(10f, 7.8f, 6f, 7.5f, 8f, 10f, 6f, 6f);
		NguyenVong nguyenVong = new NguyenVong("MN4", "CNTT", "CN4", "D", 0f);
		this.thiSinh = new ThiSinh(1328l, "Vũ Trọng D", 1, 2005, "Nghệ An", diemThi, 1f, nguyenVong);
	}
	
	@AfterEach
	void delete() {
		this.thiSinh = null;
	}
	
	@Test
	void testGetNguyenVong() {
		NguyenVong expected = new NguyenVong("MN4", "CNTT", "CN4", "D", 0f);
		
		String actualMaNganh = expected.getMaNganh();
		
		assertEquals(expected, this.thiSinh.getNguyenVong(actualMaNganh));
	}
	
	@Test
	void testAddNguyenVongChoThiSinh() {
		NguyenVong expected = new NguyenVong("MN5", "KT", "KT4", "A", 0f);
		
		thiSinh.addNguyenVongChoThiSinh(expected);
		
		assertEquals(expected, thiSinh.getNguyenVong("MN5"));
	}
	
	@Test
	void testAddListNguyenVongChoThiSinh() {
		NguyenVong nguyenVong1 = new NguyenVong("MN1", "KT", "KT1", "A", 0f);
		NguyenVong nguyenVong2 = new NguyenVong("MN2", "CNTT", "CN1", "A", 0f);
		
		List<NguyenVong> listNguyenVong = new ArrayList<>();
		listNguyenVong.add(nguyenVong2);
		listNguyenVong.add(nguyenVong1);
		
		thiSinh.addNguyenVongChoThiSinh(listNguyenVong);
		
		String actualMaNganh = nguyenVong1.getMaNganh();
		
		assertEquals(nguyenVong1, thiSinh.getNguyenVong(actualMaNganh));
	}
	
	@Test
	void testRemoveNguyenVong() {
		thiSinh.removeNguyenVong("MN4", "CN4");
		
		int expected = 0;
		int actual = thiSinh.getDanhSachNguyenVong().size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckNguyenVongChungTuyen() {
		NguyenVong expected = new NguyenVong("MN4", "CNTT", "CN4", "D", 0f);
		
		String actualMaNganh = "MN4";
		float diemChungTuyen = 10;
		
		NguyenVong actual = thiSinh.checkNguyenVongChungTuyen(actualMaNganh, diemChungTuyen);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSoThuTuNguyenVong() {
		int actual = thiSinh.getSoThuTuNguyenVong("MN4");
		int expected = 1;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testExceptionSwapNguyenVong() throws Exception{
		try {
			thiSinh.swapNguyenVong(2, 3);
			fail("Not throw an exception");
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e instanceof ElementNotExistException);
		}
	}
	
	@Test
	void testSwapNguyenVong() {
		NguyenVong expected = new NguyenVong("MN4", "CNTT", "CN4", "D", 0f);
		thiSinh.addNguyenVongChoThiSinh(expected);
		
		thiSinh.swapNguyenVong(0, 1);
		
		NguyenVong actual = thiSinh.getDanhSachNguyenVong().get(0);
		
		assertEquals(expected, actual);
	}
	
}
