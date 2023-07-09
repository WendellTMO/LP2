package documin;

import java.util.Comparator;
/**
 * Override do comparator de Strings em ordem de tamanho
 * 
 * @author Wendell Tomé Marinho Oliveira - 122110748
 *
 */
public class OrdemTamanho implements Comparator<String> {

	/**
	 * Ordena o elemento TERMO com base no seu tamanho
	 * 
	 * @param object1 Objeto 1
	 * @param object2 Objeto 2
	 */
	@Override
	public int compare(String object1, String object2) {
		return object2.length() - object1.length();
	}

}
