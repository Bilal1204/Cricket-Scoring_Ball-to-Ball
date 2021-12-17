import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.ImageIcon;

public class summary implements ActionListener
{ 
	static int[][] top_bat1 = new int[2][2];
	static int[][] top_bowl2 = new int[2][2];
	static int[][] top_bat2 = new int[2][2];
	static int[][] top_bowl1 = new int[2][2];
	static String[] t1bat = new String[2];
	static String[] t2bat = new String[2];
	static String[] t1bowl = new String[2];
	static String[] t2bowl = new String[2];
	static int i,j,overs,t1wkts;
   static  String team1,team2;
   static  int t1runs,t2runs = scorboard.curr_runs;
	
    Frame screen = new Frame("Match Summary");
    Button button = new Button("EXIT");
    Label Heading = new Label("Match Summary");
      Label Team1 = new Label();
    
      Label Team2 = new Label();

      Label Team1Bat1= new Label();
	  Label Team1Bat2= new Label();
	  Label T1Bat1Run= new Label();
	  Label T1Bat2Run= new Label();

	  Label Team1Ball1= new Label();
	  Label Team1Ball2= new Label();
	  Label T1Bowler1Run= new Label();
	  Label T1Bowler2Run= new Label();

	  Label Team2Bat1= new Label();
	  Label Team2Bat2= new Label();
	  Label T2Bat1Run= new Label();
	  Label T2Bat2Run= new Label();

	  Label Team2Ball1= new Label();
	  Label Team2Ball2= new Label();
	  Label T2Bowler1Run= new Label();
	  Label T2Bowler2Run= new Label();

	  Label Team1TotalRuns= new Label();
	  Label Team2TotalRuns= new Label();

	  Label Overs1= new Label();
	  Label Overs2= new Label();
	
	  Label Res= new Label();
		
			
		
    
	Panel panel1=new Panel();  
	Panel panel2=new Panel();  
	
summary()
{
	try {
		Team1();
		Team2();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	/////////////
	ImageIcon image_ball = new ImageIcon("BALL (2).png");
	screen.setIconImage(image_ball.getImage());
	Team1.setText(team1);
	Team2.setText(team2);
	Overs1.setText(overs+" Overs");
	Overs2.setText(String.format("%.1f",scorboard.curr_overs)+" Overs");

	Team1Bat1.setText(t1bat[0]);
	Team1Bat2.setText(t1bat[1]);

	T1Bat1Run.setText(""+top_bat1[0][0]+"("+top_bat1[0][1]+")");
	T1Bat2Run.setText(""+top_bat1[1][0]+"("+top_bat1[1][1]+")");

	Team1Ball1.setText(""+t2bowl[0]);
	Team1Ball2.setText(""+t2bowl[1]);

	T1Bowler1Run.setText(""+top_bowl2[0][1]+"/"+top_bowl2[0][0]);
	T1Bowler2Run.setText(""+top_bowl2[1][1]+"/"+top_bowl2[1][0]);

	Team2Bat1.setText(t2bat[0]);
	Team2Bat2.setText(t2bat[1]);

	T2Bat1Run.setText(""+top_bat2[0][0]+"("+top_bat2[0][1]+")");
	T2Bat2Run.setText(""+top_bat2[1][0]+"("+top_bat2[1][1]+")");

	Team2Ball1.setText(""+t1bowl[0]);
	Team2Ball2.setText(""+t1bowl[1]);

	T2Bowler1Run.setText(""+top_bowl1[0][1]+"/"+top_bowl1[0][0]);
	T2Bowler2Run.setText(""+top_bowl1[1][1]+"/"+top_bowl1[1][0]);

	
	////////////////////
	Heading.setBounds(625,50,350,70);
	Heading.setForeground(Color.BLACK);
	Heading.setFont(new Font("Tahooma",Font.BOLD,44));
	panel1.add(Heading);

	panel1.setBounds(5,30,1540,70);    
    panel1.setBackground(Color.WHITE);  
	screen.add(panel1);
	
	panel2.setBounds(4,440,1540,10);    
    panel2.setBackground(Color.WHITE);  
	screen.add(panel2);
	 
	Team1.setBounds(200,160,350,60);
	Team1.setForeground(Color.WHITE);
	Team1.setFont(new Font("Tahooma",Font.PLAIN,54));
	screen.add(Team1);
	
	Team2.setBounds(200,460,350,60);
	Team2.setForeground(Color.WHITE);
	Team2.setFont(new Font("Tahooma",Font.PLAIN,54));
	screen.add(Team2);
	
	Overs1.setBounds(800,170,200,40);
	Overs1.setForeground(Color.WHITE);
	Overs1.setFont(new Font("Tahooma",Font.PLAIN,40));
	screen.add(Overs1);
	
	Overs2.setBounds(800,460,460,40);
	Overs2.setForeground(Color.WHITE);
	Overs2.setFont(new Font("Tahooma",Font.PLAIN,40));
	screen.add(Overs2);
	
	Team1Bat1.setBounds(200,250,250,40);
	Team1Bat1.setForeground(Color.WHITE);
	Team1Bat1.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team1Bat1);
	
	Team1Bat2.setBounds(200,320,250,40);
	Team1Bat2.setForeground(Color.WHITE);
	Team1Bat2.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team1Bat2);
	
