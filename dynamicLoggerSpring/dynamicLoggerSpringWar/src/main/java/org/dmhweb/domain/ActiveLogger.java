package org.dmhweb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents the current state of one logger and the potential levels available
 * to it.
 * 
 * @author dan
 * 
 */
@XmlRootElement
public class ActiveLogger implements Comparable<ActiveLogger> {

	private String name;
	private String currentLevel;
	private List<AvailableLevel> availableLevel;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(final String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public List<AvailableLevel> getAvailableLevel() {
		if (availableLevel == null) {
			availableLevel = new ArrayList<AvailableLevel>();
		}
		return availableLevel;
	}

	@Override
	public String toString() {
		return "ActiveLogger [name=" + name + ", currentLevel=" + currentLevel
				+ ", availableLevel=" + availableLevel + "]";
	}

	@Override
	public int compareTo(final ActiveLogger o) {
		return name.compareTo(o.name);
	}

}
