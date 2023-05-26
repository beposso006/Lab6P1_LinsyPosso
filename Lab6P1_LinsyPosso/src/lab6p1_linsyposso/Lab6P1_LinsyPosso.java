/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_linsyposso;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author CARMEN POSSO
 */
public class Lab6P1_LinsyPosso {
static Scanner Leer = new Scanner (System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         boolean seguir = true;
        
        while (seguir){
            System.out.println(" MENU ");
            System.out.println("1.¿Cuántos primos tienes?");
            System.out.println("2.Frecuencia de letras");
            System.out.println("3.Salir");
            System.out.println("Ingrese una opcion: ");
            int op = Leer.nextInt();
            switch (op){
                case 1:
                    System.out.println("Ingrese es tamaño del arreglo: ");
                    int tamaño = Leer.nextInt();
                    while (tamaño <=1){
                        System.out.println("El arreglo tiene que ser mayor que 1");
                        System.out.println("Ingrese un nuevo tamaño: ");
                        tamaño = Leer.nextInt();
                    }
                    System.out.println("Ingrese el limite inferior: ");
                    int limiteI = Leer.nextInt();
                    System.out.println("Ingrese el limite superior: ");
                    int limiteS = Leer.nextInt();
                    while (limiteS <= limiteI){
                        System.out.println("El limite superior tiene que ser mayor que el inferior");
                        System.out.println("Ingrese el limite superior nuevamente: ");
                        limiteS = Leer.nextInt();   
                    }
                    int [] array = genRandArray (tamaño, limiteI, limiteS);
                    int [] respuesta = getTotalPrimeCount (array);
                    for (int i = 0; i < array.length; i++) {
                        System.out.print("["+array[i]+"]");
                    }
                    System.out.println("");
                    for (int i = 0; i < respuesta.length; i++) {
                        System.out.print("["+respuesta[i]+"]");   
                    }
                    break;
                    
                case 2:
                    Scanner lea = new Scanner (System.in);
                    System.out.println("Ingrese una palabra: ");
                    String palabra = lea.nextLine();
                    
                    int [] array2 = extraerFrecuencias(palabra);
                    for (int i = 0; i < array2.length; i++) {
                        System.out.print("["+array2[i]+"]");
                        
                    }
                    break;
                    
                case 3: 
                     default:
                System.out.println("Byee:)");
                break;
            }
        // TODO code application logic here
    }
    
}
 public static int[] genRandArray(int tamaño, int limiteI, int limiteS) {
    int[] arreglo = new int[tamaño];
    Random random = new Random();
    for (int i = 0; i < tamaño; i++) { 
        arreglo[i] = random.nextInt(limiteS - limiteI + 1) + limiteI;
        }
        return arreglo;
 }
  public static boolean isPrime (int num){
       if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
  }
  public static int countPrimeFactors (int num){
      int count = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && isPrime(i)) {
                count++;
            }
        }
        return count;
  }
   public static int[] getTotalPrimeCount(int[] array) {
        int[] primeCounts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            primeCounts[i] = countPrimeFactors(array[i]);
        }
        return primeCounts;
    }
    public static int[] extraerFrecuencias(String cadena) {
        int[] frecuencias = new int[33];
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);

            switch (letra) {
                case 'ñ':
                    frecuencias[26]++;
                    break;
                case 'á':
                    frecuencias[27]++;
                    break;
                case 'é':
                    frecuencias[28]++;
                    break;
                case 'í':
                    frecuencias[29]++;
                    break;
                case 'ó':
                    frecuencias[30]++;
                    break;
                case 'ú':
                    frecuencias[31]++;
                    break;
                case 'ü':
                    frecuencias[32]++;
                    break;
                default:
                    if (letra >= 'a' && letra <= 'z') {
                        int indice = letra - 'a';
                        frecuencias[indice]++;
                    }
            }
        }
        return frecuencias;
    }
        }

 
  
