package org.dmhweb.services;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.dmhweb.domain.DynamicLoggerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Receives the message to update the log4j Logger level setting
 * 
 * @author dan
 * 
 */
@MessageDriven(name = "jms/DynamicLoggerListener")
public class DynamicLoggerListener implements MessageListener {

	private static final Logger logger = LoggerFactory
			.getLogger(DynamicLoggerListener.class);

	@Override
	public void onMessage(final Message message) {

		logger.debug("Entering onMessage()");

		if (message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;

			try {
				DynamicLoggerMessage dynamicLogger = (DynamicLoggerMessage) objectMessage
						.getObject();

				org.apache.log4j.Logger loggerToChange = LogManager
						.getLogger(dynamicLogger.getLogger());
				Level level = Level.toLevel(dynamicLogger.getLevel());
				loggerToChange.setLevel(level);

				String user = dynamicLogger.getPrincipal() == null ? "unknown"
						: dynamicLogger.getPrincipal().getName();

				logger.info(
						"A log level change for logger {} to level {} was requested by {}",
						dynamicLogger.getLogger(), dynamicLogger.getLevel(),
						user);
			} catch (JMSException e) {
				logger.error("", e);
			}
		} else {
			logger.error("Dynamic Logger Listener message received but not of ObjectMessage type.");
		}

	}
}
