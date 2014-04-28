package org.dmhweb.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ActiveLogger {

	private String name;
	private String currentLevel;

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

	@Override
	public String toString() {
		return "ActiveLogger [name=" + name + ", currentLevel=" + currentLevel
				+ "]";
	}

}
