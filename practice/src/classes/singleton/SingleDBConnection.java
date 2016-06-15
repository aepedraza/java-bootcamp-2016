package classes.singleton;

public class SingleDBConnection {
	private static SingleDBConnection instance = null;

	private String dbms;

	private SingleDBConnection(final String dbms) {
		this.dbms = dbms;
	}

	public static SingleDBConnection getInstance() {
		if (instance == null) {
			instance = new SingleDBConnection("default DBMS");
		}

		return instance;
	}

	public String getDbms() {
		return dbms;
	}

	public void setDbms(final String dbms) {
		this.dbms = dbms;
	}

	@Override
	public String toString() {
		return "SingleDBConnection [dbms=" + dbms + "]";
	}
}
