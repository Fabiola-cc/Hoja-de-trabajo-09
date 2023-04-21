package src;

import structure5.AbstractList;
import structure5.DoublyLinkedList;
import structure5.SinglyLinkedList;

/**
 * Factory
 * Permite la generación de distintos tipos de Lista según sea decidido por el usuario.
 *
 * @date 21/02/2023
 * @author Fabiola Contreras
 */
public class List_Factory {

    public static <T> AbstractList getInstance (int TipoL){
        switch (TipoL){
            case 1:
                return new SinglyLinkedList();

            case 2:
                return new DoublyLinkedList();

            default:
                return null;
        }
    }

}
