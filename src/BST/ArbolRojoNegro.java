package BST;
import BST.structure5.RedBlackSearchTree;

/**
 * @author MAAG
 * Árbol Binario de Búsqueda Balanceado - ROJO NEGRO
 * Ligeramente modificado para una mejor implementación en el programa
 */
public class ArbolRojoNegro<T extends Comparable<T>> implements EstructuraArbol<T> {

	private RedBlackSearchTree<T> miArbolInterno;
	
	public ArbolRojoNegro() {
		miArbolInterno = new RedBlackSearchTree<T>();
	}
	
	@Override
	public void add(T value) {
		miArbolInterno.add(value);
	}

	@Override
	public T get(T key) {
		return miArbolInterno.get(key);
	}

	@Override
	public Boolean has(T key) { return miArbolInterno.contains(key);}

	@Override
	public T remove(T key) {
		return miArbolInterno.remove(key);
	}

	@Override
	public int count() {
		return miArbolInterno.size();
	}

	@Override
	public boolean isEmpty() {
		return miArbolInterno.isEmpty();
	}
	
	public RedBlackSearchTree<T> getInternalTree(){
		return miArbolInterno;
	}

}
