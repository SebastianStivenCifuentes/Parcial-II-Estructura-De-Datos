public class Nodo {
    Moto moto; // Atributo que almacena la moto en el nodo
    Nodo izquierdo; // Atributo que almacena la referencia al nodo hijo izquierdo
    Nodo derecho; // Atributo que almacena la referencia al nodo hijo derecho

    // Constructor de la clase Nodo
    public Nodo(Moto moto) {
        this.moto = moto;
    }
}