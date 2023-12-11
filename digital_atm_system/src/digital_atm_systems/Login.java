package digital_atm_systems;
import javax.swing.*;
import java.awt.Event;

import Listeners.ActionListners;

import java.awt.*;


public class Login extends JFrame {
	
	ActionListners acListener =new ActionListners(this);
	
	
	 public JButton login,clear,signUp;
	public JTextField cardTxtField;
	public JPasswordField pinTxtField;
	public Login() {
		setTitle("Automated Teller Machine");
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70,10, 100, 100);
		add(label);
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel cardNo=new JLabel("Card No : ");
		cardNo.setFont(new Font("Raleway",Font.BOLD,28));
		cardNo.setBounds(120,150,150,40);
		add(cardNo);
		
		cardTxtField =new JTextField();
		cardTxtField.setFont(new Font("Arial",Font.BOLD,14));
		cardTxtField.setBounds(300,150,250,30);
		add(cardTxtField);
		
		JLabel pin=new JLabel("Pin :");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		pinTxtField =new JPasswordField();
		pinTxtField.setFont(new Font("Arial",Font.BOLD,14));
		pinTxtField.setBounds(300,220,250,30);
		add(pinTxtField);
		
		login =new JButton("Login");
		login.setBounds(300,300,100,30);
		login.addActionListener(acListener);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		add(login);
	
		clear =new JButton("Clear");
		clear.setBounds(450,300,100,30);
		clear.addActionListener(acListener);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		add(clear);
		
		
		signUp =new JButton("Sign Up");
		signUp.setBounds(300,350,250,30);
		signUp.setBackground(Color.black);
		signUp.addActionListener(acListener);
		signUp.setForeground(Color.white);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,500);
		setVisible(true);
		setLocation(350,200);
	}

	public static void main(String[] args) {
		new Login();

	}

}
