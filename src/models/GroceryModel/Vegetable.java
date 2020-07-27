package models.GroceryModel;

public class Vegetable extends Grocery  {


    public Vegetable(long id, String name, String description, String amount) {
        super(id, name, description,amount);
    }

    @Override
    public String toString() {
        return "Vegetable{}" + super.toString();
    }
}
