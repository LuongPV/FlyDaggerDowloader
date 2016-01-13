package mont.cristo.flydaggerdownloader.views.adapters;

import com.google.common.io.Files;

import java.io.File;

import mont.cristo.flydaggerdownloader.R;
import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;
import mont.cristo.flydaggerdownloader.helpers.file.FileFormat;

public class DownloadViewFilter {

    private DownloadInfo downloadInfo;

    public DownloadViewFilter(DownloadInfo downloadInfo) {
        this.downloadInfo = downloadInfo;
    }

    public String getFileName() {
        return new File(downloadInfo.getUrlLocal()).getName();
    }

    public String getExtension() {
        return Files.getFileExtension(getFileName());
    }

    /**
     * Get icon corrective with the file extension
     * @return Icon resource id
     */
    public int getIcon() {
        switch (FileFormat.getFileFormat(getExtension())) {

            // For known image type
            case IMAGE_JPG:
            case IMAGE_JPEG:
            case IMAGE_GIF:
            case IMAGE_PNG:
                return R.mipmap.ic_image_type;

            // For known audio type
            case AUDIO_MP3:
            case AUDIO_AMR:
            case AUDIO_OGG:
                return R.mipmap.ic_audio_type;

            // For known video type
            case VIDEO_3GP:
            case VIDEO_FLV:
            case VIDEO_AVI:
            case VIDEO_MKV:
            case VIDEO_MOV:
            case VIDEO_MP4:
            case VIDEO_WMV:
            case VIDEO_MPG:
                return R.mipmap.ic_video_type;

            // For known application type
            case APPLICATION_APK:
                return R.mipmap.ic_apk_type;

            // For known document type
            case DOCUMENT_WORD:
            case DOCUMENT_WORD_NEW:
            case DOCUMENT_EXCEL:
            case DOCUMENT_EXCEL_NEW:
            case DOCUMENT_POWER_POINT:
            case DOCUMENT_POWER_POINT_NEW:
            case DOCUMENT_PDF:
                return R.mipmap.ic_document_type;

            // For empty extension
            // For unknown type
            case OTHER:
            case EMPTY:
            default:
                return R.mipmap.ic_empty_unknown_type;

        }
    }
}
