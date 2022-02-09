package com.tms.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tms.app.App;
import com.tms.beans.Trainer;
import com.tms.trainer.TrainerDashboard;
import com.tms.trainer.TrainerProfile;

import org.hibernate.query.Query;

/**
 *
 * @author Ashish
 *
 */
public class TrainerDAO implements ITrainerDao {

	@Override
	public void saveTrainer(Session session, Trainer trainer) {
		session.save(trainer);
		session.getTransaction().commit();
		System.out.println("registration successfull..");

	}

	@Override
	public void getTrainer(Session session, String username, String password) {
		TrainerDashboard dashboard = new TrainerDashboard();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Trainer> query = criteriaBuilder.createQuery(Trainer.class);
		Root<Trainer> root = query.from(Trainer.class);
		query.select(root).where(criteriaBuilder.equal(root.get("username"), username),
				criteriaBuilder.equal(root.get("password"), password));

		Query<Trainer> trainerQuery = session.createQuery(query);
		Trainer tr = trainerQuery.getSingleResult();
		dashboard.dashBoard(tr);

	}

	@Override
	public void updateTrainer(Trainer trainer, Session session) {
		TrainerProfile profile = new TrainerProfile();
		session.merge(trainer);
		session.getTransaction().commit();
		System.out.println("Updation successfull..");
		profile.viewProfile(trainer);

	}

	public void changePassword(Session session, String username, String password) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaUpdate<Trainer> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Trainer.class);
		Root<Trainer> root = criteriaUpdate.from(Trainer.class);
		criteriaUpdate.set("password", password);
		criteriaUpdate.where(criteriaBuilder.equal(root.get("username"), username));

		session.createQuery(criteriaUpdate).executeUpdate();
		session.getTransaction().commit();

	}

}
