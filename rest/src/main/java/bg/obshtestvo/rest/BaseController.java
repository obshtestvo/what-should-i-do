package bg.obshtestvo.rest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bg.obshtestvo.model.ErrorEntity;

public abstract class BaseController {
	public static Response buildResponse(Object entity) {
		return Response.ok(entity)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	public static Response buildErrorResponse(ErrorEntity errorEntity) {
		return Response.status(errorEntity.getStatus()).entity(errorEntity).build();
	}
}
