package database.controller;

import database.model.MultipleChoiceQuestion;
import database.model.Participant;
import database.model.Survey;

import javax.swing.*;
import java.util.List;

import static database.model.HibernateUtil.*;

public class DatabaseRunner
{
	public static void main(String [] args)
	{
//		DatabaseController appController = new DatabaseController();
//		appController.start();
		SurveyController surveyController =
			notifyQuery(session -> {
				Participant jonah = session.get(Participant.class, 1);
				Survey survey = session.get(Survey.class, 2);
				return new SurveyController(survey, jonah);
			});
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(surveyController.getPanel());
		frame.pack();
		SwingUtilities.invokeLater( () -> frame.setVisible(true));
	}
}
