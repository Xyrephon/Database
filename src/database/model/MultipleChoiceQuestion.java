package database.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Xyrephon on 4/27/2017.
 */
@Entity
public class MultipleChoiceQuestion extends Question
{
    @OneToMany (mappedBy = "question")
    private List<Answer> choices;

    public List<Answer> getChoices() {
        return choices;
    }

    public void setChoices(List<Answer> choices) {
        this.choices = choices;
    }
}
