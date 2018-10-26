package com.mindtree.BookManagement.Dao;

import java.util.List;

import com.mindtree.BookManagement.Entity.Book;

public interface BookDao {
public List<Book> displayCategoryBooks(String category);

}
