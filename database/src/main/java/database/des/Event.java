package database.des;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString(exclude = "scheduler")
public class Event implements Command {
	@Getter
	private long timestamp;
	
	private Scheduler scheduler;
	
	public void execute() {
		this.scheduler.action();
	}
}
