package ed;

public class Algorithms {

	private static final long SLEEP_TIME = 5;
	
	/**
	 *  Método que realiza un algoritmo lineal O(n)
	 * @param n, número de veces que se repite el algoritmo, de tipo long
	 */
	public static void linear(int n) {

		for (int i = 0; i <= n; i++) {

			doNothing();
		}
	}
	 
	 /**
	  * Método que realiza un algoritmo lineal O(n^2)
	  * @param n, número de veces que se repite el algoritmo, de tipo long
	  */
	public static void quadratic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				doNothing();
			}
		}
	}
	 
	 /**
	  * Método que realiza un algoritmo lineal O(n^3)
	  * @param n, número de veces que se repite el algoritmo, de tipo long
	  */
	public static void cubic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					doNothing();
				}
			}
		}
	}

	 /**
	  * Método que realiza un algoritmo  logarítmico
	  * @param n, número de veces que se repite el algoritmo, de tipo long
	  */
	public static void logarithm(int n) {

		for (long i = n; i > 0; i = i / 2) {
			doNothing();
		}

	}
	 
	/**
	 * Método que duerme el hilo durante el tiempo que se le pasa por constante	SLLEP_TIME
	 * @return 0 si no salta ninguna excepción. -1 si salta alguna excepción
	 */
	 public static int doNothing(){
		try {
			Thread.sleep(SLEEP_TIME);
			return 0;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. La complejidad es lineal.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int 
	 */		 
	public static long pow2iter(int n) {
		long total = 1;
		if (n > 0)
			for (long i = 0; i < n; i++) {
				doNothing();
				total = total * 2;
			}

		return total;

	}
	 
	/**
	 * Método que relaiza un algoritmo que calcula el factorial de un número
	 * @param n, numéro al que se le quiere calcular su factorial, de tipo int
	 */	
	public long fac(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return n * fac(n - 1);
		}

	}
	
	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. La complejidad es lineal.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int 
	 */	
	public long pow2rec1(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return 2 * pow2rec1(n - 1);
		}
	}
	
	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. La complejidad es cúbica.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int
	 */	
	public long pow2rec2(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return pow2rec2(n - 1) + pow2rec2(n - 1);
		}
	}
	
	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. La complejidad es logarítmica.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int
	 */	
	public long pow2rec3(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return pow2rec3(n / 2) + pow2rec3(n / 2);
		} else {
			return pow2rec3(n / 2) + pow2rec3(n / 2) * 2;
		}
	}

	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. La complejidad es lineal.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int
	 */	
	public static long pow2rec4(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			long aux = pow2rec4(n / 2);
			aux = aux * aux;
			if (n % 2 != 0)
				return aux * 2;
			else
				return aux;
		}
	}
}
	