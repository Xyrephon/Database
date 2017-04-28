package database.controller;

import database.model.*;
import database.view.HasAnswers;
import database.view.MultipleChoiceQuestionPanel;
import database.view.QuestionPanel;
import database.view.TakeSurveyPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by Xyrephon on 4/27/2017.
 */
public class SurveyController
{
    private Survey survey;
    private Participant participant;
    private List<Runnable> listeners;

    public SurveyController(Survey survey, Participant participant) {
        this.survey = survey;
        this.participant = participant;
        this.listeners = new ArrayList<>();
    }

    public JPanel getPanel()
    {
        return HibernateUtil.notifyQuery(session -> {
            TakeSurveyPanel builder = new TakeSurveyPanel();
            session.refresh(survey);
            builder.getSurveyName().setText(survey.getTitle());
            List<Question> questions = survey.getQuestions();
            List<HasAnswers> answers = new ArrayList<>();

            for (Question question : questions)
            {
                JPanel toAdd;
                if (question instanceof MultipleChoiceQuestion)
                {
                    MultipleChoiceQuestionPanel mcqPanel = new MultipleChoiceQuestionPanel();
                    MultipleChoiceQuestion mcq = (MultipleChoiceQuestion)(question);
                    mcqPanel.getQuestion().setText(mcq.getQuestion());
                    mcq.getChoices().forEach(mcqPanel :: createAnswer);
                    toAdd = mcqPanel.getMain();
                    answers.add(mcqPanel);
                }
                else
                {
                    QuestionPanel qPanel = new QuestionPanel();
                    qPanel.getQuestion().setText(question.getQuestion());
                    toAdd = qPanel.getMain();
                    qPanel.setQuestion(question);
                    answers.add(qPanel);
                }
                builder.getQuestionsPanel().add(toAdd);
            }
            builder.getSubmit().addActionListener(e ->
                HibernateUtil.notifyQuery(session2 -> {
                    TakenSurvey takenSurvey = new TakenSurvey();
                    takenSurvey.setParticipant(participant);
                    takenSurvey.setSurvey(survey);
                    takenSurvey.setAnswers(
                        answers.stream()
                                .map(HasAnswers :: getAnswer)
                                .peek(session2 :: saveOrUpdate)
                                .collect(Collectors.toList())
                    );
                    session2.persist(takenSurvey);

                    listeners.forEach(Runnable :: run);

                    return null;
                }));

            return builder.getMain();
        });

    }
}
