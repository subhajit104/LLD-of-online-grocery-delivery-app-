package userInterface;

import Driver.GroceryService;
import Util.Address;
import models.GroceryModel.Fruit;
import models.GroceryModel.Grocery;
import models.GroceryModel.Vegetable;
import models.PaymentModels.GroceryWallet;
import models.UserModel.User;
import models.orderModels.Cart;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

     static Scanner scanner = new Scanner(System.in);
     private GroceryService groceryManagementSystem ;
     // current userId.
     private  long userId = 0;
     private User activeUser;
     //Unique Id;
     public static int uniqueId = 1;

    public UI() {
        this.groceryManagementSystem = new GroceryService();
        addGrocery();
        addUser();
    }

    private boolean verifyInput(int input, int lowerBound, int upperBound){
        return (input < lowerBound || input > upperBound ) ? false : true;
    }
    private int getInput(int lowerBound, int upperBound){
        while(true){
            System.out.print("\t");
            try {
                int input = scanner.nextInt();
                if (verifyInput(input,lowerBound,upperBound) == false)
                      throw new NotValidInput("please provide a valid output");
                return input;
            }catch (NotValidInput notValidInput) {
                notValidInput.printStackTrace();
            }catch (Exception e){
                System.out.println();
                scanner.next();
            }
        }

    }
    public void run()
    {
        System.out.println("DashBoard");
        while (true)
        {
            System.out.println("1 : List of products");
            System.out.println("2 : Move to carts");
            System.out.println("3 : Exit");
            int input =  getInput(1,3);
            switch(input)
            {
                case  1:
                {
                    ListGrocery();
                    break;
                }
                case 2: {
                    moveToCart();
                    break;
                }
                case 3:{
                    System.out.println("Bye!");
                    return;
                }
                default:
                    System.out.println("Bye!");
            }
        }
    }

     public void ListGrocery()
     {
         int id = 0 ;
         List<Grocery> groceries = new ArrayList<>(groceryManagementSystem.getGroceryMap().values());
         for ( Grocery grocery : groceries) {
             System.out.println("##############################################################");
             System.out.println("Id : " + id++);
             System.out.println("Details : ");
             System.out.println(grocery.toString());
         }
             System.out.println("###############################################################");

         while(true)
         {
             System.out.println("1: Add Grocery to Cart ");
             System.out.println("2: DashBoard" );
             int input = getInput(0,2);
             if(input == 2) {
                 return;
             } else {
                 Cart cart = activeUser.getCart();
                 System.out.println("Enter Id of Grocery: ");
                 int groceryId = getInput(0,groceries.size()-1);
                 System.out.println("give number of items");
                 int count = getInput(0,3);
                 for (int i = 0; i < count; i++) {
                     cart.addGrocery(groceries.get(groceryId));
                 }
             }
         }

     }
     private void moveToCart(){
         Cart cart = activeUser.getCart();
         System.out.println("Total Amount: " + cart.getTotalAmount());
         System.out.println("1:Check out and Make Payment");
         System.out.println("2: Move to DashBoard:");
         int input = getInput(1,2);
         if(input == 1){
             GroceryWallet groceryWallet = activeUser.getGroceryWallet();
             if(groceryWallet.iSufficient(cart.getTotalAmount())) {
                 System.out.println("Payment SuccessFul");
             } else {
                 System.out.println("Insufficient Balance!\n");
                 System.out.println("1: Add money");
                 System.out.println("2: Move to DashBoard");
                 input = getInput(1,2);
                 if(input == 1) {
                     System.out.println("Money Added and proceed to check out");
                     groceryManagementSystem.checkout(activeUser,getAddress());
                 }
             }
         }
     }
     private @NotNull Address getAddress()
     {
         //get the address.
         Address address = new Address();
         address.setPinCode(721443);
         address.setDist("West Medinipur");
         address.setStreet("School Bazar");
         return address;
     }

    public void addGrocery()
    {
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Milk","Fresh milk", 20,"200ml",5));
        groceryManagementSystem.addGrocery(new Vegetable(uniqueId++,"Onion","Fresh vegetable",20,"200gm",5));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Cheese","Fresh Cheese", 20,"50gm",5));
        groceryManagementSystem.addGrocery(new Vegetable(uniqueId++,"Potato","Fresh Potato",20,"200gm",5));


    }
    public void addUser()
    {

        // create user.
        User user = new User("Subhajit Manna","password","subhajitmanna@gmail.com");
        groceryManagementSystem.addUser(user);
        activeUser = user;
        userId =  user.getUserId();

    }

}
