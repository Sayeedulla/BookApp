package com.mindtree.BookManagement.Service;

import com.mindtree.BookManagement.Entity.Purchase;
import com.mindtree.BookManagement.Exception.InvalidBookIdException;
import com.mindtree.BookManagement.Exception.InvalidMobileNoException;

public interface PurchaseService {
	public Purchase purchase_book(Purchase p,int id);
	public void checkpurchase(Purchase p,int id) throws InvalidMobileNoException, InvalidBookIdException;
}
