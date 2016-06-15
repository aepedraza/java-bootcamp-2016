package classes.abstractfactory;

import classes.abstractfactory.engine.Engine;
import classes.abstractfactory.transaction.TransactionType;

public abstract class AbstractConnectionFactory {
	public abstract Engine getEngine(String engine);

	public abstract TransactionType getTransactionType(String type);
}
