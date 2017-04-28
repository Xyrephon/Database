package database.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Xyrephon on 4/27/2017.
 */
@Entity
@Table(name = "taken_survey")
public class TakenSurvey
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Survey survey;
    @OneToOne
    private Participant participant;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taken_date;
    @OneToMany
    @JoinTable(
            name = "participant_answer",
            joinColumns =
            @JoinColumn(name="taken_survey_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name="answer_id", referencedColumnName = "id")
    )
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Date getDate() {
        return taken_date;
    }

    public void setDate(Date date) {
        this.taken_date = date;
    }
}
