package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.handlers;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.AstericsClient;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaRequestJson;
import at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model.AlexaResponseJson;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class ApplicationLaunchIntent implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("ApplicationLaunchIntent"));
    }
    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
        Intent intent = request.getIntent();

        AlexaRequestJson json = new AlexaRequestJson();
        json.setDeviceType("APPLICATION");

        Slot nameSlot = intent.getSlots().getOrDefault("applicationName", null);
        String value = nameSlot.getValue();
        if (value.equals("text editor") || value.equals("notepad")) {
            json.setPayload("NOTEPAD");
        } else if (value.equals("steam")) {
            json.setPayload("STEAM");
        } else {
            json = null;
        }

        String statusMessage = "I launched the app " + value + "for you.";
        if (json != null) {
            AlexaResponseJson response = AstericsClient.performRequest(json);
            if (response != null) {
                statusMessage = "An error occurred while sending the request: " + response.getMessage();
            }
        } else {
            statusMessage = "Sorry! The app " + value + " is not supported.";
        }

        return handlerInput.getResponseBuilder()//
                .withShouldEndSession(false)//
                .withSpeech(statusMessage)//
                .build();
    }
}
