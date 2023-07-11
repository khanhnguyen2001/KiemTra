package model;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String detail;

    public Product() {
    }

    public Product(String productId, String productName, double price, int quantity, String detail) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.detail = detail;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Mã Sản Phẩm: " + this.getProductId() + "\n" +
                "Tên Sản Phẩm: " + this.getProductName() + "\n" +
                "Giá Sản Phẩm: " + this.getPrice() + "\n" +
                "Số Lượng Sản Phẩm: " + this.getQuantity() + "\n" +
                "Mô Tả Sản Phẩm: " + this.getDetail();
    }
}
