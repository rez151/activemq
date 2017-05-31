package activemqpraktikum;

import javax.jms.*;

class SimpleQueueParticipant extends SimpleParticipant {

	protected final QueueSession queueSession;
	protected final Queue queue;

	SimpleQueueParticipant(String subject) throws JMSException {
		queue = session.createQueue(subject);
		QueueConnection queueConnection = factory
				.createQueueConnection();
		queueConnection.start();
		queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	}
}
