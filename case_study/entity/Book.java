package entity;

public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private int stockQuantity;
    private String status;

    public Book(int id, String title, String author, String category, int stockQuantity, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.status = status;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category
                + ", stockQuantity=" + stockQuantity + ", status=" + status + "]";
    }

}
