package database.des;

public class CancelEvent extends Event {

	public CancelEvent(long timestamp, Scheduler scheduler) {
		super(timestamp, scheduler);
	}

	public void execute() {
		super.scheduler.end();
	}
	
	
}
