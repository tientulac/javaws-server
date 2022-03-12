package com.components.javawsserver.resource;
import com.components.javawsserver.entities.Employee;
import com.components.javawsserver.repository.JpaRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("employee")
public class EmployeeResource {
    JpaRepository<Employee> jpaEmployee = new JpaRepository<Employee>(Employee.class);

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.status(Response.Status.OK).entity(jpaEmployee.findAll()).build();
        }
        catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(null).build();
        }
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        try {
            return Response.status(Response.Status.OK).entity(jpaEmployee.findById(id)).build();
        }
        catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(null).build();
        }
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Employee employee) {
        try {
            boolean result = jpaEmployee.save(employee);
            if (result) {
                return Response.status(Response.Status.CREATED).entity(employee).build();
            }
            else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
        catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


    @PUT()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Employee employee) {
        try {
            List<Employee> checkExist = jpaEmployee.findById(employee.getId());
            if (checkExist.size() > 0) {
                boolean result = jpaEmployee.update(employee);
                if (result) {
                    return Response.status(Response.Status.OK).entity(employee).build();
                }
                else {
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }
            }
            else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
        catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id) {
        try {
            boolean result = jpaEmployee.delete(id);
            if (result) {
                return Response.status(Response.Status.OK).entity(result).build();
            }
            else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
        catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
