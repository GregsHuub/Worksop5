package pl.coderslab.interfaces;

import pl.coderslab.models.Book;

import java.util.List;

public interface BooksInterface {

     Book addBook(int id, String isbn, String title,
                        String author, String publisher, String type);
    Book editBook(int id, String isbn, String title, String author,
                  String publisher, String type);
    String getBookById(int idToGet);
    Book removeBook(int idToDelete);
    List<Book> getList();





}
