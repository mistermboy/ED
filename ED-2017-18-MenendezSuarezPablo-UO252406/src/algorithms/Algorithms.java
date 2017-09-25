package algorithms;

public class Algorithms {
	
	
	static long SLEEP_TIME = 250;

	
	/**
	 * Método que duerme el hilo durante el tiempo que se le pasa por constante	SLLEP_TIME
	 * 
	 */
	private static void doNothing() {
		try {
			Thread.sleep(SLEEP_TIME);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	/**
	 *  Método que realiza un algoritmo con complejidad O(n)
	 * @param n, número de veces que se repite el algoritmo, de tipo int
	 */
	public static void linear(int n) {
		
		for (int i = 0; i <= n; i++) {

			doNothing();
		}
	}
	 
	 /**
	  * Método que realiza un algoritmo con complejidad O(n^2)
	  * @param n, número de veces que se repite el algoritmo, de tipo int
	  */
	public static void quadratic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				doNothing();
			}
		}
	}
	 
	 /**
	  * Método que realiza un algoritmo  con complejidad O(n^3)
	  * @param n, número de veces que se repite el algoritmo, de tipo int
	  */
	public static void cubic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= n; k++) {
					doNothing();
				}
			}
		}
	}

	 /**
	  * Método que realiza un algoritmo con complejidad O(log n)
	  * @param n, número de veces que se repite el algoritmo, de tipo int
	  */
	public static void logarithm(int n) {
		for (int i = 1; i <= n; i*=2) {
			doNothing();
		}

	}


	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parï¿½metro.
	 * La complejidad es lineal, ya que solo tiene un bucle for.
	 * @param n, número al que se le quiere elevar el 2, de tipo int 
	 */		 
	public static long pow2iter(int n) {
		long total = 1;
		if (n > 0)
			for (int i = 0; i < n; i++) {
				doNothing();
				total = total * 2;
			}

		return total;
	}
	
	/**
	 * Método iterativo que calcula el factorial de un número que se le pasa por parámetro
	 * @param n número del que se desea averiguar su factorial, de tipo int
	 * @return factorial del número indicado, de tipo long
	 */
	public static long factorial(int n) {
		long aux = 1;
		for (int i = n; i > 0; i--) {
			aux *= i;
		}

		return aux;
	}
	
	
	/**
	 * Método recursivo que calcula el factorial de un número que se le pasa por parámetro
	 * @param n número del que se desea averiguar su factorial, de tipo int
	 * @return factorial del número indicado, de tipo long
	 */
	public static long factorialRec(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return n * factorialRec(n - 1);
		}
		
	}
	
	
	/**
	 * Método iterativo que calcula el término de la sucesión de fibonacci que se le indica
	 * @param n termino de la sucesión que se desea averiguar, de tipo int
	 * @return resultado, de tipo long
	 */
	public static long fibonacci(int n) {
		long aux=0;
		doNothing();
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else if(n==2) {
			return 1;
		}
		else {
			for (int i = 3; i <= n; i++) {
				aux += n-1;
			}
		}
		return aux;
	}
	
	
	/**
	 * Método recursivo que calcula el término de la sucesión de fibonacci que se le indica
	 * @param n termino de la sucesión que se desea averiguar, de tipo int
	 * @return resultado, de tipo long
	 */
	public static long fibonacciRec(int n) {
		doNothing();
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return  fibonacciRec(n-1) + fibonacciRec(n-2);
		}
		
	}
	


	
	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. 
	 * La complejidad es lineal.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int 
	 */	
	public long pow1(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return 2 * pow1(n - 1);
		}
	}
	
	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. 
	 * La complejidad es cúbica.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int
	 */	
	public long pow2(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return pow2(n - 1) + pow2(n - 1);
		}
	}
	
	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. 
	 * La complejidad es logarítmica.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int
	 */	
	public long pow3(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return pow3(n / 2) * pow3(n / 2);
		} else {
			return pow3(n / 2) * pow3(n / 2) * 2;
		}
	}

	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parámetro. 
	 * La complejidad es lineal.
	 * @param n, numéro al que se le quiere elevar el 2, de tipo int
	 */	
	public static long pow4(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			long aux = pow4(n / 2);
			aux = aux * aux;
			if (n % 2 != 0)
				return aux * 2;
			else
				return aux;
		}
	}
	
	
	
}
