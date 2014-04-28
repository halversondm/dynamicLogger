package org.dmhweb.services.intf;

import org.dmhweb.domain.DynamicLoggerMessage;

/**
 * Interface to send the message to the associated Topic listeners
 * 
 * @author dan
 * 
 */
public interface DynamicLoggerMessager {

	void sendMessage(DynamicLoggerMessage message);

}
