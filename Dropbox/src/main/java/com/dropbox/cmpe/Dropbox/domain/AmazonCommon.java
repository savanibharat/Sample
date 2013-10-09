package com.dropbox.cmpe.Dropbox.domain;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.model.CreateVaultRequest;
import com.amazonaws.services.glacier.model.CreateVaultResult;

/**
 * @author Team Projections
 * This class contains methods which will have common amazon functions which we need
 * for every operation that we will perform on amazon glacier.
 *
 */
public class AmazonCommon {	
	/**
	 * @param credentials
	 * @return AmazonGlacierClient
	 */
	public AmazonGlacierClient getClient(AWSCredentials credentials){
		AmazonGlacierClient client = new AmazonGlacierClient(credentials);
		client.setEndpoint("https://glacier.us-west-1.amazonaws.com/");
		return client;
	}
	
	/**
	 * @return AWSCredentials
	 */
	public AWSCredentials getCredentials(){
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIGAO6XZRPVYRW5NQ", "HfLq+HKcH83NODmGtxYc/umd9JDP8j2Nq//vehf8");
		return credentials;
	}
	
	/**
	 * @param vaultName
	 * @param client
	 * @return CreateVaultResult
	 */
	public CreateVaultResult createVault(String vaultName, AmazonGlacierClient client)
	{
		CreateVaultRequest request = new CreateVaultRequest().withVaultName(vaultName);
		CreateVaultResult result = client.createVault(request);
		if(result!=null){
			System.out.println("Created vault successfully: " + result.getLocation());
		}
		else{
			System.out.println("ERROR IN CREATING VAULT ");
		}
		return result;
	}
}