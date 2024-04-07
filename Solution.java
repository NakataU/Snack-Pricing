package PROS;

import java.util.*;

public class Solution {
   public static List<Product> products = new ArrayList<>(Arrays.asList(
           new Product(1,"Danish Muffin",0.52,0.80,0),
           new Product(2,"Granny’s Cup Cake",0.38,1.2,0.3),
           new Product(3,"Frenchy’s Croissant",0.41,2.19,0),
           new Product(4,"Crispy Chips",0.60,1.67,0)
    ));

    public static List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client(1, "ABC Distribution", 0.05, 0, 0.02),
            new Client(2, "DEF Foods", 0.04, 0.01, 0.02),
            new Client(3,"GHI Trade",0.03,0.01,0.03),
            new Client(4,"JKL Kiosks",0.02,0.03,0.05),
            new Client(5,"MNO Vending",0,0.05,0.07)
    ));

    // Function to calculate the standard unit price

    public static double calculateClientDiscount(int clientId, double orderTotal) {
        double basicDiscount = 0, volumeDiscount = 0;
        for (Client client : clients) {
            if (client.getId() == clientId) {
                basicDiscount = client.getBasicDiscountInPercents();
                if (orderTotal > 10000) {
                    volumeDiscount = client.getDiscountAbove10kInPercents();
                }
                if (orderTotal > 30000) {
                    volumeDiscount = client.getDiscountAbove30kInPercents();
                }
                break;
            }
        }
        return round(orderTotal * (basicDiscount + volumeDiscount), 2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException("Number of decimal places cannot be negative");
        long factor = (long) Math.pow(10, places);
        long temp = Math.round(value * factor);
        return (double) temp / factor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter order details: ");
        String orderInput = scanner.nextLine();
        String[] orderParts = orderInput.split(",");

        int clientId = Integer.parseInt(orderParts[0]);
        Map<Integer, Integer> productQuantities = new HashMap<>();
        for (int i = 1; i < orderParts.length; i++) {
            String[] productInfo = orderParts[i].split("=");
            int productId = Integer.parseInt(productInfo[0]);
            int quantity = Integer.parseInt(productInfo[1]);
            productQuantities.put(productId, quantity);
        }

        double totalBeforeDiscount = 0;
        System.out.println("Client: " + clients.get(clientId-1).getName());
        for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            double standardUnitPrice = products.get(productId-1).calculateStandardUnitPrice();
            double promotionalUnitPrice = products.get(productId-1).calculatePromotionalUnitPrice(quantity);
            double lineTotal = round(promotionalUnitPrice * quantity, 2);
            System.out.printf("Product: %s\nQuantity: %d\nStandard Unit Price: EUR %.2f\nPromotional Unit Price: EUR %.5f\nLine Total: EUR %.2f\n",
                    products.get(productId-1).getName(), quantity, standardUnitPrice, promotionalUnitPrice, lineTotal);
            totalBeforeDiscount += lineTotal;
        }

        double clientDiscount = calculateClientDiscount(clientId, totalBeforeDiscount);
        double orderTotal = round(totalBeforeDiscount - clientDiscount, 2);
        System.out.printf("Total Before Client Discounts: EUR %.2f\n", totalBeforeDiscount);
        System.out.printf("Additional Volume Discount: EUR %.2f\n", clientDiscount);
        System.out.printf("Order Total Amount: EUR %.2f\n", orderTotal);

        scanner.close();
    }
}

