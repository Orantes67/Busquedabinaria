import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivo {
    private Arbolproducto arbol;

    public Archivo(Arbolproducto arbol) {
        this.arbol = arbol;
    }

    public void escribirInformacion() {
        try (FileWriter fichero = new FileWriter("prueba.txt")) {
            PrintWriter pw = new PrintWriter(fichero);

            pw.println("Recorrido Inorden:");
            escribirInorden(arbol.getRaiz(), pw);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void escribirInorden(Nodo raiz, PrintWriter pw) {
        if (raiz != null) {
            escribirInorden(raiz.getIzq(), pw);
            if (raiz.getDato().getCantidad() > 5) { 
                pw.println(raiz.getDato().getCodigo() + " - " + raiz.getDato().getNombre());
            }
            escribirInorden(raiz.getDer(), pw);
        }
    }
}
