package app.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.dal.entities.Users;

@Repository
public class DataProviderImpl implements DataPovider {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String loadData() {
		System.out.println(String.format("%s has loaded data.", DataProviderImpl.class));
		
		return "Some data from data provider";
	}

	@Override
	@Transactional
	public List<Users> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users u");
		return query.list();
	}

}
