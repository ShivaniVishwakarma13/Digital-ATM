package digital_atm_systems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
JButton back;
String pinnumber;
int balance;
	public BalanceEnquiry(String pinnumber) {
		this.pinnumber=pinnumber;
		setLayout(null);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		back=new JButton("Back");
		back.setBounds(355,489,150,30);
		back.addActionListener(this);
		image.add(back);
		
		Connect con=new Connect();
		try {
			ResultSet rs= con.st.executeQuery("select * from bank where pin = '"+pinnumber+"';");
			balance =0;
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance +=Integer.parseInt(rs.getString("amount"));
				}else {
					balance -=Integer.parseInt(rs.getString("amount"));
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JLabel text=new JLabel(" Your current account balance amount is ");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,300,400,30);
		image.add(text);
		
		JLabel atext=new JLabel(" Rs."+balance);
		atext.setForeground(Color.white);
		atext.setFont(new Font("System",Font.BOLD,16));
		atext.setBounds(300,350,400,30);
		image.add(atext);
		
		
		
		
		
		
		setSize(900,900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	}

}
