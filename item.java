import javax.swing.*;
import java.text.*;

public class item extends JRadioButton {

   protected double price;
   protected String name;
   public int amount;

	
   public item(String eName, double ePrice) {
      super();
      name = eName;
      price = ePrice;
      setText(name);
      amount = 1;
      setText(toString());
   	//setActionCommand(name);
   
   }
	
	/*
	* Returns a short description(name: $price)
	* for the GUI.
	*/
	
   public String toString() {
   
      String summarize = "";
   	
      if(amount > 1)
         summarize  += "("+amount+")";
   	
      summarize += ""+name;
      summarize += ": $"+getPrice();
   	
      return summarize;
   
   }
	
   public double getPrice() {
   
      DecimalFormat twoDecimals = new DecimalFormat("#.##");
   			//price = Double.valueOf(twoDecimals.format(price)); 
   
      return Double.valueOf(twoDecimals.format(price*amount));
   
   }

}