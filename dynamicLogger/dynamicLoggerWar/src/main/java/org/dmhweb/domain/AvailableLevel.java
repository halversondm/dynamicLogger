package org.dmhweb.domain;

public class AvailableLevel {

	private String level;
	private boolean current;

	public String getLevel() {
		return level;
	}

	public void setLevel(final String level) {
		this.level = level;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(final boolean current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return "AvailableLevel [level=" + level + ", current=" + current + "]";
	}

}
