import BST.EstructuraArbol;
import BST.Palabra;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * @author
 *         Fabiola Contreras
 * @category Hoja de trabajo #7
 *           Propósito: Leer el arhivo txt para obtener los datos de traducción
 * @date 24/03/2023
 */

public class readFile {
    private File toRead;
    private Scanner myReader;

    readFile(String fpath) throws FileNotFoundException {
        toRead = new File(fpath);
    }

    /**
     * Registra las palabras presentes en el archivo de texto, teniendo como
     * clave la palabra en ingles (en primera posición)
     * 
     * @return arbol binario de busqueda con información recopilada - clave: palabra
     *         en ingles, valor: palabra en español
     * @throws FileNotFoundException - archivo no encontrado
     */
    public EstructuraArbol<Palabra> _readEnglish(EstructuraArbol<Palabra> tree) throws FileNotFoundException {
        myReader = new Scanner(toRead);

        while (myReader.hasNextLine()) {
            String[] temp = myReader.nextLine().split(",");
            if (!temp[0].isBlank()) {
                String eng = temp[0].trim().toLowerCase();
                String sp = temp[1].trim().toLowerCase();

                Palabra use = new Palabra(eng, sp);
                tree.add(use);
            }
        }
        myReader.close();

        return tree;
    }

    /**
     * Registra y divide las palabras que se desean traducir
     * 
     * @return ArrayList con frases a traducir, separadas por palabra
     * @throws FileNotFoundException - archivo no encontrado
     */
    public ArrayList<String[]> Traduce() throws FileNotFoundException {
        myReader = new Scanner(toRead);
        ArrayList<String[]> frases = new ArrayList<>();
        String[] words = { "" };

        while (myReader.hasNextLine()) {
            words = myReader.nextLine().split(" ");
            if (!words[0].isBlank()) {
                frases.add(words);
            }

        }

        return frases;
    }
}
