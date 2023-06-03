import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Prog2_dynamic {
	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "password");

			/*
			 * dynamic data insert into db Scanner sc=new Scanner(System.in);
			 * System.out.println("Enter Id"); int id=sc.nextInt();
			 * 
			 * System.out.println("Enter Name"); String name=sc.next();
			 * 
			 * System.out.println("Enter Address"); String address=sc.next(); /*
			 * PreparedStatement
			 * ps=conn.prepareStatement("insert into studentInfo values(?,?,?)");
			 * ps.setInt(1,id); ps.setString(2, name); ps.setString(3, address);
			 * 
			 * int a=ps.executeUpdate(); System.out.println("Data Insert Sucessfully..");
			 */

			/*
			 * update into db dynamic Scanner sc = new Scanner(System.in);
			 * System.out.println("Enter Id"); int id= sc.nextInt();
			 * 
			 * System.out.println("Enter Name"); String name = sc.next();
			 * 
			 * System.out.println("Enter Adress"); String address = sc.next();
			 * 
			 * 
			 * PreparedStatement ps =
			 * conn.prepareStatement("update studentInfo set name=? ,adress=? where id=?");
			 * ps.setString(1, name); ps.setString(2, address); ps.setInt(3, id);
			 * 
			 * int a = ps.executeUpdate(); System.out.println("Data update Sucessfully..");
			 */

			/*
			 * Scanner sc = new Scanner(System.in); System.out.println("Enter Name"); String
			 * name=sc.next();
			 * 
			 * PreparedStatement ps =
			 * conn.prepareStatement("delete from studentInfo where name=?");
			 * 
			 * ps.setString(1, name);
			 * 
			 * int a = ps.executeUpdate();
			 * 
			 * if(a==1) { System.out.println("Data delete Sucessfully..");
			 * 
			 * }else { System.out.println("Data not delete Sucessfully.."); }
			 */
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name");
			String name=sc.next();

			PreparedStatement ps = conn.prepareStatement("select * from studentInfo where name=?");

			ps.setString(1, name);

			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("Id="+rs.getInt(1)+" Adress="+rs.getString(3));
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
