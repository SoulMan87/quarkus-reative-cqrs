package es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Snapshot {

    private UUID id;
    private String aggregateId;
    private String aggregateType;
    private byte[] data;
    private byte[] metaData;

    private long version;
    private ZonedDateTime timeStamp;

    @Override
    public String toString() {
        return "Snapshot{" +
                "id=" + id +
                ", aggregateId='" + aggregateId + '\'' +
                ", aggregateType='" + aggregateType + '\'' +
                ", data=" + data.length + " bytes" +
                ", metaData=" + data.length + " bytes" +
                ", version=" + version +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
