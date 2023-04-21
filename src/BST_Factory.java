import BST.*;
import BST.structure5.Association;

/**
 * Factory
 * Permite la generación de distintos tipos de árbol según sea decidido por el usuario.
 *
 * @author Fabiola Contreras
 */
public class BST_Factory {

    public static EstructuraArbol<Palabra> getInstance (int BST_Type){
        switch (BST_Type) {
            case 1: //Arbol Rojo-Negro
                return new ArbolRojoNegro<Palabra>();

            case 2: //Arbol Splay
                return new ArbolSplay<Palabra>();

            case 3: //Arbol AVL
                return new AVLTree<Palabra>();

            default: //Ninguno seleccionado
                System.out.println("Este no es un tipo de árbol incluido");
                System.out.println("Se implementa un árbol rojo-negro");
                return new ArbolRojoNegro<Palabra>();
        }
    }

}
