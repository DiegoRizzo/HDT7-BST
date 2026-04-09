import java.text.Normalizer;

public class Palabra {

    private String espanol;
    private String frances;

    public Palabra(String espanol, String frances) {
        this.espanol = espanol;
        this.frances = frances;
    }

    public String getEspanol() {
        return espanol;
    }

    public String getFrances() {
        return frances;
    }

    // Método para normalizar las palabras, eliminando acentos y convirtiendo la palabra a minúsculas
    // Esto significa que "é" se convertirá en "e", con el fin de ordenar las palabras en orden alfabético sin considerar los acentos.
    public String normalize(String texto) {
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return normalized.toLowerCase();
    }

    public int compareTo(Palabra otra) {
        return normalize(frances).compareTo(normalize(otra.frances));
    }

    @Override
    public String toString() {
        return frances + " --> " + espanol;
    }
    
}