	Team1Ball1.setBounds(900,550,200,40);
	Team1Ball1.setForeground(Color.WHITE);
	Team1Ball1.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team1Ball1);
	
	Team1Ball2.setBounds(900,620,200,40);
	Team1Ball2.setForeground(Color.WHITE);
	Team1Ball2.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team1Ball2);
	
	
	Team2Bat1.setBounds(200,550,250,40);
	Team2Bat1.setForeground(Color.WHITE);
	Team2Bat1.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team2Bat1);
	
	Team2Bat2.setBounds(200,620,250,40);
	Team2Bat2.setForeground(Color.WHITE);
	Team2Bat2.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team2Bat2);
	
	Team2Ball1.setBounds(900,250,250,40);
	Team2Ball1.setForeground(Color.WHITE);
	Team2Ball1.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team2Ball1);
	
	Team2Ball2.setBounds(900,320,250,40);
	Team2Ball2.setForeground(Color.WHITE);
	Team2Ball2.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(Team2Ball2);
	
	T1Bat1Run.setBounds(500,250,350,40);
	T1Bat1Run.setForeground(Color.WHITE);
	T1Bat1Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T1Bat1Run);
	
	T1Bat2Run.setBounds(500,320,350,40);
	T1Bat2Run.setForeground(Color.WHITE);
	T1Bat2Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T1Bat2Run);
	

	T2Bat1Run.setBounds(500,550,350,40);
	T2Bat1Run.setForeground(Color.WHITE);
	T2Bat1Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T2Bat1Run);
	
	T2Bat2Run.setBounds(500,620,350,40);
	T2Bat2Run.setForeground(Color.WHITE);
	T2Bat2Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T2Bat2Run);
	

	T1Bowler1Run.setBounds(1150,550,250,40);
	T1Bowler1Run.setForeground(Color.WHITE);
	T1Bowler1Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T1Bowler1Run);
	
	T1Bowler2Run.setBounds(1150,620,250,40);
	T1Bowler2Run.setForeground(Color.WHITE);
	T1Bowler2Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T1Bowler2Run);
	

	T2Bowler1Run.setBounds(1150,250,250,40);
	T2Bowler1Run.setForeground(Color.WHITE);
	T2Bowler1Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T2Bowler1Run);
	
	T2Bowler2Run.setBounds(1150,320,250,40);
	T2Bowler2Run.setForeground(Color.WHITE);
	T2Bowler2Run.setFont(new Font("Tahooma",Font.PLAIN,34));
	screen.add(T2Bowler2Run);
	
	Team1TotalRuns.setBounds(1300,160,350,40);
	Team1TotalRuns.setText(""+t1runs+"/"+t1wkts);
	Team1TotalRuns.setForeground(Color.WHITE);
	Team1TotalRuns.setFont(new Font("Tahooma",Font.PLAIN,42));
	screen.add(Team1TotalRuns);
	
	Team2TotalRuns.setBounds(1300,460,350,40);
	Team2TotalRuns.setText(""+t2runs+"/"+scorboard.curr_wkts);
	Team2TotalRuns.setForeground(Color.WHITE);
	Team2TotalRuns.setFont(new Font("Tahooma",Font.PLAIN,42));
	screen.add(Team2TotalRuns);
	
	Res.setBounds(300,730,1000,60);
	Res.setForeground(Color.red);
	Res.setFont(new Font("Tahooma",Font.PLAIN,46));
	screen.add(Res);
	
	button.setBounds(600,100,350,50);
	button.addActionListener(this);
	button.setForeground(Color.white);
	button.setBackground(new Color(10,50,100));
	button.setFont(new Font("Tahooma",Font.PLAIN,46));
	screen.add(button);
	
	if(t1runs>t2runs)
		Res.setText(team1+" win the match from "+team2 +" by "+(t1runs-t2runs)+" runs");
	else
		Res.setText(team2+" win the match from "+team1 +" by "+(10-scorboard.curr_wkts)+" wickets");
       screen.setBackground(new Color(10,50,100));
	   screen.setForeground(Color.red);
	   screen.setSize(1920,1080);
	   screen.setLayout(null);
	   screen.setVisible(true);
	    screen.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {System.exit(0);}});
	    screen.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {System.exit(0);}});
}

