package at.tsul.dev.f4l.uni.asterics.astericsAlexaFunction.client.model;

/**
 * The POJO representation of the Json payload used to send to the Asterics plugin instance.
 *
 * @author Thomas Sulzbacher
 * @author Lisa Fixl
 */
public class AlexaRequestJson {

    /**
     * Used to identify the targets functionality (mostly a device: eg. MOUSE, KEYBOARD, APPLICATION)
     */
    private String deviceType;

    /**
     * The data needed for executing the requested operation.
     */
    private String payload;

    /**
     * Constructor for jackson object mapper.
     */
    public AlexaRequestJson () {
    }

    /**
     * Constructor creating an {@link AlexaRequestJson}.
     *
     * @param deviceType the device type
     * @param payload the payload
     */
    public AlexaRequestJson (String deviceType, String payload) {
        this.deviceType = deviceType;
        this.payload = payload;
    }

    /**
     * Getter for deviceType
     *
     * @return the deviceType as String
     */
    public String getDeviceType () {
        return deviceType;
    }

    /**
     * Getter for payload.
     *
     * @return the payload as String
     */
    public String getPayload () {
        return payload;
    }

    /**
     * Setter for deviceType.
     *
     * @param deviceType the deviceType as String
     */
    public void setDeviceType (String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Setter for payload.
     *
     * @param payload the payload as String
     */
    public void setPayload (String payload) {
        this.payload = payload;
    }

    @Override
    public String toString () {
        return "AlexaRequestJson [deviceType=" + deviceType + ", payload=" + payload + "]";
    }
}
