package bg.obshtestvo.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class Application extends ResourceConfig{
	public Application() {
		//Jersey - Spring bridge
		register(RequestContextFilter.class);
		//Jackson
		register(JacksonFeature.class);
	}
}
