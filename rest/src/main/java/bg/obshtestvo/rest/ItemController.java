package bg.obshtestvo.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.obshtestvo.model.Item;
import bg.obshtestvo.service.ItemService;

@Component
@Path("items")
@PermitAll
public class ItemController extends BaseController {

	@Autowired
	private ItemService itemService;
	
	@GET
	@Path("/{id}")
	public Response getItem(@PathParam("id") Long itemId) {
		return BaseController.buildResponse(itemService.findItem(itemId));
	}
	
	@GET
	public Response getAllItems() {
		return BaseController.buildResponse(itemService.findAllItems());
	}
	
	
	@GET
	@Path("/{id}/answers")
	public Response getAnswersForQuestion(@PathParam("id") Long itemId) {
		return BaseController.buildResponse(itemService.findAnswersForItem(itemId));
	}
	
	@DELETE
	@RolesAllowed("ADMIN")
	@Path("/{id}")
	public void deleteItem(@PathParam("id") Long itemId) {
		itemService.removeItem(itemId);
	}
	
	@POST
	@RolesAllowed({"USER","ADMIN"})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createItem(Item item) {
		itemService.createOrUpdateItem(item);
	}
	
	@PUT
	@RolesAllowed({"USER","ADMIN"})
	public void updateItem(Item item) {
		itemService.createOrUpdateItem(item);
	}
	
	@GET
	@Path("/search")
	public Response findItem(@QueryParam("q") String searchString) {
		return BaseController.buildResponse(itemService.findItems(searchString));
	}
	
	@POST
	@RolesAllowed({"USER","ADMIN"})
	@Path("/{id}/tags")
	public void addTagsToItem(@PathParam("id") Long itemId, List<String> tags) {
		
	}
}
