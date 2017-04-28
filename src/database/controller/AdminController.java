package database.controller;

import database.model.HibernateUtil;
import database.model.Participant;
import database.model.Survey;
import database.view.AdminPanel;

import javax.swing.*;
import java.util.List;

/**
 * Created by Xyrephon on 4/27/2017.
 */
public class AdminController
{
    public JPanel getAdminPanel()
    {
        return HibernateUtil.notifyQuery(session -> {
            AdminPanel builder = new AdminPanel();
            List<Participant> participants = session.createQuery("FROM Participant").list();
            List<Survey> surveys = session.createQuery("FROM Survey GROUP BY version HAVING version = maxVersion").list();
            DefaultListModel<Survey> surveyModel = new DefaultListModel<>();
            surveys.stream().forEach(surveyModel :: addElement);
            builder.getSurveys().setModel(surveyModel);
            DefaultListModel<Participant> participantModel = new DefaultListModel<>();
            participants.stream().forEach(participantModel :: addElement);
            builder.getParticipants().setModel(participantModel);

            builder.getRemoveSurvey().addActionListener(e ->
                HibernateUtil.notifyQuery(session2 -> {
                    Survey toDelete = builder.getSurveys().getSelectedValue();
                    if(toDelete != null) {
                        session2.delete(toDelete);
                        surveyModel.removeElement(toDelete);
                    }
                    return null;
                })
            );

            builder.getCreateSurvey().addActionListener(e -> this.createSurvey());

            builder.getUpdateSurvey().addActionListener(e -> this.updateSurvey(builder.getSurveys().getSelectedValue()));

            builder.getAdministerSurvey().addActionListener(e -> this.administerSurvey(builder.getSurveys().getSelectedValue()));

            builder.getRemoveParticipant().addActionListener(e ->
                HibernateUtil.notifyQuery(session2 -> {
                    Participant toDelete = builder.getParticipants().getSelectedValue();
                    if(toDelete != null) {
                        session2.delete(toDelete);
                        participantModel.removeElement(toDelete);
                    }
                    return null;
                })
            );

            builder.getCreateParticipant().addActionListener(e -> this.createParticipant());

            builder.getEditParticipant().addActionListener(e -> this.editParticipant(builder.getParticipants().getSelectedValue()));

            return builder.getMain();
        });
    }

    private void administerSurvey(Survey selectedValue)
    {

    }

    private void editParticipant(Participant selectedValue)
    {

    }

    private void createParticipant()
    {

    }

    private void updateSurvey(Survey selectedValue)
    {

    }

    private void createSurvey()
    {

    }
}
