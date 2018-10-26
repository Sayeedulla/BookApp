package com.mindtree.BookManagement.Dao.DaoImpl;

import java.sql.PreparedStatement;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.identity.GetGeneratedKeysDelegate;

import com.mindtree.BookManagement.Dao.PurchaseDao;
import com.mindtree.BookManagement.Entity.Book;
import com.mindtree.BookManagement.Entity.Purchase;
import com.mindtree.BookManagement.Service.PurchaseService;
import com.mindtree.BookManagement.Util.DbUtil;

public class PurchaseDaoImpl implements PurchaseDao {
	SessionFactory sessionfactory = DbUtil.createConnection();

	public Purchase purchase_book(Purchase p,int bookid) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		Book b = session.get(Book.class,bookid);
		p.setB(b);
		p.setAmount(b.getPrice());
		
		p.setPurchase_date(new Date());
		

		p.setAmount(b.getPrice());
		
		

		Integer purchaseId = (Integer)session.save(p);
		
		session.getTransaction().commit();
		session.close();


		return p;
	}
	
	

}
