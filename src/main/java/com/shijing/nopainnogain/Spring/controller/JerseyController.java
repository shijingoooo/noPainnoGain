package com.shijing.nopainnogain.Spring.controller;

import com.shijing.nopainnogain.Spring.vo.UserVo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user/")
public class JerseyController {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserVo hello(@PathParam("id") Long id) {
        UserVo user = new UserVo();
        user.setId(id);
        user.setName("H");

        return user;
    }

}
