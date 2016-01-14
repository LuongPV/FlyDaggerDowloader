package mont.cristo.flydaggerdownloader.apis.getdownloadurl;

public class Authentication {
    private String deviceId;
    private String secretKey;

    public Authentication(String deviceId, String secretKey) {
        this.deviceId = deviceId;
        this.secretKey = secretKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
