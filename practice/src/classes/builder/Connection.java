package classes.builder;

public class Connection {
	private String engine;
	private String user;
	private String databaseName;

	public String getEngine() {
		return engine;
	}

	public void setEngine(final String engine) {
		this.engine = engine;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
	public String toString() {
		return "Connection [engine=" + engine + ", user=" + user + ", databaseName=" + databaseName + "]";
	}

}
