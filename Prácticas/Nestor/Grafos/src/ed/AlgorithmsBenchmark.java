package ed;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 
 */

/**
 * @author uo252406
 *
 */
public class AlgorithmsBenchmark {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * M�todo que crea un archivo csv en el que se escriben los datos proporcionados.
	 * @param output nombre del archivo que se crea, de tipo String
	 * @throws IOException 
	 */
	public void test0(String output) throws IOException {
		FileWriter file = null;
		PrintWriter pw;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			pw.println("1; 10");
			pw.println("2; 20");
			pw.println("3; 30");
			pw.println("4; 40");
			pw.println("5; 50");
			pw.println("6; 60");
			pw.println("7; 70");
			pw.println("8; 80");
			pw.println("9; 90");
			pw.println("10; 100");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				file.close();
			}
		}
	}
	
	/**
	 * M�todo que crea un archivo csv en el que se escribe el tiempo en milisegundos que tarda el algoritmo linear en funci�n de n.
	 * @param output, nombre del archivo que se crea, de tipo String
	 * @param n, par�mtero que se le pasa al m�todo linear, de tipo int
	 * @throws IOException 
	 */
	public void test1(String output, int n) throws IOException {
		FileWriter file = null;
		PrintWriter pw;
		long startTime;
		long finalTime;
		long eleapsedTime;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			startTime = System.currentTimeMillis();
			Algorithms.linear(n);
			finalTime = System.currentTimeMillis();
			eleapsedTime = finalTime - startTime;
			System.out.println(eleapsedTime);
			pw.println(n + "," + eleapsedTime);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				file.close();
			}
		}
	}
	
	/**
	 * M�todo que crea un archivo csv en el que se escribe el tiempo en milisegundos que tarda el algoritmo linear en funci�n de los par�metros que van
	 * desde startN hasta endN
	 * @param output, nombre del archivo que se crea, de tipo String
	 * @param startN, par�mtero con el que empieza el m�todo linear, de tipo int
	 * @param endN, par�mtero con el que termina el m�todo linear, de tipo int
	 * @throws IOException 
	 */
	public void test2(String output, int startN, int endN) throws IOException {
		FileWriter file = null;
		PrintWriter pw;
		long startTime;
		long finalTime;
		long eleapsedTime;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int workLoad = startN; workLoad <= endN; workLoad++) {
				startTime = System.currentTimeMillis();
				Algorithms.linear(workLoad);
				finalTime = System.currentTimeMillis();
				eleapsedTime = (finalTime - startTime);
				pw.println(workLoad + "," + eleapsedTime);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				file.close();
		}
	}

	/**
	 * M�todo que crea un archivo csv en el que se escribe el tiempo que tarda el algoritmo linear en funci�n de los par�metros que van
	 * desde startN hasta endN haciendo la media de cada uno de ellos.
	 * @param output, nombre del archivo que se crea, de tipo String
	 * @param times, veces que se realiza el m�todo linear, de tipo int
	 * @param startN, par�mtero con el que empieza el m�todo linear, de tipo int
	 * @param endN, par�mtero con el que termina el m�todo linear, de tipo int
	 * @throws IOException
	 */
	public void test3(String output, int times, int startN, int endN)
			throws IOException {
		FileWriter file = null;
		PrintWriter pw;
		long startTime;
		long finalTime;
		long eleapsedTime;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i <= endN; i++) {
				startTime = System.currentTimeMillis();
				for (int j = 0; j <= times; j++) {
					Algorithms.linear(i);
				}
				finalTime = System.currentTimeMillis();
				eleapsedTime = (finalTime - startTime) / times;
				pw.println(i + "," + eleapsedTime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				file.close();
		}
	}
	
	
	/**
	 * Tiempo en milisegundos que tarda en ejecutarse el m�todo �nomMetodo� de la clase �nomClase� con un par�metro entero �n�
	 * @param className, nombre de la clase que se quiere utilizar, de tipo String
	 * @param methodName, nombre del m�todo que se quiere utilizar, de tipo String
	 * @param n,par�metro que se le pasa al m�todo, de tipo int
	 * @throws IOException
	 */
	public long testAlgorithm(String className, String methodName, int n) {
		long tInicial = 0, tFinal = 0;

		Class<?> cl;
		try {
			cl = Class.forName(className);
			Object o = cl.newInstance();
			Method m = cl.getMethod(methodName, int.class);

			tInicial = System.currentTimeMillis();
			m.invoke(o, n);
			tFinal = System.currentTimeMillis();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tFinal - tInicial;
	}


	/**
	 * M�todo que crea un archivo csv en el que se escribe el tiempoen milisegundos que tarda el m�todo de una clase(ambos pasados por par�metros)
	 * en realizar el algor�tmo que se especifica dentro del m�todoen funci�n de los par�metros que van desde startN hasta endN haciendo 
	 * la media de cada uno de ellos.
	 * @param output, nombre del archivo que se crea, de tipo String
	 * @param times, veces que se realiza el m�todo nombreMetodo, de tipo int
	 * @param startN, par�mtero con el que empieza el m�todo, de tipo int
	 * @param endN, par�mtero con el que termina el m�todo, de tipo int
	 * @param nombreClase, nombre de la clase que se utiliza, de tipo String
	 * @param nombreMetodo, nombre del m�todo que se utiliza, de tipo String
	 */
	public void test(String output, int times, int startN, int endN,
			String nombreClase, String nombreMetodo) {

		FileWriter file = null;
		PrintWriter pw;
		long m = 0;
		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int n = startN; n <= endN; n++) {
				for (int i = 0; i <= times; i++) {
					long media = 0;
					media = (media + testAlgorithm(nombreClase, nombreMetodo, n)) / 2;
					m = media;
				}
				pw.println(n + ", " + m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}