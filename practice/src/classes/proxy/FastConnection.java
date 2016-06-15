package classes.proxy;

import java.util.Date;

public class FastConnection extends Connection {

	public FastConnection() {
		startedAt = new Date();
		createdAt = new Date();
	}

}
