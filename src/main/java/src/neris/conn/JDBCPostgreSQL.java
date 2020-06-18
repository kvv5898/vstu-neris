package src.neris.conn;

//STEP 1. Import required packages
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCPostgreSQL {

	// Database credentials
	static final String DB_URL = "jdbc:postgresql://ec2-54-247-78-30.eu-west-1.compute.amazonaws.com/d2et3uvg9qqd45";
	static final String USER = "axcaxenuxwqccx";
	static final String PASS = "94e4da693bcb9e04e12d09364418f78790cae701b4c1054a35ce684e0a168313";

	public static Connection conni() throws SQLException, ClassNotFoundException {

		System.out.println("Testing connection to PostgreSQL JDBC");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
			e.printStackTrace();

		}

		System.out.println("PostgreSQL JDBC Driver successfully connected");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("You successfully connected to database now");
		} else {
			System.out.println("Failed to make connection to database");
		}
		return connection;
	}
}