package design.pattern.app.observer;

import lombok.Getter;

@Getter
public class User implements Observable {
	
	private String username;

	public User(String username) {
		this.username = username;
	}

	@Override
	public String notify(String title, String channelName) {
		return username + "님 " + channelName + " 채널에 " + title + " 영상이 게시되었습니다.";
	}
}
