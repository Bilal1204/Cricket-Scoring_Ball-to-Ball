// Scoreboard
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
public class scorboard implements ActionListener{
	
	String team1 = wicket_update.team1,team2 = wicket_update.team2 ,electedTo = wicket_update.electedTo;
	static String bwlr1,plyr1  = wicket_update.next_player[0],plyr2 = wicket_update.next_player[1] ;
	String this_over = "";
	static int curr_runs = 0,curr_wkts =0,diff = 0,prev_runs=0;
	int plyr1_runs = 0,plyr2_runs = 0,plyr1_balls = 0,plyr2_balls = 0;
	static int total_overs = wicket_update.tot_overs ;
	static int bwlr1_runs = 0,bwlr1_wkt=0;
	float curr_run_rate = 7,req_run_rate;
	static float bwlr1_overs = 0,curr_overs = 0; 
	
	JFrame myframe = new JFrame("Ball To Ball Cricket Scoring");
	
	
	ImageIcon image = new ImageIcon("msdhoni2.jpg");
	ImageIcon image_ball = new ImageIcon("BALL (2).png");
	ImageIcon image_bat = new ImageIcon("batsman.png");
	ImageIcon im = new ImageIcon("black.jpg");
	
	
	
	
	
	JLabel strike = new JLabel(); 
	Label curr_score = new Label(curr_runs+"/"+curr_wkts);
	Label team_name = new Label();
	Label overs_match = new Label();
	Label curr_overs_label = new Label("("+curr_overs+"/"+total_overs+")");
	Label curr_batting = new Label(team1);
	Label prev_batting = new Label(team2);
	static Label prev_score_label = new Label("Yet To bat");
	Label curr_run_rate_label = new Label();
	Label req_run_rate_label = new Label("Req.R.R = "+req_run_rate);
	Panel button_box = new Panel();
	
	Button b0 = new Button("Dot Ball");
	Button b1 = new Button("1");
	Button b2 = new Button("2");
	Button b3 = new Button("3");
	Button b4 = new Button("Four");
	Button b5 = new Button("5");
	Button b6 = new Button("Six");
	Button noball = new Button("No Ball");
	Button wide = new Button("Wide");
	Button byes = new Button("Byes");
	Button lbyes = new Button("L.Byes");

	Button wkt = new Button("WICKET ");
	
	static Label label1_name ;
	static Label label2_name ;
	Label label1_runs = new Label(" "+plyr1_runs);
	Label label2_runs = new Label(" "+plyr2_runs);
	Label label1_balls = new Label(""+plyr1_balls);
	Label label2_balls = new Label(""+plyr2_balls);
	Label label1_rate = new Label("0");
	Label label2_rate = new Label("0");
	
	static Label bwlr1_name = new Label("Select");
	static Label label_bwlr1_runs = new Label(" "+bwlr1_runs);
	static Label label_bwlr1_overs = new Label(""+bwlr1_overs);
	static Label label_bwlr1_wkts = new Label(" "+bwlr1_wkt);
	static Label inn = new Label("1st INNINGS");
	static Label target = new Label("");
	JLabel onstrike= new JLabel("");
	Label label_this_over = new Label(this_over);
	
