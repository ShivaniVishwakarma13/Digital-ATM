package digital_atm_systems;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.SubmissionPublisher;

import javax.swing.*;







public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton saving,current,fd,rd;
	JCheckBox atm, ibanking, mbanking, alert ,cheqbook, estatement,declare;
	JButton submit,cancel;
	String formno;
	
	public SignUpThree(String formno) {
		this.formno=formno;
    setLayout(null);
		
		
		setTitle("NEW ACCOUNT APPLICATION ");
		
		
		
		JLabel l1=new JLabel("Page 3 : Additional Details");
		l1.setFont(new Font("Releway",Font.BOLD,20));
		l1.setBounds(290,20,400,40);
		add(l1);
		
		JLabel account=new JLabel("Account Type ");
		account.setFont(new Font("Releway",Font.BOLD,20));
		account.setBounds(100,140,200,30);
		add(account);
		
		saving=new JRadioButton("Saving Account");
		saving.setFont(new Font("Releway",Font.BOLD,16));
		saving.setBackground(Color.white);
		saving.setBounds(100,180,150,20);
		add(saving);
		

		current=new JRadioButton("Current Account");
		current.setFont(new Font("Releway",Font.BOLD,16));
		current.setBackground(Color.white);
		current.setBounds(350,180,150,20);
		add(current);
		

		fd=new JRadioButton("Fixed Deposit Account");
		fd.setFont(new Font("Releway",Font.BOLD,16));
		fd.setBackground(Color.white);
		fd.setBounds(100,220,200,20);
		add(fd);
		

		rd=new JRadioButton("Recurring Deposit Account");
		rd.setFont(new Font("Releway",Font.BOLD,16));
		rd.setBackground(Color.white);
		rd.setBounds(350,220,250,20);
		add(rd);
		
		ButtonGroup btngrp=new ButtonGroup();
		btngrp.add(current);
		btngrp.add(fd);
		btngrp.add(rd);
		btngrp.add(saving);
		
		JLabel card=new JLabel("Card Number ");
		card.setFont(new Font("Releway",Font.BOLD,20));
		card.setBounds(100,300,200,30);
		add(card);
		JLabel carddetail=new JLabel("Your 16 digit Card Number");
		carddetail.setFont(new Font("Releway",Font.BOLD,12));
		carddetail.setBounds(100,330,300,20);
		add(carddetail);
		
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-1234");
		number.setFont(new Font("Releway",Font.BOLD,20));
		number.setBounds(330,300,300,30);
		add(number);
		
		
		
		JLabel pin=new JLabel("Pin Number ");
		pin.setFont(new Font("Releway",Font.BOLD,20));
		pin.setBounds(100,370,200,30);
		add(pin);
		JLabel pindetail=new JLabel("Your 4 digit Password");
		pindetail.setFont(new Font("Releway",Font.BOLD,12));
		pindetail.setBounds(100,400,300,20);
		add(pindetail);
		
		JLabel pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Releway",Font.BOLD,20));
		pnumber.setBounds(330,370,300,30);
		add(pnumber);
		
		
		JLabel services=new JLabel("Services Required");
		services.setFont(new Font("Releway",Font.BOLD,20));
		services.setBounds(100,450,200,20);
		add(services);
		
		atm=new JCheckBox("ATM Card");
		atm.setBackground(Color.white);
		atm.setFont(new Font("Releway",Font.BOLD,16));
		atm.setBounds(100,500,200,20);
		add(atm);
		
		ibanking=new JCheckBox("Internet Banking");
		ibanking.setBackground(Color.white);
		ibanking.setFont(new Font("Releway",Font.BOLD,16));
		ibanking.setBounds(350,500,200,20);
		add(ibanking);
		
		mbanking=new JCheckBox("Mobile Banking");
		mbanking.setBackground(Color.white);
		mbanking.setFont(new Font("Releway",Font.BOLD,16));
		mbanking.setBounds(100,550,200,20);
		add(mbanking);
		
		alert=new JCheckBox("Email & SMS Alert");
		alert.setBackground(Color.white);
		alert.setFont(new Font("Releway",Font.BOLD,16));
		alert.setBounds(350,550,200,20);
		add(alert);
		
		cheqbook=new JCheckBox("Cheque Book");
		cheqbook.setBackground(Color.white);
		cheqbook.setFont(new Font("Releway",Font.BOLD,16));
		cheqbook.setBounds(100,600,200,20);
		add(cheqbook);
		
		estatement=new JCheckBox("E-Statement");
		estatement.setBackground(Color.white);
		estatement.setFont(new Font("Releway",Font.BOLD,16));
		estatement.setBounds(350,600,200,20);
		add(estatement);
		
		declare=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
		declare.setBackground(Color.white);
		declare.setFont(new Font("Releway",Font.BOLD,12));
		declare.setBounds(100,680,600,20);
		add(declare);
		
		submit=new JButton("Submit");
		submit.setBounds(250,720,100,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("raleway",Font.BOLD,14));
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(420,720,100,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("raleway",Font.BOLD,14));
		cancel.addActionListener(this);
		add(cancel);
		
		
		
		
		
		
        getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new SignUpThree("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String acType=null;
			if(saving.isSelected()) {
				acType="Saving Account";
			}else if(fd.isSelected()) {
				acType="Fixed Deposit Account";
			}else if(rd.isSelected()) {
				acType="Recurring Deposit Account";
			}else if(current.isSelected()) {
				acType="Current Account";
			}
			
			
			Random random=new Random();
			String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			String pinnumber=""+Math.abs(((random.nextLong()%9000L)+1000L));
			
			String facility="";
			
			if(atm.isSelected()) {
				facility=facility+" ATM Card";
			}else if(ibanking.isSelected()) {
				facility=facility+" Internet Banking";
			}else if(mbanking.isSelected()) {
				facility=facility+" Mobile Bankig";
			}else if(alert.isSelected()) {
				facility=facility+" Email & SMS Alert";
			}else if(cheqbook.isSelected()) {
				facility=facility+" Cheque Book";
			}else if(estatement.isSelected()) {
				facility=facility+" E-Statement";
			}
			
			
			try {
				if(facility.equals("")) {
					JOptionPane.showMessageDialog(null, "facility is required");
				}else if(acType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				}else if(!(declare.isSelected())){
					JOptionPane.showMessageDialog(null, "Declaration must be marked");
				}else {
				
				Connect c=new Connect();
				String query1="Insert Into signupthree Values('"+formno+"' ,'"+acType+"' ,'"+cardNumber+"' ,'"+pinnumber+"','"+facility+"');";
				String query2="Insert Into login Values('"+formno+"' ,'"+cardNumber+"' ,'"+pinnumber+"');";
				c.st.executeUpdate(query1);
				c.st.executeUpdate(query2);
				JOptionPane.showMessageDialog(null,"Card Number : "+cardNumber+"\nPin Number : "+pinnumber);
				
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);
				
				}
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
			
		}else if(e.getSource()==cancel ) {
			setVisible(false);
			new Login().setVisible(true);
			
		}
		
	}

}
