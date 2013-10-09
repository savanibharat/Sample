package com.dropbox.cmpe.Dropbox;

import java.util.Scanner;
import javax.ws.rs.Path;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.dropbox.cmpe.Dropbox.api.resources.DocumentResource;
import com.dropbox.cmpe.Dropbox.api.resources.RootResource;
import com.dropbox.cmpe.Dropbox.config.*;;

/**
 * CMPE 273 - Dropbox using amazon Glacier
 * Author: Team Projections
 *
 */

public class DropboxService extends Service<DropboxServiceConfiguration> 
{
    public static void main( String[] args )throws Exception
    {
    	new DropboxService().run(args);
    }
    
    @Override
    public void initialize(Bootstrap<DropboxServiceConfiguration> bootstrap) {
	bootstrap.setName("dropbox-service");
    }
    
    @Override
    public void run(DropboxServiceConfiguration configuration,
    	    Environment environment) throws Exception {
    	//Added root resource - kept nothing as of now.
    	environment.addResource(RootResource.class);
    	//Added Document resource API to handle file uploading
    	environment.addResource(DocumentResource.class);
    }
}