package design.pattern.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.app.observer.Broker;
import design.pattern.app.observer.Channel;
import design.pattern.app.observer.User;

public class ObserverTest {

	// 옵저버 패턴: 구독자, 발행자가 긴밀히 연관되어 있을 때 사용
	// 	따라서 동일 서버 내에서만 사용 가능
	@Test
	void Observer_Pattern() {
		Channel channel = new Channel("미스터비스트");
		
		User dean = new User("dean");
		channel.subscribe(dean);
		
		int userCount = channel.getSubscriderCount();
		
		assertEquals(1, userCount);
		
		channel.sendNewVideoNotice("새로운 동영상");
		
		User sean = new User("sean");
		channel.subscribe(sean);

		channel.sendNewVideoNotice("새로운 동영상 2");
	}
	

	// 발행-구독 패턴: 구독자, 발행자가 서로 알지 못해도 사용 가능
	// 	중간에 브로커 소프트웨어가 연결시켜준다.
	// 	전달 정보를 topic이라고 한다.
	@Test
	void Publisher_Subscriber_Pattern() {
		User publisher = new User("john");
		Channel channel = new Channel("퓨디파이", publisher);
		
		assertEquals(publisher, channel.getPublisher());
		assertEquals("퓨디파이", channel.getChannelName());
		
		// 발행
		Broker broker = new Broker(); // 브로커
		broker.publish(channel);
		
		// User는 Channel 정보를 알지 못한다고 가정.
		Channel targetChannel = broker.getChannel("퓨디파이");
		assertEquals("퓨디파이", targetChannel.getChannelName());
		
		// 구독
		User dean = new User("dean");
		channel.subscribe(dean);
		assertEquals(1, channel.getSubscriderCount());
		
		// 1. 발행자가 브로커에 알림 메시지를 보내도록 호출
		// 2. 브로커는 알림 로직을 수행
		// 	2-1. 발행자의 채널 조회
		//	2-2. 해당 채널의 구독자 조회
		// 3. 구독자에게 알림 전송
		
		int noticeCount = broker.sendNewVideoNotice("새로운 동영상 3", "퓨디파이");
		assertEquals(1, noticeCount);
		
		// 구독 +
		User sam = new User("sam");
		channel.subscribe(sam);
		assertEquals(2, channel.getSubscriderCount());
		
		noticeCount = broker.sendNewVideoNotice("새로운 동영상 4", "퓨디파이");
		assertEquals(2, noticeCount);
	}
}
