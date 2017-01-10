
import java.text.*;
import javax.swing.*;

public class order extends JPanel {

   public final int MAX_ITEMS = 20;

   public item[] orderItem = new item[MAX_ITEMS];
	
	//Orders to be recognized by their unique ID.
   public int orderId;
	
   public boolean initialized = false;
	
	//Used for Linked-list management.
   public order last, next;
	
	
	/*
	*
	* The constructor of an intially empty
	* order, contents to be added by the GUI.
	*/

   public order() {
   	
   }
	
	/*
	*
	* Adds an item to the order.
	* We first check to see if we're incrementing
	* The amount of an item, or adding it to a new
	* Slot.
	* @param - the item object to be added.
	*/
   public void addItem(item toAdd) {
   
   
      for(int i = 0; i < MAX_ITEMS; i++) {
      
         if(orderItem[i] == null)
            continue;
      
      	//Item already in order
         if(orderItem[i].name == toAdd.name) {
         
         //
         
            orderItem[i].amount++;
            orderItem[i].setText(orderItem[i].toString());
            return;
         
         }
      
      }
   
      for(int i = 0; i < MAX_ITEMS; i++) {
      
      	//empty slot is found
         if(orderItem[i] == null) {
         
            orderItem[i] = toAdd;
            return;
         
         }
      
      }
      System.out.println("Error adding item!");
   
   }
	
	/*
	*
	*A method to delete an item, by exact name(not case-sensitive)
	*@param - name of the item.
	*
	*/
	
   public void deleteSelected(JPanel removeFrom) {
   
      for(int i = 0; i < orderItem.length; i++) {
      
         if(orderItem[i] == null)
            continue;
      
         if(orderItem[i].isSelected()) {
         
            removeFrom.remove(orderItem[i]);
            orderItem[i] = null;
         
         }
      
      }
   
   }
	
   public void deleteAll(JPanel removeFrom) {
   
      for(int i = 0; i < orderItem.length; i++) {
      
         if(orderItem[i] == null)
            continue;
      
         removeFrom.remove(orderItem[i]);
         orderItem[i] = null;
      
      }
   
   }
	
   public void deleteItem(String name) {
   
      name = name.toLowerCase();
   	
      for(int i = 0; i < orderItem.length; i++) {
      
         String tmp = orderItem[i].name.toLowerCase();
      
         if(name.equals(tmp)) {
         
            orderItem[i] = null;
            return;
         
         }
      
      }
   
   }
	
	/*
	*
	* Returns the total for this specific order.
	*
	*/
	
   public double getTotal() {
   
      double price = 0;
   	
      for(item i : orderItem)
         if(i != null)
            price += i.getPrice();
   			
      DecimalFormat twoDecimals = new DecimalFormat("#.##");
      price = Double.valueOf(twoDecimals.format(price)); 
   
   		
      return price;
   
   }
	
	/*
	*
	* Used to return a summary(String)
	* of the order! (name: price)
	*					 (name: price)
	* Used for the GUI.
	*/					
	
   public String orderSummary() {
   
      String order = "";
   	
      for(item current : orderItem)
      
      {
         if(current != null)
            order += current+"\n";
      
      }
      return order;
   
   }
}