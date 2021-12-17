
// adding details
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

public class team_details implements ActionListener{

// submit
//t1 = team1 name, t2 = team2 name,
    // t3 = overs
    //t4 = toss
    // t16 = toss kon jeeta
	
    String team1,team2;
    String total_overs;
    String[] toss_win = {"Select"};
    String[] nxt_bats;
    static String[] toss = {"Select","Bat","Ball"};
    JFrame myframe = new JFrame("Ball To Ball Cricket Scoring");
    Frame display = new Frame(" Team Select ");
    Button submit = new Button("Next");
    Button proceed = new Button("Confirm");
    Button next = new Button("Next");
    TextField t1 = new TextField();
    TextField t2=new TextField();


    TextField t3=new TextField();
    TextField t5=new TextField();
    TextField t6=new TextField();
    TextField t7=new TextField();
    TextField t8=new TextField();
    TextField t9=new TextField();
    TextField t10=new TextField();
    TextField t11=new TextField();
    TextField t12=new TextField();
    TextField t13=new TextField();
    TextField t14=new TextField();
    TextField t15=new TextField();
    JComboBox t16,t4;

    TextField t21 = new TextField();
    TextField t22=new TextField();
    TextField t23=new TextField();
    TextField t24=new TextField();
    TextField t25=new TextField();
    TextField t26=new TextField();
    TextField t27=new TextField();
    TextField t28=new TextField();
    TextField t29=new TextField();
    TextField t30=new TextField();
    TextField t31=new TextField();

    Label team_name = new Label();
    Label overs_match = new Label();
    Label p1 = new Label();
    Label p2 = new Label();
    Label p3 = new Label();
    Label p4 = new Label();
    Label p5 = new Label();
    Label p6 = new Label();
    Label p7 = new Label();
    Label p8 = new Label();
    Label p9 = new Label();
    Label p10 = new Label();
    Label p11 = new Label();

    Label a1 = new Label();
    Label a2 = new Label();
    Label a3 = new Label();
    Label a4 = new Label();
    Label a5 = new Label();
    Label a6 = new Label();
    Label a7 = new Label();
    Label a8 = new Label();
    Label a9 = new Label();
    Label a10 = new Label();
    Label a11 = new Label();
    
    Label c,d,f,team1_label,team2_label;

     team_details()
    {
    	ImageIcon image_ball = new ImageIcon("BALL (2).png");
    	display.setIconImage(image_ball.getImage());
        Label a = new Label("Team1 ");
        a.setBounds(260, 80, 100, 30);
        display.add(a);
        t1.setBounds(370,80,200,30);
        display.add(t1);
        submit.setBounds(725,260,100,30);
        submit.addActionListener(this);
        submit.setVisible(false);
        display.add(submit);
        proceed.setBounds(725,130,100,30);
        proceed.addActionListener(this);
        proceed.setForeground(Color.BLACK);
        proceed.setFont(new Font("Algerian",Font.BOLD,20));



        display.add(proceed);
        a.setForeground(Color.WHITE);
        a.setFont(new Font("Algerian",Font.BOLD,20));
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Algerian",Font.BOLD,20));
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Algerian",Font.BOLD,20));

        next.setBounds(725,660,100,30);
        next.addActionListener(this);
        next.setVisible(false);
        display.add(next);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Algerian",Font.BOLD,20));

        Label b = new Label("Team2");
        b.setBounds(1050, 80, 100, 30);
        display.add(b);
        t2.setBounds(1150,80,200,30);
        display.add(t2);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Algerian",Font.BOLD,20));
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Algerian",Font.BOLD,20));

        c = new Label("Overs");
        c.setVisible(false);
        c.setBounds(970, 170, 80, 30);
        display.add(c);
        t4 = new JComboBox(toss);
        t3.setBounds(1080,175,100,30);
        t3.setVisible(false);
        display.add(t3);
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Algerian",Font.BOLD,20));
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("Algerian",Font.BOLD,20));

