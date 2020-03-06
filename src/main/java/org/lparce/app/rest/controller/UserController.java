package org.lparce.app.rest.controller;

import org.lparce.app.core.entity.User;
import org.lparce.app.core.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService service;

    @POST
    public Map<String, String> createUser(User user) {
        this.service.createUser(user.getName());
        return Collections.singletonMap("message", "OK");
    }

    @GET
    public List<User> getUsers() {
        return this.service.getUsers();
    }
}