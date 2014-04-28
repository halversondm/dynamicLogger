package org.dmhweb.services;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.dmhweb.domain.DynamicLoggerMessage;
import org.dmhweb.services.intf.DynamicLoggerMessager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sends the log level message to the topic.
 * 
 * @author dan
 * 
 */
@Stateless
@Local(DynamicLoggerMessager.class)
public class DynamicLoggerMessagerImpl implements DynamicLoggerMessager {

	private static final Logger logger = LoggerFactory
			.getLogger(DynamicLoggerMessagerImpl.class);

	@Resource(name = "jms/DynamicLoggerTCF")
	private TopicConnectionFactory topicConnectionFactory;

	@Resource(name = "jms/DynamicLoggerTopic")
	private Topic topic;

	@Override
	public void sendMessage(final DynamicLoggerMessage message) {

		logger.debug("Entering sendMessage()");

		TopicConnection connection = null;
		TopicSession session = null;
		TopicPublisher publisher = null;

		try {
			connection = topicConnectionFactory.createTopicConnection();
			session = connection.createTopicSession(true,
					Session.AUTO_ACKNOWLEDGE);
			publisher = session.createPublisher(topic);

			ObjectMessage objectMessage = session.createObjectMessage(message);
			publisher.publish(objectMessage);
		} catch (JMSException e) {
			logger.error("", e);
		} finally {
			try {
				publisher.close();
				session.close();
				connection.close();
			} catch (JMSException e) {
				logger.error("", e);
			}
		}

	}

}
