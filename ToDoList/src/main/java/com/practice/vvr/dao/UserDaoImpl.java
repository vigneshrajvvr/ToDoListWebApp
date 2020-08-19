package com.practice.vvr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.vvr.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);
	}

	@Override
	public User findUserByEmail(String email) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("from User where email=:tempEmail", User.class);
		theQuery.setParameter("tempEmail", email);
		
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		}catch(Exception e) {
			theUser = null;
		}
		return theUser;
	}

}
