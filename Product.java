package PROS;

public class Product {
    private int id;
    private String name;
    private double unitCost;
    private double markupInPercents;
    private double promotion;

    public Product(int id, String name, double unitCost, double markupInPercents, double promotion) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
        this.markupInPercents = markupInPercents;
        this.promotion = promotion;
    }

    public double calculateStandardUnitPrice() {

        return round(unitCost + (unitCost * markupInPercents),2);
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        long temp = Math.round(value * factor);
        return (double) temp / factor;
    }

    public double calculatePromotionalUnitPrice(int quantity){

        if(this.id == 4) {
            int paidItems = quantity - (quantity / 3); // Number of items customer pays for
            return round((paidItems * calculateStandardUnitPrice() / quantity), 5);
        }

        if (promotion > 0) {
            return round(quantity * this.unitCost * 0.7, 5);
        } else {
            return calculateStandardUnitPrice();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getMarkupInPercents() {
        return markupInPercents;
    }

    public void setMarkupInPercents(double markupInPercents) {
        this.markupInPercents = markupInPercents;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitCost=" + unitCost +
                ", markup=" + markupInPercents +
                ", promotion=" + promotion +
                '}';
    }
}
