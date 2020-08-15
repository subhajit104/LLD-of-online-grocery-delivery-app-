package models.orderModels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WishList {

    private Set<Long> groceries;

    public WishList() {
        this.groceries = new HashSet<>();
    }

    public void addToWishList(Long groceryId){
        groceries.add(groceryId);
    }

    public Set<Long> getGroceries() {
        return groceries;
    }
}
