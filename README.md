dynamicLogger
=============

A solution to log4j log level changes while the application is running.  The design is cenetered around a cluster of JVMs that are listening on the same Topic.  There are two implementations of the code.

JEE 6
=============  
The JEE6 version can be run using WebSphere Liberty 8.5.5.2 via a server.xml file in the WARs META-INF directory.
The login password is admin123 for the included HTML pages.  The final EAR size is 1.6 MB.

Spring
=============
The Spring version can be run using an included Maven Tomcat plugin, tomcat7:run to execute.
The login password is admin123 for the included HTML pages.  The final EAR size is 9.7 MB.
The Spring version could run on a full JEE server such as WebSphere.  In my experience, you would have to flip the classloader and remove conflicting JARs from the final build.
