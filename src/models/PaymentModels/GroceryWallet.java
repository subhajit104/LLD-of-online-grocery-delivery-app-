package models.PaymentModels;

import models.orderModels.TransactionHistory;
import userInterface.UI;

import java.util.ArrayList;
import java.util.List;

public class GroceryWallet {

     private long id;
     private long userId;
     private List<TransactionHistory> transactionHistories;
     private float totalAmount;

     public GroceryWallet()
     {
          this.id = UI.uniqueId++;
          transactionHistories = new ArrayList<>();
          totalAmount = 0.0f ;
     }

     public void reduceAmount(float amount)
     {
          // TODO: implement
     }

     public void increaseAmount(float amount)
     {
          // TODO: implement.
     }

     public Boolean iSufficient( float amount)
     {
         return totalAmount >= amount;
     }

     public long getUserId() {
          return userId;
     }

     public void setUserId(long userId) {
          this.userId = userId;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }
}