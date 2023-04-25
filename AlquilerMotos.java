import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class AlquilerMotos {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda(ComparadorMoto.porMarca());
        BuscadorMotos buscador = new BuscadorMotos(arbol);

        // Insertar algunas motos
        arbol.insertar(new Moto("kawasaki KLX 110R L", 21000, "Verde", "Enduro"));
        arbol.insertar(new Moto("kawasaki NINJA ZX-10R", 23012, "Verde Golden", "Super Deportiva"));
        arbol.insertar(new Moto("kawasaki VERSYS 1000 S", 0, "Negro", "Super Deportiva"));
        arbol.insertar(new Moto("kawasaki z900", 100, "Azul", "Super Deportiva"));
        arbol.insertar(new Moto("CFMoto 800MT", 1910, "Arena", "Turismo"));
        arbol.insertar(new Moto("Pulsar N250", 18540, "Golden", "Turismo"));
        arbol.insertar(new Moto("TVS Apache RR310", 17800, "Blanca", "Deportiva"));
        arbol.insertar(new Moto("Ducati Streetfighter V4", 0, "Roja", "Hyper Naked"));
        arbol.insertar(new Moto("Harley Davidson Street Bob", 52800, "Blanca", "custom"));
        arbol.insertar(new Moto("SPEED TRIPLE 1200 RR", 1510, "Negro Verde", "Super Deportiva"));

        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;
        //Menú interactivo para gestionar el alquiler de motos
        while (ejecutando) {
        	 System.out.println("---------------------------------");
            System.out.println("Menu:");
            System.out.println("---------------------------------");
            System.out.println("1. Agregar moto");
            System.out.println("---------------------------------");
            System.out.println("2. Ver motos ordenadas");
            System.out.println("---------------------------------");;
            System.out.println("3. Buscar y seleccionar moto");
            System.out.println("---------------------------------");
            System.out.println("4. Salir");
            System.out.println("---------------------------------");
            System.out.print("Ingrese una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.println("---------------------------------");

            switch (opcion) {
                case 1:
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Kilometraje: ");
                    int kilometraje = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();
                    arbol.insertar(new Moto(marca, kilometraje, color, tipo));
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("Motos ordenadas por marca:");
                    arbol.inorden(System.out::println);
                    System.out.println("---------------------------------");
                    break;
                case 3:
                    buscarYSeleccionarMoto(scanner, buscador);
                    System.out.println("---------------------------------");
                    break;
                case 4:
                    ejecutando = false;
                    System.out.println("---------------------------------");
                    break;
                
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
    // Método para buscar y seleccionar una moto según un criterio ingresado por el usuario
    private static void buscarYSeleccionarMoto(Scanner scanner, BuscadorMotos buscador) {
    		// Solicitar criterio y valor de búsqueda
        System.out.print("Ingrese el criterio de busqueda (marca, color, tipo): ");
        String criterio = scanner.nextLine().toLowerCase();
        	// Establecer el filtro de búsqueda según el criterio
        System.out.println("---------------------------------");
        System.out.print("Ingrese el valor de busqueda: ");
        String valor = scanner.nextLine();
        	
        System.out.println("---------------------------------");
        Predicate<Moto> filtro;
     // Buscar las motos que cumplen con el criterio
        switch (criterio) {
            case "marca":
                filtro = moto -> moto.getMarca().equalsIgnoreCase(valor);
                System.out.println("---------------------------------");
                break;
            case "color":
                filtro = moto -> moto.getColor().equalsIgnoreCase(valor);
                System.out.println("---------------------------------");
                break;
            case "tipo":
                filtro = moto -> moto.getTipo().equalsIgnoreCase(valor);
                System.out.println("---------------------------------");
                break;
            default:
                System.out.println("Criterio desconocido. Regresando al menu principal.");
                return;
        }
        List<Moto> resultados = buscador.buscar(filtro);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron motos que cumplan con el criterio.");
        } else {
            System.out.println("Motos encontradas:");
            for (int i = 0; i < resultados.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, resultados.get(i));
            }
            System.out.print("Seleccione una moto ingresando el numero correspondiente (0 para cancelar): ");
            int seleccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            if (seleccion > 0 && seleccion <= resultados.size()) {
                Moto motoSeleccionada = resultados.get(seleccion - 1);
                System.out.println("Moto seleccionada: " + motoSeleccionada);
                // Aquí puedes realizar acciones adicionales con la moto seleccionada, como iniciar el proceso de alquiler.
            } else {
                System.out.println("No se ha seleccionado ninguna moto. Regresando al menu principal.");
            }
        }
    }
}