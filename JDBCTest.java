package neel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static String DATABASE_URL = "jdbc:mysql://172.17.174.51:3306/test";
	public static String USER_NAME = "root";
	public static String PASSWORD = "root";
	// public final String INSERT = "";
	// public final String UPDATE = "";
	// public final String GET_ALL_PERSON = "";
	// public final String GET_PERSON = "";

	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = getConnection();
			System.out.println(connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		insert(new Person("Akash", 23, Gender.MALE));
	}

	public static void insert(final Person person) {
		Connection connection = null;
		Statement statement = null;
		final String INSERT = "INSERT INTO PERSON VALUES (" + person.getName() + "," + person.getAge() + ","
				+ person.getGender().type + ")";
		try {
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeQuery(INSERT);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void update(final String name) {
		final String UPDATE = "UPDATE TEST SET NAME = NewName WHERE NAME = " + name + "";
		Connection connection = null;
		Statement statement = null;
		int updateResult = 0;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			updateResult = statement.executeUpdate(UPDATE);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static Person get(final String personName) {
		final String GET_PERSON = "SELECT * FROM TEST WHERE NAME =" + personName;

		Connection connection = null;
		Statement statement = null;
		int updateResult = 0;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			updateResult = statement.executeUpdate(GET_PERSON);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static Person getAllPerson() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM TEST");
			printPersons(resultSet);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception when fetching all person");
		}

		return null;

	}

	public static void delete(final Person person) {
		Connection connection = null;
		Statement statement = null;
		boolean resultSet = false;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.execute("DELETE * FROM TEST WHERE NAME =" + person.getName());

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception when fetching all person");
		} finally {
			if (connection != null) {

			}
		}

		return;

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		return connection;
	}

	public static void close(final Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	private static void printPersons(final ResultSet resultSet) {
		if (resultSet == null) {
			System.out.println("No record fetched.");
			return;
		}
		// TODO:
		System.out.println(resultSet);
	}

}