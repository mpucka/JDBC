//package for the sql db
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		String url      =  "jdbc:mysql://localhost:3306/mydb";
		String user     =  "worker";
		String password =  "pass124";
		
		
		//to catch any exception that might happen
		try {
			
			/*
			 * use mydb
			 */
			
			//Get a connection to the db
			//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","pepinohelena");
			Connection myCon = DriverManager.getConnection(url,user,password);
			
			//Create a statement
			Statement mySta = myCon.createStatement();
			
			//Execute the SQL query
			
			//INSERT
			/*String sql = "insert into employees "
					   + "(lName, fName, email) "
					   + "values ('Mosby', 'Ted', 'ted@mosby.com')";*/
			
			//UPDATE 
			 /*String sql = " update employees"
			            + " set email = 'kenny@foo.com'"
					    + " WHERE lName = 'Baniah'";*/
			
			//DELETE
			String sql = "delete from employees where fName = 'Ted'";
			
		
			
			
			
			int rowsAffected = mySta.executeUpdate(sql);
			System.out.println("The new change afected " + rowsAffected + " row");
			System.out.println("Here is the list");
			
			//Process the result
			//SELECT STATEMENT
			ResultSet myRes = mySta.executeQuery("select * from employees");
			while (myRes.next()) {
				System.out.println(myRes.getString("lName")+ "," + myRes.getString("fName")+ ", Email: " + myRes.getString("email"));
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}

	}

}
