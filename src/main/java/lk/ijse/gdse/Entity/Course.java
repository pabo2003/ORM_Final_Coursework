package lk.ijse.gdse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Course {
    @Id
    private String id;
    private String name;
    private String duration;
    private String fee;

    @ManyToMany(mappedBy = "StudentDTO")
    private List<StudentRegister> studentRegisterList;

    public Course(String id, String name, String duration, String fee, List<StudentRegister> studentRegisterList) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.studentRegisterList = studentRegisterList;
    }

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public List<StudentRegister> getStudentRegisterList() {
        return studentRegisterList;
    }

    public void setStudentRegisterList(List<StudentRegister> studentRegisterList) {
        this.studentRegisterList = studentRegisterList;
    }
}
