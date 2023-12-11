package digital_atm_systems;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Transaction extends JFrame implements ActionListener{
	
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceEnquiry,exit;
	String pinNumber;
	
	public Transaction(String pinnumber) {
		pinNumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel Img=new JLabel(i3);
		Img.setBounds(0,0,900,900);
		add(Img);
		
		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		Img.add(text);
		
		
		deposit=new JButton("Deposit");
		deposit.setBounds(170,390,150,30);
		deposit.addActionListener(this);
		Img.add(deposit);
		
		withdrawl=new JButton("Cash Withdrawl");
		withdrawl.setBounds(355,390,150,30);
		withdrawl.addActionListener(this);
		Img.add(withdrawl);
		
		fastcash=new JButton("Fast Cash");
		fastcash.setBounds(170,423,150,30);
		fastcash.addActionListener(this);
		Img.add(fastcash);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBounds(355,423,150,30);
		ministatement.addActionListener(this);
		Img.add(ministatement);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBounds(170,456,150,30);
		pinchange.addActionListener(this);
		Img.add(pinchange);
		
		balanceEnquiry=new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(355,456,150,30);
		balanceEnquiry.addActionListener(this);
		Img.add(balanceEnquiry);
		
		exit=new JButton("Exit");
		exit.setBounds(355,489,150,30);
		exit.addActionListener(this);
		Img.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Transaction("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==exit) {
			System.exit(0);
		}else if(e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}else if(e.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pinNumber).setVisible(true);
		}else if(e.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}else if(e.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinNumber);
		}else if(e.getSource()==balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}else if(e.getSource()==ministatement) {
			new MiniStatement(pinNumber).setVisible(true);
		}
		
		
	}

}
