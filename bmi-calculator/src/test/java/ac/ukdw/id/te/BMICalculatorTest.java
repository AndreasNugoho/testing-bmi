package ac.ukdw.id.te;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "45, 1.60, 'Kurang berat badan'", 
        "50, 1.60, 'Normal'",
        "60, 1.75, 'Normal'",            
        "70, 1.75, 'Normal'",            
        "80, 1.75, 'Kelebihan berat badan'", 
        "90, 1.75, 'Kelebihan berat badan'",
        "100, 1.75, 'Obesitas'",         
    })
    @DisplayName("Test BMI dengan berbagai kombinasi berat dan tinggi")
    public void testCalculateBMI(double weightKg, double heightM, String expectedCategory) {
        assertEquals(expectedCategory, BMICalculator.calculateBMI(weightKg, heightM));
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 1.7",   
        "70, -1.7", 
        "-10, -2"    
    })
    @DisplayName("Test exception jika input negatif")
    public void testCalculateBMIWithNegativeValues(double weightKg, double heightM) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(weightKg, heightM));
        assertEquals("Berat badan dan tinggi badan harus lebih besar dari 0", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "0, 2",
        "50, 0"
    })
    @DisplayName("Test input nol pada berat atau tinggi")
    public void testCalculateBMIWithZeroValues(double weightKg, double heightM) {
        if (weightKg == 0 && heightM == 0) {
            return;   
        }

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> BMICalculator.calculateBMI(weightKg, heightM));

        if (heightM == 0) {
            assertEquals("Berat badan dan tinggi badan harus lebih besar dari 0", ex.getMessage());
        } else {
            assertEquals("Berat badan dan tinggi badan harus lebih besar dari 0", ex.getMessage());
        }
    }

}
