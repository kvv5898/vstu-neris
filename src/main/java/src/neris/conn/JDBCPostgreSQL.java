package src.neris.conn;

//STEP 1. Import required packages
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCPostgreSQL {

	// Database credentials
	static final String DB_URL = "jdbc:postgresql://ec2-54-217-236-206.eu-west-1.compute.amazonaws.com/dapdo905rgeksu";
	static final String USER = "ovgbnnnyciadyj";
	static final String PASS = "b3207d39318ad1ec84025f9b4011c1c86d9f70b94ed3cf78292abf2c273ef136";

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