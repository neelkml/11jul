package neel;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
	public static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static String DATABASE_URL = "jdbc:mysql://172.17.174.51:3306/test";
	public static String USER_NAME = "root";
	public static String PASSWORD = "root";
	// public static String INSERT="";
	// public static String UPDATE="";
	// public static String GET_ALL_PERSON="";
	// public static String GET_PERSON="";

	public static void main(String args[]) {
		Connection connection = null;
		try {
			connection = getConnection();
			System.out.println(connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static Connection getConnection1() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		return connection;
	}

	public static void insert(final Person person) throws SQLException {
		Connection connection = null;
		java.sql.Statement statement = null;
		final String INSERT = "INSERT INTO TEST VALUES(" + person.getName() + "," + person.getAge() + ","
				+ person.getGender() + ")";
		try {
			connection = getConnection1();
			statement = connection.createStatement();
			statement.execute(INSERT);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}

	public static void update(final String name) {
		final String UPDATE = "UPDATE TEST SET NAME=NewName WHERE NAME" + name + "";
		Connection connection = null;
		int UpdateResult;
		try {
			connection = getConnection1();
			// statement=connection.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Person get() {
		return null;
	}

	public static void delete(final Person person) {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		return connection;
	}
}
