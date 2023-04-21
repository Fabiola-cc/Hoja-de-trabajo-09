/**
 * 
 */
package BST;

/**
 * @author MAAG
 * Ligeramente modificado para una mejor implementación en el programa
 */
public interface EstructuraArbol<T> {

	public void add (T value);
	
	public T get (T key);

	public Boolean has (T key);
	
	public T remove (T key);
	
	public int count ();
	
	public boolean isEmpty();
}
