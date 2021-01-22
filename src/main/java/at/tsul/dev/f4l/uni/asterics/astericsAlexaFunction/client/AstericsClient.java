package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.core.RestEasyProvider;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaRequestJson;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaResponseJson;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AstericsEndpoint;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;

import javax.ws.rs.core.Response;

/**
 * This class offers access to the Asterics Plugin by performing HTTP request with the given payload.
 *
 * IMPORTANT: AWS lambda function environment variable "astericsUrl" has to be set to work.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public class AstericsClient {

    /**
     * Performs an HTTP POST request using {@link ResteasyClient} and the given model.
     *
     * @param json the payload of the HTTP POST request
     * @return an {@link AlexaResponseJson} containing the error message in case of an error or <code>null</code> if everything went well.
     */
    public static AlexaResponseJson performRequest (AlexaRequestJson json) {
        ResteasyClient client = RestEasyProvider.getClient();
        AstericsEndpoint asterics = RestEasyProvider.getProxy(client, getUrl(), AstericsEndpoint.class);

        Response response = asterics.triggerAction(json);

        AlexaResponseJson alexaResponseJson = null;
        if (response.getStatus() != 204) {
            alexaResponseJson = response.readEntity(AlexaResponseJson.class);
        }

        client.close();
        return alexaResponseJson;
    }

    private static String getUrl () {
        return System.getenv("astericsUrl");
    }
}
