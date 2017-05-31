package activemqpraktikum;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SimpleParticipant {

	protected ActiveMQConnectionFactory factory;
	protected Session session;
	
	public SimpleParticipant() throws JMSException {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = "tcp://192.168.162.128:61616";

		factory = new ActiveMQConnectionFactory(user, password, url);
		Connection connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}
}
