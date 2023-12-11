package digital_atm_systems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;





public class PinChange extends JFrame implements ActionListener{
	String pinnumber ;
	JButton change,cancel;
	JPasswordField pin,repin;
	
	public PinChange(String pinnumber) {
		
		setLayout(null);
		this.pinnumber=pinnumber;
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pintext=new JLabel("NEW PIN : ");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image.add(pintext);
		
		pin=new JPasswordField();
		pin.setFont(new Font("Releway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		JLabel repintext=new JLabel("Re-Enter New PIN : ");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		image.add(repintext);
		repin=new JPasswordField();
		repin.setFont(new Font("Releway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		
		change=new JButton("Change");
		change.setBounds(355,456,150,30);
		change.addActionListener(this);
		image.add(change);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(355,489,150,30);
		cancel.addActionListener(this);
		image.add(cancel);
		
		
		
		setSize(900,900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
			new PinChange("").setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==change) {
		try {
			String npin=pin.getText();
			String rpin=repin.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered Pin does not match");
				return ;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter New PIN ");
				return;
			}
			
			if(repin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN ");
				return;
			}
			
			
			Connect con=new Connect();
			String query1="Update bank set pin = '"+npin+"' where pin='"+pinnumber+"'";
			String query2="Update login set PinNumber = '"+npin+"' where PinNumber='"+pinnumber+"'";
			String query3="Update signupthree set PinNumber = '"+npin+"' where PinNumber='"+pinnumber+"'";
			con.st.executeUpdate(query1);
			con.st.executeUpdate(query2);
			con.st.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
			setVisible(false);
			new Transaction(rpin).setVisible(true);
			
			
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
		}else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
		
	}

}
