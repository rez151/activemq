package activemqpraktikum.pubsub;

import activemqpraktikum.SimpleParticipant;

import javax.jms.*;

class SimplePubSubParticipant extends SimpleParticipant {

	protected final Topic topic;

	SimplePubSubParticipant(String t) throws JMSException {
	       topic = session.createTopic(t);
	 }
}
