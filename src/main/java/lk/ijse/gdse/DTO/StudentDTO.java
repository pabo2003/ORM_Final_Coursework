package lk.ijse.gdse.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class StudentDTO {
    private String stu_id;
    private String stu_name;
    private String stu_phone;
    private String stu_email;
    private String stu_address;
    private UserDTO user;

  /*  public StudentDTO(String stuId, String stuName, String stuPhone, Object o, String stuEmail, String stuAddress, UserDTO userDTO) {
    }*/
}
