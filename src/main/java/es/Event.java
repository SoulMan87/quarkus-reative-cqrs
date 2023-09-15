package es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    public Event(String eventType, String aggregateType) {
        this.id = UUID.randomUUID ();
        this.eventType = eventType;
        this.aggregateType = aggregateType;
        this.timeStamp = ZonedDateTime.now ();
    }

    private UUID id;
    private String aggregateId;
    private String eventType;
    private String aggregateType;
    private long version;
    private byte[] data;
    private byte[] metaData;
    private ZonedDateTime timeStamp;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", aggregateId='" + aggregateId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", aggregateType='" + aggregateType + '\'' +
                ", version=" + version +
                ", timeStamp=" + timeStamp +
                ", data=" + Arrays.toString (data) +
                '}';
    }
}
