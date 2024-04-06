package PROS.Tests;

import PROS.Client;
import PROS.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTests {
    @Test
    public void testCalculateClientDiscount_BasicDiscountOnly() {
        Client client = new Client(1,"ABC", 5, 0, 0); // Client with basic discount of 5%
        double orderTotal = 5000;

        double discount = Solution.calculateClientDiscount(1, orderTotal);

        assertEquals(250, discount, 0.001); // 5% of 5000
    }

    @Test
    public void testCalculateClientDiscount_OrderTotalLessThan10k() {
        Client client = new Client(1, "ABC",5, 0, 0); // Client with basic discount of 5%

        double orderTotal = 5000;

        double discount = Solution.calculateClientDiscount(1, orderTotal);

        assertEquals(250, discount, 0.001); // 5% of 5000
    }
}
