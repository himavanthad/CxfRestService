package com.lessonslab.cxfrestservice;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lessonslab.cxfrestservice.model.Employee;

/**
 * 
 * @author lessonslab.com
 * This is interface for the employee services
 *
 */
@Path("/")
@WebService(name="employeeService", targetNamespace="http://www.lessonslab.com/cxf-rest/example")
public interface CxfRestService 
{
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getemployeedetail/{employeeId}")
	public Response getEmployeeDetail(@PathParam("employeeId") String employeeId);
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/getemployeedetails")
	public Employee getEmployeeDetails(@QueryParam("employeeId") String employeeId);
	
}
