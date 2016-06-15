package main;

import classes.abstractfactory.AbstractConnectionFactory;
import classes.abstractfactory.FactoryProducer;
import classes.abstractfactory.engine.Engine;
import classes.abstractfactory.transaction.TransactionType;
import classes.builder.Connection;
import classes.builder.ConnectionBuilder;
import classes.builder.ConnectionDirector;
import classes.builder.MongoDBConnectionBuilder;
import classes.builder.MySQLConnectionBuilder;
import classes.proxy.FastConnection;
import classes.proxy.Proxy;
import classes.singleton.SingleDBConnection;

public class MainDemo {

	public static void main(final String[] args) {
		System.out.println("Excercise 1:");
		final SingleDBConnection singleDbConn = SingleDBConnection.getInstance();
		System.out.println(singleDbConn);
		singleDbConn.setDbms("MySQL");

		final SingleDBConnection anotherSingleConn = SingleDBConnection.getInstance();
		System.out.println(anotherSingleConn); // must print MySQL as dbms

		separator();

		System.out.println("Excercise 2:");
		final AbstractConnectionFactory engineFactory = FactoryProducer.getFactory("engine");
		final Engine mysqlEngine = engineFactory.getEngine("MySQL");
		final AbstractConnectionFactory transactionTypeFactory = FactoryProducer.getFactory("transaction");
		final TransactionType jtaTransaction = transactionTypeFactory.getTransactionType("JTA");

		// Must print "Doing a JTA transaction with MySQL engine"
		printFactoryResult(mysqlEngine, jtaTransaction);

		final Engine postgresEngine = engineFactory.getEngine("postgresql");
		final TransactionType jdbcTransaction = transactionTypeFactory.getTransactionType("jdbc");

		// Must print "Doing a JDBC transaction with PostgreSql engine"
		printFactoryResult(postgresEngine, jdbcTransaction);

		separator();

		System.out.println("Excercise 3:");
		final FastConnection fastConnection = new FastConnection();
		fastConnection.printConnectionTimestamp();
		final Proxy proxy = new Proxy();

		// Slow Connection created on demand. Long-running process
		proxy.printConnectionTimestamp();
		// Slow Connection is already created, must take no time
		proxy.printConnectionTimestamp();

		separator();

		System.out.println("Excercise 4:");
		// Must print Mongo DB connection data
		makeBuildProccessAndPrintResult(new MongoDBConnectionBuilder());
		// Must print MySQL DB connection data
		makeBuildProccessAndPrintResult(new MySQLConnectionBuilder());

		separator();

	}

	private static void makeBuildProccessAndPrintResult(final ConnectionBuilder builder) {
		final ConnectionDirector director = new ConnectionDirector(builder);
		director.constructConnection();
		final Connection connection = director.getConnection();
		System.out.println(connection);
	}

	private static void separator() {
		System.out.println("\n------------------------------------------\n");
	}

	private static void printFactoryResult(final Engine engine, final TransactionType transactionType) {
		System.out.println("Doing a " + transactionType.getTransactionType() + " transaction with " + engine.getEngineName() + " engine");
	}

}
