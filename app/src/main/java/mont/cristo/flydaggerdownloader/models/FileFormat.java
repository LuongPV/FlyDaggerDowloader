package mont.cristo.flydaggerdownloader.models;

/**
 * Contain all file formats that application can identify
 */
public enum FileFormat {

    IMAGE_JPG("jpg"),

    IMAGE_JPEG("jpeg"),

    IMAGE_GIF("gif"),

    IMAGE_PNG("png"),

    AUDIO_MP3("mp3"),

    AUDIO_OGG("ogg"),

    AUDIO_AMR("amr"),

    VIDEO_MP4("mp4"),

    VIDEO_MPG("mpg"),

    VIDEO_3GP("3gp"),

    VIDEO_MKV("mkv"),

    VIDEO_WMV("wmv"),

    VIDEO_AVI("avi"),

    VIDEO_MOV("mov"),

    VIDEO_FLV("flv"),

    APPLICATION_APK("apk"),

    DOCUMENT_WORD("doc"),

    DOCUMENT_WORD_NEW("docx"),

    DOCUMENT_EXCEL("xls"),

    DOCUMENT_EXCEL_NEW("xlsx"),

    DOCUMENT_POWER_POINT("ppt"),

    DOCUMENT_POWER_POINT_NEW("pptx"),

    DOCUMENT_PDF("pdf"),

    /**
     * For some file that don't contain any extension
     */
    EMPTY(""),

    /**
     * for all remain format that application don't know
     */
    OTHER(null);

    /**
     * Extension as a string
     */
    private String extension;

    FileFormat(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    /**
     * Get file format enum by format string
     * @param formatString Format string need to find
     * @return Corrective format enum
     */
    public static FileFormat getFileFormat(String formatString) {
        for (FileFormat fileFormat : FileFormat.values()) {
            if (fileFormat.getExtension().equals(formatString)) {
                return fileFormat;
            }
        }
        // If not found enum will consider unknown format type
        return FileFormat.OTHER;
    }
}
