package com.the.mild.project.server.resources;

import static com.the.mild.project.server.util.ResourceConfig.PATH_TEST_RESOURCE_WITH_PARAM;
import static com.the.mild.project.server.util.ResourceConfig.PATH_TEST_RESOURCE_WITH_PARAM_ID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the.mild.project.server.jackson.ParamTest;
import com.the.mild.project.server.jackson.util.JacksonHandler;

@Path(PATH_TEST_RESOURCE_WITH_PARAM)
public class ResourceWithParam {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPrinter(@PathParam(PATH_TEST_RESOURCE_WITH_PARAM_ID) String id) {
        final ParamTest test = new ParamTest(id);

        return JacksonHandler.stringify(test);
    }
}
