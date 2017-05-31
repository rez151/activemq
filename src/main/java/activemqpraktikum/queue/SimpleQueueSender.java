package activemqpraktikum.queue;

import javax.jms.*;

public class SimpleQueueSender extends SimpleQueueParticipant{

	SimpleQueueSender(String subject) throws JMSException {
		super(subject);
	}

	public void send(int msgs) throws JMSException{
		QueueSender queueSender = queueSession.createSender(queue);
		TextMessage message = queueSession.createTextMessage();
		for (int i = 0; i < msgs; i++) {
			message.setText("This is message " + (i + 1));
			System.out.println("Sending message: " + message.getText());
			queueSender.send(message);
		}
	}
		
	public static void main(String[] args) throws Exception {
		new SimpleQueueSender("An Example").send(10);
	}
}