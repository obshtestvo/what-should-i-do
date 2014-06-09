package bg.obshtestvo.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import bg.obshtestvo.model.Item;
import bg.obshtestvo.service.ItemService;

@Component
@Path("items")
public class ItemController extends BaseController {

	@Autowired
	private ItemService itemService;
	
	@GET
	@Path("/{id}")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public Response getItem(@PathParam("id") Long itemId) {
		return Response.ok(itemService.findItem(itemId))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	@GET
	public Response getAllItems() {
		return Response.ok(itemService.findAllItems())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	
	@GET
	@Path("/{id}/answers")
	public Response getAnswersForQuestion(@PathParam("id") Long itemId) {
		return Response.ok(itemService.findAnswersForItem(itemId))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteItem(@PathParam("id") Long itemId) {
		itemService.removeItem(itemId);
	}
	
	@POST
	public void createItem(Item item) {
		itemService.createOrUpdateItem(item);
	}
	
	@PUT
	public void updateItem(Item item) {
		itemService.createOrUpdateItem(item);
	}
	
	@GET
	@Path("/search")
	public Response findItem(@QueryParam("q") String searchString) {
		return Response.ok(itemService.findItems(searchString))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
}
