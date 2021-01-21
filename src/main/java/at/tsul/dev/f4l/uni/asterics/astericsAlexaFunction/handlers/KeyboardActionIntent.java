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

public class KeyboardActionIntent implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.matches(Predicates.intentName("KeyboardActionIntent"));
    }
    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        String statusMessage = "Sorry. I can not do that.";

        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
        Intent intent = request.getIntent();

        AlexaRequestJson json = new AlexaRequestJson();
        json.setDeviceType("KEYBOARD");

        Slot keyCombination = intent.getSlots().getOrDefault("keyCombination", null);
        if (keyCombination.getValue().equals("new line")) {
            json.setPayload("{ENTER}");
            AlexaResponseJson response = AstericsClient.performRequest(json);
            if (response == null) {
                statusMessage = keyCombination.getValue() + " entered.";
            } else {
                statusMessage = "An error occurred while sending the request: " + response.getMessage();
            }
        }

        return handlerInput.getResponseBuilder()//
                .withShouldEndSession(false)//
                .withSpeech(statusMessage)//
                .build();
    }
}
