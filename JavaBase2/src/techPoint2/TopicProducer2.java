package techPoint2;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicProducer2 implements Runnable {
	ActiveMQConnectionFactory connectionFactory = null;

	public TopicProducer2(ActiveMQConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public void run() {
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createTopic("SAYHELLO");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			
			String text = "Hello ActiveMQ.";
			TextMessage message = session.createTextMessage(text);
			
			producer.send(message);
			
			session.close();
			connection.close();
		} catch (JMSException jmse) {
			System.out.println("Exception: "+ jmse.getMessage());
		}


	}

}
