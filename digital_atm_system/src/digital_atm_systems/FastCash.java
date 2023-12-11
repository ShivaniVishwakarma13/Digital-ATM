package digital_atm_systems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class FastCash extends JFrame implements ActionListener{
	
	JButton hundred,fiveH,oneT,twoT,fiveT,tenT,back;
	String pinNumber;
	
	public FastCash(String pinnumber) {
		pinNumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel Img=new JLabel(i3);
		Img.setBounds(0,0,900,900);
		add(Img);
		
		JLabel text=new JLabel("Please select Withdrawal amount");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		Img.add(text);
		
		
		hundred=new JButton("Rs 100");
		hundred.setBounds(170,390,150,30);
		hundred.addActionListener(this);
		Img.add(hundred);
		
		fiveH=new JButton("Rs 500");
		fiveH.setBounds(355,390,150,30);
		fiveH.addActionListener(this);
		Img.add(fiveH);
		
		oneT=new JButton("Rs 1000");
		oneT.setBounds(170,423,150,30);
		oneT.addActionListener(this);
		Img.add(oneT);
		
		twoT=new JButton("Rs 2000");
		twoT.setBounds(355,423,150,30);
		twoT.addActionListener(this);
		Img.add(twoT);
		
		fiveT=new JButton("Rs 5000");
		fiveT.setBounds(170,456,150,30);
		fiveT.addActionListener(this);
		Img.add(fiveT);
		
		tenT=new JButton("Rs 10000");
		tenT.setBounds(355,456,150,30);
		tenT.addActionListener(this);
		Img.add(tenT);
		
		back=new JButton("Back");
		back.setBounds(355,489,150,30);
		back.addActionListener(this);
		Img.add(back);
		
		
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
		
		if(e.getSource()==back) {
			System.exit(0);
		}else {
			
			String amount=((JButton)e.getSource()).getText().substring(3);
			Connect con=new Connect();
			
			try {
				
				ResultSet rs= con.st.executeQuery("select * from bank where pin = '"+pinNumber+"';");
				int balance =0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance +=Integer.parseInt(rs.getString("amount"));
					}else {
						balance -=Integer.parseInt(rs.getString("amount"));
					}
				}
				
				
				if(e.getSource()!= back && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				java.util.Date date=new java.util.Date();
				
				String query= "insert  into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"');";
				
				con.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
				
				setVisible(false);
	            new Transaction(pinNumber).setVisible(true);
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		
	}

}
