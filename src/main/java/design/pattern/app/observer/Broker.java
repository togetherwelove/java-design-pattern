package design.pattern.app.observer;

import java.util.ArrayList;
import java.util.List;

public class Broker {

	List<Channel> channels = new ArrayList<>();
	
	public void publish(Channel channel) {
		this.channels.add(channel);
	}

	public Channel getChannel(String channelName) {
		return channels.stream()
				.filter(channel -> channel.getChannelName().equals(channelName))
				.findFirst()
				.orElse(null);
	}

	public int sendNewVideoNotice(String title, String channelName) {
		Channel pubChannel = getChannel(channelName);
		List<User> subscribers = pubChannel.getSubscribers();
		subscribers.forEach((user) -> {
			String allim = user.notify(title, channelName);
			System.out.println(allim);
		});
		return subscribers.size();
	}
}
