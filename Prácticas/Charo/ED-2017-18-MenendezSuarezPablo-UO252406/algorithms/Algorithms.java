package algorithms;

public class Algorithms {
	
	
	static long SLEEP_TIME = 250;

	
	/**
	 * M�todo que duerme el hilo durante el tiempo que se le pasa por constante	SLLEP_TIME
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
	 *  M�todo que realiza un algoritmo con complejidad O(n)
	 * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	 */
	public static void linear(int n) {
		if (n < 0) {
			return;
		}
		
		for (int i = 0; i <= n; i++) {

			doNothing();
		}
	}
	 
	 /**
	  * M�todo que realiza un algoritmo con complejidad O(n^2)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	  */
	public static void quadratic(int n) {
		if (n < 0) {
			return;
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				doNothing();
			}
		}
	}
	 
	 /**
	  * M�todo que realiza un algoritmo  con complejidad O(n^3)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	  */
	public static void cubic(int n) {

		if (n < 0) {
			return;
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= n; k++) {
					doNothing();
				}
			}
		}
	}

	 /**
	  * M�todo que realiza un algoritmo con complejidad O(log n)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	  */
	public static void logarithm(int n) {
		if (n < 0) {
			return;
		}
		for (int i = 1; i <= n; i *= 2) {
			doNothing();
		}

	}


	/**
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro.
	 * La complejidad es lineal, ya que solo tiene un bucle for.
	 * @param n, n�mero al que se le quiere elevar el 2, de tipo int 
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */		 
	public static long pow2iter(int n) {
		if (n < 0) {
			return -1;
		}
		long total = 1;
		if (n > 0)
			for (int i = 0; i < n; i++) {
				doNothing();
				total = total * 2;
			}

		return total;
	}
	
	/**
	 * M�todo iterativo que calcula el factorial de un n�mero que se le pasa por par�metro
	 * @param n n�mero del que se desea averiguar su factorial, de tipo int
	 * @return factorial del n�mero indicado, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */
	public  long factorialIterativo(int n) {
		if (n < 0) {
			return -1;
		}
		long aux = 1;
		for (int i = n; i > 0; i--) {
			doNothing();
			aux *= i;
		}

		return aux;
	}
	
	
	/**
	 * M�todo recursivo que calcula el factorial de un n�mero que se le pasa por par�metro
	 * @param n n�mero del que se desea averiguar su factorial, de tipo int
	 * @return factorial del n�mero indicado, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */
	public  long factorialRec(int n) {
		if (n < 0) {
			return -1;
		}
		doNothing();
		if (n == 0) {
			return 1;
		} else {
			return n * factorialRec(n - 1);
		}
		
	}
	
	
	/**
	 * M�todo iterativo que calcula el t�rmino de la sucesi�n de fibonacci que se le indica
	 * @param n termino de la sucesi�n que se desea averiguar, de tipo int
	 * @return resultado, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */
	public  long fibonacciIterativo(int n) {
		if (n < 0) {
			return -1;
		}
		long n1=0;
		long n2=1;
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}
		else {
			for (int i = 0; i <= n-2; i++) {
				doNothing();
				 n2 = n1 + n2;
		         n1 = n2 - n1;
			}
		}
		return n2;
	}
	
	
	/**
	 * M�todo recursivo que calcula el t�rmino de la sucesi�n de fibonacci que se le indica
	 * @param n termino de la sucesi�n que se desea averiguar, de tipo int
	 * @return resultado, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */
	public long fibonacciRec(int n) {
		if (n >= 0) {
			doNothing();
			if (n == 0) {
				return 0;
			} else if (n == 1) {
				return 1;
			} else {
				return fibonacciRec(n - 1) + fibonacciRec(n - 2);
			}
		}
		return -1;

	}
	


	
	/**
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. 
	 * La complejidad es lineal.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int 
	 * * @return el resulado obtenido, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */	
	public long pow1Rec(int n) {
		if (n >= 0) {
			doNothing();
			if (n == 0) {
				return 1;
			} else {
				return 2 * pow1Rec(n - 1);
			}
		}
		return -1;
	}

	/**
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. 
	 * La complejidad es c�bica.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int
	 * @return el resulado obtenido, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */	
	public long pow2Rec(int n) {
		if (n >= 0) {
			doNothing();
			if (n == 0) {
				return 1;
			} else {
				return pow2Rec(n - 1) + pow2Rec(n - 1);
			}
		}
		return -1;
	}
	
	/**
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. 
	 * La complejidad es logar�tmica.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int
	 * @return el resulado obtenido, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */	
	public long pow3Rec(int n) {
		if (n >= 0) {

			doNothing();
			if (n == 0) {
				return 1;
			} else if (n % 2 == 0) {
				return pow3Rec(n / 2) * pow3Rec(n / 2);
			} else {
				return pow3Rec(n / 2) * pow3Rec(n / 2) * 2;
			}
		}
		return -1;
	}

	/**
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro. 
	 * La complejidad es lineal.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int
	 * @return el resulado obtenido, de tipo long
	 * 			-1 en caso de que el n introducido sea menor que 0
	 */	
	public  long pow4Rec(int n) {
		if (n >= 0) {
			doNothing();
			if (n == 0) {
				return 1;
			} else {
				long aux = pow4Rec(n / 2);
				aux = aux * aux;
				if (n % 2 != 0)
					return aux * 2;
				else
					return aux;
			}
		}
		return -1;
	}
	
	
	
}
