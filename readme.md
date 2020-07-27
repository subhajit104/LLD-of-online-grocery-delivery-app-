
## Design an Online Grocery Shopping System(Bigbasket)

# Requirements : 
            
            1. user must have registered account.
            2. User must see the list of groceries.
            3. user add/remove/update items from the cart. 
            4. must have payment system(wallet). 
            5. maintain order history.
            6. Cancel orders and return specific items.
            7. system must send receipt to registered mobile number/mail .
            8. address is specific orders. 
            9. must have wish list. 


# Actors: 
              1. Users: search,order,cancel
              2. Owner: Add Grocery,Remove Gorcery,Update Grocery
              3. System: send receipt to the register mobile and email address. 
  
 # Use cases : 
              1. Seach a item
              2.  add,remove,update grocery
              3. add to wish list
              4. return orders
              5. return a particular item from the orders.
              6. add address 
              7. Initiate payment
              8. check out 
              
---------------------------------------
Classes : 

 Person: 
   - id
   - name
   - email 
   - mobile number
   - getters/setters
   
 
 User: Person
   - GroceryWallet
   - Cart
   - List<OrderHistory>
   
 
 Owner: Person
    
    methods:
      -add items()
      -remove items()
      
      
 Grocery :
   id : 
   price: 
   description: 
 
 Vegetables: Grocery
    name: 
    weight:
    
 Fruits: Grocery
    name:
    weight:
    
 Meats: Grocery
    name:
    weight:
    
 Drinks: Grocery
    name:
    quantity:
    list_of_unit_items
    
    
 DryFoods: Grocery
    name: 
    number_of_items:
    
 PersonalGoods: Grocery
    name : 
    number_of_items:
    
 Others: Grocery
    name: 
    
    
 Cart: 
  - totalAmount
  - list of grocery
  - UserId
  - addGrocery( int id):
  - removeGrocery(int id): 
  
 GroceryWallet:
  
   OwnerID:
   transacion historys: 
   amount:
   
   reduceAmount(int amount):
   
   increaseAmount(int amount):
   
   isSufficient(int amount): 
   
   makePayment(int amount): 
   
   
/**
 PaymenySystems:
   - GroceryWallet
   - list of wallets
   - list of active cards
   - home delivery
   -
*/


   
   
   
 Order:
   -id
   -address:
   -receipt:
   -list of grocery
   - isCanceled
   - date 

 OrdersHistory:
   
   - userId
   - list of orders
   - addOrder
   - getAllOrder()
   - getOrderById(int oderId)
   
   
 
 WishList:
   -userId
   -List<int> itemIds: 
   -addItem(int id):
   -removeItem(int id):   
   
   
 
 
 GroceryManagementSystem:
    
    List<Grocery> groceries; // sorted by id
    
   // map<User,OrderHistory> userOrders:
    
    // map<User,GroceryWallet> wallets,
    
    List<User> users; // 
    
    List<Owner> owners;
    
    //map<User,WishList> withItems;
    
    // map<User,cart> carts; 

    -----------------------------------------
    
    
    addUser(User user):
       users.add(user); 
       
    updateUser(User user): 
       
    
    updateOwner(Owner owner): 
    

    addOwner(Owner owner):
    
 ------------------------------------------------
    addGrocery(Grocery grocery):
    
    
    updateGrocery(Grocery grocery):
    
    showGroceries(): 
       return groceries
    
    search(int id):
    
---------------------------------------------------
    addItemCart(int id, int oderId):
    
    removeItem(int id, int OrderID): 
    
    updateItem(int id, int OrderId):
    
    addToWishList(int id):
    
    
-----------------------------------------------------
    addAddress(int id, int Order):
    
    
    makePayment(User user, int orderId,int amount):
    
    
    checkOut(int orderId):
      // add to orderHistory
    
    sendReceipt(int usrId): 
      // send to mail and mobile number. 
    addToHistory(int userId): 
    
    cancelOrder(int id):
    
    returnItemFromOrders(int orderId, List<int> itemIds):
    
    
    seeOrderHistory(int userId):


    
    I'll be back in 5 mins
    Okay
    
    
    
     
    
    
    
    
    
    
   
   
 

  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
