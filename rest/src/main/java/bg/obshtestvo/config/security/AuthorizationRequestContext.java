package bg.obshtestvo.config.security;

public class AuthorizationRequestContext {

    private final String requestUrl;

    private final String httpMethod;

    private final String requestDateString;

    private final String nonceToken;

    private final String authorizationToken;

    public AuthorizationRequestContext(String requestUrl, String httpMethod, String requestDateString, String nonceToken, String hashedToken) {
        this.requestUrl = requestUrl;
        this.httpMethod = httpMethod;
        this.requestDateString = requestDateString;
        this.nonceToken = nonceToken;
        this.authorizationToken = hashedToken;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRequestDateString() {
        return requestDateString;
    }

    public String getNonceToken() {
        return nonceToken;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }
}
