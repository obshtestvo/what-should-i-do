package bg.obshtestvo.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import bg.obshtestvo.config.security.SecurityInterceptor;

public class Application extends ResourceConfig{
	public Application() {
		// Validation errors won't be sent to the client.
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	    // @ValidateOnExecution annotations on subclasses won't cause errors.
	    property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
		//Jersey - Spring bridge
		register(RequestContextFilter.class);
		//Jackson
		register(JacksonFeature.class);
		//Security Interceptor
		register(SecurityInterceptor.class);
	}
}
