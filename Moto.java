public class Moto {
    // Atributos de la clase Moto

    private String marca;
    private int kilometraje;
    private String color;
    private String tipo;
    // Constructor de la clase Moto
    public Moto(String marca, int kilometraje, String color, String tipo) {
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.color = color;
        this.tipo = tipo;
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 // Método toString para representar la moto en una cadena de texto
    @Override
    public String toString() {
        return "Moto {" +
                "marca= " + marca + '\'' +
                ", kilometraje= " + kilometraje +
                ", color= " + color + '\'' +
                ", tipo= " + tipo + '\'' +
                '}';
    }
}