import java.sql.*;
// to add values of team_name and create tables for team1 and team2
public class team_database {

	static String tem1, tem2, tos, electedto;
	   static  float ovrs;
	   public static void Data (String toss, String electedTo,String team1, String team2, Float overs ) throws SQLException{

		   tem1 = team1;
	        tem2 = team2;
	        ovrs = overs;
	        tos = toss;
	        electedto = electedTo;
	
	Connection myConn = null;
    Statement myStmt = null;
        try {
        // 1. Get a connection to database
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");

        // 2. Create a statement
        myStmt = myConn.createStatement();

        // 3. Execute SQL query
        System.out.println("Inserting a new Player to database");
        String team_d = "drop table if exists team_detail";
        String team_detail = "create table team_detail ( toss varchar(50) NOT NULL, electedTo varchar(10) NOT NULL,team1 varchar(50) NOT NULL, team1_score INT DEFAULT 0, team1_wkt INT DEFAULT 0, team2 varchar(50) NOT NULL,team2_score INT DEFAULT 0, overs INT DEFAULT 0);";
      

        myStmt.executeUpdate(team_d);
        myStmt.executeUpdate(team_detail);
        


        myStmt.executeUpdate(
                "insert into team_detail"+
                        "(toss, electedTo,team1,team2,overs) "+
                        "values ("+ "'"+tos + "','"+electedto+"',"+
                        "'"+tem1 + "','"+tem2+"','"+ovrs+"');"

        );
        String t1 = "drop table if exists team1;";
        String queryTeam1 = "create table team1 ( id INT NOT NULL AUTO_INCREMENT, name VARCHAR(100) DEFAULT 'A',  Runs_Batsman INT DEFAULT 0,Balls_Batsman INT DEFAULT 0, StrikeRate FLOAT(5,2) NOT NULL DEFAULT '0.00', overs FLOAT(5,2) NOT NULL DEFAULT '0.00', Wicket INT DEFAULT 0,Runs_Bowler INT DEFAULT 0, PRIMARY KEY (id) );" ;
        String t2 = "drop table if exists team2;";
        String queryTeam2 = "create table team2 ( id INT NOT NULL AUTO_INCREMENT, name VARCHAR(100) DEFAULT 'a',  Runs_Batsman INT DEFAULT 0,Balls_Batsman INT DEFAULT 0, StrikeRate FLOAT(5,2) NOT NULL DEFAULT '0.00', overs FLOAT(5,2) NOT NULL DEFAULT '0.00', Wicket INT DEFAULT 0,Runs_Bowler INT DEFAULT 0, PRIMARY KEY (id) );" ;

        myStmt.executeUpdate(t1);
        myStmt.executeUpdate(queryTeam1);
        myStmt.executeUpdate(t2);
        myStmt.executeUpdate(queryTeam2);
    }
    catch (Exception exc) {
        exc.printStackTrace();
    }
    finally {
        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }
}
}
