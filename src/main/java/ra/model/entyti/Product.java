package ra.model.entyti;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private int quantity;
    private String title;
    private String description;
    private boolean productStatus;
    private String productImage;
    private int catalogId;
    private List<String> listImageUrl = new ArrayList<>();

    public Product() {
    }

    public Product(int productId, String productName, float price, int quantity, String title, String description, boolean productStatus, String productImage, int catalogId, List<String> listImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.description = description;
        this.productStatus = productStatus;
        this.productImage = productImage;
        this.catalogId = catalogId;
        this.listImageUrl = listImageUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public List<String> getListImageUrl() {
        return listImageUrl;
    }

    public void setListImageUrl(List<String> listImageUrl) {
        this.listImageUrl = listImageUrl;
    }
}
