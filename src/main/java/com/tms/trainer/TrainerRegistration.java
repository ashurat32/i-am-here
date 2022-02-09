package com.tms.trainer;

import static com.tms.util.HibernateUtil.getSessionFactory;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tms.beans.Trainer;
import com.tms.dao.TrainerDAO;
import com.tms.exception.DateOfBirthNotValid;
import com.tms.exception.InvalidEmailException;
import com.tms.exception.NotAValidPhoneNo;
import com.tms.util.Utility;

/**
 *
 * @author Ashish
 *
 */
public class TrainerRegistration {

	public void trainerRegistration() {

		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		TrainerDAO dao = new TrainerDAO();
		Trainer trainer = new Trainer();
		try {
			System.out.println("Enter Trainer Name");
			String name = Utility.stringUtil();
			trainer.setTrName(name);
			System.out.println("Enter Trainer Email");
			String email = Utility.stringUtil();
			if (!email.contains("@")) {
				throw new InvalidEmailException("Email " + email + "is not valid");
			} else {
				trainer.setTrEmail(email);
			}
			System.out.println("Enter Trainer userName");
			String userName = Utility.stringUtil();
			trainer.setUsername(userName);
			System.out.println("Enter Trainer Password");
			String password = Utility.stringUtil();
			trainer.setPassword(password);
			System.out.println("Enter Trainer Contact number");
			String contact = Utility.stringUtil();
			if (contact.length() > 10 || contact.length() < 10) {
				throw new NotAValidPhoneNo("Contact " + contact + " Enter a valid phone no. not inlcude +91");
			} else {
				trainer.setTrMb(contact);
			}
			System.out.println("Enter Trainer DOB");
			String dob = Utility.stringUtil();
			if (!dob.contains("/")) {
				throw new DateOfBirthNotValid("Dob " + dob + "Invalid type please try Format = dd/mm/yyy");
			} else {

				trainer.setTrDob(dob);
			}
			dao.saveTrainer(session, trainer);
			session.close();

		}

		catch (IOException e) {
			System.out.println("Trainer Registration failed" + e);
		} catch (InvalidEmailException e) {
			e.printStackTrace();
		} catch (DateOfBirthNotValid e) {
			e.printStackTrace();
		} catch (NotAValidPhoneNo e) {
			e.printStackTrace();
		}
	}

}
