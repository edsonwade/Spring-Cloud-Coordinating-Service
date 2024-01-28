package code.with.vanilson;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class TollRate implements Serializable {

    private static final long serialVersionUID = 134674677L;
    private Integer stationId;
    private Float currentRate;
    private String timestamp;

    public TollRate(Integer stationId, Float currentRate, String timestamp) {
        this.stationId = stationId;
        this.currentRate = currentRate;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TollRate{" +
                "stationId=" + stationId +
                ", currentRate=" + currentRate +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
