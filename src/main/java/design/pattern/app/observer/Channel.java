package design.pattern.app.observer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Channel {
	
	private User publisher;
	private String channelName;
	List<User> subscribers = new ArrayList<User>();
	
	public Channel(String channelName) {
		this.channelName = channelName;
	}

	public Channel(String channelName, User publisher) {
		this(channelName);
		this.setPublisher(publisher);
	}

	public void subscribe(User subscriber) {
		subscribers.add(subscriber);
	}
	
	public int getSubscriderCount() {
		return subscribers.size();
	}

	/**
	 * @deprecated
	 */
	public void sendNewVideoNotice(String title) {
		subscribers.forEach((user) -> {
			String allim = user.notify(title, this.channelName);
			System.out.println(allim);
		});
	}
}
