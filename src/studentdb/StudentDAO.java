package studentdb;

import java.sql.*;
public class StudentDAO {
	private String url="jdbc:mysql://localhost:3306/studentdb";
	private String user="root";
	private String password="";
	private Connection con; 
	public StudentDAO() throws SQLException {
	    con = DriverManager.getConnection(url, user, password);
	}
	public void closeConnection() throws SQLException {
		con.close();
	}
	public int insertStudent(Student std) throws SQLException{
		String sql="INSERT INTO student VALUES(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,std.getId());
		ps.setString(2,std.getName());
		ps.setInt(3,std.getAge());
		int rows=ps.executeUpdate();
		return rows;
	}
	public int deleteStudent(Student std) throws SQLException{
		String sql="DELETE FROM student WHERE id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,std.getId());
		int rows=ps.executeUpdate();
		return rows;
	}
	public int updateStudent(Student std) throws SQLException{
		String sql="UPDATE student SET name=? WHERE id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(2,std.getId());
		ps.setString(1,std.getName());
		int rows=ps.executeUpdate();
		return rows;
	}
	public ResultSet displayStudents() throws SQLException{
		String sql="SELECT * FROM student";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	public ResultSet searchStudentById(Student std) throws SQLException {
		String sql="SELECT * FROM student WHERE id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,std.getId());
		ResultSet rs=ps.executeQuery();
		ps.close();
		return rs;
	}
}
