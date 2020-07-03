package database.des;

import java.util.List;
import java.util.PriorityQueue;


public class Scheduler {
	private long time;
	private PriorityQueue<Event> eventQueue;
	
	public Scheduler() {
		this.time = 0;
		this.eventQueue = new PriorityQueue<Event>( (a,b) -> a.getTimestamp() < b.getTimestamp() ? -1 : 1);
	}
	
	public int start(List<Event> inititalEvent) {
		int eventsExecuted = 0;
		this.eventQueue.addAll(inititalEvent);
		while(!this.eventQueue.isEmpty()) {
			// get next element
			Event current = this.eventQueue.remove();
			// update time on scheduler
			this.time = current.getTimestamp();
			System.out.println("Time: " + this.time + ", event = " + current);
			// execute event
			current.execute();
			eventsExecuted++;
		}
		System.out.println("Events executed: " + eventsExecuted);
		return eventsExecuted;
	}
	
	public void scheduleInFuture(Event event, long timeInFuture) {
		event.setTimestamp(timeInFuture + event.getTimestamp());
		this.eventQueue.add(event);
	}
	
	public void end() {
		this.eventQueue.clear(); 
	}
}
