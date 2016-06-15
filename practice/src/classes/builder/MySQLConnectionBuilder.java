package classes.builder;

public class MySQLConnectionBuilder implements ConnectionBuilder {
	private Connection connection;

	public MySQLConnectionBuilder() {
		this.connection = new Connection();
	}

	@Override
	public void buildEngine() {
		connection.setEngine("MySQL");
	}

	@Override
	public void buildUser() {
		connection.setUser("root");
	}

	@Override
	public void buildDatabaseName() {
		connection.setDatabaseName("testdb");
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

}
