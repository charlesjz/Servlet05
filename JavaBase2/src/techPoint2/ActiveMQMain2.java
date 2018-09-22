package techPoint2;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQMain2 {

	public static void main(String[] args) {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		Thread topicConsumerThread = new Thread((Runnable) new TopicConsumer(connectionFactory));
		
		topicConsumerThread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		Thread topicProducerThread = new Thread(new TopicProducer(connectionFactory));
		topicProducerThread.start();
		
		System.out.println("end.");
	}
}
