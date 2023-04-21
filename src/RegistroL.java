import BST.EstructuraArbol;
import BST.Palabra;
import java.io.FileNotFoundException;

/**
 * @author Fabiola Contreras
 * Mantiene el árbol donde se registra cada palabra para el diccionario
 */
public class RegistroL {
    static EstructuraArbol<Palabra> inglesK;

    /**
     * Llama a la clase readFile para leer el documento deseado y retornar los datos
     * del archivo en el formato adecuado
     * 
     * @param reader
     * @throws FileNotFoundException
     */
    public static void saveInfo(readFile reader, EstructuraArbol<Palabra> tree) throws FileNotFoundException {
        inglesK = reader._readEnglish(tree);

    }

}