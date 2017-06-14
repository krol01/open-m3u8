package com.iheartradio.m3u8.data;

import java.util.Objects;

public class TrackData {
    private final String mUri;
    private final TrackInfo mTrackInfo;
    private final EncryptionData mEncryptionData;
    private final String mProgramDateTime;
    private final boolean mHasDiscontinuity;
    private final ByteRange mByteRange;

    private TrackData(String uri, TrackInfo trackInfo, EncryptionData encryptionData, String programDateTime, boolean hasDiscontinuity, ByteRange byteRange) {
        mUri = uri;
        mTrackInfo = trackInfo;
        mEncryptionData = encryptionData;
        mProgramDateTime = programDateTime;
        mHasDiscontinuity = hasDiscontinuity;
        mByteRange = byteRange;
    }

    public String getUri() {
        return mUri;
    }

    public boolean hasTrackInfo() {
        return mTrackInfo != null;
    }

    public TrackInfo getTrackInfo() {
        return mTrackInfo;
    }

    public boolean hasEncryptionData() {
        return mEncryptionData != null;
    }

    public boolean isEncrypted() {
        return hasEncryptionData() &&
               mEncryptionData.getMethod() != null &&
               mEncryptionData.getMethod() != EncryptionMethod.NONE;
    }

    public boolean hasProgramDateTime() {
        return mProgramDateTime != null && mProgramDateTime.length() > 0;
    }
    
    public String getProgramDateTime() {
        return mProgramDateTime;
    }

    public boolean hasDiscontinuity() {
        return mHasDiscontinuity;
    }

    public boolean hasByteRange() {
        return mByteRange != null;
    }

    public ByteRange getByteRange() {
        return mByteRange;
    }    
    
    public EncryptionData getEncryptionData() {
        return mEncryptionData;
    }

    public Builder buildUpon() {
        return new Builder(getUri(), mTrackInfo, mEncryptionData, mHasDiscontinuity, mProgramDateTime, mByteRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mUri, mEncryptionData, mTrackInfo, mHasDiscontinuity, mProgramDateTime, mByteRange);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TrackData)) {
            return false;
        }

        TrackData other = (TrackData) o;

        return Objects.equals(mUri, other.mUri) &&
               Objects.equals(mTrackInfo, other.mTrackInfo) &&
               Objects.equals(mEncryptionData, other.mEncryptionData) &&
               Objects.equals(mProgramDateTime, other.mProgramDateTime) &&
               Objects.equals(mHasDiscontinuity, other.mHasDiscontinuity) &&
               Objects.equals(mByteRange, other.mByteRange);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("(TrackData")
                .append(" mUri=").append(mUri)
                .append(" mTrackInfo=").append(mTrackInfo)
                .append(" mEncryptionData=").append(mEncryptionData)
                .append(" mProgramDateTime=").append(mProgramDateTime)
                .append(" mHasDiscontinuity=").append(mHasDiscontinuity)
                .append(" mByteRange=").append(mByteRange)
                .append(")")
                .toString();
    }

    public static class Builder {
        private String mUri;
        private TrackInfo mTrackInfo;
        private EncryptionData mEncryptionData;
        private String mProgramDateTime;
        private boolean mHasDiscontinuity;
        private ByteRange mByteRange;

        public Builder() {
        }

        private Builder(String uri, TrackInfo trackInfo, EncryptionData encryptionData, boolean hasDiscontinuity, String programDateTime, ByteRange byteRange) {
            mUri = uri;
            mTrackInfo = trackInfo;
            mEncryptionData = encryptionData;
            mHasDiscontinuity = hasDiscontinuity;
            mProgramDateTime = programDateTime;
            mByteRange = byteRange;
        }

        public Builder withUri(String url) {
            mUri = url;
            return this;
        }

        public Builder withTrackInfo(TrackInfo trackInfo) {
            mTrackInfo = trackInfo;
            return this;
        }

        public Builder withEncryptionData(EncryptionData encryptionData) {
            mEncryptionData = encryptionData;
            return this;
        }

        public Builder withProgramDateTime(String programDateTime) {
            mProgramDateTime = programDateTime;
            return this;
        }

        public Builder withDiscontinuity(boolean hasDiscontinuity) {
            mHasDiscontinuity = hasDiscontinuity;
            return this;
        }
        
        public Builder withByteRange(ByteRange byteRange) {
            mByteRange = byteRange;
            return this;
        }

        public TrackData build() {
            return new TrackData(mUri, mTrackInfo, mEncryptionData, mProgramDateTime, mHasDiscontinuity, mByteRange);
        }
    }
}
