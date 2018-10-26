package com.mindtree.BookManagement.Service.ServiceImpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mindtree.BookManagement.Dao.PurchaseDao;
import com.mindtree.BookManagement.Dao.DaoImpl.PurchaseDaoImpl;
import com.mindtree.BookManagement.Entity.Purchase;
import com.mindtree.BookManagement.Exception.InvalidBookIdException;
import com.mindtree.BookManagement.Exception.InvalidMobileNoException;
import com.mindtree.BookManagement.Service.BookService;
import com.mindtree.BookManagement.Service.PurchaseService;

public class purchaseServiceimpl implements PurchaseService {
	PurchaseDao purchasedao = new PurchaseDaoImpl();

	public Purchase purchase_book(Purchase p,int bookid) {
		return purchasedao.purchase_book(p,bookid);

	}

	public void checkpurchase(Purchase p,int bookid) throws InvalidMobileNoException, InvalidBookIdException {
		BookService bs = new BookServiceImpl();
		List<Integer> l = bs.getallbookid();
		if (!(l.contains(bookid))) {
			throw new InvalidBookIdException("Invalid book id, please check your input");

		}

		if (p.getCustomer_mobileno().length() < 10 || p.getCustomer_mobileno().length() > 10) {
			
			throw new InvalidMobileNoException("Invalid mobile no, please check your input");

		}else {
			 // 3) Then contains 9 digits
	        Pattern p1 = Pattern.compile("[0-9]{10}");
	 
	        
	        Matcher m = p1.matcher(p.getCustomer_mobileno());
	        if((m.find() && m.group().equals(p.getCustomer_mobileno()))) {
	        	
	        }
	        else {
	        	throw new InvalidMobileNoException("Invalid mobile no, please check your input");
	        }
		}
	}

	
}
