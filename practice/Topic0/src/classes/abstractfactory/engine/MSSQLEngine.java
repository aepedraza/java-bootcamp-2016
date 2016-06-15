package classes.abstractfactory.engine;

public class MSSQLEngine implements Engine {

	@Override
	public String getEngineName() {
		return "MSSQL";
	}

}
