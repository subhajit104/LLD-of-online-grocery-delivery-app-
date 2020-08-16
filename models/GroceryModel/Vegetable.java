package models.GroceryModel;

public class Vegetable extends Grocery  {


    public Vegetable(long id, String name, String description, float price, String weight, int count) {
        super(id, name,description,price,weight,count);
    }

    @Override
    public String toString() {
        return "Vegetable" + super.toString();
    }
}
