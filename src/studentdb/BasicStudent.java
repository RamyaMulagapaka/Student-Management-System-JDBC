package studentdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BasicStudent {
	static String url="jdbc:mysql://localhost:3306/studentdb";
	static String user="root";
	static String password="";
	static Connection con;
	public static void insertStudents(int id,String name,int age) throws SQLException{
		String sql="INSERT INTO student VALUES(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setInt(3,age);
		int rows=ps.executeUpdate();
		System.out.println(rows+" affected successfully");
	}
	public static void deleteStudents(int id) throws SQLException{
		String sql="DELETE FROM student WHERE id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		int rows=ps.executeUpdate();
		System.out.println(rows+" affected successfully");
	}
	public static void updateStudents(int id,String name) throws SQLException{
		String sql="UPDATE student SET name=? WHERE id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(2,id);
		ps.setString(1,name);
		int rows=ps.executeUpdate();
		System.out.println(rows+" affected successfully");
	}
	public static void displayStudents() throws SQLException{
		String sql="SELECT * FROM student";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("age"));
		}
	}
	
	public static void main(String[] args) {
		try {
			con=DriverManager.getConnection(url,user,password);
			Scanner sc=new Scanner(System.in);
			while(true) {
			System.out.println("1.Insert Student\n2.Display Student\n3.Update Student\n4.Delete student\n5.Exit");
			int val=sc.nextInt();
			switch(val) {
			case 1:
				System.out.println("Enter student details id name age : ");
				int id=sc.nextInt();
				sc.nextLine();
				String name=sc.nextLine();
				int age=sc.nextInt();
				BasicStudent.insertStudents(id,name,age);
				break;
			case 2:
				System.out.println("Student details");
				BasicStudent.displayStudents();
				break;
			case 3:
				System.out.println("Enter id and name to update");
				int setid=sc.nextInt();
				sc.nextLine();
				String setname=sc.nextLine();
				BasicStudent.updateStudents(setid,setname);
				break;
			case 4:
				System.out.println("Enter id to remove a student");
				int remid=sc.nextInt();
				BasicStudent.deleteStudents(remid);
				break;
			case 5:
				con.close();
				sc.close();
				System.out.println("Have a great day !");
				return;
			}
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
