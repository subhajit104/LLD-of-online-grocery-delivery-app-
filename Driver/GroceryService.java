package Driver;

import Util.Address;
import models.GroceryModel.Grocery;
import models.PaymentModels.GroceryWallet;
import models.PaymentModels.Receipt;
import models.UserModel.User;
import models.orderModels.Cart;
import models.orderModels.Order;
import models.orderModels.OrderHistory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryService {


    private Map<Long, User> userMap;
    private Map<Long, Grocery> groceryMap;


    public GroceryService() {

        System.out.println("GroceryService created");
        System.out.println("UserMap created");
        System.out.println("GroceryMap created");
        this.userMap = new HashMap<>();
        this.groceryMap = new HashMap<>();
    }

    // ############################################################################################
    //                                 UserService
    // ############################################################################################
    public void addUser(User user) {
        System.out.println("User added");
        System.out.println(user.toString());
        if (verifyUser(user)){
            System.out.println("User is already present");
        }else{
            userMap.put(user.getUserId(),user);
        }
    }

    public void removeUser(User user) {
        if(verifyUser(user)){
            userMap.remove(user.getUserId());
            System.out.println("User is removed");
        } else {
            System.out.println("User is not present");
        }
    }

    public Boolean verifyUser(User user) {
        User saved = userMap.get(user.getUserId());
        return saved != null;
    }
    // ############################################################################################
    //                                 GroceryService                                            //
    // ############################################################################################

    public void addGrocery(Grocery grocery) {
        if(verifyGrocery(grocery)){
            System.out.println("Grocery is already present");
        }else {
            groceryMap.put(grocery.getId(),grocery);
        }
    }

    public void removeGrocery(Grocery grocery) {
        if(verifyGrocery(grocery)){
            groceryMap.remove(grocery.getId());
            System.out.println("Grocery removed");
        }else{
            System.out.println("Grocery is not present");
        }
    }

    public void updateGrocery(Grocery grocery) {
          if(verifyGrocery(grocery)){
              groceryMap.put(grocery.getId(),grocery);
              System.out.println("Grocery Updated");
          }else{
              System.out.println("Grocery is not present");
          }
    }

    public boolean verifyGrocery(Grocery grocery) {
       return  groceryMap.get(grocery.getId()) != null;
    }
    // ############################################################################################
    //                                 WishListService
    // ############################################################################################

    public void addToWishList(User user, long groceryId)
    {
        User savedUser = userMap.get(user.getUserId());
        savedUser.getWishList().addToWishList(groceryId);
        System.out.println("Added to wish list");
    }

    public void removeFromWishList(User user, long groceryId)
    {
        User savedUser = userMap.get(user.getUserId());
        savedUser.getWishList().addToWishList(groceryId);
        System.out.println("removed from list");
    }

    // ############################################################################################
    //                                 PaymentService
    // ############################################################################################
    public void checkout(User user, Address address) {
        Cart cart = user.getCart();
        OrderHistory orderHistory = user.getOrderHistory();
        GroceryWallet groceryWallet = user.getGroceryWallet();
        for (long grocerId: cart.getGroceries()) {
            Grocery grocery = groceryMap.get(grocerId);
            Order order = new Order();
            order.setAddress(address);
            order.setGrocery(grocery);
            order.setTotalAmount(grocery.getPrice());
            groceryWallet.reduceAmount(order.getTotalAmount());
            System.out.println(order.toString());
            System.out.println("Order Placed");
            orderHistory.addOrder(order);
            Receipt receipt = new Receipt(user.getMail(),order);
            System.out.println("receipt sent to the registered mail address");
        }
    }
    public void addMoneyToWallet(User user, float amount) {
        GroceryWallet groceryWallet = user.getGroceryWallet();
        groceryWallet.increaseAmount(amount);
        System.out.println("Money added to the list.");
    }

    public String cancelOrder(User user, long orderId) {
        OrderHistory orderHistory = user.getOrderHistory();
        orderHistory.cancelOrder(orderId);
        return "Order canceled.";
    }

    private List<Grocery> getGroceryFromCart(User user) {
        Cart cart = user.getCart();
        List<Long> groceries = cart.getGroceries();
        List<Grocery> groceryList = new ArrayList<>();
        for (long groceryId : groceries) {
            groceryList.add(groceryMap.get(groceryId));
        }
        return groceryList;
    }
    // ############################################################################################
    //                                 Getters & Setters
    // ############################################################################################


    public Map<Long, Grocery> getGroceryMap() {
        return groceryMap;
    }

    public void setGroceryMap(Map<Long, Grocery> groceryMap) {
        this.groceryMap = groceryMap;
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Long, User> userMap) {
        this.userMap = userMap;
    }
}
