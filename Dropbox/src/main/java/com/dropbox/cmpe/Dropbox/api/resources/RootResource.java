//Root resource
package com.dropbox.cmpe.Dropbox.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.yammer.metrics.annotation.Timed;

/**
 * @author Team Projections
 *
 */

@Path("/v1")

public class RootResource {

	@GET
    @Timed(name = "get-root")
    
	public Response getRoot() {
	
		System.out.println("Hit Root");
		return Response.ok().build();
		
    }
}