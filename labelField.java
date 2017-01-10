import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class labelField extends JPanel {

   public labelField(final Register mainRegister) {
   
      setLayout(new GridLayout(4, 1, 20, 0));
   
   
      mainRegister.clearButton.addActionListener(
            new ActionListener() { 
               public void actionPerformed(ActionEvent e) { 
                  mainRegister.clearOrder();
               }
            }); 
   		 
      mainRegister.saveOrder.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  mainRegister.saveOrder();
               }
            });
   	
      mainRegister.deleteButton.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  mainRegister.deleteSelected();
               }
            });
   	
      add(mainRegister.deleteButton);
      add(mainRegister.clearButton);
      add(mainRegister.saveOrder);
		add(mainRegister.orderDisplay);
   
   }

}