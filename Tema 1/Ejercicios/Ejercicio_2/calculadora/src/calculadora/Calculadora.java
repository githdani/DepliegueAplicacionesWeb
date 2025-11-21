/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;
import java.util.Scanner;
/**
 * Programa que representa una calculadora básica en la terminal.
 * Permite realizar operaciones simples entre dos números
 * con los operadores: suma (+), resta (-), multiplicación (*) y división (/).
 *
 * <p>Ejemplo:</p>
 * <pre>
 *   Ingresa el primer número: 10
 *   Ingresa el operador (+, -, *, /): *
 *   Ingresa el segundo número: 5
 *   Resultado: 50.0
 * </pre>
 *
 * @author Daniel
 */
public class Calculadora {
    /**
    * Método principal que inicia la calculadora.
    * Se ejecuta en la terminal y solicita al usuario dos números
    * y un operador para realizar el cálculo.
    *
    * @param args argumentos de la línea de comandos (no se utilizan).
    */

    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingresa el operador (+, -, *, /): ");
        char operador = sc.next().charAt(0);

        System.out.print("Ingresa el segundo número: ");
        double num2 = sc.nextDouble();

        double resultado;

        switch (operador) {
            case '+':
                resultado = sumar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case '-':
                resultado = restar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case '*':
                resultado = multiplicar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case '/':
                if (num2 != 0) {
                    resultado = dividir(num1, num2);
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Error: no se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operador no válido.");
        }

        sc.close();
    }

    /**
     * Suma dos números.
     *
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public static double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números.
     *
     * @param a primer número
     * @param b segundo número
     * @return la resta de a y b
     */
    public static double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     *
     * @param a primer número
     * @param b segundo número
     * @return el producto de a y b
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números.
     *
     * @param a dividendo
     * @param b divisor (no debe ser 0)
     * @return el cociente de a y b
     * @throws ArithmeticException si el divisor es 0
     */
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }
    
}
