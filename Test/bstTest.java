import BST.AVLTree;
import BST.ArbolRojoNegro;
import BST.ArbolSplay;
import BST.Palabra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class bstTest {
    ArbolRojoNegro<Palabra> RN = new ArbolRojoNegro<>();
    ArbolSplay<Palabra> AS = new ArbolSplay<>();
    AVLTree<Palabra> AVL = new AVLTree<>();

    @Test
    void getInstance() {
        //A pesar de hacerse un cast para comprobar el dato, si factory retorna un dato incorrecto el test falla
        RN = (ArbolRojoNegro<Palabra>) BST_Factory.getInstance(1);
        AS = (ArbolSplay<Palabra>) BST_Factory.getInstance(2);
        AVL = (AVLTree<Palabra>) BST_Factory.getInstance(3);
    }

    @Test
    void AVL_SetGet(){
        Palabra try1 = new Palabra("Hello", "hola");
        AVL.add(try1);

        assertEquals(AVL.get(try1), try1);
    }

    @Test
    void RN_SetGet(){
        Palabra try2 = new Palabra("Cat", "gato");
        RN.add(try2);

        assertEquals(RN.get(try2), try2);
    }

    @Test
    void AS_SetGet(){
        Palabra try3 = new Palabra("Dog", "perro");
        AS.add(try3);

        assertEquals(AS.get(try3), try3);
    }
}