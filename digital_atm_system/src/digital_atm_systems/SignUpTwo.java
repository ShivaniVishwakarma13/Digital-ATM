package digital_atm_systems;
import javax.swing.*;

import digital_atm_systems.Connect.*;

import java.sql.*;


import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField pan , aadhar;
	JComboBox religions , categories, incomes,edu, occupations;
	JRadioButton syes,sno,ayes,ano;
	JButton button;
	String formno;
	
	public SignUpTwo(String formno) {
		this.formno=formno;
		setLayout(null);
		
		
		setTitle("NEW ACCOUNT APPLICATION ");
		
		
		
		JLabel additionalDetail=new JLabel("Page 2 : Additional Details");
		additionalDetail.setFont(new Font("Releway",Font.BOLD,20));
		additionalDetail.setBounds(290,80,400,30);
		add(additionalDetail);
		
		JLabel religion=new JLabel("Religion :");
		religion.setFont(new Font("Releway",Font.BOLD,20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		
		String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
		 religions=new JComboBox(valReligion);
		religions.setBackground(Color.white);
		religions.setBounds(300,140,400,30);
		add(religions);
		
		
		JLabel category=new JLabel("Category");
		category.setFont(new Font("Releway",Font.BOLD,20));
		category.setBounds(100,240,200,30);
		add(category);
		
		String valCategory[]= {"General","OBC","SC","ST","Other"};
		categories=new JComboBox(valCategory);
		categories.setBackground(Color.white);
		categories.setBounds(300,240,400,30);
		add(categories);

		
		
		JLabel income=new JLabel("Income :");
		income.setFont(new Font("Releway",Font.BOLD,20));
		income.setBounds(100,190,200,30);
		add(income);
	
		String valIncome[]= {"null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		incomes =new JComboBox(valIncome);
		incomes.setBounds(300,190,400,30);
    	incomes.setBackground(Color.white);
		add(incomes);
		
		JLabel education=new JLabel("Education :");
		education.setFont(new Font("Releway",Font.BOLD,20));
		education.setBounds(100,280,200,30);
		add(education);
		
		JLabel qualification=new JLabel("Qualification :");
		qualification.setFont(new Font("Releway",Font.BOLD,20));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		String valEdu[]= {"Non-Graduation","Gradution","Post Graduation","Doctrate","Other"};
		edu =new JComboBox(valEdu);
		edu.setBounds(300,315,400,30);
    	edu.setBackground(Color.white);
		add(edu);
		
		
		JLabel occupation=new JLabel("Occupation :");
		occupation.setFont(new Font("Releway",Font.BOLD,20));
		occupation.setBounds(100,380,200,30);
		add(occupation);
		
		String valOcc[]= {"Salaried","Self-Employee","Bussiness","Student","Retired","Other"};
	    occupations =new JComboBox(valOcc);
		occupations.setBounds(300,380,400,30);
    	occupations.setBackground(Color.white);
		add(occupations);
		
		
				
		JLabel panNo=new JLabel("PAN Number :");
		panNo.setFont(new Font("Releway",Font.BOLD,20));
		panNo.setBounds(100,430,200,30);
		add(panNo);
		pan=new JTextField();
		pan.setFont(new Font("Releway",Font.BOLD,14));
		pan.setBounds(300,430,400,30);
		add(pan);
				
		JLabel aadharNo=new JLabel("Aadhar Number :");
		aadharNo.setFont(new Font("Releway",Font.BOLD,20));
		aadharNo.setBounds(100,480,200,30);
		add(aadharNo);
		aadhar=new JTextField();
		aadhar.setFont(new Font("Releway",Font.BOLD,14));
		aadhar.setBounds(300,480,400,30);
		add(aadhar);
		
		JLabel seniorCitizen =new JLabel("Senior Citizen :");
		seniorCitizen.setFont(new Font("Releway",Font.BOLD,20));
		seniorCitizen.setBounds(100,530,200,30);
		add(seniorCitizen);
		 syes=new JRadioButton("Yes");
			syes.setBounds(300,530,60,30);
			syes.setBackground(Color.white);
			add(syes);
			
			
			sno=new JRadioButton("No");
			sno.setBounds(450,530,120,30);
			sno.setBackground(Color.white);
			add(sno);
			
			ButtonGroup senior=new ButtonGroup();
			senior.add(syes);
			senior.add(sno);
			
		
		JLabel existingAc =new JLabel("Existing Account :");
		existingAc.setFont(new Font("Releway",Font.BOLD,20));
		existingAc.setBounds(100,580,200,30);
		add(existingAc);
		ayes=new JRadioButton("Yes");
		ayes.setBounds(300,580,60,30);
		ayes.setBackground(Color.white);
		add(ayes);
		
		
		ano=new JRadioButton("No");
		ano.setBounds(450,580,120,30);
		ano.setBackground(Color.white);
		add(ano);
		
		ButtonGroup btnGroup=new ButtonGroup();
		btnGroup.add(ano);
		btnGroup.add(ayes);
		
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
		new SignUpTwo("");

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		String panNo=pan.getText();
		String aadharNo=aadhar.getText();
		String religion=(String)religions.getSelectedItem();
		String category= (String)categories.getSelectedItem();
		String income= (String)incomes.getSelectedItem();
		String education=(String)edu.getSelectedItem();
		String seniorCitizen=null;
		if(syes.isSelected()) {
			seniorCitizen="Yes";
		}else if(sno.isSelected()) {
			seniorCitizen="No";
		}
		
		String existingAc=null;
		if(ayes.isSelected()) {
			existingAc="Yes";
		}else if(ano.isSelected()) {
			existingAc="No";
		}
		
		String occupation=occupations.getSelectedItem().toString();
		
		
		
		try {
			if(panNo.equals("")) {
				JOptionPane.showMessageDialog(null, "PAN Number  is required");
			}else if(aadharNo.equals("")) {
				JOptionPane.showMessageDialog(null, "Aadhar Number is required");
			}else if(religion.equals("")) {
				JOptionPane.showMessageDialog(null, "Religion is required");
			}else if(category.equals("")) {
				JOptionPane.showMessageDialog(null, "Category is required");
			}else if(income.equals("")) {
				JOptionPane.showMessageDialog(null, "Income is required");
			}else if(education.equals("")) {
				JOptionPane.showMessageDialog(null, "Education Qualification is required");
			}else if(seniorCitizen.equals("")) {
				JOptionPane.showMessageDialog(null, "Senior Citizen is required");
			}else if(existingAc.equals("")) {
				JOptionPane.showMessageDialog(null, "Existing Account is required");
			}else if(occupation.equals("")) {
				JOptionPane.showMessageDialog(null, "Occupation Status is required");
			}else {
				Connect con=new Connect();
				String queryTwo="insert into signuptwo values('"+ formno +"' , '"+religion+"' , '"+category+"' , '"+income+"' , '"+education+"' , '"+occupation+"' , '"+seniorCitizen+"' , '"+existingAc+"' , '"+panNo+"' , '"+aadharNo+"');";
				con.st.executeUpdate(queryTwo);
				setVisible(false);
				new SignUpThree(formno).setVisible(true);
			}
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
