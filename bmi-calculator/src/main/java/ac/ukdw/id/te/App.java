package ac.ukdw.id.te;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan berat badan (kg): ");
            double berat = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Masukkan tinggi badan (m): ");
            double tinggi = Double.parseDouble(scanner.nextLine());
            
            String kategoriBMI = BMICalculator.calculateBMI(berat, tinggi);
            System.out.println("Kategori BMI: " + kategoriBMI);
            
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka yang benar.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            
        } finally {
            scanner.close();
        }
    }
}
