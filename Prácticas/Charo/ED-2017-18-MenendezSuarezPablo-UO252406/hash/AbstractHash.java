package hash;

public abstract class AbstractHash<T extends Comparable<T>> {

	/**
	 * Inserta un nuevo elemento en la tabla hash
	 * 
	 * @param elem
	 *            Elemento que se inserta
	 * @return true si lo ha insertado o false en caso contrario
	 */
	abstract public boolean add(T elem);

	/**
	 * Busca y devuelve un elemento de la tabla hash
	 * 
	 * @param elem
	 *            La clave que se busca,
	 * 
	 * @return El elemento encontrado si lo encuentra o null en caso contrario (OJO
	 *         que no debe devolver el buscado)
	 */
	abstract public T find(T elem);

	/**
	 * Borra un elemento que se encuentra en la tabla hash
	 * 
	 * @param elem
	 *            elemento para borrar
	 * @return true si lo ha borrado o false en caso contrario
	 */
	abstract public boolean remove(T elem);

	/**
	 * Realiza una redispersión (aumentando el tamaño) al número primo mayor que el
	 * doble del tamaño actual, y recolocando los elementos
	 * 
	 * @return true si la realiza, false en caso contrario
	 */
	abstract protected boolean reDispersion();

	/**
	 * Realiza una redispersión inversa (disminuyendo el tamaño) al número primo
	 * menor que la mitad del tamaño actual, y recolocando los elementos
	 * 
	 * @return true si la realiza, false en caso contrario
	 */
	abstract protected boolean inverseReDispersion();

	/**
	 * Convierte la tabla a una String que se pueda mostrar de forma "visible"
	 *
	 * @return el String con la información de la tabla hash
	 */
	abstract public String toString();

	/**
	 * Calcula el resultado de aplicar la función hash sobre el parámetro (versión
	 * 2016-17) Utiliza hashCode() Convierte posibles negativos a positivos
	 *
	 * @return el resultado correspondiente
	 */
	abstract protected int fHash(T elem,int intentos);

	/**
	 * 
	 * Calcula si un número positivo es un número primo, los negativos devuelve que
	 * no lo son
	 * 
	 * @param n
	 *            El número que queremos comprobar
	 * @return true si es primo, false en caso contrario
	 */
	protected boolean esPrimo(int n) {
		if (n < 2 || (n > 2 && n % 2 == 0))
			return false;
		if (n <= 7)
			return true;
		for (int i = 3; i * i <= n; i += 2) // impares
			if (n % i == 0)
				return false; // no es primo
		return true;
	}

	/**
	 * @param n
	 *            El número del que se quiere saber el siguiente número primo mayor
	 *            que él
	 * @return El primer número primo mayor que el parámetro
	 */
	protected int numPrimoMayor(int n) {
		int num = n + 1;
		while (!esPrimo(num)) {
			num++;
		}
		return num;
	}

	/**
	 * @param d
	 *            El número del que se quiere saber el anterior número primo menor
	 *            que él.
	 * @return El primer número primo menor, si no hay números primos menores,
	 *         devuelve el menor número primo (positivo) 2
	 */
	protected int numPrimoMenor(double d) {
		if (d <= 2)
			return 2;
		int num = (int) (d - 1);
		while (!esPrimo(num)) {
			num--;
		}
		return num;
	}

	/**
	 * 
	 * @param info
	 * @return
	 */
	protected int obtenerClave(T info) {
		if (info instanceof Integer) {
			return ((Integer) info).intValue();
		} else if (info instanceof String) {
			String clave = (String) info;
			int result = 0;
			for (int i = 0; i < clave.length(); i++) {
				result = result + (int) clave.charAt(i);
			}
			return result;
		} else {
			return info.hashCode();
		}

	}

}
