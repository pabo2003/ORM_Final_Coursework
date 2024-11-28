package lk.ijse.gdse.Entity.EntityTm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTm {
    private String stu_id;
    private String stu_name;
    private String stu_phone;
    private String stu_email;
    private String stu_address;
    private String user_id;
}