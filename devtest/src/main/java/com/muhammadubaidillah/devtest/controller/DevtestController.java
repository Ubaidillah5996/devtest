package com.muhammadubaidillah.devtest.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonString;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import com.muhammadubaidillah.devtest.dto.DevtestReq;
import com.muhammadubaidillah.devtest.dto.DevtestResp;
import com.muhammadubaidillah.devtest.model.Devtest;
import com.muhammadubaidillah.devtest.service.DevtestService;

import oracle.jdbc.driver.JsonWebToken;

@Path("/v1/devtest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed({"User"})
@RequestScoped
//@SecuritySchemes(value = {
//        @SecurityScheme(
//                securitySchemeName = "accessToken",
//                type = SecuritySchemeType.HTTP,
//                scheme = "bearer",
//                apiKeyName = "Authorization: Bearer",
//                bearerFormat = "jwt"
//        )
//})

public class DevtestController {
	
//	@Inject
//    JsonWebToken jwt;
	
	@Inject
	DevtestService devtestService;
	
	@Path("/save")
    @POST
    public DevtestResp SaveAndUpdateDevtest(DevtestReq request) throws Exception {
        return devtestService.saveUpdate(request);
    }
	
	@Path("/delete")
    @DELETE
    public DevtestResp deleteDevtest(DevtestReq request) throws Exception {
        return devtestService.delete(request);
    }
	
	@Path("/getDevtest")
    @GET
    public List<Devtest> getDevtest(DevtestReq request) {
        return devtestService.getDevtest(request);
    }

}
