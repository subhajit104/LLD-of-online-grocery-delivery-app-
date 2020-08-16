package models.GroceryModel;

public class Grocery {


    private long id;
    private String name;
    private String description ;
    private  float price;
    private boolean isAvailable;
    private int count ;
    private String weight;

    public Grocery(long id, String name, String description, float price, String weight, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", count=" + count +
                ", weight='" + weight + '\'' +
                '}';
    }
}
