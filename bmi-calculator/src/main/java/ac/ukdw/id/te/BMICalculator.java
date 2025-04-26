package ac.ukdw.id.te;

public class BMICalculator {
    public static String calculateBMI(double weightKg, double heightM) {
        if (weightKg <= 0 || heightM <= 0) {
            throw new IllegalArgumentException("Berat badan dan tinggi badan harus lebih besar dari 0");
        }

        double bmi = weightKg / (heightM * heightM);
        
        if (bmi < 18.5)
            return "Kurang berat badan";
        else if (bmi >= 18.5 && bmi < 24.9)
            return "Normal";
        else if (bmi >= 25 && bmi < 29.9)
            return "Kelebihan berat badan";
        else
            return "Obesitas";
    }
}
