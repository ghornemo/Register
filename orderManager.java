

public class orderManager {
	
   public order head;

	/*
	*
	*Adding an order to our linked lists!
	*@param - the order to add to our list.
	*
	*/
   public void addOrder(order toAdd, int uniqueId) {
   
      if(head == null) {
         head = toAdd;
         return;
      }
   	
      order tmp = head;
   	
   	//Retrieving the last order
      while(tmp.next != null) 
         tmp = tmp.next;
   		
      toAdd.last = tmp;
      tmp.next = toAdd;
      toAdd.orderId = uniqueId;
      toAdd.initialized = true;
   	
   }
	
	/*
	*
	* Used to save changes to an already
	* Existing order.
	*
	*/
   public void saveChange(order toSave) {
   
      int id = toSave.orderId;
   	
      order old = head;
   	
      while(old.orderId != id) {
      
         old = head.next;
      
      }
   	
      old = toSave;
   
   }
	
	/*
	*
	* Retrieves an order by the unique order
	* ID. The ID is to make the program
	* user-friendly.
	* @param - the unique Order ID to retrieve.
	*/
   public order getOrder(int id) {
   
      order found = null;
      order tmp = head;
   	
      while(tmp.next != null) {
      
         tmp = tmp.next;
         if(tmp.orderId == id)
            return tmp;
      
      }
   	
      System.out.println("Error! Order #"+id+" not found!");
      return head;
   
   }
	
	/*
	*
	* A method to delete a specified user-friendly
	* order, then adjusts the linked-lists.
	*
	*/

   public void deleteOrder(int id) {
   
      order toDelete = getOrder(id);
   	
      if(toDelete == null)
         return;
   	
   	//Modifying the previous order in the series.
      if(toDelete.last != null) {
      
         if(toDelete.next != null)
         	
            toDelete.last.next = toDelete.next;
         
         else
         	
            toDelete.last.next = null;
      
      }
   	
   	
   	//modifying the next order in the series
      if(toDelete.next != null) {
      
         if(toDelete.last != null) 
            toDelete.last.next = toDelete.next;
      	
      }
   
      if(toDelete.last != null) {
      
         if(toDelete.next != null)
         
            toDelete.last.next = toDelete.next;
         	
         else
         
            toDelete.last.next = null;
      		
      }
   	
      System.out.println("Order "+id+" successfully deleted.");
   
   }
	
	/*
	*
	* Generates the revenue from all
	* initialized orders.
	*/
	
   public double generateRevenue() {
   
      order tmp = head;
   	
   	//In case no orders have been initialized
      if(head == null)
         return 0;
   		
      double total = head.getTotal();
   	
      while(tmp.next != null) {
      
         tmp = tmp.next;
         total += tmp.getTotal();
      
      }
   	
      return total;
   
   }

}