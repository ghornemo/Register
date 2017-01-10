import javax.swing.*;
import java.awt.*;

public class Management extends JPanel {

	public Management(Register main) {
	
		setLayout(new GridLayout(3,1, 40, 40));
	
	//	JTextBox orderNumber = new JTextBox("Order number");
		
		JButton editOrder = new JButton("Edit");
		JButton deleteOrder = new JButton("Delete");
		
		//add(orderNumber);
		add(editOrder);
		add(deleteOrder);
		add(main.totalLabel);
		
	
	}

}