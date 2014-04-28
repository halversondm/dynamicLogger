package org.dmhweb.services;

import java.util.Enumeration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.LogManager;
import org.dmhweb.domain.ActiveLogger;
import org.dmhweb.domain.ActiveLoggerGroup;
import org.dmhweb.domain.DynamicLoggerMessage;
import org.dmhweb.services.intf.DynamicLoggerMessager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Path("/")
public class DynamicLoggerService {

	private static final Logger logger = LoggerFactory
			.getLogger(DynamicLoggerService.class);

	@EJB
	private DynamicLoggerMessager dynamicLoggerMessager;

	@Context
	private SecurityContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveActiveLoggers() {

		logger.debug("Entering retrieveActiveLoggers()");

		Enumeration enumeration = LogManager.getCurrentLoggers();
		ActiveLoggerGroup group = new ActiveLoggerGroup();

		// add 'root' logger

		ActiveLogger activeRootLogger = new ActiveLogger();
		org.apache.log4j.Logger rootLogger = LogManager.getRootLogger();
		activeRootLogger.setName(rootLogger.getName());
		activeRootLogger.setCurrentLevel(rootLogger.getLevel().toString());
		group.getActiveLoggers().add(activeRootLogger);

		// add 'children' loggers. Those from the configuration file and those
		// found during class instantiation.
		while (enumeration.hasMoreElements()) {
			org.apache.log4j.Logger frameworkLogger = (org.apache.log4j.Logger) enumeration
					.nextElement();

			ActiveLogger activeLogger = new ActiveLogger();
			activeLogger.setName(frameworkLogger.getName());
			if (frameworkLogger.getLevel() == null) {
				activeLogger.setCurrentLevel(frameworkLogger.getParent()
						.getLevel().toString());
			} else {
				activeLogger.setCurrentLevel(frameworkLogger.getLevel()
						.toString());
			}
			group.getActiveLoggers().add(activeLogger);

		}

		return Response.ok().entity(group).build();

	}

	@POST
	@Path("/update/{logger}/{level}")
	public Response updateActiveLogger(
			@PathParam("logger") final String loggerName,
			@PathParam("level") final String level) {

		logger.debug("Entering updateActiveLogger()");

		DynamicLoggerMessage message = new DynamicLoggerMessage();
		message.setLevel(level);
		message.setLogger(loggerName);
		if (context.getUserPrincipal() == null) {
			return Response
					.status(Status.NOT_ACCEPTABLE)
					.entity("User Login required to process update to logger level")
					.build();
		} else {
			message.setPrincipal(context.getUserPrincipal());
			dynamicLoggerMessager.sendMessage(message);
			return Response.ok().build();
		}

	}
}
