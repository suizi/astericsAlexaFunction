package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface AstericsEndpoint {

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/alexa")
    Response triggerAction (AlexaRequestJson json);
}



