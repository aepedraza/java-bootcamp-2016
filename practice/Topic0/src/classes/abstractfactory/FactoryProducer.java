package classes.abstractfactory;

public class FactoryProducer {
	public static AbstractConnectionFactory getFactory(final String factory) {
		if (factory.equalsIgnoreCase("engine"))
			return new EngineFactory();
		else if (factory.equalsIgnoreCase("transaction"))
			return new TransactionTypeFactory();
		return null;
	}
}
