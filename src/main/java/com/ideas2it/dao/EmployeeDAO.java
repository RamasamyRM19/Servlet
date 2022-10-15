package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;

/**
 * EmployeeDataAccessObject contains the methods to perform the database
 * operations for Employee Details
 *
 * @version 1.0 12 Aug 2022
 *
 * @author Ramasamy R M
 */
public class EmployeeDAO {

	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private Session session = null;

	/**
	 * Insert Trainer Details
	 *
	 * @param Trainer trainer
	 * @return Integer rowsAffected
	 */
	public Integer insertTrainer(Trainer trainer) {
		Integer rowsAffected = 0;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			rowsAffected = (Integer) session.save(trainer);
			transaction.commit();
		} finally {
			session.close();
		}
		return rowsAffected;
	}

	/**
	 * Get all Trainer details 
	 *
	 * @param
	 * @return List<Trainer> trainers
	 */
	public List<Trainer> retrieveAllTrainers() {
		List<Trainer> trainers = new ArrayList<Trainer>();
		try {
			session = sessionFactory.openSession();
			Query<Trainer> query = session.createQuery("FROM Trainer");
			trainers = query.list();
		} finally {
			session.close(); 
		}
		return trainers;
	}

	/**
	 * Get the particular Trainer detail 
	 *
	 * @param Integer id
	 * @return List<Trainer> trainers
	 */
	public Trainer retrieveTrainerById(Integer id) {
		Trainer trainer = new Trainer();
        try {
            session = sessionFactory.openSession();
            trainer = (Trainer) session.get(Trainer.class, id);
        } finally {
            session.close(); 
        }
        return trainer;
	}

	/**
	 * Update the particular trainer detail by id
	 *
	 * @param Trainer trainer
	 * @return void
	 */
	public void updateTrainerById(Trainer trainer) {
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			if (!trainer.isEmpty()) {
				session.merge(trainer);
			}
			transaction.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete the particular Trainer detail
	 *
	 * @param Integer id
	 * @return void
	 */
	public void deleteTrainerById(Integer id) {
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Trainer trainer = (Trainer) session.get(Trainer.class, id);
			session.delete(trainer);
			transaction.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert Trainee Details
	 *
	 * @param Trainee trainee
	 * @return Integer rowsAffected
	 */
	public Integer insertTrainee(Trainee trainee) {
		Integer rowsAffected = 0;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			rowsAffected = (Integer) session.save(trainee);
			transaction.commit();
		} finally {
			session.close();
		}
		return rowsAffected;
	}

	/**
	 * Get all Trainee details
	 *
	 * @param
	 * @return List<Trainee> trainees
	 */
	public List<Trainee> retrieveAllTrainees() {
		List<Trainee> trainees = new ArrayList<Trainee>();
		try {
			session = sessionFactory.openSession();
			String query = "FROM Trainee";
			trainees = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return trainees;
	}

	/**
	 * Get the particular Trainee detail
	 *
	 * @param Integer id
	 * @return Trainee trainee
	 */
	public Trainee retrieveTraineeById(Integer id) {
		Trainee trainee = new Trainee();
		try {
			session = sessionFactory.openSession();
			trainee = (Trainee) session.get(Trainee.class, id);
		} finally {
			session.close();
		}
		return trainee;
	}

	/**
	 * Update the particular trainee detail by id
	 *
	 * @param Trainee trainee
	 * @return void
	 */
	public void updateTraineeById(Trainee trainee) {
		try { 
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			if (!trainee.isEmpty()) {
				session.saveOrUpdate(trainee);
				System.out.println(trainee);
			}
			transaction.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete the particular Trainee detail 
	 *
	 * @param Integer id
	 * @return void
	 */
	public void deleteTraineeById(Integer id) {
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Trainee trainee = (Trainee) session.get(Trainee.class, id);
			session.delete(trainee);
			transaction.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Search the particular Trainer detail by FirstName
	 * </p>
	 *
	 * @param String detail
	 * @return List<Employee> employee
	 */
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		List<Employee> employee = new ArrayList<Employee>();
		try {
			session = sessionFactory.openSession();
			String hql = "from Employee where firstName like :firstName";
			Query<Employee> query = session.createQuery(hql);
			query.setParameter("firstName", "%" + firstName + "%");
			employee = query.list();
		} finally {
			session.close();
		}
		return employee;
	}

	/**
	 * <p>
	 * Search the particular Trainer detail by LastName
	 * </p>
	 *
	 * @param String detail
	 * @return List<Employee> employee
	 */
	public List<Employee> searchEmployeeByLastName(String lastName) {
		List<Employee> employee = new ArrayList<Employee>();
		try {
			session = sessionFactory.openSession();
			String hql = "from Employee where lastName like :lastName";
			Query<Employee> query = session.createQuery(hql);
			query.setParameter("lastName", "%" + lastName + "%");
			employee = query.list();
		} finally {
			session.close();
		}
		return employee;
	}
}