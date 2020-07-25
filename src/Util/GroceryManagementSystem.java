package Util;

import models.Address;
import models.Cart;
import models.GroceryModel.Grocery;
import models.Reciept;
import models.UserModel.Admin;
import models.UserModel.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryManagementSystem {

    List<User> userList;
    Map<Long,User> userMap;
    List<Admin> adminList;
    Map<Long,Admin> adminMap;
    List<Grocery> groceryList;
    Map<Long,Grocery> groceryMap;
    List<Cart> cartList;
    Map<Long,Cart> cartMap;
    List<OrderHistory> orderHistoryList;
    Map<Long,OrderHistory> orderHistoryMap;


    public GroceryManagementSystem() {

        userList = new ArrayList<>();
        adminList = new ArrayList<>();
        groceryList = new ArrayList<>();
        cartList = new ArrayList<>();
        orderHistoryList = new ArrayList<>();

        userMap = new HashMap<>();
        adminMap = new HashMap<>();
        groceryMap = new HashMap<>();
        cartMap = new HashMap<>();
        orderHistoryMap = new HashMap<>();
    }


    public void addUser(User user)
    {
        userList.add(user);
    }

    public void addOwner(Admin admin)
    {
        adminList.add(admin);
    }

    public Grocery addGrocery(Grocery grocery)
    {
        groceryList.add(grocery);
        return grocery;
    }

    public Grocery searchById(int id)
    {
        return null;
    }

// -------------------------------------------------------

    private Cart getCart(int groceryId, int userId)
    {
        User savedUser = userMap.get(userId);
        Long cartId = savedUser.getCartId();
        Cart cart = cartMap.get(cartId);
        return cart;
    }

   public void addItemToCart(int groceryId, int userId)
   {
       Cart cart = getCart(groceryId,userId);
       cart.addGrocery(groceryMap.get(groceryId));
   }

   public void removeItem(int groceryId, int userId )
   {

       Cart cart = getCart(groceryId,userId);
       cart.addGrocery(groceryMap.get(groceryId));
   }

   public void addToWishList(int groceryId)
   {
       // TODO: implement this function.
   }
   //----------------------------------------------


    public void checkOut(Address address)
    {
         // TODO: implement.
    }

    private void sendReceipt(Reciept reciept)
    {
        // TODO: send to this to the register mail address.
    }

    private void addOrderToOrderHistory(int userId, int orderHistoryId)
    {
        // TODO: implement.
    }

    public void cancelItem(int orderId)
    {
        // TODO: implement.
    }

    public void returnItemOrders(int orderId, List<Long> itemIds)
    {
        // TODO: implement.
    }


    public List<OrderHistory> getAllOrderHistory(int userId)
    {
        // TODO : implement.
        return null;
    }



}
