package mont.cristo.flydaggerdownloader.apis.base;

public interface RequestListener {

    void onPrepareRequest();
    
    void onRequestDone(Response response);
}