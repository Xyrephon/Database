package database.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xyrephon on 4/27/2017.
 */
@Entity
public class Survey
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int version;
    @OneToMany(mappedBy = "survey")
    private List<Question> questions = new ArrayList<>();
    @OneToMany(mappedBy = "survey")
    private List<TakenSurvey> takenSurveys = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public List<TakenSurvey> getTakenSurveys() {
        return takenSurveys;
    }

    public void setTakenSurveys(List<TakenSurvey> takenSurveys) {
        this.takenSurveys = takenSurveys;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
