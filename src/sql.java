import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// to add values of team2
public class sql {

   static String player;

    public static void Data (String player_team2) throws SQLException{

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
                    "insert into team2"+
                            "(name) "+
                            "values ("+
                            "'"+player_team2 + "');"

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