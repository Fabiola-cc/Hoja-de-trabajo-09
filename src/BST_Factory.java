import BST.*;
import BST.structure5.Association;

/**
 * Factory
 * Permite la generación de distintos tipos de árbol según sea decidido por el usuario.
 *
 * @date 21/04/2023
 * @author Fabiola Contreras
 */
public class BST_Factory {

    public static EstructuraArbol<Palabra> getInstance (int BST_Type){
        switch (BST_Type) {
            case 1:
                return new ArbolRojoNegro<Palabra>();

            case 2:
                return new ArbolSplay<Palabra>();

            case 3:
                return new AVLTree<Palabra>();

            default:
                System.out.println("Este no es un tipo de árbol incluido");
                return null;
        }
    }

}
