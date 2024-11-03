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
public class CourseDTO {
    private String course_id;
    private String course_name;
    private String duration;
    private double course_fee;
}
