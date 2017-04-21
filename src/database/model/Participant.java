package database.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Xyrephon on 4/18/2017.
 */

@Entity
public class Participant
{
    @Id
    @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;
    @Temporal(TemporalType.DATE)
    private LocalDate age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "participant")
    private List<ContactInfo> infoList;
    @OneToMany
    @JoinTable(
            name = "parent",
            joinColumns =
                    @JoinColumn(name="child_id", referencedColumnName = "id"),
            inverseJoinColumns =
                    @JoinColumn(name="parent_id", referencedColumnName = "id")

    )
    private List<Participant> parents;
    @OneToMany
    @JoinTable(
            name = "parent",
            joinColumns =
            @JoinColumn(name="parent_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name="child_id", referencedColumnName = "id")
    )
    private List<Participant> children;

    public String toString()
    {
        return first_name + " " + last_name + " is a " + gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<ContactInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<ContactInfo> infoList) {
        this.infoList = infoList;
    }

    public List<Participant> getParents() {
        return parents;
    }

    public void setParents(List<Participant> parents) {
        this.parents = parents;
    }

    public List<Participant> getChildren() {
        return children;
    }

    public void setChildren(List<Participant> children) {
        this.children = children;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }
}


