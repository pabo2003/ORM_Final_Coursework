
package lk.ijse.gdse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Payment {
    @Id
    private String pay_id;
    private Date pay_date;
    private double pay_amount;

    @ManyToOne
    @JoinColumn(name = "student_course_id")
    private Student_Course student_course;
}
