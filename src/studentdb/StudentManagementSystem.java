package studentdb;

import java.sql.ResultSet;
import java.util.*;
public class StudentManagementSystem{
	public static void main(String[] args) {
		try {
			StudentDAO dao = new StudentDAO();
			Scanner sc=new Scanner(System.in);
			System.out.println("======Student Management System======");
			while(true) {
			System.out.println("1.Insert Student\n2.Display Student\n3.Update Student\n4.Delete student\n5.Search Student\n6.Exit");
			int val=sc.nextInt();
			switch(val) {
			case 1:
				System.out.println("Enter student details id name age : ");
				int id=sc.nextInt();
				sc.nextLine();
				String name=sc.nextLine();
				int age=sc.nextInt();
				Student newStudent=new Student(id,name,age);
				int insertedrows=dao.insertStudent(newStudent);
				System.out.println(insertedrows+" rows affected successfully");
				break;
			case 2:
				System.out.println("Student details");
				ResultSet totalstudents=dao.displayStudents();
				System.out.println("-------------------------------------");
				System.out.println("Id   Name       Age");
				System.out.println("-------------------------------------");
				while(totalstudents.next()) {
					System.out.printf("%-5d %-15s %-5d%n",totalstudents.getInt("id"),totalstudents.getString("name"),totalstudents.getInt("age"));
				}
				System.out.println("-------------------------------------");
				break;
			case 3:
				System.out.println("Enter id and name to update");
				int setid=sc.nextInt();
				sc.nextLine();
				String setname=sc.nextLine();
				Student updatedStudent=new Student(setid,setname);
				int updatedrows=dao.updateStudent(updatedStudent);
				System.out.println(updatedrows+" rows are updated successfully");
				break;
			case 4:
				System.out.println("Enter id to remove a student");
				int remid=sc.nextInt();
				Student deletedStudent=new Student(remid);
				int deletedrows=dao.deleteStudent(deletedStudent);
				System.out.println(deletedrows+" rows deleted successfully");
				break;
			case 5:
				System.out.println("Enter a student id to search : ");
				int searchid=sc.nextInt();
				Student searchStudent=new Student(searchid);
				ResultSet rs=dao.searchStudentById(searchStudent);
				if(rs.next()) {
					System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("age"));
				}else {
					System.out.println("Student not found");
				}
				break;
			case 6:
				dao.closeConnection();
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
