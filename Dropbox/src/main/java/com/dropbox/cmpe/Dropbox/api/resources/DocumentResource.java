//DocumentResource
package com.dropbox.cmpe.Dropbox.api.resources;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.transfer.ArchiveTransferManager;
import com.amazonaws.services.glacier.transfer.UploadResult;
import com.dropbox.cmpe.Dropbox.domain.AmazonCommon;
import com.yammer.metrics.annotation.Timed;
/**
 * @author Team Projection
 *
 */
@Path("v1/documents")
public class DocumentResource {

	AmazonGlacierClient client;

	@POST
	@Path("upload")
	@Timed(name="upload-file")
	public Response uploadFile(@QueryParam("filepath") String filePath) throws IOException
	{
		//to test
		System.out.println("Inside file upload method");
		System.out.println("FilePath is : "+filePath);
		String vaultName="myvault1";
		String filePathUpload=filePath;

		/*
		 * ensured that the file is on your classpath, then you should have everything correct.
		 */
		
		AmazonCommon common = new AmazonCommon();
		AWSCredentials credentials = common.getCredentials();
		AmazonGlacierClient client = common.getClient(credentials);
		
		//Create this vault only if user is new
		//CreateVaultResult vaultresult = common.createVault(vaultName, client);
		
		boolean result = uploadFileOnGlacier(client,credentials,filePathUpload,vaultName);
		
		if(result==true){
			//Display message that file is uploaded
			System.out.println("Operation Successful");
			return Response.ok().build();
		}
		else{
			//Display message that file is not uploaded
			System.out.println("OPERATION UNSUCCESSFUL");
			return Response.ok().build();
		}
	}