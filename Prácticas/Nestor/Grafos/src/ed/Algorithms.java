package ed;

public class Algorithms {

	private static final long SLEEP_TIME = 5;
	
	/**
	 *  M�todo que realiza un algoritmo lineal O(n)
	 * @param n, n�mero de veces que se repite el algoritmo, de tipo long
	 */
	public static void linear(int n) {

		for (int i = 0; i <= n; i++) {

			doNothing();
		}
	}
	 
	 /**
	  * M�todo que realiza un algoritmo lineal O(n^2)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo long
	  */
	public static void quadratic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				doNothing();
			}
		}
	}
	 
	 /**
	  * M�todo que realiza un algoritmo lineal O(n^3)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo long
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
	  * M�todo que realiza un algoritmo  logar�tmico
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo long
	  */
	public static void logarithm(int n) {

		for (long i = n; i > 0; i = i / 2) {
			doNothing();
		}

	}
	 
	/**
	 * M�todo que duerme el hilo durante el tiempo que se le pasa por constante	SLLEP_TIME
	 * @return 0 si no salta ninguna excepci�n. -1 si salta alguna excepci�n
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
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. La complejidad es lineal.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int 
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
	 * M�todo que relaiza un algoritmo que calcula el factorial de un n�mero
	 * @param n, num�ro al que se le quiere calcular su factorial, de tipo int
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
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. La complejidad es lineal.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int 
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
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. La complejidad es c�bica.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int
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
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. La complejidad es logar�tmica.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int
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
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. La complejidad es lineal.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int
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
	