public static void Team1() throws SQLException{
	Connection conn = null;
	Statement stmt = null,st =null,mystmt = null;
	ResultSet rs1 = null;
	ResultSet rs = null;
	ResultSet res = null;
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");
		mystmt=stmt=conn.createStatement();
		st=conn.createStatement();

		rs1 = stmt.executeQuery("Select * from team_detail;");
		while(rs1.next()) {
			t1runs = rs1.getInt("team1_score");
			overs = rs1.getInt("overs");
			team1 = rs1.getString("team1");
			t1wkts = rs1.getInt("team1_wkt");
		}
		res = st.executeQuery("select * from team1 order by Runs_Batsman DESC Limit 2;");
		i=0;
		while(res.next() && i<=1) {
					t1bat[i] = res.getString("name");
					top_bat1[i][0] = res.getInt("Runs_Batsman");
					top_bat1[i][1] = res.getInt("Balls_Batsman");
					i+=1;
}
		rs = mystmt.executeQuery("select * from team1  where overs != 0 order by Wicket DESC Limit 2;");
		i=0;
		while(rs.next() && i<=1) {
					t2bowl[i] = rs.getString("name");
					top_bowl2[i][0] = rs.getInt("Wicket");
					top_bowl2[i][1] = rs.getInt("Runs_Bowler");
					i+=1;
}
	}catch (Exception exc) {
        exc.printStackTrace();
    }
	finally {
	      
    	if (stmt != null) {
           stmt.close();
        }

        if (conn != null) {
            conn.close();
        }
        if(rs != null) {
        	res.close();
        	rs.close();
        }
        
    }
	
}

public static void Team2() throws SQLException{
	Connection conn = null;
	Statement stmt = null,st =null,mystmt = null;
	ResultSet rs1 = null;
	ResultSet rs = null;
	ResultSet res = null;
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");
		mystmt=stmt=conn.createStatement();
		st=conn.createStatement();

		rs1 = stmt.executeQuery("Select * from team_detail;");
		while(rs1.next()) {
			t2runs = rs1.getInt("team2_score");
		//	t2runs = rs1.getInt("team2_score");
			team2 = rs1.getString("team2");
		}
		res = st.executeQuery("select * from team2 order by Runs_Batsman DESC Limit 2;");
		i=0;
		while(res.next() && i<=1) {
					t2bat[i] = res.getString("name");
					top_bat2[i][0] = res.getInt("Runs_Batsman");
					top_bat2[i][1] = res.getInt("Balls_Batsman");
					i+=1;
}
		rs = mystmt.executeQuery("select * from team2 order by Wicket DESC Limit 2;");
		i=0;
		while(rs.next() && i<=1) {
					t1bowl[i] = rs.getString("name");
					top_bowl1[i][0] = rs.getInt("Wicket");
					top_bowl1[i][1] = rs.getInt("Runs_Bowler");
					i+=1;
}
	}catch (Exception exc) {
        exc.printStackTrace();
    }
	finally {
	      
    	if (stmt != null) {
           stmt.close();
        }

        if (conn != null) {
            conn.close();
        }
        if(rs != null) {
        	res.close();
        	rs.close();
        }
        
    }
	
}

public static void main (String args[])
{
	 new summary();
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == button)
	{
		screen.dispose();
	}
	
}

}