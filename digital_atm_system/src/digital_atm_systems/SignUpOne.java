package digital_atm_systems;
import javax.swing.*;

import digital_atm_systems.Connect.*;

import java.util.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextField,fnameTextField,cityTextField,stateTextField,pinTextField,addressTextField,dateChooser ,emailTextField;
	JRadioButton male,female,married,unmarried,other;
	JButton button;
	//JDateChooser dateChooser;
	
	public SignUpOne() {
		
		setLayout(null);
		 Random ran=new Random();
		
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		

		JLabel frameNo = new JLabel("APPLICATION FORM NO : "+random);
		frameNo.setFont(new Font("Raleway",Font.BOLD,38));
		frameNo.setBounds(140,20,600,40);
		add(frameNo);
		
		JLabel personalDetail=new JLabel("Page 1 : Personal Details");
		personalDetail.setFont(new Font("Releway",Font.BOLD,20));
		personalDetail.setBounds(290,80,400,30);
		add(personalDetail);
		
		JLabel name=new JLabel("Name :");
		name.setFont(new Font("Releway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		 nameTextField=new JTextField();
		nameTextField.setFont(new Font("Releway",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		JLabel fname=new JLabel("Father's Name :");
		fname.setFont(new Font("Releway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField=new JTextField();
		fnameTextField.setFont(new Font("Releway",Font.BOLD,14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob=new JLabel("Date of Birth :");
		dob.setFont(new Font("Releway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		// dateChooser=new JDateChooser();
		dateChooser =new JTextField();
		dateChooser.setBounds(300,240,400,30);
    	dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		JLabel gender=new JLabel("Gender :");
		gender.setFont(new Font("Releway",Font.BOLD,20));
		gender.setBounds(100,280,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,280,60,30);
		male.setBackground(Color.white);
		add(male);
		
		
		female=new JRadioButton("Female");
		female.setBounds(450,280,120,30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup btnGroup=new ButtonGroup();
		btnGroup.add(male);
		btnGroup.add(female);
		
		JLabel email=new JLabel("Email Address:");
		email.setFont(new Font("Releway",Font.BOLD,20));
		email.setBounds(100,330,200,30);
		add(email);
		emailTextField=new JTextField();
		emailTextField.setFont(new Font("Releway",Font.BOLD,14));
		emailTextField.setBounds(300,330,400,30);
		add(emailTextField);
		
		JLabel marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Releway",Font.BOLD,20));
		marital.setBounds(100,380,200,30);
		add(marital);
		
		 married=new JRadioButton("Married");
		married.setBounds(300,380,120,30);
		married.setBackground(Color.white);
		add(married);
		
		other=new JRadioButton("Other");
		other.setBounds(600,380,100,30);
		other.setBackground(Color.white);
		add(other);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,380,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		ButtonGroup maritalbtn=new ButtonGroup();
		maritalbtn.add(married);
		maritalbtn.add(unmarried);
		maritalbtn.add(other);
		
		
		JLabel address=new JLabel("Address :");
		address.setFont(new Font("Releway",Font.BOLD,20));
		address.setBounds(100,430,200,30);
		add(address);
		addressTextField=new JTextField();
		addressTextField.setFont(new Font("Releway",Font.BOLD,14));
		addressTextField.setBounds(300,430,400,30);
		add(addressTextField);
		
		JLabel city=new JLabel("City :");
		city.setFont(new Font("Releway",Font.BOLD,20));
		city.setBounds(100,480,200,30);
		add(city);
		cityTextField=new JTextField();
		cityTextField.setFont(new Font("Releway",Font.BOLD,14));
		cityTextField.setBounds(300,480,400,30);
		add(cityTextField);
		
		JLabel state =new JLabel("State :");
		state.setFont(new Font("Releway",Font.BOLD,20));
		state.setBounds(100,530,200,30);
		add(state);
		stateTextField=new JTextField();
		stateTextField.setFont(new Font("Releway",Font.BOLD,14));
		stateTextField.setBounds(300,530,400,30);
		add(stateTextField);
		
		JLabel pinCode =new JLabel("Pin Code :");
		pinCode.setFont(new Font("Releway",Font.BOLD,20));
		pinCode.setBounds(100,580,200,30);
		add(pinCode);
		
		pinTextField=new JTextField();
		pinTextField.setFont(new Font("Releway",Font.BOLD,14));
		pinTextField.setBounds(300,580,400,30);
		add(pinTextField);
		
		
		button=new JButton("Next");
		button.setBounds(620,660,80,30);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(new Font("raleway",Font.BOLD,14));
		button.addActionListener(this);
		add(button);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new SignUpOne();

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		String formno=""+random;
		String name=nameTextField.getText();
		String fname=fnameTextField.getText();
		String city=cityTextField.getText();
		String state=stateTextField.getText();
		//String dob =(JTextField)dateChooser.gatDataEditor().getUIComponent().getText();
		String dob=dateChooser.getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}
		
		String email=emailTextField.getText();
		String marital=null;
		if(married.isSelected()) {
			marital="Married";
		}else if(unmarried.isSelected()) {
			marital="Unmarried";
		}else if(other.isSelected()) {
			marital="Other";
		}
		
		
		String address=addressTextField.getText();
		String pincode=pinTextField.getText();
		
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name  is required");
			}else if(fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Father's Name  is required");
			}else if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "City is required");
			}else if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State is required");
			}else if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address is required");
			}else if(pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "PinCode is required");
			}else if(dob.equals("")) {
				JOptionPane.showMessageDialog(null, "Date of Birth is required");
			}else if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender is required");
			}else if(marital.equals("")) {
				JOptionPane.showMessageDialog(null, "Marital Status is required");
			}else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email is required");
			}else {
				Connect con=new Connect();
				String query="insert into signup values('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+city+"' , '"+state+"' ,' "+address+"', '"+pincode+"');";
				con.st.executeUpdate(query);
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
