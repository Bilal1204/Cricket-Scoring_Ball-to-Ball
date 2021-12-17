
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class next_bowler extends JFrame implements ActionListener{
	String[] nxt_bats = wicket_update.next_player;
	//ImageIcon image_bat = new ImageIcon("batsman.png");
	ImageIcon image_bat = new ImageIcon("BALL (2).png");
	ImageIcon image = new ImageIcon("black.jpg");
	JRadioButton plyr1 = new JRadioButton(over_update.nxt_bowl[0]);
	JRadioButton plyr2 = new JRadioButton(over_update.nxt_bowl[1]);
	JRadioButton plyr3 = new JRadioButton(over_update.nxt_bowl[2]);
	JRadioButton plyr4 = new JRadioButton(over_update.nxt_bowl[3]);
	JRadioButton plyr5 = new JRadioButton(over_update.nxt_bowl[4]);
	JRadioButton plyr6 = new JRadioButton(over_update.nxt_bowl[5]);
	JRadioButton plyr7 = new JRadioButton(over_update.nxt_bowl[6]);
	JRadioButton plyr8 = new JRadioButton(over_update.nxt_bowl[7]);
	JRadioButton plyr9 = new JRadioButton(over_update.nxt_bowl[8]);
	JRadioButton plyr10 = new JRadioButton(over_update.nxt_bowl[9]);
	JRadioButton plyr11 = new JRadioButton(over_update.nxt_bowl[10]);
	ButtonGroup list = new ButtonGroup();
	JButton submit = new JButton("SUBMIT");
	
	next_bowler() 
	{
//	System.out.println(Arrays.toString(wicket_update.next_player));	
		ImageIcon image_ball = new ImageIcon("BALL (2).png");
    	this.setIconImage(image_ball.getImage());
	JLabel label = new JLabel("Select The Next Bowler");
	label.setBackground(Color.black);
	label.setForeground(new Color(255,250,205));
	label.setFont(new Font("",Font.HANGING_BASELINE,28));
	label.setAlignmentX(label.CENTER);
	this.add(label);
	
	plyr1.setIcon(image);
	plyr2.setIcon(image);
	plyr3.setIcon(image);
	plyr4.setIcon(image);
	plyr5.setIcon(image);
	plyr6.setIcon(image);
	plyr7.setIcon(image);
	plyr8.setIcon(image);
	plyr9.setIcon(image);
	plyr10.setIcon(image);
	plyr11.setIcon(image);
	
	plyr1.setSelectedIcon(image_bat);
	plyr2.setSelectedIcon(image_bat);
	plyr3.setSelectedIcon(image_bat);
	plyr4.setSelectedIcon(image_bat);
	plyr5.setSelectedIcon(image_bat);
	plyr6.setSelectedIcon(image_bat);
	plyr7.setSelectedIcon(image_bat);
	plyr8.setSelectedIcon(image_bat);
	plyr9.setSelectedIcon(image_bat);
	plyr10.setSelectedIcon(image_bat);
	plyr11.setSelectedIcon(image_bat);
	
	list.add(plyr1);
	list.add(plyr2);
	list.add(plyr3);
	list.add(plyr4);
	list.add(plyr5);
	list.add(plyr6);
	list.add(plyr7);
	list.add(plyr8);
	list.add(plyr9);
	list.add(plyr10);
	list.add(plyr11);
	
	
	plyr1.setActionCommand(over_update.nxt_bowl[0]);
	plyr2.setActionCommand(over_update.nxt_bowl[1]);
	plyr3.setActionCommand(over_update.nxt_bowl[2]);
	plyr4.setActionCommand(over_update.nxt_bowl[3]);
	plyr5.setActionCommand(over_update.nxt_bowl[4]);
	plyr6.setActionCommand(over_update.nxt_bowl[5]);
	plyr7.setActionCommand(over_update.nxt_bowl[6]);
	plyr8.setActionCommand(over_update.nxt_bowl[7]);
	plyr9.setActionCommand(over_update.nxt_bowl[8]);
	plyr10.setActionCommand(over_update.nxt_bowl[9]);
	plyr11.setActionCommand(over_update.nxt_bowl[10]);
	
	plyr1.setBackground(Color.black);
	plyr1.setForeground(Color.white);
	plyr1.setFont(new Font("",Font.HANGING_BASELINE,24));
	
//	plyr1.isSelected();
	plyr1.setDisabledSelectedIcon(null);
	plyr1.addActionListener(this);
	
	plyr2.setBackground(Color.black);
	plyr2.setForeground(Color.white);
	plyr2.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr2.addActionListener(this);
	
	plyr3.setBackground(Color.black);
	plyr3.setForeground(Color.white);
	plyr3.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr3.addActionListener(this);
	
	plyr4.setBackground(Color.black);
	plyr4.setForeground(Color.white);
	plyr4.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr4.addActionListener(this);
	
	plyr5.setBackground(Color.black);
	plyr5.setForeground(Color.white);
	plyr5.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr5.addActionListener(this);
	
	plyr6.setBackground(Color.black);
	plyr6.setForeground(Color.white);
	plyr6.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr6.addActionListener(this);
	
	plyr7.setBackground(Color.black);
	plyr7.setForeground(Color.white);
	plyr7.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr7.addActionListener(this);
	
	plyr8.setBackground(Color.black);
	plyr8.setForeground(Color.white);
	plyr8.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr8.addActionListener(this);
	
	plyr9.setBackground(Color.black);
	plyr9.setForeground(Color.white);
	plyr9.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr9.addActionListener(this);
	
	plyr10.setBackground(Color.black);
	plyr10.setForeground(Color.white);
	plyr10.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr10.addActionListener(this);
	
	plyr11.setBackground(Color.black);
	plyr11.setForeground(Color.white);
	plyr11.setFont(new Font("",Font.HANGING_BASELINE,24));
	plyr11.addActionListener(this);
	
	
	
	submit.setFocusable(false);
	submit.setBackground(new Color(0,0,0));
	submit.setForeground(Color.white);
	submit.addActionListener(this);
	submit.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	submit.addActionListener(this);
	
	this.setSize(400,600);	
	this.add(plyr1);
	this.add(plyr2);
	this.add(plyr3);
	this.add(plyr4);
	this.add(plyr5);
	this.add(plyr6);
	this.add(plyr7);
	this.add(plyr8);
	this.add(plyr9);
	this.add(plyr10);
	this.add(plyr11);
	this.add(submit);
	this.setVisible(true);
	this.getContentPane().setBackground(new Color(0,0,0));
	this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);;
	this.setLayout(new GridLayout( 13,1,0, 0));
	this.setLocation(1100,0);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit)
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet res = null;
			scorboard.bwlr1 = list.getSelection().getActionCommand();
			scorboard.bwlr1_name.setText(""+scorboard.bwlr1);
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");
				stmt=conn.createStatement();
				if(wicket_update.flag==0)
					res = stmt.executeQuery("select overs, Wicket , Runs_Bowler from  `team2` where name = ('"+scorboard.bwlr1+"');");
				else
					res = stmt.executeQuery("select overs, Wicket , Runs_Bowler from  `team1` where name = ('"+scorboard.bwlr1+"');");
				
					while(res.next()) {
					scorboard.bwlr1_overs = res.getFloat("overs");
					scorboard.bwlr1_wkt = res.getInt("Wicket");
					scorboard.bwlr1_runs = res.getInt("Runs_Bowler");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			scorboard.label_bwlr1_overs.setText(String.format("%.1f",scorboard.bwlr1_overs));
			scorboard.label_bwlr1_runs.setText(""+scorboard.bwlr1_runs);
			scorboard.label_bwlr1_wkts.setText(""+scorboard.bwlr1_wkt);
			this.dispose();
		}
	}
}
