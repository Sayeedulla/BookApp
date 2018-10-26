package com.mindtree.BookManagement.Service;

import java.util.List;

import com.mindtree.BookManagement.Entity.Book;
import com.mindtree.BookManagement.Exception.InvalidCategoryName;

public interface BookService {
public  void check_Category(String c) throws InvalidCategoryName;
public List<Book> displayCategoryBooks(String category);
public List<Integer> getallbookid();
}
