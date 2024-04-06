package PROS;
// Client ID, Basic Client Discount, Above EUR 10000, Above EUR 30000

public class Client {
    private int id;
    private String name;
    private double basicDiscountInPercents;
    private double discountAbove10kInPercents;
    private double discountAbove30kInPercents;

    public Client(int id, String name, double basicDiscountInPercents, double discountAbove10kInPercents, double discountAbove30kInPercents) {
        this.id = id;
        this.name = name;
        this.basicDiscountInPercents = basicDiscountInPercents;
        this.discountAbove10kInPercents = discountAbove10kInPercents;
        this.discountAbove30kInPercents = discountAbove30kInPercents;
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

    public double getBasicDiscountInPercents() {
        return basicDiscountInPercents;
    }

    public void setBasicDiscountInPercents(double basicDiscountInPercents) {
        this.basicDiscountInPercents = basicDiscountInPercents;
    }

    public double getDiscountAbove10kInPercents() {
        return discountAbove10kInPercents;
    }

    public void setDiscountAbove10kInPercents(double discountAbove10kInPercents) {
        this.discountAbove10kInPercents = discountAbove10kInPercents;
    }

    public double getDiscountAbove30kInPercents() {
        return discountAbove30kInPercents;
    }

    public void setDiscountAbove30kInPercents(double discountAbove30kInPercents) {
        this.discountAbove30kInPercents = discountAbove30kInPercents;
    }

    public double getVolumeDiscount(double orderTotal) {
        double volumeDiscount = 0;
        if (orderTotal > 10000) {
            volumeDiscount += this.discountAbove10kInPercents;
        }
        if (orderTotal > 30000) {
            volumeDiscount += this.discountAbove30kInPercents;
        }
        return volumeDiscount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basicDiscountInPercents=" + basicDiscountInPercents +
                ", discountAbove10kInPercents=" + discountAbove10kInPercents +
                ", discountAbove30kInPercents=" + discountAbove30kInPercents +
                '}';
    }
}
