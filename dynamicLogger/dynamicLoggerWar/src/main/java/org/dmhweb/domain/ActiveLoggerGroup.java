package org.dmhweb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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