        d = new Label("Elected to");
        d.setBounds(660, 180, 120, 30);
        d.setVisible(false);
        display.add(d);
        t4.setBounds(790,180,100,30);
        display.add(t4);
        d.setForeground(Color.WHITE);
        d.setFont(new Font("Algerian",Font.BOLD,20));
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("Algerian",Font.BOLD,20));
        t4.setVisible(false);

        Label e = new Label("VS");
        e.setBounds(760, 80, 120, 30);
        display.add(e);
        e.setForeground(Color.WHITE);
        e.setFont(new Font("Algerian",Font.BOLD,32));

        f = new Label("Toss");
        f.setBounds(340, 180, 60, 30);
        f.setVisible(false);
        display.add(f);

        t16=new JComboBox(toss_win);
        t16.setBounds(450,180,160,30);
        t16.setVisible(false);
        display.add(t16);
        f.setForeground(Color.WHITE);
        f.setFont(new Font("Algerian",Font.BOLD,20));
        t16.setForeground(Color.BLACK);
        t16.setFont(new Font("Algerian",Font.BOLD,20));

        p1.setText("Player 1");
        p1.setBounds(260, 300, 100, 20);
        display.add(p1);
        team1_label = new Label(team1);
        team1_label.setBounds(290,230,500,40);
        display.add(team1_label);
        team1_label.setForeground(Color.cyan);
        team1_label.setFont(new Font("Algerian",Font.BOLD,40));
        team1_label.setVisible(false);
        team2_label = new Label(team1);
        team2_label.setBounds(1070,230,500,40);
        display.add(team2_label);
        team2_label.setForeground(Color.cyan);
        team2_label.setFont(new Font("Algerian",Font.BOLD,40));
        team2_label.setVisible(false);
        t5.setBounds(370,300,160,20);
        display.add(t5);
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Algerian",Font.BOLD,14));
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("Algerian",Font.BOLD,14));
        p1.setVisible(false);
        t5.setVisible(false);

        p2.setText("Player 2");
        p2.setBounds(260, 340, 100, 20);
        display.add(p2);
        t6.setBounds(370,340,160,20);
        display.add(t6);
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Algerian",Font.BOLD,14));
        t6.setForeground(Color.BLACK);
        t6.setFont(new Font("Algerian",Font.BOLD,14));
        p2.setVisible(false);
        t6.setVisible(false);

        p3.setText("Player 3");
        p3.setBounds(260, 380, 100, 20);
        display.add(p3);
        t7.setBounds(370,380,160,20);
        display.add(t7);
        p3.setForeground(Color.WHITE);
        p3.setFont(new Font("Algerian",Font.BOLD,14));
        t7.setForeground(Color.BLACK);
        t7.setFont(new Font("Algerian",Font.BOLD,14));
        p3.setVisible(false);
        t7.setVisible(false);

        p4.setText("Player 4");
        p4.setBounds(260, 420, 100, 20);
        display.add(p4);
        t8.setBounds(370,420,160,20);
        display.add(t8);
        p4.setForeground(Color.WHITE);
        p4.setFont(new Font("Algerian",Font.BOLD,14));
        t8.setForeground(Color.BLACK);
        t8.setFont(new Font("Algerian",Font.BOLD,14));
        p4.setVisible(false);
        t8.setVisible(false);

        p5.setText("Player 5");
        p5.setBounds(260, 460, 100, 20);
        display.add(p5);
        t9.setBounds(370,460,160,20);
        display.add(t9);
        p5.setForeground(Color.WHITE);
        p5.setFont(new Font("Algerian",Font.BOLD,14));
        t9.setForeground(Color.BLACK);
        t9.setFont(new Font("Algerian",Font.BOLD,14));
        p5.setVisible(false);
        t9.setVisible(false);

        p6.setText("Player 6");
        p6.setBounds(260, 500, 100, 20);
        display.add(p6);
        t10.setBounds(370,500,160,20);
        display.add(t10);
        p6.setForeground(Color.WHITE);
        p6.setFont(new Font("Algerian",Font.BOLD,14));
        t10.setForeground(Color.BLACK);
        t10.setFont(new Font("Algerian",Font.BOLD,14));
        p6.setVisible(false);
        t10.setVisible(false);

        p7.setText("Player 7");
        p7.setBounds(260, 540, 100, 20);
        display.add(p7);
        t11.setBounds(370,540,160,20);
        display.add(t11);
        p7.setForeground(Color.WHITE);
        p7.setFont(new Font("Algerian",Font.BOLD,14));
        t11.setForeground(Color.BLACK);
        t11.setFont(new Font("Algerian",Font.BOLD,14));
        p7.setVisible(false);
        t11.setVisible(false);

        p8.setText("Player 8");
        p8.setBounds(260, 580, 100, 20);
        display.add(p8);
        t12.setBounds(370,580,160,20);
        display.add(t12);
        p8.setForeground(Color.WHITE);
        p8.setFont(new Font("Algerian",Font.BOLD,14));
        t12.setForeground(Color.BLACK);
        t12.setFont(new Font("Algerian",Font.BOLD,14));
        p8.setVisible(false);
        t12.setVisible(false);

        p9.setText("Player 9");
        p9.setBounds(260, 620, 100, 20);
        display.add(p9);
        t13.setBounds(370,620,160,20);
        display.add(t13);
        p9.setForeground(Color.WHITE);
        p9.setFont(new Font("Algerian",Font.BOLD,14));
        t13.setForeground(Color.BLACK);
        t13.setFont(new Font("Algerian",Font.BOLD,14));
        p9.setVisible(false);
        t13.setVisible(false);

        p10.setText("Player 10");
        p10.setBounds(260, 660, 100, 20);
        display.add(p10);
        t14.setBounds(370,660,160,20);
        display.add(t14);
        p10.setForeground(Color.WHITE);
        p10.setFont(new Font("Algerian",Font.BOLD,14));
        t14.setForeground(Color.BLACK);
        t14.setFont(new Font("Algerian",Font.BOLD,14));
        p10.setVisible(false);
        t14.setVisible(false);

        p11.setText("Player 11");
        p11.setBounds(260, 700, 100, 20);
        display.add(p11);
        t15.setBounds(370,700,160,20);
        display.add(t15);
        p11.setForeground(Color.WHITE);
        p11.setFont(new Font("Algerian",Font.BOLD,14));
        t15.setForeground(Color.BLACK);
        t15.setFont(new Font("Algerian",Font.BOLD,14));
        p11.setVisible(false);
        t15.setVisible(false);

        a1.setText("Player 1");
        a1.setBounds(1050, 300, 100, 20);
        display.add(a1);
        t21.setBounds(1150,300,160,20);
        display.add(t21);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Algerian",Font.BOLD,14));
        t21.setForeground(Color.BLACK);
        t21.setFont(new Font("Algerian",Font.BOLD,14));
        a1.setVisible(false);
        t21.setVisible(false);

        a2.setText("Player 2");
        a2.setBounds(1050, 340, 100, 20);
        display.add(a2);
        t22.setBounds(1150,340,160,20);
        display.add(t22);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Algerian",Font.BOLD,14));
        t22.setForeground(Color.BLACK);
        t22.setFont(new Font("Algerian",Font.BOLD,14));
        a2.setVisible(false);
        t22.setVisible(false);

        a3.setText("Player 3");
        a3.setBounds(1050, 380, 100, 20);
        display.add(a3);
        t23.setBounds(1150,380,160,20);
        display.add(t23);
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Algerian",Font.BOLD,14));
        t23.setForeground(Color.BLACK);
        t23.setFont(new Font("Algerian",Font.BOLD,14));
        a3.setVisible(false);
        t23.setVisible(false);

        a4.setText("Player 4");
        a4.setBounds(1050, 420, 100, 20);
        display.add(a4);
        t24.setBounds(1150,420,160,20);
        display.add(t24);
        a4.setForeground(Color.WHITE);
        a4.setFont(new Font("Algerian",Font.BOLD,14));
        t24.setForeground(Color.BLACK);
        t24.setFont(new Font("Algerian",Font.BOLD,14));
        a4.setVisible(false);
        t24.setVisible(false);

        a5.setText("Player 5");
        a5.setBounds(1050, 460, 100, 20);
        display.add(a5);
        t25.setBounds(1150,460,160,20);
        display.add(t25);
        a5.setForeground(Color.WHITE);
        a5.setFont(new Font("Algerian",Font.BOLD,14));
        t25.setForeground(Color.BLACK);
        t25.setFont(new Font("Algerian",Font.BOLD,14));
        a5.setVisible(false);
        t25.setVisible(false);

        a6.setText("Player 6");
        a6.setBounds(1050, 500, 100, 20);
        display.add(a6);
        t26.setBounds(1150,500,160,20);
        display.add(t26);
        a6.setForeground(Color.WHITE);
        a6.setFont(new Font("Algerian",Font.BOLD,14));
        t26.setForeground(Color.BLACK);
        t26.setFont(new Font("Algerian",Font.BOLD,14));
        a6.setVisible(false);
        t26.setVisible(false);

        a7.setText("Player 7");
        a7.setBounds(1050, 540, 100, 20);
        display.add(a7);
        t27.setBounds(1150,540,160,20);
        display.add(t27);
        a7.setForeground(Color.WHITE);
        a7.setFont(new Font("Algerian",Font.BOLD,14));
        t27.setForeground(Color.BLACK);
        t27.setFont(new Font("Algerian",Font.BOLD,14));
        a7.setVisible(false);
        t27.setVisible(false);

        a8.setText("Player 8");
        a8.setBounds(1050, 580, 100, 20);
        display.add(a8);
        t28.setBounds(1150,580,160,20);
        display.add(t28);
        a8.setForeground(Color.WHITE);
        a8.setFont(new Font("Algerian",Font.BOLD,14));
        t28.setForeground(Color.BLACK);
        t28.setFont(new Font("Algerian",Font.BOLD,14));
        a8.setVisible(false);
        t28.setVisible(false);

        a9.setText("Player 9");
        a9.setBounds(1050, 620, 100, 20);
        display.add(a9);
        t29.setBounds(1150,620,160,20);
        display.add(t29);
        a9.setForeground(Color.WHITE);
        a9.setFont(new Font("Algerian",Font.BOLD,14));
        t29.setForeground(Color.BLACK);
        t29.setFont(new Font("Algerian",Font.BOLD,14));
        a9.setVisible(false);
        t29.setVisible(false);

        a10.setText("Player 10");
        a10.setBounds(1050, 660, 100, 20);
        display.add(a10);
        t30.setBounds(1150,660,160,20);
        display.add(t30);
        a10.setForeground(Color.WHITE);
        a10.setFont(new Font("Algerian",Font.BOLD,14));
        t30.setForeground(Color.BLACK);
        t30.setFont(new Font("Algerian",Font.BOLD,14));
        a10.setVisible(false);
        t30.setVisible(false);

        a11.setText("Player 11");
        a11.setBounds(1050, 700, 100, 20);
        display.add(a11);
        t31.setBounds(1150,700,160,20);
        display.add(t31);
        a11.setForeground(Color.WHITE);
        a11.setFont(new Font("Algerian",Font.BOLD,14));
        t31.setForeground(Color.BLACK);
        t31.setFont(new Font("Algerian",Font.BOLD,14));
        a11.setVisible(false);
        t31.setVisible(false);

        display.setBackground(new Color(0,0,45));
        display.setForeground(Color.WHITE);
        display.setSize(1920,1080);
        display.setLayout(null);
        display.setVisible(true);
        Label header = new Label("  Home");
        header.setBackground(Color.LIGHT_GRAY);
        header.setBounds(5, 15, 1550, 50);
        header.setFont(new Font("Classic",Font.ITALIC,24));
        header.setAlignment(Label.LEFT);
        myframe.add(header);
        overs_match.setText(total_overs+" Overs Match ");

        team_name.setText(team1 +" vs "+ team2);


        team_name.setBounds(100,100,1250,40);
        team_name.setAlignment(Label.CENTER);
        team_name.setFont(new Font("Classic",Font.BOLD,48));
        team_name.setBackground(new Color(0,0,45));
        team_name.setForeground(Color.WHITE);


        overs_match.setBounds(1150, 100, 400, 35);
        overs_match.setAlignment(Label.LEFT);
        overs_match.setFont(new Font("Classic",Font.BOLD,48));
        overs_match.setBackground(new Color(0,0,45));
        overs_match.setForeground(Color.WHITE);
    /*
    myframe.add(overs_match);
    myframe.add(team_name);
    myframe.setLayout(null);
    myframe.setVisible(true);
    myframe.setSize(1550,800);
    myframe.setBackground(new Color(0,0,45));
    myframe.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {System.exit(0);}});*/
        display.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {System.exit(0);}});


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== submit)
        {

            submit.setVisible(false);
            proceed.setVisible(false);
            next.setVisible(true);
            p1.setVisible(true);
            t5.setVisible(true);
            p2.setVisible(true);
            t6.setVisible(true);
            p3.setVisible(true);
            t7.setVisible(true);
            p4.setVisible(true);
            t8.setVisible(true);
            p5.setVisible(true);
            t9.setVisible(true);
            p6.setVisible(true);
            t10.setVisible(true);
            p7.setVisible(true);
            t11.setVisible(true);
            p8.setVisible(true);
            t12.setVisible(true);
            p9.setVisible(true);
            t13.setVisible(true);
            p10.setVisible(true);
            t14.setVisible(true);
            p11.setVisible(true);
            t15.setVisible(true);
            a1.setVisible(true);
            t21.setVisible(true);
            a2.setVisible(true);
            t22.setVisible(true);
            a3.setVisible(true);
            t23.setVisible(true);
            a4.setVisible(true);
            t24.setVisible(true);
            a5.setVisible(true);
            t25.setVisible(true);
            a6.setVisible(true);
            t26.setVisible(true);
            a7.setVisible(true);
            t27.setVisible(true);
            a8.setVisible(true);
            t28.setVisible(true);
            a9.setVisible(true);
            t29.setVisible(true);
            a10.setVisible(true);
            t30.setVisible(true);
            a11.setVisible(true);
            t31.setVisible(true);
            
            String toss ;
            String electedTo;
            String team1, team2 ;
            float overs;

            electedTo = (String)t4.getSelectedItem();
            toss = (String)t16.getSelectedItem();
            team1 = t1.getText();
            team2 = t2.getText();

            overs = Float.parseFloat(t3.getText());
            System.out.println(electedTo);
            System.out.println(toss);
            
            if((toss.equals(team1) && electedTo.equals("Bat")) || (toss.equals(team2) && electedTo.equals("Ball"))) {
            	System.out.println("1 a");
                team1_label.setText(team1);
                team2_label.setText(team2);
                try {
                    team_database.Data(toss,electedTo,team1,team2,overs);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                }
            else {
            	System.out.println("1 b");
            	team1_label.setText(team2);
                team2_label.setText(team1);
                try {
                    team_database.Data(toss,electedTo,team2,team1,overs);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            team1_label.setVisible(true);
            team2_label.setVisible(true);
        }
        else if(e.getSource()== proceed)
        {

            t16.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            d.setVisible(true);
            f.setVisible(true);
            c.setVisible(true);
            submit.setVisible(true);
            t1.setEditable(false);
            t2.setEditable(false);

            //************
            team1 = t1.getText();
            team2 = t2.getText();
            t16.addItem(team1);
            t16.addItem(team2);

        }

        if(e.getSource() == next){
            String player;
            try {
            	player = t5.getText();
                jdbcPlayers.Data(player);
                player = t6.getText();
                jdbcPlayers.Data(player);
                player = t7.getText();
                jdbcPlayers.Data(player);
                player = t8.getText();
                jdbcPlayers.Data(player);
                player = t9.getText();
                jdbcPlayers.Data(player);
                player = t10.getText();
                jdbcPlayers.Data(player);
                player = t11.getText();
                jdbcPlayers.Data(player);
                player = t12.getText();
                jdbcPlayers.Data(player);
                player = t13.getText();
                jdbcPlayers.Data(player);
                player = t14.getText();
                jdbcPlayers.Data(player);
                player = t15.getText();
                jdbcPlayers.Data(player);

                player = t21.getText();
                sql.Data(player);
                player = t22.getText();
                sql.Data(player);
                player = t23.getText();
                sql.Data(player);
                player = t24.getText();
                sql.Data(player);
                player = t25.getText();
                sql.Data(player);
                player = t26.getText();
                sql.Data(player);
                player = t27.getText();
                sql.Data(player);
                player = t28.getText();
                sql.Data(player);
                player = t29.getText();
                sql.Data(player);
                player = t30.getText();
                sql.Data(player);
                player = t31.getText();
                sql.Data(player);
                
               over_update.Data("", 0, 0,0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            try {
				wicket_update.innings();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
            new scorboard();
            display.dispose();
			
        }
    }
    /*
    public static void main (String[] args)
    {
        team_details ob = new team_details();
      
     //   System.out.println(toss[1]);
    }
    */
}