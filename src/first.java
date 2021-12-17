
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class first extends JPanel implements ActionListener {


    JFrame frame;
    JLabel display;
    ImageIcon image,img;
    JLabel title = new JLabel("Cricket Scoreboard");
    JLabel mini = new JLabel("Mini Project");
    JLabel bilal = new JLabel("Bilal Shaikh - 54");
    JLabel chirag = new JLabel("Chirag Shukla - 55");
    JLabel ganesh = new JLabel("Ganesh Vaishnav - 60");
    JButton button = new JButton("START");
    public first()  {

frame = new JFrame("First Frame");


        title.setBounds(375,30,1250,100);
        title.setAlignmentX(JLabel.CENTER);
        title.setFont(new Font("Classic",Font.HANGING_BASELINE,72));
        title.setBackground(new Color(0,0,0));
        //title.setForeground(new Color(0,255,127));
        title.setForeground(Color.WHITE);
        frame.add(title);

        mini.setBounds(550,125,1250,100);
        mini.setAlignmentX(JLabel.CENTER);
        mini.setFont(new Font("Classic",Font.HANGING_BASELINE,50));
        mini.setBackground(new Color(0,0,0));
      //  by.setForeground(new Color(0,255,127));
        mini.setForeground(Color.WHITE);
        frame.add(mini);


        button.setBounds(655,550,250,60);
        button.setAlignmentX(JLabel.CENTER);
        button.setFont(new Font("Classic",Font.HANGING_BASELINE,36));
        button.setBackground(Color.black);
       // button.setForeground(new Color(0,255,127));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setFocusable(false);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
        	ImageIcon image = new ImageIcon("CRICKET.png");
        	ImageIcon img = new ImageIcon("BALL (2).png");
        	frame.setIconImage(img.getImage());
        	//display.setIcon(image);
            display = new JLabel(image);
          //  display.setBounds(0,0,1800,1800);
            frame.add(display);
        }catch (Exception e)
        {
            System.out.println(e);
        }

        frame.setSize(1600,800);
frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
         new first();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
        	 new team_details();
        	frame.dispose();
           
        }
    }
}

