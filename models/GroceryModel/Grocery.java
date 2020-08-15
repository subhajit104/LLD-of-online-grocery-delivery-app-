package models.GroceryModel;

public class Grocery {


    private long id;
    private String name;
    private String description ;
    private  float price;
    private String amount;
    private boolean isAvailable;
    private int count ;

    public Grocery(long id, String name, String description, String amount, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.isAvailable = true;
        this.count = count;

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount='" + amount + '\'' +
                '}';
    }

}
