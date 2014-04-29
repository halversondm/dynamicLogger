package org.dmhweb.domain;

import java.io.Serializable;

/**
 * Serializable class to pass the information to the listener from the update
 * service
 * 
 * @author dan
 * 
 */
public class DynamicLoggerMessage implements Serializable {

	private static final long serialVersionUID = -762349012018960274L;

	private String logger;
	private String level;
	private String updatedBy;

	public String getLogger() {
		return logger;
	}

	public void setLogger(final String logger) {
		this.logger = logger;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(final String level) {
		this.level = level;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(final String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "DynamicLoggerMessage [logger=" + logger + ", level=" + level
				+ ", updatedBy=" + updatedBy + "]";
	}

}
