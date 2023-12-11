package digital_atm_systems;

import java.awt.Color;
import java.sql.ResultSet;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame{
 String pinnumber;
	public MiniStatement(String pinnumber) {
		this.pinnumber=pinnumber;
		
		setLayout(null);
		setTitle("Mini Statement");
		
		JLabel mini=new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank=new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card=new JLabel();
		card.setBounds(20,80,200,20);
		add(card);
		
		JLabel balance=new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			Connect con=new Connect();
			
			ResultSet rs=con.st.executeQuery("Select * from login where PinNumber = '"+pinnumber+"';");
			while(rs.next()) {
				card.setText("Card Number : "+rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("CardNumber").substring(12));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		try {
			Connect con=new Connect();
			int bal=0;
			ResultSet rs=con.st.executeQuery("Select * from bank where pin ='"+pinnumber+"'");
			while (rs.next()) {
				mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				
				if(rs.getString("type").equals("Deposit")) {
					bal +=Integer.parseInt(rs.getString("amount"));
				}else {
					bal -=Integer.parseInt(rs.getString("amount"));
				}
			}
			
			balance.setText("Your current account balance is Rs "+bal);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new MiniStatement("");

	}

}
