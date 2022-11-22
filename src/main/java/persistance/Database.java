package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import logger.Logger;

public class Database {

	private final String URL = "jdbc:sqlite:database.db";
	private final Logger log;

	private Connection conn = null;
	private static Database instance = null;

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public Database() {
		log = Logger.getInstance();
		try {
			conn = DriverManager.getConnection(URL);
			log.writeLine("Connection to SQLite has been established.");
			initializeData();
		} catch (SQLException e) {
			log.writeLine(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				log.writeLine(ex.getMessage());
			}
		}
	}

	private void initializeData() {
		log.writeLine("Initializing data...");
		execute(Query.DROP_ACCOUNT);
		execute(Query.DROP_ACCOUNTTYPE);
		execute(Query.DROP_CLIENT);
		execute(Query.DROP_BANK);

		execute(Query.CREATE_BANK);
		execute(Query.POPULATE_BANK);

		execute(Query.CREATE_CLIENT);
		execute(Query.POPULATE_CLIENT);

		execute(Query.CREATE_ACCOUNTTYPE);
		execute(Query.POPULATE_ACCOUNTTYPE);

		execute(Query.CREATE_ACCOUNT);
		execute(Query.POPULATE_ACCOUNT);
		log.writeLine("Data initialization finished");
	}

	private void execute(String query) {
		log.writeLine("Executing... %s", query);
		try {
			Statement stmt = conn.createStatement();
			if (query.startsWith("DROP"))
				stmt.executeQuery(query);
			if (query.startsWith("CREATE"))
				stmt.executeQuery(query);
			else if (query.startsWith("INSERT"))
				stmt.executeUpdate(query);
			stmt.close();
			conn.commit();
			log.writeLine("Correct execution!!");
		} catch (SQLException e) {
			log.writeLine(e.getMessage());
		}
	}

	public Connection getConnection() {
		return conn;
	}

}
