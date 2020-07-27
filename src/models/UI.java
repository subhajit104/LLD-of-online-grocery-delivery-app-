package models;

import Util.GroceryManagementSystem;
import models.GroceryModel.Fruit;
import models.GroceryModel.Grocery;
import models.UserModel.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

     private GroceryManagementSystem groceryManagementSystem ;
     private  long userId = 0;
     public static int uniqueId = 1;
     GroceryWallet groceryWallet = new GroceryWallet();

     List<Long> groceriesId = new ArrayList<>();
     static Scanner scanner = new Scanner(System.in);

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
         groceries.clear();

         while(true)
         {

             System.out.println("move to cart:-> " + 0);
             System.out.println("ItemNumber :-> " );
             int itemNumber = scanner.nextInt();
             // TODO : need Validator.
             if(itemNumber < i && i > 0  )
                  groceriesId.add(groceries.get(itemNumber).getId());
             else
                 break;;
         }

     }

     private void moveToCart()
     {
         Cart cart = groceryManagementSystem.getCartMap().get(userId);
         System.out.println(cart.toString());

         System.out.println("move to cart:"  + 1);

         int input = scanner.nextInt();

         while (1 != input)
         {
             input = scanner.nextInt();
         }

         System.out.println("address added");
         System.out.println("Amount deducted");

         groceryManagementSystem.checkOut(userId,new Address());
         System.out.println("please come back");

     }


    public void run()
    {
        while (true)
        {
            System.out.println("DashBoard");

            System.out.println("1 : see the products");
            System.out.println("2 : move the cart");

            int input = 1;
            switch(input)
            {
                case  1:
                {
                    showGrocery();
                }

                case 2: {
                    moveToCart();
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
    }


    public void addGrocery()
    {
        groceryManagementSystem.addGrocery(new Fruit(uniqueId,"Milk","Fresh milk","200ml"));
    }
    public void addUser()
    {
        User user = new User("subhajit","password","subhajitmanna@gmail.com");
        groceryManagementSystem.addUser(user);
        userId =  user.getUserId();
    }

}
