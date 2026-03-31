package generics;
import java.util.ArrayList;
import java.util.List;

/* ---------- Category Interface ---------- */
interface Category {
    String getCategoryName();
    double getMinPrice();
    double getMaxPrice();
}

/* ---------- Category Implementations ---------- */
class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }

    public double getMinPrice() {
        return 100;
    }

    public double getMaxPrice() {
        return 2000;
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }

    public double getMinPrice() {
        return 300;
    }

    public double getMaxPrice() {
        return 5000;
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }

    public double getMinPrice() {
        return 500;
    }

    public double getMaxPrice() {
        return 100000;
    }
}

/* ---------- Generic Product Class ---------- */
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException("Invalid price for category");
        }
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return "Product: " + name +
               " | Category: " + category.getCategoryName() +
               " | Price: ₹" + price;
    }
}

/* ---------- Marketplace Utility ---------- */
class MarketplaceUtil {

    // Generic Method with Bounded Type Parameter
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}

/* ---------- Marketplace Catalog ---------- */
class MarketplaceCatalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<? extends Category> product : products) {
            System.out.println(product.getDetails());
        }
    }
}

/* ---------- Main Class ---------- */
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 1500, new BookCategory());

        Product<ClothingCategory> clothing =
                new Product<>("Denim Jacket", 3000, new ClothingCategory());

        Product<GadgetCategory> gadget =
                new Product<>("Smartphone", 45000, new GadgetCategory());

        MarketplaceCatalog catalog = new MarketplaceCatalog();
        catalog.addProduct(book);
        catalog.addProduct(clothing);
        catalog.addProduct(gadget);

        System.out.println("---- Before Discount ----");
        catalog.displayCatalog();

        MarketplaceUtil.applyDiscount(book, 10);
        MarketplaceUtil.applyDiscount(gadget, 5);

        System.out.println("\n---- After Discount ----");
        catalog.displayCatalog();
    }
}

