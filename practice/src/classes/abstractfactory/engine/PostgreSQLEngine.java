package classes.abstractfactory.engine;

public class PostgreSQLEngine implements Engine {

	@Override
	public String getEngineName() {
		return "PostgreSQL";
	}

}
