package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import digital_atm_systems.*;

import java.sql.*;

public  class ActionListners implements ActionListener {
	Login log;
	
	 public ActionListners(Login log) {
       this.log=log;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== log.clear) {
			log.cardTxtField.setText("");
			log.pinTxtField.setText("");
			
		}else if(e.getSource()==log.login) {
			
			Connect c =new Connect();
			String cardNumber=log.cardTxtField.getText();
			String pinNumber=log.pinTxtField.getText();
			String query="Select * From login where cardNumber = '"+cardNumber+"' and pinNumber ='"+pinNumber+"';";
			
			try {
				ResultSet rs= c.st.executeQuery(query);
				if(rs.next()) {
					log.setVisible(false);
					new Transaction(pinNumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin Number");
				}
				
			} catch (Exception e2) {
				System.out.print(e2);
			}
			
		}else if(e.getSource()==log.signUp){
			
			log.setVisible(false);
			new SignUpOne().setVisible(true);
			
		}
		
	}

}

	
