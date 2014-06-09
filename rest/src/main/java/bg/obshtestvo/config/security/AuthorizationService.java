package bg.obshtestvo.config.security;

import bg.obshtestvo.model.User;

public interface AuthorizationService {

    /**
     * Given an AuthorizationRequestContext validate and authorize a User
     *
     * @param authorizationRequestContext the context required to authorize a user for a particular request
     * @return ExternalUser
     */
    public User authorize(AuthorizationRequestContext authorizationRequestContext);
}
