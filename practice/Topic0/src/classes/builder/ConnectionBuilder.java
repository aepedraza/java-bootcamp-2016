package classes.builder;

public interface ConnectionBuilder {
	public void buildEngine();

	public void buildUser();

	public void buildDatabaseName();

	public Connection getConnection();
}
