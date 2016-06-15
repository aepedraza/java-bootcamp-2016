package classes.proxy;

import java.util.Date;

public abstract class Connection {

	protected Date startedAt;
	protected Date createdAt;

	public void printConnectionTimestamp() {
		System.out.println(this.getClass().getSimpleName() + " started at" + startedAt + " and finished at " + createdAt);
	}
}
