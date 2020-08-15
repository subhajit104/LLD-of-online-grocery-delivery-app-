package models.UserModel;

import models.PaymentModels.GroceryWallet;
import models.orderModels.Cart;
import models.orderModels.OrderHistory;
import models.orderModels.WishList;

public class User extends Person {

      private GroceryWallet groceryWallet;
      private WishList wishList;
      private OrderHistory orderHistory;
      private Cart cart;


    public User(String name, String password, String mail) {
        super(name, password, mail);

        this.groceryWallet = new GroceryWallet();
        this.wishList = new WishList();
        this.orderHistory = new OrderHistory();
        this.cart = new Cart();
    }

    public GroceryWallet getGroceryWallet() {
        return groceryWallet;
    }

    public void setGroceryWallet(GroceryWallet groceryWallet) {
        this.groceryWallet = groceryWallet;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
