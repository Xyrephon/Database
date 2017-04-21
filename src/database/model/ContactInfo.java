package database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Xyrephon on 4/18/2017.
 */
@Entity
public class ContactInfo
{
    @Id
    @GeneratedValue
    private int id;
    private String contact_type;
    private String contact_info;
    @ManyToOne
    private Participant participant;


    public int getId() {
        return id;
    }

    public String getContactType() {
        return contact_type;
    }

    public void setContactType(String contact_type) {
        this.contact_type = contact_type;
    }

    public String getContactInfo() {
        return contact_info;
    }

    public void setContactInfo(String contact_info) {
        this.contact_info = contact_info;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
