import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class prog1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "password");

			// insert data into database PreparedStatement
			/*
			 * PreparedStatement ps =
			 * conn.prepareStatement("insert into studentInfo values(?,?,?)"); ps.setInt(1,
			 * 123); ps.setString(2, "Pabitra3"); ps.setString(3, "Odisha3");
			 * ps.executeUpdate(); System.out.println("Data Insert Sucessfully..");
			 */

			/*
			 * update data into db PreparedStatement ps=conn.
			 * prepareStatement("update studentInfo set name=? , adress=? where id=?");
			 * ps.setString(1,"Rakesh"); ps.setString(2,"Jharkhand"); ps.setInt(3,122); int
			 * i=ps.executeUpdate(); System.out.println("Data update Sucessfully..");
			 */

			/*
			 * delete data from database PreparedStatement ps =
			 * conn.prepareStatement("delete from studentInfo where id=?"); ps.setInt(1,
			 * 125); int i = ps.executeUpdate();
			 * System.out.println("Data delete Sucessfully..");
			 */
			/*
			 * PreparedStatement ps = conn.prepareStatement("select * from studentInfo");
			 * ResultSet rs = ps.executeQuery(); while (rs.next()) {
			 * System.out.println("Id=" + rs.getInt(1) + " Name=" + rs.getString(2) +
			 * " Adress=" + rs.getString(3)); }
			 * 
			 * conn.close();
			 */

			boolean f = true;

			while (f) {
				Scanner sc = new Scanner(System.in);
				System.out.println("---------------------------");
				// System.out.println("***************************");
				System.out.println("1. Add Phone No");
				System.out.println("2. Edit Phone No");
				System.out.println("3. Delete Phone No");
				System.out.println("4. View Phone No");
				System.out.println("5. Exit");
				System.out.println("---------------------------");
				System.out.println("Enter Serial No");
				System.out.println("---------------------------");

				int i = sc.nextInt();

				switch (i) {
				case 1:
					System.out.println("Enter Name");
					String name = sc.next();
					System.out.println("Enter Ph No");
					String phno = sc.next();
					System.out.println("Enter Address");
					String address = sc.next();
					System.out.println("Phone No Added Sucessfully..");
					break;

				case 2:
					System.out.println("Enter Id");
					System.out.println("Enter Name");
					System.out.println("Enter Ph No");
					System.out.println("Phone No Edit Sucessfully..");
					break;
				case 3:
					System.out.println("Enter Id");
					System.out.println("Phone No Delete Sucessfully..");
					break;
				case 4:
					System.out.println("Ram Shaym");
					break;
				case 5:
					System.out.println("Thank U..Visit Again");
					f = false;
					break;
				default:
					System.out.println("Please Enter Correct no");
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
