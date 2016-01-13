package mont.cristo.flydaggerdownloader.apis.factory;

import mont.cristo.flydaggerdownloader.apis.GetDownloadUrlAPI;
import mont.cristo.flydaggerdownloader.apis.base.BaseAPI;
import mont.cristo.flydaggerdownloader.apis.base.RequestListener;

public class APIFactory {
    private APIFactory() {

    }

    public static BaseAPI getAPI(APIType apiType, RequestListener requestListener) {
        switch (apiType) {
            case GET_DOWNLOAD_URL:
                return new GetDownloadUrlAPI(requestListener);
            default:
                return new GetDownloadUrlAPI(requestListener);
        }
    }
}
