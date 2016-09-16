package com.pluralsight;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.models.Activity;
import com.pluralsight.models.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@DELETE
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteActivity (@PathParam ("activityId") String activityId) {
		
		System.out.println(activityId);
		
		activityRepository.delete(activityId);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateActivity (Activity act) {
		
		System.out.println(act.getId());
		
		act = activityRepository.update(act);
		
		return Response.ok().entity(act).build();
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity (Activity act) {
		
		System.out.println(act.getDescription());
		System.out.println(act.getDuration());
		
		activityRepository.create(act);
		
		return act;
	}
		
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParams (MultivaluedMap<String, String> formParams) {
		
		
		
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity act = new Activity();
		act.setDescription(formParams.getFirst("description"));
		act.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		activityRepository.create(act);
		 
		return act;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities () {
		return activityRepository.findAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}")
	public Response getActivity (@PathParam ("activityId") String activityId) {
		
		if(activityId == null || activityId.length() < 4 ) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity act = activityRepository.findActivity(activityId);
		
		if(act == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(act).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user")
	public User getActivityUser (@PathParam ("activityId") String activityId) {
		return activityRepository.findActivity(activityId).getUser();
	}

}
