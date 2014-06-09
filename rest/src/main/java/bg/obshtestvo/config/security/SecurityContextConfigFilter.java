package bg.obshtestvo.config.security;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.springframework.beans.factory.annotation.Autowired;

import bg.obshtestvo.model.User;

@Priority(Priorities.AUTHENTICATION)
public class SecurityContextConfigFilter implements ContainerRequestFilter {

	protected static final String HEADER_AUTHORIZATION = "Authorization";

	protected static final String HEADER_DATE = "x-java-rest-date";

	protected static final String HEADER_NONCE = "nonce";

	@Autowired
	private AuthorizationService authorizationService;
	
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		System.out.println("SecurityContextFilter / filter("
				+ printContainerRequestContext(requestContext) + ")");
		String authToken = requestContext.getHeaderString(HEADER_AUTHORIZATION);
		String requestDateString = requestContext.getHeaderString(HEADER_DATE);
		String nonce = requestContext.getHeaderString(HEADER_NONCE);
		AuthorizationRequestContext context = new AuthorizationRequestContext(
				requestContext.getUriInfo().getPath(),
				requestContext.getMethod(), requestDateString, nonce, authToken);
		User externalUser = authorizationService.authorize(context);
		requestContext
				.setSecurityContext(new SecurityContextImpl(externalUser));
		System.out
				.println(String
						.format(" END OF SecurityContextFilter / filter - AuthorizationRequestContext: %s, externalUser:%s",
								context, externalUser));
	}

	private String printContainerRequestContext(ContainerRequestContext requestContext) {
	    return String.format("[ContainerRequestContext:%s]", requestContext);
	}
	
}
