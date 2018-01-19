/**
 * 
 */
package Tests;

import java.io.IOException;

import org.junit.Test;

import ed.AlgorithmsBenchmark;

/**
 * @author UO252406
 *
 */
public class AlgorithmsBenchmarkTest {

	/**
	 * @throws IOException
	 * @throws java.lang.Exception
	 */

	// Pruebas del algortimo linear
	@Test
	public void linearTest() {
		AlgorithmsBenchmark algorithmsBenchmark = new AlgorithmsBenchmark();

		algorithmsBenchmark.test("linearTest.txt", 3, 1, 10, "ed.Algorithms",
				"linear");
	}

	// Pruebas del algortimo quadratic
	@Test
	public void quadraticTest() {
		AlgorithmsBenchmark algorithmsBenchmark = new AlgorithmsBenchmark();

		algorithmsBenchmark.test("quadraticTest.txt", 3, 1, 10,
				"ed.Algorithms", "quadratic");
	}

	// Pruebas del algortimo cubic
	@Test
	public void cubicTest() {
		AlgorithmsBenchmark algorithmsBenchmark = new AlgorithmsBenchmark();

		algorithmsBenchmark.test("cubicTest.txt", 3, 1, 10, "ed.Algorithms",
				"cubic");
	}

	// Pruebas del algortimo logarithm
	@Test
	public void logarithmTest() {
		AlgorithmsBenchmark algorithmsBenchmark = new AlgorithmsBenchmark();

		algorithmsBenchmark.test("logarithmTest.txt", 3, 1, 10,
				"ed.Algorithms", "logarithm");
	}

	// Pruebas de los algoritmos:factorial,pow2iter,pow2rec1,pow2rec2,pow2rec3,pow2rec4
	@Test
	public void testTest() throws IOException {
	
		AlgorithmsBenchmark algorithmsBenchmark = new AlgorithmsBenchmark();


		algorithmsBenchmark.test("factorial", 3, 1, 10, "ed.Algorithms", "fac");
		algorithmsBenchmark.test("pow2iter", 3, 1, 10, "ed.Algorithms", "pow2iter");
		algorithmsBenchmark.test("pow2rec1", 3, 1, 10, "ed.Algorithms", "pow2rec1");
		algorithmsBenchmark.test("pow2rec2", 3, 1, 10, "ed.Algorithms", "pow2rec2");
		algorithmsBenchmark.test("pow2rec3", 3, 1, 10, "ed.Algorithms", "pow2rec3");
		algorithmsBenchmark.test("pow2rec4", 3, 1, 10, "ed.Algorithms", "pow2rec4");

	}
}