	scorboard()

{	
	new next_bowler();
	
	JLabel label = new JLabel(); 
    label.setIcon(image);
    label.setBounds(30, 20, 200, 350);
    myframe.add(label);
    
    
    plyr1 = wicket_update.next_player[0];
    plyr2 = wicket_update.next_player[1];
    label1_name = new Label(plyr1);
	label2_name = new Label(plyr2);

    strike.setIcon(image_ball);
    strike.setBounds(262, 583, 40, 40);
    myframe.add(strike);
    myframe.setIconImage(image_ball.getImage());
	team_name.setBounds(100,50,1250,100);
	team_name.setAlignment(Label.CENTER);
	team_name.setFont(new Font("Classic",Font.HANGING_BASELINE,72));
	team_name.setBackground(new Color(0,0,0));
	team_name.setForeground(new Color(0,255,127));
	team_name.setText(team1 +" vs "+ team2);
	
	
	overs_match.setBounds(1150, 100, 400, 50);
	overs_match.setAlignment(Label.LEFT);
	overs_match.setFont(new Font("Classic",Font.HANGING_BASELINE,48));
	overs_match.setBackground(new Color(0,0,0));
	overs_match.setForeground(new Color(188,143,143));
	overs_match.setText(total_overs+" Overs Match ");
	
	Label toss = new Label( wicket_update.toss + " won the Toss And  Decided to "+electedTo);
	toss.setBounds(230,150,1400,40);
	toss.setAlignment(Label.LEFT);
	toss.setFont(new Font("",Font.HANGING_BASELINE,30));
	toss.setBackground(new Color(0,0,0));
	toss.setForeground(new Color(218,165,32));
	
	
	
	
	curr_batting.setBounds(230, 210, 200, 50);
	curr_batting.setFont(new Font("",Font.HANGING_BASELINE,48));
	curr_batting.setAlignment(Label.LEFT);
	curr_batting.setBackground(new Color(0,0,0));
	curr_batting.setForeground(new Color(135,206,235));
	myframe.add(curr_batting);
	
	
	curr_score.setForeground(new Color(255, 127, 80));
	curr_score.setBackground(new Color(0,0,0));
	curr_score.setFont(new Font("",Font.HANGING_BASELINE,40));
	curr_score.setBounds(450, 210, 110, 50);
	myframe.add(curr_score );
	
	
	curr_overs_label.setForeground(new Color(188,143,143));
	curr_overs_label.setBackground(new Color(0,0,0));
	curr_overs_label.setFont(new Font("",Font.HANGING_BASELINE,30));
	curr_overs_label.setBounds(560, 210, 300, 50);
	myframe.add(curr_overs_label );
	
	
	prev_batting.setBounds(1000, 210,300 , 50);
	prev_batting.setFont(new Font("",Font.HANGING_BASELINE,40));
	prev_batting.setAlignment(Label.LEFT);
	prev_batting.setBackground(new Color(0,0,0));
	prev_batting.setForeground(new Color(135,206,235));
	myframe.add(prev_batting);
	
	target.setBounds(1320, 300,250 , 50);
	target.setFont(new Font("",Font.PLAIN,40));
	target.setAlignment(Label.LEFT);
	target.setBackground(new Color(0,0,0));
	target.setForeground(new Color(255,250,205));
//	target.setVisible(false);
	myframe.add(target);
	
	prev_score_label.setBounds(1350, 210,250 , 50);
	prev_score_label.setFont(new Font("",Font.PLAIN,30));
	prev_score_label.setAlignment(Label.LEFT);
	prev_score_label.setBackground(new Color(0,0,0));
	prev_score_label.setForeground(new Color(255,250,205));
	myframe.add(prev_score_label);
	
	inn.setBounds(900, 300,400 , 60);
	inn.setFont(new Font("Classic",Font.PLAIN,64));
	inn.setAlignment(Label.LEFT);
	inn.setBackground(new Color(0,0,0));
	inn.setForeground(Color.cyan);
	myframe.add(inn);
	
	
	curr_run_rate_label.setBounds(300, 260, 120, 30);
	curr_run_rate_label.setBackground(new Color(0,0,0));
	curr_run_rate_label.setForeground(new Color(255,250,205));
	curr_run_rate_label.setFont(new Font("",Font.ITALIC,20));
	myframe.add(curr_run_rate_label);
	
	req_run_rate_label.setBounds(420, 260, 150, 30);
	req_run_rate_label.setBackground(new Color(0,0,0));
	req_run_rate_label.setForeground(new Color(255,250,205));
	req_run_rate_label.setFont(new Font("",Font.ITALIC,20));
	req_run_rate_label.setVisible(false);
	myframe.add(req_run_rate_label);
	
	
	b0.setFocusable(false);
	b0.setBackground(new Color(0,0,0));
	b0.setForeground(Color.white);
	b0.addActionListener(this);
	b0.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	b1.setFocusable(false);
	b1.setBackground(new Color(0,0,0));
	b1.setForeground(Color.white);
	b1.addActionListener(this);
	b1.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	b2.setFocusable(false);
	b2.setBackground(new Color(0,0,0));
	b2.setForeground(Color.white);
	b2.addActionListener(this);
	b2.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	b3.setFocusable(false);
	b3.setBackground(new Color(0,0,0));
	b3.setForeground(Color.white);
	b3.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	b4.setFocusable(false);
	b4.setBackground(new Color(0,0,0));
	b4.setForeground(Color.white);
	b4.setBounds(900, 635, 300, 75);
	b4.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,36));
	myframe.add(b4);
	
	b5.setFocusable(false);
	b5.setBackground(new Color(0,0,0));
	b5.setForeground(Color.white);
	b5.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	
	b6.setFocusable(false);
	b6.setBackground(new Color(0,0,0));
	b6.setForeground(Color.white);
	b6.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,36));
	b6.setBounds(1200, 635, 300, 75);
	myframe.add(b6);
	
	noball.setFocusable(false);
	noball.setBackground(new Color(0,0,0));
	noball.setForeground(Color.white);
	noball.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	wide.setFocusable(false);
	wide.setBackground(new Color(0,0,0));
	wide.setForeground(Color.white);
	wide.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));
	
	lbyes.setFocusable(false);
	lbyes.setBackground(new Color(0,0,0));
	lbyes.setForeground(Color.white);
	lbyes.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,20));

	
	
	
	wkt.setFocusable(false);
	wkt.setBounds(900, 710, 600, 75);
	wkt.setBackground(new Color(0,0,0));
	wkt.setForeground(Color.white);
	wkt.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,42));
	myframe.add(wkt);
	
	
	
	button_box.setBounds(900, 430, 600, 200);
	button_box.setLayout(new GridLayout(2,4,0, 0));
	
    button_box.add(b1);
    button_box.add(b2);
    button_box.add(b3);
    button_box.add(b5);
    button_box.add(b0);
    button_box.add(noball);
    button_box.add(wide);
    button_box.add(lbyes);
    button_box.setBackground(new Color(0,0,0));
	myframe.add(button_box);
	
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);
	wide.addActionListener(this);
	noball.addActionListener(this);
