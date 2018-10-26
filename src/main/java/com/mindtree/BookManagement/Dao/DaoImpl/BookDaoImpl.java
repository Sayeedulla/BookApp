package com.mindtree.BookManagement.Dao.DaoImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mindtree.BookManagement.Dao.BookDao;
import com.mindtree.BookManagement.Entity.Book;
import com.mindtree.BookManagement.Util.DbUtil;

public class BookDaoImpl implements BookDao {
SessionFactory sessionfactory=DbUtil.createConnection();
	public List<Book> displayCategoryBooks(String category) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		 
	    
//		Query qry=session.createQuery("from Book e where e.category=:p1");
//		qry.setParameter("p1",category);
//		List l2=qry.list();
		Criteria cr = session.createCriteria(Book.class);
		cr.add(Restrictions.eq("category", category));
		List<Book> results = cr.list();

	 
	   session.getTransaction().commit();
	 
	    session.close();
		return results;
	}
	

}
