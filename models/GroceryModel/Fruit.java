package models.GroceryModel;

public class Fruit extends Grocery {

    public Fruit(long id, String name, String description,String amount) {
        super(id, name, description,amount,5);
    }

    @Override
    public String toString() {
        return "Fruit" + super.toString();
    }
}
