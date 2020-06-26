package database.des;

import java.util.List;
import java.util.PriorityQueue;

import lombok.ToString;


@ToString
public class Scheduler {
	private long time;
	private PriorityQueue<Event> eventQueue;
	
	public Scheduler() {
		this.time = 0;
		this.eventQueue = new PriorityQueue<Event>( (a,b) -> a.getTimestamp() < b.getTimestamp() ? -1 : 1);
	}
	
	public void start(List<Event> inititalEvent) {
		this.eventQueue.addAll(inititalEvent);
		while(!this.eventQueue.isEmpty()) {
			// get next element
			Event current = this.eventQueue.remove();
			// update time on scheduler
			this.time = current.getTimestamp();
			System.out.println("Time: " + this.time + ", event = " + current);
			// execute event
			current.execute();
		}
	}
	
	public void action() {
		this.eventQueue.add(
				 new Event(this.time + 10,this));
	}
}
