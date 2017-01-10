import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 


public class ButtonField extends JPanel {

   final Register mainRegister;

   public ButtonField(Register main, int type) {
   
      mainRegister = main;
   
      setLayout(new GridLayout(3,2, 10, 10));
   	
   	
      if(type == 0) {//Main course
         String[] foods = {"Hamburger", "Chicken burger", "Wrap", "Salad","Sandwich", "Fries",
                               "Onion rings", "Chicken strips", "Poutine", "Wings", "Pizza"};
      
         JButton[] buttons = new JButton[foods.length];
      
         for(int i = 0; i < foods.length; i++) {
         
            buttons[i] = new JButton(foods[i]);
            buttons[i].setActionCommand(foods[i]);
            buttons[i].addActionListener(
                  new ActionListener() { 
                  
                     public void actionPerformed(ActionEvent e) { 
                        mainRegister.itemClicked(e.getActionCommand());
                     }
                  }); 
         
            add(buttons[i]);
         
         }
      }
      else if(type == 1) {//Desserts
      
         String[] desserts = {"Ice cream", "Pie", "Cheesecake"};
      
         JButton[] buttons = new JButton[desserts.length];
      
         for(int i = 0; i < desserts.length; i++) {
         
            buttons[i] = new JButton(desserts[i]);
            buttons[i].setActionCommand(desserts[i]);
            buttons[i].addActionListener(
                  new ActionListener() { 
                  
                     public void actionPerformed(ActionEvent e) { 
                        mainRegister.itemClicked(e.getActionCommand());
                     }
                  }); 
         
            add(buttons[i]);
         
         }
      
      }
      else if(type == 2) {//Drinks
      
         String[] drinks = {"Coffee", "Tea", "Martini", "Cocktails","Alpine", "Moose Light", "Moose Ale", "Moose Lager", 
                              "Coors Light", "But Light", "Stella Artois", "Guinness", "Wine 5oz", "Wine 9oz"};
      
         JButton[] buttons = new JButton[drinks.length];
      
         for(int i = 0; i < drinks.length; i++) {
         
            buttons[i] = new JButton(drinks[i]);
            buttons[i].setActionCommand(drinks[i]);
            buttons[i].addActionListener(
                  new ActionListener() { 
                  
                     public void actionPerformed(ActionEvent e) { 
                        mainRegister.itemClicked(e.getActionCommand());
                     }
                  }); 
         
            add(buttons[i]);
         
         }
      
      }
   	
   
   }

}