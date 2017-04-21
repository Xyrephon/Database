package database.controller;

import database.model.Participant;

import java.util.List;

import static database.model.HibernateUtil.*;

public class DatabaseRunner 
{
	public static void main(String [] args)
	{
//		DatabaseController appController = new DatabaseController();
//		appController.start();
		notifyQuery(session -> {
			List<Participant>  list = session.createQuery("FROM Participant p WHERE p.parents IS NOT EMPTY").list();
				list.forEach(p -> {
					System.out.println(p.getParents());
				});
				return null;
		});
	}
}
