package Ch38_JUNIT;

import static org.junit.Assert.*;

import org.junit.Test;

public class C01JunitTestCase {

	
	//assert : 주장하다 , 확인하다
	@Test
	public void test1() {
		assertEquals(5, 5);
		assertEquals(5, 3);
	}
	@Test
	public void test2() {
       assertTrue(4 % 2 == 0);
       assertTrue(5 % 2 == 0);
	}
	@Test
	public void test3() {
       assertFalse(4 % 2 == 0);
       assertFalse(5 % 2 == 0);
	}	
	
    @Test
    public void test4() {
        String str = null;
        assertNull(str);
        assertNotNull(str);
    }
    

    @Test
    public void test5() {
        String str1 = "Hello";
        String str2 = "Hello";
        assertSame(str1, str2);
        assertNotSame(str1, str2);

    }
    @Test
    public void testArrayEquality() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testException() {
//        MyCalculator calculator = new MyCalculator();
//        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
    
 
    
    
}
