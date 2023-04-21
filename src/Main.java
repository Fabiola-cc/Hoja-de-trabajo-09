import BST.EstructuraArbol;
import BST.Palabra;
import BST.structure5.Association;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Clase Main
 * @author: Fabiola Contreras
 * 
 * A través de esta clase se interactúa con el usuario y se llama a otras clases para permitir el funcionamiento adecuado del programa
 */
public class Main {
    static readFile reader;
    static Scanner sc = new Scanner(System.in);
    static EstructuraArbol<Palabra> Imp_arbol;
    static boolean continuar = true;

    /**
     * Permite iniciar el programa
     * 
     * @param args
     * @throws FileNotFoundException - archivo no encontrado
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nBienvenid@");
        while(continuar){
            int type = solicitarI("¿Qué tipo de árbol desea que se implemente en el programa?\n1.Arbol Rojo-Negro  2.Arbol Splay  3.Arbol AVL");
            Imp_arbol = BST_Factory.getInstance(type);
            menu();
        }
    }

    /**
     * Mantiene el programa funcionando hasta que el usuario desee lo contrario,
     * permite elegir entre leer o traducir datos, además de volver a elegir el tipo de árbol
     * 
     * @throws FileNotFoundException - archivo no encontrado
     */
    public static void menu() throws FileNotFoundException {
        int finish = 0;
        while (finish != 4) {
            switch (solicitarI("¿Qué deseas hacer?\n1. Registrar palabras  2. Traducir oraciones  3. Cambiar de ABB  4. Salir")) {
                case 1 -> { // Registro de palabras
                    reader = new readFile("src/Spanish.txt"); //Crea un objeto tipo readFile con el archivo de texto necesario
                    RegistroL.saveInfo(reader, Imp_arbol);
                    System.out.println("Se ha registrado la información en el archivo 'Spanish.txt'\n");
                }
                case 2 -> { // Traducción de texto
                    System.out.println(
                            "Se leera la información en el archivo 'texto.txt' asegurate de que no tenga elementos extra como puntos para no interferir con el proceso de traducción.");
                    reader = new readFile("src/texto.txt");
                    Traduccion.traduce(reader);
                    System.out.println("\nSe ha traducido toda la información en el archivo 'texto.txt'\n");
                }
                case 3 -> { // Cambiar de arbol
                    continuar = true;
                    finish = 4;
                }
                case 4 -> { // Fin de programa
                    continuar = false;
                    finish = 4;
                }
            }
        }
    }

    /**
     * Imprime una solicitud y recibe un dato tipo int
     * Evita una excepción -InputMismatchException- volviendo a solicitar el dato en
     * caso de que ocurra. (Utilizada continuamente en distintos programas)
     *
     * @author Fabiola Contreras
     * @param solicitud texto que describe lo solicitado
     * @return entero ingresado por el usuario
     */
    public static int solicitarI(String solicitud) {
        System.out.println(solicitud);
        int solicitar = 0;
        boolean correcto = false;
        do {
            try {
                solicitar = sc.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("¡Cuidado! Ingresa un número entero.");
            }
        } while (!correcto);
        sc.nextLine(); // Elimina la posibilidad de saltarse una linea de solicitud después
        return solicitar;
    }
}
