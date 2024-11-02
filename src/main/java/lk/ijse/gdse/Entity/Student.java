package lk.ijse.gdse.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private int age;
    private String NIC;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToMany(mappedBy = "StudentDTO")
    private List<StudentRegister> studentRegisterList;

    public Student() {
    }

    public Student(String id, String name, int age, String NIC, String phoneNumber, String email, String address, User user, List<StudentRegister> studentRegisterList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.NIC = NIC;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.user = user;
        this.studentRegisterList = studentRegisterList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<StudentRegister> getStudentRegisterList() {
        return studentRegisterList;
    }

    public void setStudentRegisterList(List<StudentRegister> studentRegisterList) {
        this.studentRegisterList = studentRegisterList;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
