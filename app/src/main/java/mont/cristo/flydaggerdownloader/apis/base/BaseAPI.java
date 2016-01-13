package mont.cristo.flydaggerdownloader.apis.base;

import java.util.Map;


public abstract class BaseAPI implements APICallable, APICancellable {
    protected static final String URL_SERVER_BASE = "http://???";
    private RequestListener requestListener;
    private RequestTask taskCallAPI;

    public BaseAPI(RequestListener requestListener) {
        this.requestListener = requestListener;
    }

    protected abstract Map<String, String> getBodyParams();

    protected abstract String getAPIUrl();

    @Override
    public void call() {
        taskCallAPI = new RequestTask(requestListener, getBodyParams());
        taskCallAPI.execute(getAPIUrl());
    }

    @Override
    public void cancel() {
        taskCallAPI.cancel(true);
    }
}
