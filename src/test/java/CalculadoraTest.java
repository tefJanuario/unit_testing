import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

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
//		Assertions.fail("Falhou pelo motivo A");
	}
	
	@Test
	public void deveRetornarNumIntNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(6, 2);
		Assertions.assertEquals(3, resultado);
	}
	
	@Test
	public void deveRetornarNumNegativoNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(6, -2);
		Assertions.assertEquals(-3, resultado);
	}
	
	@Test
	public void deveRetornarNumDecimalNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(10, 3);
		Assertions.assertEquals(3.3333332538604736, resultado);
		Assertions.assertEquals(3.33, resultado, 0.01);
	}
	
	@Test
	public void deveRetornarZeroComNumeradorZeroNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(0, 2);
		Assertions.assertEquals(0, resultado);
	}
	
	@Test
	public void deveLancarExcecaoDividirPorZero_Junit4() {		
		try {			
			float resultado = 10 / 0;
			Assertions.fail("Deveria ter sido lançado uma exceção na divisão");
		} catch (ArithmeticException e) {
			Assertions.assertEquals("/ by zero", e.getMessage());
		}
	}
	
	@Test
	public void deveLancarExcecaoDividirPorZero_Junit5() {
		ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
			float resultado = 10 / 0;
		});
		Assertions.assertEquals("/ by zero", exception.getMessage());
	}
	
	
}
