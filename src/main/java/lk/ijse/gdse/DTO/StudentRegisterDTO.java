package lk.ijse.gdse.DTO;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data

public class StudentRegisterDTO {
    private String student_course_id;
    private Date registration_date;
}
