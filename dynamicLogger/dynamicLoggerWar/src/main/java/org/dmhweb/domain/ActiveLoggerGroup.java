package org.dmhweb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a group of loggers for the running application
 * 
 * @author dan
 * 
 */
@XmlRootElement
public class ActiveLoggerGroup {

	private List<ActiveLogger> activeLoggers;

	public List<ActiveLogger> getActiveLoggers() {
		if (activeLoggers == null) {
			activeLoggers = new ArrayList<ActiveLogger>();
		}
		return activeLoggers;
	}

}
