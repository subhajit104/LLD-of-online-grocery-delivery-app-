package models.GroceryModel;

public class Fruit extends Grocery {

    public Fruit(long id, String name, String description, float price, String weight, int count) {
        super(id, name,description,price,weight,count);
    }

    @Override
    public String toString() {
        return "Fruit" + super.toString();
    }
}
