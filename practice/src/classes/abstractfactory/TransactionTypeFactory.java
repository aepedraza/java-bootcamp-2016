package classes.abstractfactory;

import classes.abstractfactory.engine.Engine;
import classes.abstractfactory.transaction.JdbcTransactionType;
import classes.abstractfactory.transaction.JtaTransactionType;
import classes.abstractfactory.transaction.TransactionType;

public class TransactionTypeFactory extends AbstractConnectionFactory {

	@Override
	public Engine getEngine(final String engine) {
		return null;
	}

	@Override
	public TransactionType getTransactionType(final String type) {
		if (type.equalsIgnoreCase("jta"))
			return new JtaTransactionType();
		else if (type.equalsIgnoreCase("jdbc"))
			return new JdbcTransactionType();

		return null;
	}

}
