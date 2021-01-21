package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.core.RestEasyProvider;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaRequestJson;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaResponseJson;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AstericsEndpoint;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;

import javax.ws.rs.core.Response;

public class AstericsClient {

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
