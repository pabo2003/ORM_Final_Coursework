package lk.ijse.gdse.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Student {
    @Id
    private String stu_id;
    private String stu_name;
    private String stu_phone;
    private String stu_email;
    private String stu_address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Student_Course> studentCourses;
    //associate table ekt yn ek

    @ManyToOne
    private User user;
    //UserId eka ganna

    /*public String getUser_id() {
        return user != null ? user.getUser_id() : null;
    }*/




}