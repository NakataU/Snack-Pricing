package PROS.Tests;

import PROS.Product;
import org.junit.Test;

import static PROS.Solution.round;
import static org.junit.Assert.assertEquals;

public class ProductTests {

    @Test
    public void testCalculatePromotionalUnitPrice_NoPromotion() {

        Product product = new Product(1, "Cherry Pie",10, 0,0);

        double unitPrice = product.calculatePromotionalUnitPrice(5);

        assertEquals(10, unitPrice, 0.001);
    }

    @Test
    public void testCalculatePromotionalUnitPrice_WithPromotion() {

        Product product = new Product(1, "Cherry Pie",10, 0,0);

        double unitPrice = product.calculatePromotionalUnitPrice(5);

        assertEquals(10, unitPrice, 0.001);
    }

    @Test
    public void testCalculatePromotionalUnitPrice_SpecialPromotion() {

        Product product = new Product(1, "Cherry Pie",10, 0,0);

        double unitPrice = product.calculatePromotionalUnitPrice(3);

        assertEquals(10, unitPrice, 0.001);
    }

    @Test
    public void testCalculateStandardUnitPrice_NoMarkup() {
        // Given
        Product product = new Product(1, "Cherry Pie",10, 0,0);

        // When
        double standardUnitPrice = product.calculateStandardUnitPrice();

        // Then
        assertEquals(10.0, standardUnitPrice, 0.001);
    }

    @Test
    public void testCalculateStandardUnitPrice_WithMarkup() {
        // Given
        Product product = new Product(1, "Cherry Pie",10, 0.1,0);

        // When
        double standardUnitPrice = product.calculateStandardUnitPrice();

        // Then
        assertEquals(11.0, standardUnitPrice, 0.001);
    }

    @Test
    public void testRound_PositiveValue_PositivePlaces() {
        // Given
        double value = 3.456789;
        int places = 3;

        // When
        double roundedValue = round(value, places);

        // Then
        assertEquals(3.457, roundedValue, 0.001);
    }

    @Test
    public void testRound_PositiveValue_NegativePlaces() {
        // Given
        double value = 3.456789;
        int places = -2;

        // Then
        try {
            // When
            round(value, places);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Number of decimal places cannot be negative", e.getMessage());
        }
    }

    @Test
    public void testRound_NegativeValue_PositivePlaces() {
        // Given
        double value = -3.456789;
        int places = 2;

        // When
        double roundedValue = round(value, places);

        // Then
        assertEquals(-3.46, roundedValue, 0.001);
    }

    @Test
    public void testRound_ZeroValue() {
        // Given
        double value = 0.0;
        int places = 2;

        // When
        double roundedValue = round(value, places);

        // Then
        assertEquals(0.0, roundedValue, 0.001);
    }
}
