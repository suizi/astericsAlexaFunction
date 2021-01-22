package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model;

/**
 * The POJO representation of the Json payload that can be received as anwer to a HTTP request.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public class AlexaResponseJson {

    /**
     * The message holding data in case of an error.
     */
    private String message;

    /**
     * Constructor for jackson object mapper.
     */
    public AlexaResponseJson () {
    }

    /**
     * Constructor creating an {@link AlexaResponseJson}.
     *
     * @param message the message
     */
    public AlexaResponseJson (String message) {
        this.message = message;
    }

    /**
     * Getter for message.
     *
     * @return the message as String
     */
    public String getMessage () {
        return message;
    }

    /**
     * Setter for message.
     *
     * @param message the message as String
     */
    public void setMessage (String message) {
        this.message = message;
    }
}
