package classes.proxy;

import java.util.Date;
import java.util.Objects;

public class Proxy extends Connection {
	private SlowConnection connection;

	public Proxy() {
		startedAt = new Date();
		createdAt = new Date();
	}

	@Override
	public void printConnectionTimestamp() {
		if (Objects.isNull(connection))
			connection = new SlowConnection();
		else {
			connection.setStartedAt(startedAt);
			connection.setCreatedAt(createdAt);
		}
		connection.printConnectionTimestamp();
	}

}
