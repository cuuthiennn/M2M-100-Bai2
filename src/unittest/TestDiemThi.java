package unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import quanlytuyensinhdaihoc.DiemThi;

public class TestDiemThi {
	DiemThi diemThi;
	
	@BeforeEach
	void initialize() {
		this.diemThi = new DiemThi(5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f);
	}
	
	@AfterEach
	void delete() {
		diemThi = null;
	}

	@Test
	void testGetDiemTheoNganhA() {
		float result = diemThi.getDiemTheoKhoi("A");

		float expected = 5f + 5f + 5f;

		assertEquals(expected, result);
	}

	@Test
	void testGetDiemTheoNganhB() {
		float result = diemThi.getDiemTheoKhoi("B");

		float expected = 5f + 5f + 5f;

		assertEquals(expected, result);

	}

	@Test
	void testGetDiemTheoNganhC() {
		float result = diemThi.getDiemTheoKhoi("C");

		float expected = 5f + 5f + 5f;

		assertEquals(expected, result);
	}

	@Test
	void testGetDiemTheoNganhD() {
		float result = diemThi.getDiemTheoKhoi("D");

		float expected = 5f + 5f + 5f;

		assertEquals(expected, result);
	}
}
