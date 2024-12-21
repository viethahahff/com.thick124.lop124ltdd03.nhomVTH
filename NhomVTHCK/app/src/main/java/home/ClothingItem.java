package home;

public class ClothingItem {
    private String name;            // Tên sản phẩm
    private String description;     // Mô tả sản phẩm
    private int price;              // Giá sản phẩm
    private int imageResourceId;    // ID tài nguyên hình ảnh sản phẩm
    private String size;            // Kích thước sản phẩm

    // Constructor
    public ClothingItem(String name, String description, int price, int imageResourceId, String size) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.size = size;  // Gán size
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getSize() {
        return size;
    }
}
