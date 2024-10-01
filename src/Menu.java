import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void seleccion() throws IOException {
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.println("Escriba el monto de dinero a convertir: ");
            double monto = teclado.nextDouble();
            System.out.println("Elija la opción a conertir:");
            System.out.println("""
                     1) Dólar ==> Peso chileno
                     2) Peso Chileno ==> Dolar
                     3) Dólar  ==> Real brasileño
                     4) Real Brasileño ==> Dólar
                     5) Dólar ==> Peso colombiano
                     6) Peso colombiano ==> Dólar
                     7) Dólar ==> Peso argentino
                     8) Peso argentino ==> Dólar
                     9) Salir
                     Elija una opción válida:
                    ********************
                    """);
            int opcion = teclado.nextInt();
            if(opcion == 9){
                System.out.println("Muchas gracias por utilizar la aplicación");
                break;
            }else{
                ConversorDeMonedas conversor = new ConversorDeMonedas();
                switch (opcion) {
                    case 1:
                        conversor.buscador("USD","CLP", monto);
                        break;
                    case 2:
                        conversor.buscador("CLP","USD",monto);
                        break;
                    case 3:
                        conversor.buscador("USD", "BRL",monto);
                        break;
                    case 4:
                        conversor.buscador("BRL", "USD",monto);
                        break;
                    case 5:
                        conversor.buscador("USD", "COP",monto);
                        break;
                    case 6:
                        conversor.buscador("COP", "USD",monto);
                        break;
                    case 7:
                        conversor.buscador("USD", "ARS",monto);
                        break;
                    case 8:
                        conversor.buscador("ARS", "USD",monto);
                        break;
                    default:
                        System.out.println("Debe elegir una opción válida");
                }
            }
        }
    }
}
