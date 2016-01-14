package mont.cristo.flydaggerdownloader.apis;

import mont.cristo.flydaggerdownloader.apis.base.BaseAPI;
import mont.cristo.flydaggerdownloader.apis.base.RequestListener;
import mont.cristo.flydaggerdownloader.apis.getdownloadurl.GetDownloadUrlAPI;

public class APIFactory {
    private APIFactory() {

    }

    public static BaseAPI getAPI(APIType apiType, RequestListener requestListener) {
        switch (apiType) {
            case GET_DOWNLOAD_URL:
                return new GetDownloadUrlAPI(requestListener, null);
            default:
                return new GetDownloadUrlAPI(requestListener, null);
        }
    }
}
