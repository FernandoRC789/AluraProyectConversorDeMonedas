import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option=0;

        do {
            System.out.println("****************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]\n");

            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir");

            System.out.println("Elija una opción válida: ");
            System.out.println("****************************************************");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Limpiar
                if (option>= 1 && option <= 6){
                    System.out.println("Ingrese el valor que desea convertir:");
                    double cantidadMoneda = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar
                    ConversionDeMonedas convertirMoneda = new ConversionDeMonedas();
                    String result = convertirMoneda.convertirMoneda(option,cantidadMoneda);
                    System.out.println(result);
                } else if (option !=7) {
                    System.out.println("⚠️ Opción inválida. Por favor, elija un número del 1 al 7.");
                }
            }catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida. Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar entrada inválida para evitar bucle infinito
            }
        }while(option != 7);
        scanner.close();
        System.out.println("Gracias por usar el conversor de Monedas...");
    }
}
