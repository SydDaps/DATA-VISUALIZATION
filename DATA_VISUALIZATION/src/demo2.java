import java.sql.ResultSet;

public class demo2 {


	public static void main(String[] args) {
		Db test = new Db();
		ResultSet rs;
		
		try {
			  test.clearData();
			  rs = test.displayUsers();
			 // dbCall.addData("amina", 56.8);
			  while (rs.next()) {
				   
				     System.out.println(rs.getString("column1") + " " + rs.getDouble("column2"));
				  }
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }

	}

}
