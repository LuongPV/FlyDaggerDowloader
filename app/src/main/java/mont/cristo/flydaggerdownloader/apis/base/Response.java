package mont.cristo.flydaggerdownloader.apis.base;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private String message;

}
