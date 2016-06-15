package classes.proxy;

import java.util.Date;

public class SlowConnection extends Connection {

	public SlowConnection() {
		startedAt = new Date();
		buildProcess();
		createdAt = new Date();
	}

	private void buildProcess() {
		System.out.print("Creating connection...");
		try {
			Thread.sleep(5000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Done");
	}

	public void setStartedAt(final Date startedAt) {
		this.startedAt = startedAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

}
