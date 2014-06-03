package bg.obshtestvo.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Hello world!
 * 
 */
public class Application extends ResourceConfig{
	public Application() {
		register(RequestContextFilter.class);
	}
}
