import java.util.Comparator;

public class ComparadorMoto {
	// Comparador por marca
    public static Comparator<Moto> porMarca() {
        return Comparator.comparing(Moto::getMarca);
    }
    // Comparador por kilometraje

    public static Comparator<Moto> porKilometraje() {
        return Comparator.comparingInt(Moto::getKilometraje);
    }
    // Comparador por color

    public static Comparator<Moto> porColor() {
        return Comparator.comparing(Moto::getColor);
    }
    // Comparador por tipo

    public static Comparator<Moto> porTipo() {
        return Comparator.comparing(Moto::getTipo);
    }
}