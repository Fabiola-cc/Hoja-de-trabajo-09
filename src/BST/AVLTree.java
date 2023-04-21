package BST;

/**
 * The type Avl tree.
 *
 * @param <T> the type parameter
 */
public class AVLTree<T extends Comparable<T>> implements EstructuraArbol<T> {

    private class Node {
        /**
         * The Key.
         */
        T key;
        /**
         * The Height.
         */
        int height;
        /**
         * The Left.
         */
        Node left;
        /**
         * The Right.
         */
        Node right;

        /**
         * Instantiates a new Node.
         *
         * @param key the key
         */
        Node(T key) {
            this.key = key;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int count;

    /**
     * Instantiates a new Avl tree.
     */
    public AVLTree() {
        root = null;
        count = 0;
    }

    // Método add (insertar)
    public void add(T key) {
        if (!search(key)) {
            root = insert(root, key);
            count++;
        }
    }

    // Método get (buscar)
    public T get(T key) {
        Node result = searchNode(root, key);
        return result == null ? null : result.key;
    }

    // Método remove (eliminar)
    public T remove(T key) {
        if (contains(key)) {
            root = remove(root, key);
            count--;
            return key;
        }
        return null;
    }

    // Método count (número de nodos)
    public int count() {
        return count;
    }

    // Método isEmpty (verificar si está vacío)
    public boolean isEmpty() {
        return root == null;
    }

    // Método privado recursivo para insertar una clave en el árbol AVL
    private Node insert(Node node, T key) {
        if (node == null) {
            return new Node(key);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Caso Left-Left
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rotateRight(node);
        }

        // Caso Right-Right
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return rotateLeft(node);
        }

        // Caso Left-Right
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso Right-Left
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Método para obtener la altura del nodo
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Método para obtener el factor de equilibrio del nodo
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Método para rotar a la derecha
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Método para rotar a la izquierda
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // Método privado recursivo para eliminar una clave en el árbol AVL
    private Node delete(Node node, T key) {
        if (node == null) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                node.key = minValue(node.right);
                node.right = delete(node.right, node.key);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Caso Left-Left
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Caso Right-Right
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Caso Left-Right
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso Right-Left
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private T minValue(Node node) {
        T minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }

    private Node searchNode(Node node, T key) {
        if (node == null || node.key.compareTo(key) == 0) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return searchNode(node.left, key);
        } else {
            return searchNode(node.right, key);
        }
    }

    /**
     * Search boolean.
     *
     * @param key the key
     * @return the boolean
     */
// Método público para buscar una clave en el árbol AVL (retorna true si se encuentra)
    public boolean search(T key) {
        return searchNode(root, key) != null;
    }

    /**
     * In order traversal.
     */
// Método para imprimir el árbol en orden ascendente
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.key + " ");
        inOrderTraversal(node.right);
    }

    /**
     * Contains boolean.
     *
     * @param key the key
     * @return the boolean
     */
// Método público contains para verificar si un valor existe en el árbol AVL (retorna true si se encuentra)
    public boolean contains(T key) {
        return contains(root, key);
    }

    // Método privado recursivo contains para buscar un valor en el árbol AVL
    private boolean contains(Node node, T key) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return contains(node.left, key);
        } else if (cmp > 0) {
            return contains(node.right, key);
        } else {
            return true;
        }
    }



    // Método privado recursivo remove para eliminar un valor en el árbol AVL
    private Node remove(Node node, T key) {
        if (node == null) {
            return node;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                node.key = minValue(node.right);
                node.right = remove(node.right, node.key);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Caso Left-Left
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Caso Right-Right
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Caso Left-Right
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso Right-Left
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }
}
