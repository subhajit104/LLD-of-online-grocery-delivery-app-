package Driver;

import Util.Address;
import models.PaymentModels.GroceryWallet;
import models.PaymentModels.Receipt;
import models.orderModels.Cart;
import models.orderModels.Order;
import models.orderModels.OrderHistory;
import models.GroceryModel.Grocery;
import models.UserModel.Admin;
import models.UserModel.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryManagementSystem {

   private List<User> userList;
   private Map<Long,User> userMap;

   private List<Admin> adminList;
   private Map<Long,Admin> adminMap;

   private List<Grocery> groceryList;
   private Map<Long,Grocery> groceryMap;

   private List<Cart> cartList;
   private Map<Long,Cart> cartMap;

    private List<Cart> oderList;
    private Map<Long, Order> orderMap;

   private List<OrderHistory> orderHistoryList;
   private Map<Long,OrderHistory> orderHistoryMap;

   private List<GroceryWallet> walletList;
   private Map<Long,GroceryWallet> groceryWalletMap;



    public GroceryManagementSystem() {

        userList = new ArrayList<>();
        adminList = new ArrayList<>();

        groceryList = new ArrayList<>();
        cartList = new ArrayList<>();

        orderHistoryList = new ArrayList<>();
        orderHistoryMap = new HashMap<>();

        userMap = new HashMap<>();
        adminMap = new HashMap<>();

        groceryMap = new HashMap<>();
        cartMap = new HashMap<>();

        walletList = new ArrayList<>();
        groceryWalletMap = new HashMap<>();

    }


    private boolean verifyUser( User user)
    {
        return false;
    }


    public void addUser(User user)
    {

        // TODO: verify user before insert into db.
        userList.add(user);
        userMap.put(user.getUserId(),user);

        // TODO: Create cart
        Cart newCart = new Cart();

        newCart.setUserId(user.getUserId());
        user.setCartId(newCart.getId());

        cartList.add(newCart);
        cartMap.put(newCart.getId(),newCart);

        // Create PaymentWallet

        GroceryWallet newGroceryWallet = new GroceryWallet();
        newGroceryWallet.setUserId(user.getUserId());
        user.setWallerId(newGroceryWallet.getId());
        walletList.add(newGroceryWallet);
        groceryWalletMap.put(newGroceryWallet.getId(),newGroceryWallet);

        // create OrderHistory
        OrderHistory orderHistory = new OrderHistory();
        user.setOrderHistoryId(orderHistory.getId());
        orderHistory.setUserId(user.getUserId());
        orderHistoryMap.put(orderHistory.getId(),orderHistory);

        // TODO: create wishlist.
    }

    private boolean verifyAdmin( Admin admin)
    {
        return false;
    }
    public void addOwner(Admin admin)
    {
        adminList.add(admin);
        adminMap.put(admin.getUserId(),admin);
    }

    public Grocery addGrocery(Grocery grocery)
    {
        groceryList.add(grocery);
        groceryMap.put(grocery.getId(),grocery);
        return grocery;
    }

    public Grocery searchById(int id)
    {
       return groceryMap.get(id);
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
       cart.removeGrocery(groceryMap.get(groceryId));
   }

   public void addToWishList(int groceryId)
   {
       // TODO: implementation.
   }


   //----------------------------------------------

    private Order getOrderFromCart(Cart cart, Address address)
    {
        Order order = new Order();
        order.setAddress(address);
        order.setGroceryList(cart.getGroceries());
        return order;
    }
    public void checkOut(Long userId, Address address)
    {

         Cart cart = cartMap.get(userMap.get(userId).getCartId());
         Order order = getOrderFromCart(cart,address);
         OrderHistory orderHistory = orderHistoryMap.get(userMap.get(userId).getOrderHistoryId());
         orderHistory.addOrder(order);

    }

    private void sendReceipt(Receipt receipt)
    {
        if(receipt == null) System.out.println("No data");
        else
          System.out.println(receipt.toString() );

    }

    private void addOrderToOrderHistory(Long orderId, Long orderHistoryId)
    {

        orderHistoryMap.get(orderHistoryId).addOrder(orderMap.get(orderId));
    }

    public void cancelItem(int orderId)
    {
        orderMap.get(orderId).setCanceled(true);

    }

    public void returnItemOrders(int orderId, List<Long> itemIds)
    {

        // TODO: implement.
        // TODO: change the status of the order.
    }


    public OrderHistory getAllOrderHistory(int userId)
    {
        return orderHistoryMap.get(userMap.get(userId).getOrderHistoryId());
    }
    // - -------------------------------------------------


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public Map<Long, Admin> getAdminMap() {
        return adminMap;
    }

    public void setAdminMap(Map<Long, Admin> adminMap) {
        this.adminMap = adminMap;
    }

    public List<Grocery> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<Grocery> groceryList) {
        this.groceryList = groceryList;
    }

    public Map<Long, Grocery> getGroceryMap() {
        return groceryMap;
    }

    public void setGroceryMap(Map<Long, Grocery> groceryMap) {
        this.groceryMap = groceryMap;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public Map<Long, Cart> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Long, Cart> cartMap) {
        this.cartMap = cartMap;
    }

    public List<Cart> getOderList() {
        return oderList;
    }

    public void setOderList(List<Cart> oderList) {
        this.oderList = oderList;
    }

    public Map<Long, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public List<OrderHistory> getOrderHistoryList() {
        return orderHistoryList;
    }

    public void setOrderHistoryList(List<OrderHistory> orderHistoryList) {
        this.orderHistoryList = orderHistoryList;
    }

    public Map<Long, OrderHistory> getOrderHistoryMap() {
        return orderHistoryMap;
    }

    public void setOrderHistoryMap(Map<Long, OrderHistory> orderHistoryMap) {
        this.orderHistoryMap = orderHistoryMap;
    }

    public List<GroceryWallet> getWalletList() {
        return walletList;
    }

    public void setWalletList(List<GroceryWallet> walletList) {
        this.walletList = walletList;
    }

    public Map<Long, GroceryWallet> getGroceryWalletMap() {
        return groceryWalletMap;
    }

    public void setGroceryWalletMap(Map<Long, GroceryWallet> groceryWalletMap) {
        this.groceryWalletMap = groceryWalletMap;
    }
}