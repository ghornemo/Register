import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends orderManager {
	
	//The order we are currently dealing with.
   public order current;
	
   public int orderCount = 1;
	
	//public JTextArea summary = new JTextArea();
	
   public JPanel forScroller = new JPanel();
	
   public JScrollPane scroller = new JScrollPane(forScroller);
	
   public JButton clearButton = new JButton("Clear order");
	
   public JButton deleteButton = new JButton("Delete Selected");
	
   public JButton saveOrder = new JButton("Save($0.00)");
	
   public JPanel orderDetails = new JPanel();
	
   public JPanel orderOptions = new JPanel();
	
   public JPanel foodOptions = new JPanel();
		
   public JPanel foodButtons = new ButtonField(this, 0);
		
   public JPanel dessertButtons = new ButtonField(this, 1);
	
   public JPanel drinkButtons = new ButtonField(this, 2);
	
   public JPanel currentOptions;
	
	public JLabel totalLabel = new JLabel("Daily revenue: $0.00");
	
   public JFrame mainFrame = new JFrame("System");
	
   public JTabbedPane menu = new JTabbedPane();
	
	public JPanel MainPanel = new JPanel();
	
	public JLabel orderDisplay = new JLabel("Order: #1");
	
   public static void main(String[] args) {
   
      Register system = new Register();
   
   }
	
   public Register() {
   
      super();		
      current = new order();
   	
      scroller.setPreferredSize(new java.awt.Dimension(190, 100)); 
   	
      orderDetails = new labelField(this);
   	
      forScroller.setLayout(new GridLayout(0, 1, 5, 5)); 
   	
      JTabbedPane foodPane = new JTabbedPane();	
   	
   	//currentOptions.setContentPane(foodButtons);
   	
   	/*
   	* Setting up the buttons to switch
   	* Menu content
   	*/
   	
      JPanel userOptions = new JPanel();
   	
   
      foodPane.addTab("Food", foodButtons);
      foodPane.addTab("Drinks", drinkButtons);
      foodPane.addTab("Desserts", dessertButtons);
   
   	/*********/
   	
      currentOptions = foodButtons;
   	
   	//orderOptions.add(userOptions);
   	//orderOptions.add(currentOptions);
      orderOptions.add(foodPane);
      orderOptions.add(scroller);
      orderOptions.add(orderDetails);
   	
      JPanel Management =new  Management(this);
   	
      menu.addTab("Order options", orderOptions);
      menu.addTab("Management", Management);
   	
      MainPanel.add(menu);
   	
      mainFrame.setContentPane(MainPanel);
   	
      mainFrame.setSize(350,350);
      mainFrame.pack();
      mainFrame.setLocationByPlatform(true);
      mainFrame.setVisible(true);
   	
   	
   
   }
	
	/*
	*
	* Action event for Save button.
	* Save order to system. Must check
	* to see if the order has already been
	* initialized, to see whether it is an
	* order edit, or a new order added.
	*
	*/
   public void saveOrder() {
	
		mainFrame.setContentPane(new paymentMethod(this));
   
   }
	
	public void confirmPayment() {

		      if(!current.initialized) {
         addOrder(current, orderCount++);
      }
      else
         saveChange(current);

		MainPanel.setVisible(true);
		mainFrame.setContentPane(MainPanel);   		
   		
      current.deleteAll(forScroller);
      current = new order();
		orderDisplay.setText("Order : #"+orderCount);
      updateGUI();

	}
	
	/* 
	* 
	* Action event for delete selected
	* button on GUI.
	* 
	*/ 
	
   public void deleteSelected() {
   
      current.deleteSelected(forScroller);
      updateGUI();
   
   }
	
	
	/*
	*
	* A food item is to be added to the order.
	* @param - name of order, sent by event.
	*/
	
   public void itemClicked(String clicked) {
   
      item toAdd = null;
		
      switch(clicked) {
      
         //food
         case "Hamburger":
            toAdd = new item("Burger", 4.52);
            break;
      	
         case "Chicken burger":
            toAdd = new item("Chicken Burger", 4.70);
            break;
         
         case "Wrap":
            toAdd = new item("Wrap", 3.20);
            break;
      	
         case "Salad":
            toAdd = new item("Salad", 2.60);
            break;
         
         case "Sandwich":
            toAdd = new item("Sandwich", 3.90);
            break;
         
         case "Fries":
            toAdd = new item("Fries", 2.25);
            break;
         
         case "Onion rings":
            toAdd = new item("Onion Rings", 4.15);
            break;
         
         case "Chicken strips":
            toAdd = new item("Chicken Strips", 3.50);
            break;
         
         case "Poutine":
            toAdd = new item("Poutine", 4.95);
            break;
            
         case "Wings":
            toAdd = new item("Wings", 5.00);
            break;
         
         case "Pizza":
            toAdd = new item("Pizza", 7.50);
            break;  
         
         //desserts
         case "Ice Cream":
            toAdd = new item("Ice Cream", 2.45);
            break;
            
         case "Pie":
            toAdd = new item("Pie", 4.30);
            break;
            
         case "Cheesecake":
            toAdd = new item("Cheesecake", 5.00);
            break;
         
         //Drinks
         case "Coffee":
            toAdd = new item("Coffee", 3.25);
            break;
            
         case "Tea":
            toAdd = new item("Tea", 3.25);
            break;
         
         case "Martini":
            toAdd = new item("Martini", 8.99);
            break;
            
         case "Cocktails":
            toAdd = new item("Cocktails", 6.99);
            break;
            
         case "Scotch":
            toAdd = new item("Scotch", 6.75);
            break;
            
         case "Alpine":
            toAdd = new item("Alpine", 5.98);
            break;
            
         case "Moose Light":
            toAdd = new item("Moose Licht", 5.98);
            break;
            
         case "Moose Ale":
            toAdd = new item("Moose Ale", 5.98);
            break;
            
         case "Moose Lager":
            toAdd = new item("Moose Lager", 5.98);
            break;
            
         case "Coors Light":
            toAdd = new item("Coors Light", 5.98);
            break;
            
         case "Bud Light":
            toAdd = new item("Bud Light", 5.98);
            break;
            
         case "Stella Artois":
            toAdd = new item("Stella Artios", 7.83);
            break;
            
         case "Guinness":
            toAdd = new item("Guinness", 7.83);
            break;
            
         case "Wine 5oz":
            toAdd = new item("Wine 5oz", 7.39);
            break;
            
         case "Wine 9oz":
            toAdd = new item("Wine 9oz", 12.89);
            break;
            
      }
   	
      if(toAdd != null) {
      
         current.addItem(toAdd);
         updateGUI();
      
      }
   
   }
	
	/*
	* Updates the GUI: for changes in price, or items.
	*/
   public void updateGUI() {
   
      updateScroller();
      saveOrder.setText("Save($"+current.getTotal()+")");
      scroller.revalidate();
      scroller.repaint();
   }
	
   public void updateScroller() {
   
      for(item button : current.orderItem) {
      
         if(button == null)
            continue;
      			
         forScroller.add(button);
      
      }
   		
      //forScroller.revalidate();
      //forScroller.repaint();
   
   }
	
	/*
	*
	* Action event for clear order
	* button.
	*
	*/
	
   public void clearOrder() {
   
      current.deleteAll(forScroller);
      current = new order();
   	
      updateGUI();
   
   }
		

}