class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name);
        System.out.println("Price: ₹" + price);
    }

    public double calculateDiscount(double discountPercent) {
        return price - (price * discountPercent / 100);
    }

    public double calculateDiscount(double discountPercent, double couponValue) {
        return price - (price * discountPercent / 100) - couponValue;
    }
}

class GroceryProduct extends Product {
    private double weight;
    public GroceryProduct(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public void display() {
        System.out.println("Grocery Product: " + name);
        System.out.println("Price: ₹" + price + " per kg");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Total: ₹" + (price * weight));
    }
}

class ElectronicProduct extends Product {
    private int warrantyYears;

    public ElectronicProduct(String name, double price, int warrantyYears) {
        super(name, price);
        this.warrantyYears = warrantyYears;
    }

    public void display() {
        System.out.println("Electronic Product: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("Warranty: " + warrantyYears + " years");
    }
}

public class Supermarket {
    public static void main(String[] args) {
        Product generalProduct = new Product("Shampoo", 150);
        generalProduct.display();
        System.out.println("Discounted Price: ₹" + generalProduct.calculateDiscount(10));
        System.out.println("Discount with Coupon: ₹" + generalProduct.calculateDiscount(10, 15));
        System.out.println();

        GroceryProduct rice = new GroceryProduct("Basmati Rice", 80, 5);
        rice.display();
        System.out.println("Discounted Price (10%): ₹" + rice.calculateDiscount(10));
        System.out.println();

        ElectronicProduct phone = new ElectronicProduct("Smartphone", 15000, 2);
        phone.display();
        System.out.println("Discounted Price (15% + ₹500 coupon): ₹" + phone.calculateDiscount(15, 500));
    }
}