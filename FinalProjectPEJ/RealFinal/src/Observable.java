import java.util.ArrayList;
import java.util.Iterator;


public abstract class Observable implements ReleaseObservable {
	
	ArrayList<Observer> observers = new ArrayList<Observer>();
	ReleaseObservable client;
	
	public Observable(ReleaseObservable client) {
		this.client =client;
	}
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer)iterator.next();
			observer.update(this);
		}
	}
	
	public abstract Ticket getTicket();
    public abstract void execute();

	public void execute(Client client) {
		// TODO Auto-generated method stub
		
	}

}
