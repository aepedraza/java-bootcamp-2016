package classes.abstractfactory.transaction;

public class JdbcTransactionType implements TransactionType {

	@Override
	public String getTransactionType() {
		return "JDBC";
	}

}
