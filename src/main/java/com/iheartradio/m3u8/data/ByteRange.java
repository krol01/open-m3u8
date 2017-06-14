package com.iheartradio.m3u8.data;

import java.util.Objects;

public class ByteRange {
    private final Integer subRangeLength;
    private final Integer offset;

    public ByteRange(Integer subRangeLength, Integer offset) {
        this.subRangeLength = subRangeLength;
        this.offset = offset;
    }
            
    public int getSubRangeLength() {
        return subRangeLength;
    }
    
    public boolean hasOffset() {
        return offset != null;
    }
    
    public Integer getOffset() {
        return offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subRangeLength, offset);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ByteRange)) {
            return false;
        }

        ByteRange other = (ByteRange) o;

        return Objects.equals(subRangeLength, other.subRangeLength) &&
               Objects.equals(offset, other.offset);
    }

    @Override
    public String toString() {
        return subRangeLength + (offset != null ? "@" + offset : "");
    }
    
}
