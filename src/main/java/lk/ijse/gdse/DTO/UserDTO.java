package lk.ijse.gdse.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class UserDTO {

    private String id;
    private String name;
    private String NIC;
    private String phoneNumber;
    private String email;
    private String address;
    private String position;
}
