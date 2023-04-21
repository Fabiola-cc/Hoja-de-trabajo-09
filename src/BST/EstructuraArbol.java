/**
 * 
 */
package BST;

/**
 * @author MAAG
 *
 */
public interface EstructuraArbol<T> {

	public void add (T value);
	
	public T get (T key);
	
	public T remove (T key);
	
	public int count ();
	
	public boolean isEmpty();
}
