package classes.builder;

public class ConnectionDirector {
	private ConnectionBuilder builder;

	public ConnectionDirector(final ConnectionBuilder builder) {
		this.builder = builder;
	}

	public void constructConnection() {
		builder.buildEngine();
		builder.buildUser();
		builder.buildDatabaseName();
	}

	public Connection getConnection() {
		return builder.getConnection();
	}
}
