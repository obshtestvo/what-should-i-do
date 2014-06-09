package bg.obshtestvo.config.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import bg.obshtestvo.model.Role;
import bg.obshtestvo.model.User;

public class SecurityContextImpl implements SecurityContext {

	private final User user;

	public SecurityContextImpl(User user) {
		this.user = user;
	}

	@Override
	public boolean isUserInRole(String role) {
		if(role.equalsIgnoreCase(Role.ANONYMOUS.name())) {
	         return true;
	    }
	    if(user == null) {
	        throw new RuntimeException("InvalidAuthorizationHeader");
	    }
	    System.out.println(String.format("SecurityContextImpl / isUserInRole - role:%s, user:%s", role, user));
	    return user.getRole().equalsIgnoreCase(role);
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public Principal getUserPrincipal() {
		return user;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

}
