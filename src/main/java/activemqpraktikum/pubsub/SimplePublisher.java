package activemqpraktikum.pubsub;

import javax.jms.*;

class SimplePublisher extends SimplePubSubParticipant {

	SimplePublisher(String topic) throws JMSException {
		super(topic);	 
	}

	public void send(int msgs) throws JMSException{
		MessageProducer publisher = session.createProducer(topic);
		TextMessage message = session.createTextMessage();
		for (int i = 0; i < msgs; i++) {
			message.setText("This is message " + (i + 1));
			System.out.println("Sending message: " + message.getText());
			publisher.send(message);
		}
	}
		
	public static void main(String[] args) throws Exception {
		new SimplePublisher("An Example").send(10);
	}
	
}
