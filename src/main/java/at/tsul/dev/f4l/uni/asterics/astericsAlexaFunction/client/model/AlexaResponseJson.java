package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model;

public class AlexaResponseJson {

    private String message;

    public AlexaResponseJson () {
    }
    public AlexaResponseJson (String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
