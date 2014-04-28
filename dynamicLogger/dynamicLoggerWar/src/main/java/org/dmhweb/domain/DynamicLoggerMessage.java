package org.dmhweb.domain;

import java.io.Serializable;
import java.security.Principal;

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
	private Principal principal;

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

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(final Principal principal) {
		this.principal = principal;
	}

	@Override
	public String toString() {
		return "DynamicLoggerMessage [logger=" + logger + ", level=" + level
				+ ", principal=" + principal + "]";
	}

}
