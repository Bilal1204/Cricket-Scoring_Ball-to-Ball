import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class wicket_update {

	public static String[] next_player = new String[11];
	static String team1,team2,toss,electedTo;
	static int tot_overs;
	static int i=0,flag=0,j=2;;
	public static void innings() throws SQLException{
		Connection conn = null;
		Statement stmt = null,st =null,mystmt = null;
		ResultSet rs = null;
		ResultSet res = null;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");
			mystmt=stmt=conn.createStatement();
			st=conn.createStatement();
			res = st.executeQuery("select * from team_detail");
			if(flag==0) {
				rs = mystmt.executeQuery("select name from  `team1`;");
				while(res.next()) {
					team1 = res.getString("team1");
					team2 = res.getString("team2");
					toss = res.getString("toss");
					electedTo = res.getString("electedTo");
					tot_overs = res.getInt("overs");
				}
				while(rs.next() & i !=11)
				{
					next_player[i] = rs.getString("name") ;		
					i+=1;
				}}
			else if(flag==1){
				Arrays.fill(next_player, null);
				j=2;
				rs = mystmt.executeQuery("select name from  `team2` ;");
				while(res.next()) {
					team1 = res.getString("team2");
					team2 = res.getString("team1");
					toss = res.getString("toss");
					electedTo = res.getString("electedTo");
					tot_overs = res.getInt("overs");
				}
				while(rs.next() & i !=11)
				{
					next_player[i] = rs.getString("name") ;		
					i+=1;
				}
			}
						
			System.out.println(Arrays.toString(next_player));
			i=0;
			if(flag == 1) {
				flag=2;
				stmt.executeUpdate("update team_detail set team1_score ="+scorboard.curr_runs+" ,team1_wkt = "+scorboard.curr_wkts+";");
				scorboard.prev_score_label.setText(""+scorboard.curr_runs+"/"+scorboard.curr_wkts);
				scorboard.prev_runs = scorboard.curr_runs;
				scorboard.curr_runs =0;
				scorboard.curr_wkts = 0;
				scorboard.curr_overs = 0;
				scorboard.bwlr1_overs = 0;
				scorboard.bwlr1_runs=0;
				scorboard.bwlr1_wkt = 0;}
			else if(flag==2)
				stmt.executeUpdate("update team_detail set team2_score ="+scorboard.curr_runs+" ;");
			
			
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

	
	public static void Data(String name,int runs,int balls,float s_rate  )throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root" , "gvaishnav30may@gmail.com");
			stmt=conn.createStatement();
			if(flag==0) {
				query = "update team1 set Runs_Batsman = "+runs+" , Balls_Batsman = "+balls+" , StrikeRate = "+s_rate+"  where name = '"+name+"' ;";
			}
			else
				{
				 query = "update team2 set Runs_Batsman = "+runs+" , Balls_Batsman = "+balls+" , StrikeRate = "+s_rate+"  where name = '"+name+"' ;";
				}
			String list = "select name from  `team1` where name != ('"+name+"');";
			stmt.executeUpdate(query);
			if(scorboard.curr_overs != scorboard.total_overs) {
			if(scorboard.str==1) {
				scorboard.plyr1 = next_player[j];
				scorboard.label1_name.setText(""+scorboard.plyr1);
				j+=1;}
				else {
					scorboard.plyr2 = next_player[j];
					scorboard.label2_name.setText(""+scorboard.plyr2);
					j+=1;}
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
            	rs.close();
            }
            
        }
		
	}
		
}
