package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.AstericsClient;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaRequestJson;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaResponseJson;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class MouseActionIntent implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("MouseActionIntent"));
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        AlexaResponseJson response = AstericsClient.performRequest(new AlexaRequestJson("MOUSE", "RIGHT_CLICK"));

        String statusMessage = "I clicked for you.";
        if (response != null) {
            statusMessage = "An error occurred while sending the request: " + response.getMessage();
        }

        return handlerInput.getResponseBuilder()//
                .withShouldEndSession(false)//
                .withSpeech(statusMessage)//
                .withReprompt(statusMessage)//
                .build();
    }
}
