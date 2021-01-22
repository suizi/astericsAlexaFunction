package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * JaxRS annotated endpoint definition.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public interface AstericsEndpoint {

    /**
     * Performs a HTTP POST request.
     *
     * @param json the {@link AlexaRequestJson} to send within the request
     * @return a {@link Response} object containing status code and a body in case of an error
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/alexa")
    Response triggerAction (AlexaRequestJson json);
}



