import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BinaryTree arbol = new BinaryTree();
        File myObj = new File("diccionario.txt");

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(", ");
                if (partes.length == 2) {
                    String frances = partes[0].trim().toLowerCase();
                    String espanol = partes[1].trim().toLowerCase();
                    Palabra palabra = new Palabra(espanol, frances);
                    arbol.insert(palabra);
                }
            }
            
            System.out.println("-=- Recorrido In-Order (Ordenado Alfabéticamente) -=-");
            arbol.inorder();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
}
