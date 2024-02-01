package code.with.vanilson;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FastPassUICustomer {

    private String fastPassId;
    private String customerFullName;
    private String customerPhone;
    private Float currentBalance;

    public FastPassUICustomer(String fastPassId, String customerFullName, String customerPhone, Float currentBalance) {
        this.fastPassId = fastPassId;
        this.customerFullName = customerFullName;
        this.customerPhone = customerPhone;
        this.currentBalance = currentBalance;
    }
}
