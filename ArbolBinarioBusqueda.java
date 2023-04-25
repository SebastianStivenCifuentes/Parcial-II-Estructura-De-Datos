import java.util.Comparator;
import java.util.function.Consumer;

public class ArbolBinarioBusqueda {
    private Nodo raiz; // Atributo que almacena la referencia al nodo raíz del árbol
    private Comparator<Moto> comparador; // Comparador para ordenar los nodos en el árbol

    // Constructor de la clase ArbolBinarioBusqueda
    public ArbolBinarioBusqueda(Comparator<Moto> comparador) {
        this.comparador = comparador;
    }

 // Método para insertar una moto en el árbol
    public void insertar(Moto moto) {
        raiz = insertarRecursivo(raiz, moto);
    }

 // Método recursivo para insertar una moto en el árbol
    private Nodo insertarRecursivo(Nodo actual, Moto moto) {
        if (actual == null) {
            return new Nodo(moto);
        }

        int comparacion = comparador.compare(moto, actual.moto);

        if (comparacion < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, moto);
        } else if (comparacion > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, moto);
        } else {
            return actual;
        }

        return actual;
    }
    // Método para recorrer el árbol en inorden y aplicar una acción a cada moto
    public void inorden(Consumer<Moto> action) {
        inordenRecursivo(raiz, action);
    }
 // Método recursivo para recorrer el árbol en inorden y aplicar una acción a cada moto
    private void inordenRecursivo(Nodo actual, Consumer<Moto> action) {
    	if (actual != null) {
    			inordenRecursivo(actual.izquierdo, action);
    				action.accept(actual.moto);
    			inordenRecursivo(actual.derecho, action);
    			}
    		}
		}