package classes.builder;

public class MongoDBConnectionBuilder implements ConnectionBuilder {

	private Connection connection;

	public MongoDBConnectionBuilder() {
		connection = new Connection();
	}

	@Override
	public void buildEngine() {
		connection.setEngine("MongoDB");
	}

	@Override
	public void buildUser() {
		connection.setUser("mgAdmin");
	}

	@Override
	public void buildDatabaseName() {
		connection.setDatabaseName("mongo_db");
	}

	@Override
	public Connection getConnection() {
		return connection;
	}
}
