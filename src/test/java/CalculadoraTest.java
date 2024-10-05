import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	@Test
	public void testSomar() {
		Calculadora calc = new Calculadora();
		Assertions.assertTrue(calc.soma(2, 3) == 5);
		Assertions.assertEquals(5, calc.soma(2, 3));
	}
	
	@Test
	public void assertivas() {
		Assertions.assertEquals("casa", "casa");
		Assertions.assertNotEquals("Casa", "casa");
		Assertions.assertTrue("Casa".equalsIgnoreCase("CASA"));
		Assertions.assertTrue("Casa".endsWith("sa"));
		Assertions.assertFalse("Casa".startsWith("ca"));
		
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();
		List<String> s3 = null;
		
		Assertions.assertEquals(s1, s2);
		Assertions.assertSame(s1, s1);
		Assertions.assertNotEquals(s1, s3);
		Assertions.assertNull(s3);
		Assertions.assertNotNull(s2);
		Assertions.fail("Falhou pelo motivo A");
	}
	
}
