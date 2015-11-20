package mont.cristo.flydaggerdownloader.models;

public class ByteRange {
    private static final String SEPARATOR = "-";

    /**
     * Start index of download will begin
     */
    private int indexStart;

    /**
     * End index of download will end
     */
    private int indexEnd;

    public ByteRange(int indexStart, int indexEnd) {

        // Check valid byte range
        if (!isByteRangeValid(indexStart, indexEnd)) {
            throw new RuntimeException("Byte range is invalid, please make sure that: start index >= 0 & start index < end index");
        }

        // Byte range valid
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    /**
     * Check byte range valid
     * @param indexStart Start byte index of range
     * @param indexEnd End byte index of range
     * @return This byte range is valid or not
     */
    private boolean isByteRangeValid(int indexStart, int indexEnd) {
        return indexStart >= 0 && indexStart < indexEnd;
    }

    /**
     * Get byte range that formatted to string
     * @return Byte range in string format
     */
    public String getByteRange() {
        return indexStart + SEPARATOR + indexEnd;
    }

    @Override
    public String toString() {
        return "ByteRange{" + "indexStart=" + indexStart + ", indexEnd=" + indexEnd + '}';
    }
}
