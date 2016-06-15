package classes.abstractfactory.transaction;

public class JtaTransactionType implements TransactionType {

	@Override
	public String getTransactionType() {
		return "JTA";
	}

}
