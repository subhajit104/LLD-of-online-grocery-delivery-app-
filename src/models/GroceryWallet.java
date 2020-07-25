package models;

import models.GroceryModel.Grocery;

import java.util.ArrayList;
import java.util.List;

public class GroceryWallet {

     private long ownerId;
     private List<TransactionHistory> transactionHistories;
     private float totalAmount;

     public GroceryWallet()
     {
         transactionHistories = new ArrayList<>();
     }

     public void reduceAmount(float amount)
     {

     }

     public void increaseAmount(float amount)
     {

     }

     public Boolean iSufficient( float amount)
     {
         return totalAmount >= amount;
     }

}