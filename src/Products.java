public class Products {
    private String name;
    private String description;
    private float price;
    private int discountPercentage;
    private int amountProduct;
    private boolean availableInStock;

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", amountProduct=" + amountProduct +
                ", availableInStock='" + availableInStock + '\'' +
                '}';
    }

    public Products(String name, String description, float price, int discountPercentage, int amountProduct, boolean availableInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.amountProduct = amountProduct;
        this.availableInStock = availableInStock;
    }

    public boolean isAvailableInStock() {
        return availableInStock;
    }

    public void setAvailableInStock() {
        this.availableInStock = !this.availableInStock;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct += amountProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
