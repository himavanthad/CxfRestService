package com.lessonslab.cxfrestservice.test;

import java.math.BigInteger;
import java.util.Arrays;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lessonslab.cxfrestservice.model.Employee;

public class WebServiceTest {
    private static WebClient client;
    
    private static final String BASE_URL = "http://localhost:8090/CxfRestService-1.0.0-SNAPSHOT/rest/employeeservices";

    @Before
    public void before() throws Exception {
    	client = CreateWebClient.getWebClient(BASE_URL, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON);
    }
    
    @After
    public void Destroy() throws Exception {
    	client = null;
    }

  
    @Test
    public void getEmployeeDetail(){
    	String requestPath = "/getemployeedetail";
    	client.path(requestPath);
    	client.path("employeeId", 251);
    	Response response = client.get();
    	Employee pagResponse = response.readEntity(Employee.class);
    	Assert.assertNotNull(pagResponse);
    }
    
    @Test
    public void getEmployeeDetails(){
    	String requestPath = "/getemployeedetails";
    	client.path(requestPath);
    	client.query("employeeId", 251);
    	Response response = client.get();
    	Employee pagResponse = response.readEntity(Employee.class);
    	Assert.assertNotNull(pagResponse);
    }
    
   /* @Test
    public void testRestWebServicePositioningPAO(){
    	String requestPath = "/positioningPAO";
    	client.path(requestPath);
    	client.query("customerId", BigInteger.valueOf(14807259));
    	client.query("canvassCode", "BU");
    	client.query("canvassOrdinalNum", "I1");
    	Response response = client.get();
    	PositioningPAOResponse paoResponse = response.readEntity(PositioningPAOResponse.class);
    	Assert.assertNotNull(paoResponse);
    	Assert.assertNotNull(paoResponse.getPositioningPAO());
    }
    
    @Test
    public void testRestWebServiceCallCounter(){
    	String requestPath = "/callCounter";
    	client.path(requestPath);
    	client.query("customerId", 109041);
    	Response response = client.get();
    	String callCounterResponse = response.readEntity(String.class);
    	Assert.assertNotNull(callCounterResponse);
    }
    
	@Test
    public void testCarterasCercanas_validRequest(){
    	String requestPath = "/carterasCercanas";	
    	client.path(requestPath);
    	client.query("customerId", BigInteger.valueOf(263557357));
    	client.query("canvassCode", "CA");
    	client.query("canvassOrdinalNum", "K1");
    	Response response = client.get();
    	String carterasCercanasList = response.readEntity(String.class);
    	Assert.assertNotNull(carterasCercanasList);
    }
	
	@Test
    public void testAccionesMkt_validRequest(){
    	String requestPath = "/accionesMkt";
    	client.path(requestPath);
    	Response response = client.get();
		String accionesMktResponseStr = response.readEntity(String.class);
		Assert.assertNotNull(accionesMktResponseStr);
    }
	
	@Test
    public void testSugerencias_validRequest(){
    	String requestPath = "/sugerencias";
    	client.path(requestPath);
    	client.query("customerId", BigInteger.valueOf(258458900));
    	client.query("canvassCode", "ZZ");
    	client.query("canvassOrdinalNum", "I1");
    	Response response = client.get();
		String sugerenciasResponseStr = response.readEntity(String.class);
		Assert.assertNotNull(sugerenciasResponseStr);
    }

	@Test
	public void testClieBusImpacProducto() {
		String requestPath = "/clieBusImacProducto/"+BigInteger.valueOf(4005005) ; 
		client.path(requestPath);
		Response response = client.get();
		ClientBusinessImpactProductResponse clieBusImpacResponse = response.readEntity(ClientBusinessImpactProductResponse.class);
		Assert.assertNotNull(clieBusImpacResponse);
				
	}
	
	@Test
    public void testContractDiscounts(){
        String requestPath = "/contractDiscounts";
        
        client.path(requestPath);
        client.query("customerId", BigInteger.valueOf(263552739));
        client.query("salesRepId", "3895");
        client.query("salesPeriodCode", "VDK1BA - BADAJOZ");
        Response response = client.get();
        String contractDiscountsResponseStr = response.readEntity(String.class);
        Assert.assertNotNull(contractDiscountsResponseStr);
    }
	
	@Test
	public void testCustomerAttributes_validRequest() {
		String requestPath = "/customerAttributes";
		client.path(requestPath);
		client.query("customerId", BigInteger.valueOf(258458900));
		client.query("salesRep", "3391");
		client.query("salesPeriodCode", "VADKINA-NAVARA");
		Response response = client.get();
		CustomerAttributes customerAttributes = response.readEntity(CustomerAttributes.class);
		Assert.assertNotNull(customerAttributes);
	}
	
	@Test
	public void testCustomerEngagement_validRequest() {
		String requestPath = "/customerEngagement";
		WebClient client = setupClient();
		client.path(requestPath);
		client.query("customerId", BigInteger.valueOf(252745187));
		client.query("salesPeriodCode", "VDE1LC - CORUÃ‘A");
		client.encoding("UTF-8");
		Response response = client.get();
		CustomerEngagementResponse customerEngagementResponse = response.readEntity(CustomerEngagementResponse.class);
		Assert.assertNotNull(customerEngagementResponse);
		Assert.assertNotNull(customerEngagementResponse.getCustomerItemInfo().get(0).getContractId());
	}
	
	@Test
	public void testContactInfo_validRequest() {
		String requestPath = "/customerContactInfo";
		WebClient client = setupClient();
		client.path(requestPath);
		client.query("customerId", BigInteger.valueOf(14281596));
		long initalTime = System.currentTimeMillis();
		Response response = client.get();
		CustomerContactInfoResponse contactInfoResponse = response.readEntity(CustomerContactInfoResponse.class);
		long finalTime = System.currentTimeMillis();
		System.out.println(finalTime-initalTime+" : time taken");
		Assert.assertNotNull(contactInfoResponse);
	}
	
	private WebClient setupClient(){
		  WebClient client=WebClient.create(BASE_URL, Arrays.asList(new JacksonJsonProvider()));
		  client.type(MediaType.APPLICATION_JSON+ ";charset=utf-8").accept(MediaType.APPLICATION_JSON+ ";charset=utf-8");
		  HTTPConduit http=(HTTPConduit)WebClient.getConfig(client).getConduit();
		  HTTPClientPolicy httpClientPolicy=new HTTPClientPolicy();
		  httpClientPolicy.setConnectionTimeout(60000);
		  httpClientPolicy.setReceiveTimeout(0);
		  http.setClient(httpClientPolicy);
		  return client;
	}
*/
	
	static class CreateWebClient {
		
		public static WebClient getWebClient(String baseUrl, String requestType, String responseType) {
			
			WebClient client = WebClient.create(baseUrl, Arrays.asList(new JacksonJsonProvider()));
			client.type(requestType).accept(responseType);
			return client;
		}
		
			}
}
