package com.mindtree.BookManagement.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mindtree.BookManagement.Dao.BookDao;
import com.mindtree.BookManagement.Dao.PurchaseDao;
import com.mindtree.BookManagement.Dao.DaoImpl.BookDaoImpl;
import com.mindtree.BookManagement.Dao.DaoImpl.PurchaseDaoImpl;
import com.mindtree.BookManagement.Entity.Book;
import com.mindtree.BookManagement.Exception.InvalidCategoryName;
import com.mindtree.BookManagement.Service.BookService;
import com.mindtree.BookManagement.Util.DbUtil;

public class BookServiceImpl implements BookService {
BookDao pd=new BookDaoImpl();
SessionFactory sessionfactory=DbUtil.createConnection();
	public void check_Category(String c) throws InvalidCategoryName {
		// TODO Auto-generated method stub
		if(!(c.equalsIgnoreCase("kids")||c.equalsIgnoreCase("General")||c.equalsIgnoreCase("Technology")))
			throw new InvalidCategoryName("Invalid category name please check your input");
		
	}

	public List<Book> displayCategoryBooks(String category) {
		// TODO Auto-generated method stub
		return pd.displayCategoryBooks(category);
	}

	public List<Integer> getallbookid() {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Book.class);
		List<Book> results = cr.list();
		List<Integer> l=new ArrayList<Integer>();
		for(Book b:results) {
			l.add(b.getBook_Id());
		}

	 
	   session.getTransaction();
	 
	    session.close();
		
		return l;
		// TODO Auto-generated method stub
		
	}

}
