package mont.cristo.flydaggerdownloader.apis.getdownloadurl;

import java.util.HashMap;
import java.util.Map;

import mont.cristo.flydaggerdownloader.apis.base.BaseAPI;
import mont.cristo.flydaggerdownloader.apis.base.RequestListener;

public class GetDownloadUrlAPI extends BaseAPI {
    public static final String URL_SERVER_REGISTER_DEVICE_ID = URL_SERVER_BASE + "/download_url";
    public static final String PARAM_SERVER_REGISTER_DEVICE_ID = "deviceId";
    public static final String PARAM_SERVER_REGISTER_SECRET_KEY = "secretKey";
    public static final String PARAM_SERVER_PLATFORM_ANDROID = "platform";
    public static final String VALUE_SERVER_PLATFORM_ANDROID = "3";
    private Authentication authentication;

    public GetDownloadUrlAPI(RequestListener requestListener, Authentication authentication) {
        super(requestListener);
        this.authentication = authentication;
    }

    @Override
    protected Map<String, String> getBodyParams() {
        Map<String, String> mapParams = new HashMap<>();
        mapParams.put(PARAM_SERVER_REGISTER_DEVICE_ID, authentication.getDeviceId());
        mapParams.put(PARAM_SERVER_REGISTER_SECRET_KEY, authentication.getSecretKey());
        mapParams.put(PARAM_SERVER_PLATFORM_ANDROID, VALUE_SERVER_PLATFORM_ANDROID);
        return mapParams;
    }

    @Override
    protected String getAPIUrl() {
        return URL_SERVER_REGISTER_DEVICE_ID;
    }

}
