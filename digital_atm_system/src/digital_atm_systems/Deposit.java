package digital_atm_systems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Deposit extends JFrame implements ActionListener{
	
	JButton deposit,back;
	JTextField amount;
	String pinnumber;
	
	
	public Deposit(String pinnumber) {
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel text=new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(190,300,400,20);
		image.add(text);
		
		amount=new JTextField();
		amount.setBounds(170,350,324,25);
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		image.add(amount);
		
		
		deposit=new JButton("Deposit");
		deposit.setBounds(355,485,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Deposit("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deposit) {
			
			String number= amount.getText();
		    java.util.Date date =new java.util.Date();			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
			}else {
				
				 try {
						
						Connect con=new Connect();
						String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"');";
						con.st.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Rs "+number+" deposited successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
						
						
					} catch (Exception e2) {
						System.out.println(e2);
					}
			
					
			}
			
		}else if(e.getSource()==back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	}

}
