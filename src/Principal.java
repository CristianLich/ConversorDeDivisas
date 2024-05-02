import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Creamos Scanner para leer los inputs
        Scanner lectura = new Scanner(System.in);
        // instancia del conversor
        ConversorCurrency conversor = new ConversorCurrency();


        MenuCurrency menuCurrency= new MenuCurrency();

        menuCurrency.Menu();


        try {
            System.out.println("\t");
            System.out.println("Por favor ingrese el Simbolo la moneda que posee");
            String moneda1 = lectura.nextLine();
            System.out.println("Por favor ingrese el simbolo de la moneda a la que desea convertir");
            String moneda2 = lectura.nextLine();

            System.out.println("Por favor ingrese el monto que desea convertir");
            Double monto = Double.valueOf(lectura.nextLine());

            Moneda monedaConvertida = conversor.ConvertirMonedas(moneda1, moneda2, monto);

            System.out.println( monto + " " + moneda1 + " son iguales a: " + monedaConvertida.conversion_result() + " " + moneda2);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
