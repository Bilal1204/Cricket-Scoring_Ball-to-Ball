import java.sql.*;

// to add values of team 1

public class jdbcPlayers {

   static String player;

    public static void Data (String player_team1) throws SQLException{

        Connection myConn = null;
        Statement myStmt = null;    
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            System.out.println("Inserting a new Player to database");
            myStmt.executeUpdate(
                    "insert into team1"+
                            "(name) "+
                            "values ("+
                            "'"+player_team1 + "');"

            );
            
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