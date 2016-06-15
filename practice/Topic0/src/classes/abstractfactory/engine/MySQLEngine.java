package classes.abstractfactory.engine;

public class MySQLEngine implements Engine {

	@Override
	public String getEngineName() {
		return "MySQL";
	}

}
