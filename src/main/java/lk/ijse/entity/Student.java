package lk.ijse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.embed.FullName;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private FullName name;
    @Column(name = "address")
    private String address;

    public Student() {
    }

    public Student(String id, FullName name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                '}';
    }
}
