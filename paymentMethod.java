import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paymentMethod extends JPanel {

	public paymentMethod(final Register main) {

		setSize(200,200);
		
		setLayout(new GridLayout(1,3, 40, 40));
		
		main.MainPanel.setVisible(false);
		
		//setDefaultCloseOperation();
		
		JButton cash = new JButton("Cash");
		JButton debit = new JButton("Debit");
		JButton credit = new JButton("Credit");
		
		cash.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  main.confirmPayment();
               }
            });
				
		debit.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  main.confirmPayment();
               }
            });
				
		credit.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  main.confirmPayment();
               }
            });
		
		cash.setFont(cash.getFont().deriveFont(35.0f));
		debit.setFont(debit.getFont().deriveFont(35.0f));
		credit.setFont(credit.getFont().deriveFont(35.0f));
		
		add(cash);
		add(debit);
		add(credit);


	}

}