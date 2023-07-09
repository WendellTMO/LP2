package documin;

import java.util.Comparator;
/**
 * Override do comparator de Strings em ordem alfabetica
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class OrdemAlfabetica implements Comparator<String> {

	/**
	 * Ordena o elemento TERMO com base em sua ordem alfabetica
	 * @param object1 Objeto 1
	 * @param object2 Objeto 2
	 */
	@Override
	public int compare(String object1, String object2) {
		return object1.toLowerCase().compareToIgnoreCase(object2);
	}

}
