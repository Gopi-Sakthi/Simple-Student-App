package com.studentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	static Connection connection;
	static Statement statement;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
	}
	public void saveStudnet( Student student) {
		try {
			connection = getConnection() ;
			String query = "Insert into db.student values( ?, ?, ?, ?, ?, ?)" ;
			preparedStatement = connection.prepareStatement(query) ;
			preparedStatement.setInt(1, student.getSid());
			preparedStatement.setString(2, student.getSname());
			preparedStatement.setDouble(3, student.getMarks());
			preparedStatement.setString(4, student.getPhone());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getGender());
			if(preparedStatement.executeUpdate() == 1 ) {
				System.out.println("Student details saved to table");
			}
			else {
				System.err.println("Student details not added to table");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void displayStudentDetails() {
		try {
			connection = getConnection() ;
			String query = "Select * From db.student" ;
			preparedStatement = connection.prepareStatement(query) ;
			resultSet = preparedStatement.executeQuery() ;
			if( resultSet != null ) {
				while( resultSet.next()) {
					Student student = new Student() ;
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setMarks(resultSet.getDouble(3));
					student.setPhone(resultSet.getString(4));
					student.setEmail(resultSet.getString(5));
					student.setGender(resultSet.getString(6));
					System.out.println(student);
				}
			}else {
				System.err.println("No student details are available is table");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void searchStudentById(int sid) {
		try {
			connection = getConnection() ;
			String query = "Select * From db.student where sid = ?" ;
			preparedStatement = connection.prepareStatement(query) ;
			preparedStatement.setInt(1, sid);
			resultSet = preparedStatement.executeQuery() ;
			if( resultSet.next()) {
				Student student = new Student() ;
				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setMarks(resultSet.getDouble(3));
				student.setPhone(resultSet.getString(4));
				student.setEmail(resultSet.getString(5));
				student.setGender(resultSet.getString(6));
				System.out.println(student);
			} else {
				System.err.println("No student details available with sid :: "+ sid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void deleteStudentById(int sid) {
		try {
			connection = getConnection() ;
			String query = "Delete From db.student where sid = ?" ;
			preparedStatement = connection.prepareStatement(query) ;
			preparedStatement.setInt(1, sid);
			if(preparedStatement.executeUpdate() == 1 ) {
				System.out.println("Student details deleted from table of id :: "+ sid);
			} else {
				System.err.println("Student details not deleted from table of id :: "+ sid);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}