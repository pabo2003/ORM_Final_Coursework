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

    private String id;
    private String name;
    private String duration;
    private String fee;
}
