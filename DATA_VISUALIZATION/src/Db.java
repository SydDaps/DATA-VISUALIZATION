import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	 private static Connection con;
	 private static boolean hasData = false;
	 
	 private void getConnection() throws ClassNotFoundException, SQLException {
		  // sqlite driver
		  Class.forName("org.sqlite.JDBC");
		  // database path, if it's new database, it will be created in the project folder
		  con = DriverManager.getConnection("jdbc:sqlite:DATA.db");
		  initialise();
	 }
	 

	public void addData(String dataValue,  double dataKey) throws ClassNotFoundException, SQLException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		  PreparedStatement prep = con.prepareStatement("insert into  Data (column1, column2) values(?,?);");
		prep.setString(1, dataValue);
				  prep.setDouble(2, dataKey);
				  prep.execute();
				  
	
		 
	 }
	 
	 public ResultSet displayUsers() throws SQLException, ClassNotFoundException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		 Statement state = con.createStatement();
		 ResultSet res = state.executeQuery("select column1, column2 from Data");
	
		 return res;
	 }
	 
	 public void clearData() throws SQLException, ClassNotFoundException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		 Statement state3 = con.createStatement();
		 state3.addBatch("delete from sqlite_sequence where name='Data'");
		 state3.addBatch("delete from data");
		 state3.executeBatch();
	 }
	 
	public void setData(int[] values,String[] label)  {
			if(con == null) {
				 // get connection
				 try {
					getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		int count = 0;
		try {
			Statement state = con.createStatement();
			ResultSet data = state.executeQuery("select * from data");
			while(data.next()) {
			label[count] = data.getString("column1");
			values[count] = data.getInt("column2");
				count++;
			}		
			
		} catch ( SQLException  e) {
			System.out.println(e);
			e.printStackTrace();
		}  
		
	}
	 
	 
	 
	 
	 private void initialise() throws SQLException {
		 if( !hasData ) {
			 hasData = true;
			 // check for database table
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='Data'");
			 if( !res.next()) {
				 System.out.println("Building the Data table with prepopulated values.");
				 // need to build the table
				  Statement state2 = con.createStatement();
				  state2.executeUpdate("CREATE TABLE Data (" + 
				  		"dataID INTEGER PRIMARY KEY AUTOINCREMENT," + 
				  		"column1 varchar(200)," + 
				  		"column2 double);");
			 }
			 
		 }
	 }
	 
}
