package userInterface;

import Util.Address;
import Driver.GroceryManagementSystem;
import models.GroceryModel.Fruit;
import models.GroceryModel.Grocery;
import models.GroceryModel.Vegetable;
import models.UserModel.User;
import models.orderModels.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

     static Scanner scanner = new Scanner(System.in);
     private GroceryManagementSystem groceryManagementSystem ;

     // current userId.
     private  long userId = 0;

     // helps to get Unique Id;
     public static int uniqueId = 1;


     // TODO : add Exceptions.

    public UI() {
        this.groceryManagementSystem = new GroceryManagementSystem();
        addGrocery();
        addUser();
    }


    public void run()
    {
        System.out.println("DashBoard");
        while (true)
        {

            System.out.println("1 : see the products");
            System.out.println("2 : move the cart");
            System.out.println(">3 : exit");

            int input =  scanner.nextInt();
            switch(input)
            {
                case  1:
                {
                    showGrocery();
                    break;
                }

                case 2: {
                    moveToCart();
                    break;
                }
                default:
                    System.out.println("Bye");
            }
        }
    }



    public void showGrocery()
     {
         int i = 0 ;
         List<Grocery> groceries = groceryManagementSystem.getGroceryList();
         for ( Grocery grocery : groceries) {
             System.out.println(++i + " = > " + grocery.toString());
         }

         System.out.println("add item -> "  +  1 );
         System.out.println("exit -> " + 2 );

         int input = scanner.nextInt();
         if(input == 2 ) return;

         User user = groceryManagementSystem.getUserMap().get(userId);
         Cart cart = groceryManagementSystem.getCartMap().get(user.getCartId());
         while(true)
         {

             System.out.println("move to cart:-> " + 0);
             System.out.println("ItemNumber :-> " + 1);

             int itemNumber = scanner.nextInt();
             // TODO : need Validator.
             if((itemNumber < i) && (itemNumber > 0 )  ) {

                 cart.addGrocery(groceries.get(itemNumber-1));
                 //groceriesId.add(groceries.get(itemNumber).getId());
             }
             else
             {

                 break;

             }
         }

     }

     private void moveToCart()
     {

         User user = groceryManagementSystem.getUserMap().get(userId);
         Cart cart = groceryManagementSystem.getCartMap().get(user.getCartId());
         System.out.println(cart.toString());

         int in = scanner.nextInt();

         while (in != 1)
         {
             in = scanner.nextInt();
         }

         System.out.println("provide address");
         // TODO: may include shipping charges.

         System.out.println("address added");
         // TODO : address added.

         System.out.println("make payment ");
         // TODO: payment done.

         System.out.println("Amount deducted");

         groceryManagementSystem.checkOut(userId,new Address());
         System.out.println("Success full");

     }


    public void addGrocery()
    {
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Milk","Fresh milk","200ml"));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Oil","Fresh milk","200ml"));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Apple","Fresh Fruit","200gm"));
        groceryManagementSystem.addGrocery(new Vegetable(uniqueId++,"Onion","Fresh vegetable","200gm"));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Milk","Fresh milk","200ml"));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Milk","Fresh milk","200ml"));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Milk","Fresh milk","200ml"));
        groceryManagementSystem.addGrocery(new Fruit(uniqueId++,"Milk","Fresh milk","200ml"));

    }
    public void addUser()
    {

        // create user.
        User user = new User("Subhajit Manna","password","subhajitmanna@gmail.com");
        groceryManagementSystem.addUser(user);
        userId =  user.getUserId();

    }

}
