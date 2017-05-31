package activemqpraktikum.queue;

import javax.jms.*;


public class SimpleQueueAsyncReceiver extends SimpleQueueParticipant {

	SimpleQueueAsyncReceiver(String subject) throws JMSException {
		super(subject);
	}

	public void receive() throws JMSException {
		QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		queueReceiver.setMessageListener(new SimpleMessageListener());
		System.out.println("Continue processing");
	}

	private class SimpleMessageListener implements MessageListener{
		@Override
		public void onMessage(Message msg) {
			if (msg instanceof TextMessage) {
				TextMessage message = (TextMessage) msg;
				try {
					String text = message.getText();
					Thread.sleep(2000);
					System.out.println("Reading message: " + text);
				} catch (JMSException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new SimpleQueueAsyncReceiver("An Example").receive();
	}
}