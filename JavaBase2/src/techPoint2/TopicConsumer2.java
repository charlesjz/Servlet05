package techPoint2;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;

public class TopicConsumer2 implements Runnable{
	ActiveMQConnectionFactory connectionFactory = null;

	public TopicConsumer2(ActiveMQConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	@Override
	public void run() {
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination topicDestination = session.createTopic("SAYHELLO");
			
			MessageConsumer messageConsumer = session.createConsumer(topicDestination);
			Message message = (Message) messageConsumer.receive();
			TextMessage textMessage = (TextMessage)message;
			System.out.println(textMessage.getText());
			
			session.close();
			connection.close();
		} catch (JMSException jmse) {
			System.out.println("Exception: "+ jmse.getMessage());
		}
		
	}

}
