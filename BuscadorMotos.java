import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BuscadorMotos {
    private ArbolBinarioBusqueda arbol;// Atributo que almacena la referencia al árbol binario de búsqueda
 // Constructor de la clase BuscadorMotos
    public BuscadorMotos(ArbolBinarioBusqueda arbol) {
        this.arbol = arbol;
    }
 // Método para buscar motos en el árbol según un criterio
    public List<Moto> buscar(Predicate<Moto> criterio) {
        List<Moto> resultado = new ArrayList<>();
        arbol.inorden(moto -> {
            if (criterio.test(moto)) {
                resultado.add(moto);
            }
        });
        return resultado;
    }
}