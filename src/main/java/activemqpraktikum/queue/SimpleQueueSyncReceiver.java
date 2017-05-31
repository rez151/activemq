package activemqpraktikum;

import javax.jms.*;


public class SimpleQueueSyncReceiver extends SimpleQueueParticipant {

	SimpleQueueSyncReceiver(String subject) throws JMSException {
		super(subject);
	}

	public void receive() throws JMSException {
		QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		while (true) {
			Message m = queueReceiver.receive();
			if (m instanceof TextMessage) {
				TextMessage message = (TextMessage) m;
				String text = message.getText();
				System.out.println("Reading message: " + text);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new SimpleQueueSyncReceiver("An Example").receive();

	}
}