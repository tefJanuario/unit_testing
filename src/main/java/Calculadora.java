
public class Calculadora {

	public int soma(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		System.out.println(calc.soma(2, 3) == 5);
		System.out.println(calc.soma(3, 3) == 7);
		System.out.println(calc.soma(6, 5) == 11);
	}
}
