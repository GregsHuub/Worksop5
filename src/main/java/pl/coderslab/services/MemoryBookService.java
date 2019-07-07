package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.interfaces.BooksInterface;
import pl.coderslab.models.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BooksInterface {

    private List<Book> list;

    private Book book;

    public MemoryBookService(List<Book> list) {
        this.list = list;
    }

    public void setList(List<Book> list) {
        this.list = list;


    }

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
        list.add(new Book(4,"484721838738", "Origin", "Dan Brown", "New Art", "Mystery"));

    }

    public Book addBook(int id, String isbn, String title, String author, String publisher, String type) {
        Book book = new Book(id, isbn, title, author, publisher, type);
        list.add(book);
        return book;
    }


    public Book editBook(int id, String isbn, String title, String author, String publisher, String type){
        for(Book book : list){
            if(book.getId() == id){
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setType(type);

            }
        }
        return book;

    }


    public List<Book> getList() {
        return list;
    }

    public String getBookById(int idToGet) {


        for (Book book : list) {
            if (book.getId() == idToGet) {
                book.toString();

                return book.toString();
            }
        }
        return "The ID what you just typed is wrong, try again matey!";

    }
    public Book removeBook(int idToDelete) {
        return list.remove(idToDelete);
    }


}




