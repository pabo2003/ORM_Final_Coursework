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

public class Student_CourseDTO {
    private String student_course_id;
    private StudentDTO student;
    private CourseDTO course;
    private Date registration_date;
}
