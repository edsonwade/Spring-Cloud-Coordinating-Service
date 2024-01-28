package code.with.vanilson;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class FastPass implements Serializable {

    private static final long serialVersionUID = 134674677L;

    private String fastPassId;
    private String customerFullName;
    private String customerPhone;
    private double currentBalance;

    public FastPass(String fastPassId, String customerFullName, String customerPhone, double currentBalance) {
        this.fastPassId = fastPassId;
        this.customerFullName = customerFullName;
        this.customerPhone = customerPhone;
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "FastPass{" +
                "fastPassId='" + fastPassId + '\'' +
                ", customerFullName='" + customerFullName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
