package com.lessonslab.cxfrestservice.internal;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.lessonslab.cxfrestservice.CxfRestService;
import com.lessonslab.cxfrestservice.dao.EmployeeDao;
import com.lessonslab.cxfrestservice.model.Employee;

public class CxfRestServiceImpl implements CxfRestService 
{
	@Autowired
	private EmployeeDao employeeDao; 

	@Override
	public Response getEmployeeDetail(String employeeId) 
	{
		if(employeeId == null)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}		
		return Response.ok(employeeDao.getEmployeeDetails(employeeId)).build();
	}

	@Override
	
	public Employee getEmployeeDetails(String employeeId) {
System.out.println("getEmployeeDetails : "+employeeId);
		return employeeDao.getEmployeeDetails(employeeId);
	}
}