//	undo.addActionListener(this);
	lbyes.addActionListener(this);
	wkt.addActionListener(this);

	Label a = new Label("BATSMEN");
	a.setBounds(50,360,200,50);
	a.setForeground(new Color(240,230,140));
	a.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	a.setBackground(new Color(0,0,0));
	myframe.add(a);
	
	Label b = new Label("Runs");
	b.setBounds(350,360,100,50);
	b.setForeground(new Color(240,230,140));
	b.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	b.setBackground(new Color(0,0,0));
	myframe.add(b);
	
	Label c = new Label("Balls");
	c.setBounds(500,360,100,50);
	c.setForeground(new Color(240,230,140));
	c.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	c.setBackground(new Color(0,0,0));
	myframe.add(c);
	
	onstrike.setBounds(262,412,50,35);
	onstrike.setIcon(image_bat);
	onstrike.setFont(new Font("Times New Roman",Font.BOLD,28));
	onstrike.setBackground(new Color(0,0,0));
	onstrike.setForeground(new Color(240,230,140));
	myframe.add(onstrike);
	
	label1_name.setBounds(60, 410, 200, 50);
	label1_name.setFont(new Font("",Font.HANGING_BASELINE,30));
	label1_name.setAlignment(Label.LEFT);
	label1_name.setBackground(new Color(0,0,0));
	label1_name.setForeground(new Color(255, 127, 80));
	myframe.add(label1_name);
	
	label1_runs.setBounds(350, 410, 100, 50);
	label1_runs.setFont(new Font("",Font.HANGING_BASELINE,30));
	label1_runs.setAlignment(Label.LEFT);
	label1_runs.setBackground(new Color(0,0,0));
	label1_runs.setForeground(new Color(255, 127, 80));
	myframe.add(label1_runs);
	
	label1_balls.setBounds(500, 410, 100, 50);
	label1_balls.setFont(new Font("",Font.HANGING_BASELINE,30));
	label1_balls.setAlignment(Label.LEFT);
	label1_balls.setBackground(new Color(0,0,0));
	label1_balls.setForeground(new Color(255, 127, 80));
	myframe.add(label1_balls);
	
	label1_rate.setBounds(650, 410, 100, 50);
	label1_rate.setFont(new Font("",Font.HANGING_BASELINE,30));
	label1_rate.setAlignment(Label.LEFT);
	label1_rate.setBackground(new Color(0,0,0));
	label1_rate.setForeground(new Color(255, 127, 80));
	myframe.add(label1_rate);
	
	
	
	label2_name.setBounds(60, 460, 200, 50);
	label2_name.setFont(new Font("",Font.HANGING_BASELINE,30));
	label2_name.setAlignment(Label.LEFT);
	label2_name.setBackground(new Color(0,0,0));
	label2_name.setForeground(new Color(255, 127, 80));
	myframe.add(label2_name);
	
	label2_runs.setBounds(350, 460, 100, 50);
	label2_runs.setFont(new Font("",Font.HANGING_BASELINE,30));
	label2_runs.setAlignment(Label.LEFT);
	label2_runs.setBackground(new Color(0,0,0));
	label2_runs.setForeground(new Color(255, 127, 80));
	myframe.add(label2_runs);
	
	label2_balls.setBounds(500, 460, 100, 50);
	label2_balls.setFont(new Font("",Font.HANGING_BASELINE,30));
	label2_balls.setAlignment(Label.LEFT);
	label2_balls.setBackground(new Color(0,0,0));
	label2_balls.setForeground(new Color(255, 127, 80));
	myframe.add(label2_balls);
	
	label2_rate.setBounds(650, 460, 100, 50);
	label2_rate.setFont(new Font("",Font.HANGING_BASELINE,30));
	label2_rate.setAlignment(Label.LEFT);
	label2_rate.setBackground(new Color(0,0,0));
	label2_rate.setForeground(new Color(255, 127, 80));
	myframe.add(label2_rate);
	
	Label d = new Label("BOWLERS");
	d.setBounds(50,530,200,50);
	d.setForeground(new Color(240,230,140));
	d.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	d.setBackground(new Color(0,0,0));
	myframe.add(d);
	
	Label e = new Label("Overs");
	e.setBounds(350,530,100,50);
	e.setForeground(new Color(240,230,140));
	e.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	e.setBackground(new Color(0,0,0));
	myframe.add(e);
	
	Label f = new Label("Wicket");
	f.setBounds(500,530,100,50);
	f.setForeground(new Color(240,230,140));
	f.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	f.setBackground(new Color(0,0,0));
	myframe.add(f);
	
	Label g = new Label("Runs");
	g.setBounds(650,530,100,50);
	g.setForeground(new Color(240,230,140));
	g.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	g.setBackground(new Color(0,0,0));
	myframe.add(g);
	
	Label h = new Label("S.Rate");
	h.setBounds(650,360,100,50);
	h.setForeground(new Color(240,230,140));
	h.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,32));
	h.setBackground(new Color(0,0,0));
	myframe.add(h);
	
	
	
	bwlr1_name.setBounds(50, 580, 200, 50);
	bwlr1_name.setFont(new Font("",Font.HANGING_BASELINE,30));
	bwlr1_name.setAlignment(Label.LEFT);
	bwlr1_name.setBackground(new Color(0,0,0));
	bwlr1_name.setForeground(new Color(255, 127, 80));
	myframe.add(bwlr1_name);
	
	label_bwlr1_overs.setBounds(350, 580, 100, 50);
	label_bwlr1_overs.setFont(new Font("",Font.HANGING_BASELINE,30));
	label_bwlr1_overs.setAlignment(Label.LEFT);
	label_bwlr1_overs.setBackground(new Color(0,0,0));
	label_bwlr1_overs.setForeground(new Color(255, 127, 80));
	myframe.add(label_bwlr1_overs);
	
	label_bwlr1_wkts.setBounds(500, 580, 100, 50);
	label_bwlr1_wkts.setFont(new Font("",Font.HANGING_BASELINE,30));
	label_bwlr1_wkts.setAlignment(Label.LEFT);
	label_bwlr1_wkts.setBackground(new Color(0,0,0));
	label_bwlr1_wkts.setForeground(new Color(255, 127, 80));
	myframe.add(label_bwlr1_wkts);
	
	label_bwlr1_runs.setBounds(650, 580, 100, 50);
	label_bwlr1_runs.setFont(new Font("",Font.HANGING_BASELINE,30));
	label_bwlr1_runs.setAlignment(Label.LEFT);
	label_bwlr1_runs.setBackground(new Color(0,0,0));
	label_bwlr1_runs.setForeground(new Color(255, 127, 80));
	myframe.add(label_bwlr1_runs);
	
	
	Label i = new Label("This Over ");
	i.setBounds(50,700,150,50);
	i.setForeground(Color.WHITE);
	i.setFont(new Font("Times New Roman",Font.HANGING_BASELINE,30));
	i.setBackground(new Color(0,0,0));
	myframe.add(i);
	
	label_this_over.setBounds(200, 700, 500, 50);
	label_this_over.setFont(new Font("",Font.HANGING_BASELINE,30));
	label_this_over.setAlignment(Label.LEFT);
	label_this_over.setBackground(new Color(0,0,0));
	label_this_over.setForeground(Color.WHITE);
	myframe.add(label_this_over);
	
	
	
	myframe.add(toss);
	myframe.add(overs_match);
	myframe.add(team_name);
	myframe.setLayout(null);
	myframe.setVisible(true);
	myframe.setSize(1550,850);
	myframe.getContentPane().setBackground(new Color(0,0,0));
	myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
	
}

	int flag=0,rem,bowler_over_runs=0;
	static int str=1;
	 void ball(int runs)
	{
		 label1_name.setText(""+plyr1);
		try {
			if(str == 1)
			{
				plyr1_runs += runs;
				plyr1_balls += 1;
				label1_runs.setText(" "+plyr1_runs);
				label1_balls.setText(""+plyr1_balls);
				label1_rate.setText(""+(plyr1_runs*100/plyr1_balls));
				
			}
			else if(str == 2)
			{
				plyr2_runs += runs;
				plyr2_balls += 1;
				label2_runs.setText(" "+plyr2_runs);
				label2_balls.setText(""+plyr2_balls);
				label2_rate.setText(""+(plyr2_runs*100/plyr2_balls));
				
			}
			if(runs %2 !=0 ) 
				strike();
			curr_runs = curr_runs+runs;
			curr_score.setText(curr_runs+"/"+curr_wkts);
			curr_overs = (float)(curr_overs + 0.1);
			rem = (int)(curr_overs*10)%10;
			
			curr_run_rate = (float)6*curr_runs/(6*(int)(curr_overs)+rem);
			this_over = this_over+"  " +runs;
			bwlr1_overs += 0.1;
			bwlr1_runs += runs;
			flag+=1;
			label_this_over.setText(this_over);
			if(flag==6)
				over();
			label_bwlr1_overs.setText(String.format("%.1f",bwlr1_overs));
			label_bwlr1_runs.setText(""+bwlr1_runs);
			curr_overs_label.setText(String.format("(%.1f/"+total_overs+")",curr_overs));
			curr_run_rate_label.setText("C.R.R = "+curr_run_rate);
			diff = prev_runs - curr_runs;
			if(diff < 0 && wicket_update.flag!=0) {
				innings();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	 void strike(){
			if(str==1) {
				onstrike.setBounds(260,462,50,35);
				str = 2;}
			else if(str == 2)	{
				onstrike.setBounds(260,412,50,35);
				str =1;}}
	 void over() {
		 curr_overs = (int)(curr_overs+1);
		 bwlr1_overs = (int)(bwlr1_overs+1);
		 strike();
		 flag=0;
		 this_over="";
		 try {
		 over_update.Data(bwlr1,bwlr1_runs,bwlr1_overs,bwlr1_wkt);
		
	 } catch (SQLException ex) {
         ex.printStackTrace();
     }
		 
		 if(curr_overs == total_overs) {
			 innings();
			 }
		 else {
			 new next_bowler();}
	 }
	 void innings() {
		 try
			{	if(plyr1_balls != 0) 
					wicket_update.Data(plyr1, plyr1_runs, plyr1_balls,(plyr1_runs*100/plyr1_balls) );
			else
				wicket_update.Data(plyr1, plyr1_runs, plyr1_balls,(0) );
			if(plyr2_balls != 0) 
				wicket_update.Data(plyr2, plyr2_runs, plyr2_balls,(plyr2_runs*100/plyr2_balls) );
			else
				wicket_update.Data(plyr2, plyr2_runs, plyr2_balls,(0) );
				over_update.Data(bwlr1,bwlr1_runs,bwlr1_overs,bwlr1_wkt);
				str=1;
				if(wicket_update.flag==0) {
					wicket_update.flag=1;
					target.setText("Target "+(scorboard.curr_runs+1));
					target.setVisible(true);
					inn.setText("2nd INNINGS");
				 wicket_update.innings();
				 bwlr1 = "Select";
				 bwlr1_name.setText(""+bwlr1);
				 over_update.Data("", 0, 0, 0);
				 new scorboard();
				 myframe.dispose();}
				else  {
					 wicket_update.innings();
					 new summary();
					 myframe.dispose();
				}
			} catch (SQLException ex) {
             ex.printStackTrace();
         }
	 }
	 void wicket()  {
		 
			 bwlr1_wkt+=1;
		 	 label_bwlr1_wkts.setText(""+bwlr1_wkt);
		 	 curr_wkts+=1;
			curr_score.setText(curr_runs+"/"+curr_wkts);
			curr_overs = (float)(curr_overs + 0.1);
			rem = (int)(curr_overs*10)%10;
			curr_run_rate = (float)6*curr_runs/(6*(int)(curr_overs)+rem);
			this_over = this_over+"  W";
			bwlr1_overs += 0.1;
			flag+=1;
			label_this_over.setText(this_over);
			
			
			if(str == 1)
			{
				plyr1_balls += 1;
				label1_balls.setText(""+plyr1_balls);
				label1_rate.setText(""+(plyr1_runs*100/plyr1_balls));
				
				
				try
				{
					wicket_update.Data(plyr1, plyr1_runs, plyr1_balls,(plyr1_runs*100/plyr1_balls) );
					
				} catch (SQLException ex) {
	                ex.printStackTrace();
	            }
				
				plyr1_balls = 0;
				label1_balls.setText(""+plyr1_balls);
				plyr1_runs = 0;
				label1_runs.setText(""+plyr1_runs);
				label1_rate.setText("0");
			
				
			}
			else if(str == 2)
			{
				plyr2_balls += 1;
				label2_balls.setText(""+plyr2_balls);
				label2_rate.setText(""+(plyr2_runs*100/plyr2_balls));
				
				try
				{
					wicket_update.Data(plyr2, plyr2_runs, plyr2_balls,(plyr2_runs*100/plyr2_balls) );
					
				} catch (SQLException ex) {
	                ex.printStackTrace();
	            }
				
				plyr2_balls = 0;
				label2_balls.setText(""+plyr2_balls);
				plyr2_runs = 0;
				label2_runs.setText(""+plyr2_runs);
				label2_rate.setText("0");
				label2_name.setText(""+plyr2);
				
				
			}
			
			if(flag==6)
				over();
			if(curr_wkts==10) {
				innings();
			}
			else 
				//new next_batsmen();
			label_bwlr1_overs.setText(String.format("%.1f",bwlr1_overs));
			label_bwlr1_runs.setText(""+bwlr1_runs);
			curr_overs_label.setText(String.format("(%.1f/"+total_overs+")",curr_overs));
			curr_run_rate_label.setText("C.R.R = "+curr_run_rate);
			
			
	 }
	 void extras(int a)
	 {
		 curr_runs = curr_runs+ 1;
		 curr_score.setText(curr_runs+"/"+curr_wkts);
		 bwlr1_runs += 1;
		 if(a == 1) {
		 this_over = this_over+"   NB" ;}
		 else {
			 this_over = this_over+"   WD" ;
		 }
		 label_bwlr1_runs.setText(""+bwlr1_runs);
		 label_this_over.setText(this_over);
		 rem = (int)(curr_overs*10)%10;
		 curr_run_rate = (float)6*curr_runs/(6*(int)(curr_overs)+rem);
		 if(curr_overs != 0)
		 curr_run_rate_label.setText("C.R.R = "+curr_run_rate);
	 }
	 void lbyes()
	 {
		 curr_runs = curr_runs+ 1;
		 curr_score.setText(curr_runs+"/"+curr_wkts);
		 this_over = this_over+"  L.B" ;
		 if(str == 1)
			{
				plyr1_balls += 1;
				label1_runs.setText(" "+plyr1_runs);
				label1_balls.setText(""+plyr1_balls);
				label1_rate.setText(""+(plyr1_runs*100/plyr1_balls));
				
			}
			else if(str == 2)
			{
				plyr2_balls += 1;
				label2_runs.setText(" "+plyr2_runs);
				label2_balls.setText(""+plyr2_balls);
				label2_rate.setText(""+(plyr2_runs*100/plyr2_balls));
				
			}
		 strike();
		 bwlr1_overs += 0.1;
		 curr_overs = (float)(curr_overs + 0.1);
			rem = (int)(curr_overs*10)%10;
			flag+=1;
			curr_run_rate = (float)6*curr_runs/(6*(int)(curr_overs)+rem);
		 label_this_over.setText(this_over);
			if(flag==6)
				over();
			label_bwlr1_overs.setText(String.format("%.1f",bwlr1_overs));
			label_bwlr1_runs.setText(""+bwlr1_runs);
			curr_overs_label.setText(String.format("(%.1f/"+total_overs+")",curr_overs));
			curr_run_rate_label.setText("C.R.R = "+curr_run_rate);
	 }
@Override
public void actionPerformed(ActionEvent e) {
	int run;
	if(e.getSource() == b0)
	{
		run=0;
		ball(run);
		
	}
	else if(e.getSource() == b1)
	{
		run=1;
		ball(run);
	}
	else if(e.getSource() == b2)
	{
		run=2;
		ball(run);
	}
	else if(e.getSource() == b3)
	{
		run=3;
		ball(run);
	}
	else if(e.getSource() == b4)
	{
		run=4;
		ball(run);
	}
	else if(e.getSource() == b5)
	{
		run=5;
		ball(run);
	}
	else if(e.getSource() == b6)
	{
		run=6;
		ball(run);
	}
	else if(e.getSource() == wide)
	{
		extras(0);
	}
	else if(e.getSource() == noball)
	{
		extras(1);
	}
	else if(e.getSource() == lbyes)
	{
		lbyes();
	}
	else if(e.getSource() == wkt)
	{
		wicket();
		label1_name.setText(""+plyr1);
	}
	
}
public static void main (String args[])
{
	 new scorboard();
	
	
}
}
