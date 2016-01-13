package mont.cristo.flydaggerdownloader.apis.base;

import android.os.AsyncTask;

import java.util.Map;

public class RequestTask extends AsyncTask<String, Void, Response> {
    private RequestListener requestListener;
    private Map<String, String> paramsBody;

    public RequestTask(RequestListener requestListener, Map<String, String> bodyParams) {
        this.requestListener = requestListener;
        this.paramsBody = bodyParams;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        requestListener.onPrepareRequest();
    }

    @Override
    protected Response doInBackground(String... params) {
        return new Response();
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        requestListener.onRequestDone(response);
    }
}
