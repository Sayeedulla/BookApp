package com.mindtree.BookManagement;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.mindtree.BookManagement.Dao.PurchaseDao;
import com.mindtree.BookManagement.Dao.DaoImpl.PurchaseDaoImpl;
import com.mindtree.BookManagement.Entity.Book;
import com.mindtree.BookManagement.Entity.Purchase;
import com.mindtree.BookManagement.Exception.InvalidBookIdException;
import com.mindtree.BookManagement.Exception.InvalidCategoryName;
import com.mindtree.BookManagement.Exception.InvalidMobileNoException;
import com.mindtree.BookManagement.Service.BookService;
import com.mindtree.BookManagement.Service.PurchaseService;
import com.mindtree.BookManagement.Service.ServiceImpl.BookServiceImpl;
import com.mindtree.BookManagement.Service.ServiceImpl.purchaseServiceimpl;
import com.mindtree.BookManagement.Util.DbUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory sessionfactory = DbUtil.createConnection();
		
		outer:
		for (;;) {
			try {
				Scanner scan = new Scanner(System.in);
			System.out.println("..........................................................................'");
			System.out.println("XYZ Book Store");
			System.out.println("...........................................................................");
			System.out.println("1:Display book details");
			System.out.println("2:Purchase a book");
			System.out.println("3:Exit");
			System.out.println("Enter your choice");
			System.out.println("...........................................................................");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("......................................................................");
				System.out.println("\t\tAvailable Book Categories");
				System.out.println("......................................................................");
				System.out.println("\t\tEnter the category[Kids,General,Technology]");
				System.out.println(".......................................................................");
				String c = scan.next();
				BookService bs = new BookServiceImpl();
				try {
					bs.check_Category(c);
					List<Book> l = bs.displayCategoryBooks(c);
					System.out.println("ID\t\tBookName\t\tAuthorName\t\tPublisher\t\tPrice");
					for (Book b : l) {
						System.out.println(b.getBook_Id() + "\t\t" + b.getBook_name() + "\t\t" + b.getAuthor_name()
								+ "\t\t" + b.getPublisher() + "\t\t" + b.getPrice());
					}
				} catch (InvalidCategoryName e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			case 2:

				PurchaseService purch = new purchaseServiceimpl();
				Purchase p = new Purchase();

				System.out.println("Enter the bookid");
				int bookid=scan.nextInt();
				System.out.println("Enter the customer name");
				p.setCustomername(scan.next());
				System.out.println("Enter the mobile number");
				p.setCustomer_mobileno(scan.next());
				try {
					purch.checkpurchase(p,bookid);
					p = purch.purchase_book(p,bookid);
					System.out.println("Book Sucessfully purchased");
					System.out.println("purchase number" + p.getPurchase_id());
					System.out.println("purchase date" + p.getPurchase_date());
					System.out.println("purchase amount: " + p.getAmount());

				} catch (InvalidBookIdException e) {
					System.out.println(e.getMessage());
				} catch (InvalidMobileNoException e) {

					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;

			default:
				System.exit(0);
				break;
			}
			}catch(Exception e) {
				System.out.println("enter valid values");
				continue outer;
			}
		}
	}
}
