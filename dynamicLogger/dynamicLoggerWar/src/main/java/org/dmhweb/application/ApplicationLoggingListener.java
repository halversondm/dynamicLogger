package org.dmhweb.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Start up logging. Not sure if this is a WebSphere Liberty thing, but want
 * logging available before anything else loads since nothing else seems to load
 * automatically at all. In other application servers this may not be necessary.
 * 
 */
public class ApplicationLoggingListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationLoggingListener.class);

	/**
	 * Default constructor.
	 */
	public ApplicationLoggingListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(final ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("Application Logging started ...");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("Application Logging stopped ...");
	}

}
