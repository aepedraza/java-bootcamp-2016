package classes.abstractfactory;

import classes.abstractfactory.engine.Engine;
import classes.abstractfactory.engine.MSSQLEngine;
import classes.abstractfactory.engine.MySQLEngine;
import classes.abstractfactory.engine.PostgreSQLEngine;
import classes.abstractfactory.transaction.TransactionType;

public class EngineFactory extends AbstractConnectionFactory {

	@Override
	public Engine getEngine(final String engine) {
		if (engine.equalsIgnoreCase("mysql"))
			return new MySQLEngine();
		else if (engine.equalsIgnoreCase("mssql"))
			return new MSSQLEngine();
		else if (engine.equalsIgnoreCase("postgresql"))
			return new PostgreSQLEngine();

		return null;
	}

	@Override
	public TransactionType getTransactionType(final String type) {
		return null;
	}

}
