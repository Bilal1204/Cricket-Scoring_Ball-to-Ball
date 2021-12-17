import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class over_update {
	static String[] nxt_bowl = new String[11];
	static int i=0;
	public static void Data(String name,int runs,float over,int wkt  )throws SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		Statement st = null;
		ResultSet res = null,rs = null;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");
			stmt=conn.createStatement();
			st=conn.createStatement();
			String query ;
			String a = "select name from team2"+
                    "where name <> '"+ name+"';" ;
			
			Arrays.fill(nxt_bowl,null);
			
			if(wicket_update.flag ==0) {
				 query = "update team2 set Runs_Bowler = "+runs+" , overs = "+over+" , Wicket = "+wkt+"  where name = '"+name+"' ;";
				res = stmt.executeQuery("select name from  `team2` where name != ('"+name+"');");}
			else { 
				query = "update team1 set Runs_Bowler = "+runs+" , overs = "+over+" , Wicket = "+wkt+"  where name = '"+name+"' ;";
				res = stmt.executeQuery("select name from  `team1` where name != ('"+name+"');");
			}
			st.executeUpdate(query);
			while(res.next() & i!=11)
			{
				nxt_bowl[i] = res.getString("name");
				i+=1;
			}
			System.out.println(Arrays.toString(nxt_bowl)+"  Bowler");
			
			i=0;
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
        }
	}
}
