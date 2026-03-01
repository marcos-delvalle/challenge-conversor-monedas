import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String apikey = "614fb8e55910e36cc99f4f08";
        Scanner lectura = new Scanner(System.in);
        List<Conversion> historial = new ArrayList<>();
        List<String> registro = new ArrayList<>();

        ConsultaAPI transferencia = new ConsultaAPI();
        while (true){
            String valor1 = "";
            String valor2 = "";

            System.out.println("= = = = = = = = = = = = = = =");
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("1) USD a ARS");
            System.out.println("2) ARS a USD");
            System.out.println("3) USD a R$");
            System.out.println("4) R$ a USD");
            System.out.println("5) USD a COP");
            System.out.println("6) COP a USD");
            System.out.println("7) - SALIR");
            System.out.println("= = = = = = = = = = = = = = =");

            int ingreso = lectura.nextInt();

            if (ingreso != 7) {
                if (ingreso>0 && ingreso<7){
                    switch (ingreso){
                        case 1: valor1 = "USD"; valor2 = "ARS"; break;
                        case 2: valor1 = "ARS"; valor2 = "USD"; break;
                        case 3: valor1 = "USD"; valor2 = "BRL"; break;
                        case 4: valor1 = "BRL"; valor2 = "USD"; break;
                        case 5: valor1 = "USD"; valor2 = "COP"; break;
                        case 6: valor1 = "COP"; valor2 = "USD"; break;
                    }
                    String tipoDeCambio = valor1 + "/" + valor2;

                    System.out.println("Ingrese la cantidad: ");
                    double monto = lectura.nextDouble();

                    Conversion conversion = transferencia.convertir(tipoDeCambio,monto);
                    historial.add(conversion);
                    System.out.println("El valor ingresado: [ " + monto + " " + valor1 + " ]" +
                            " corresponde a " + conversion.conversion_result() + " " + valor2);
                    registro.add("- " + monto + " " + valor1 + " --> " + conversion.conversion_result() + " " + valor2);

                    GeneradorDeArchivo generador = new GeneradorDeArchivo();
                    try {
                        generador.guardarJson(historial);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }else {
                    System.out.println("Ingreso inválido");
                }
            }else {
                System.out.println("Saliendo...");
                System.out.println("Registro de operaciones realizadas:");
                registro.forEach(System.out::println);
                return;
            }
        }
    }
}