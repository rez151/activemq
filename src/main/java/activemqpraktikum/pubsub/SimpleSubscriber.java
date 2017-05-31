package activemqpraktikum.pubsub;

import javax.jms.*;


public class SimpleSubscriber extends SimplePubSubParticipant {

	SimpleSubscriber(String topic) throws JMSException {
		super(topic);
	}

	public void receive() throws JMSException {
        MessageConsumer subscriber=session.createConsumer(topic);
        System.out.println("Receiving...");
		while (true) {
			Message m = subscriber.receive();
			if (m instanceof TextMessage) {
				TextMessage message = (TextMessage) m;
				String text = message.getText();
				System.out.println("Reading message: " + text);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new SimpleSubscriber("An Example").receive();

	}
}