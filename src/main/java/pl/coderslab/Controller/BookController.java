package pl.coderslab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.models.Book;
import pl.coderslab.services.MemoryBookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) { // jezeli chce skorzystac z obiektu przy wyswietlaniu
        this.memoryBookService = memoryBookService;
    }


    @RequestMapping("/invitation")
    public String invitation(){

        return "invitation";
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Book> listOfBooks(){

        return memoryBookService.getList();
    }

    @RequestMapping( value ="/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String bookById(@PathVariable String id){
        int bookIdParsed = Integer.parseInt(id);

        return memoryBookService.getBookById(bookIdParsed);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBookById(@PathVariable String id){
        int bookIdToDelete = Integer.parseInt(id);

        memoryBookService.removeBook(bookIdToDelete);

        return "Usunieto pozycje nr " + bookIdToDelete;
    }

    @RequestMapping(value = "/addBook/{id}/{isbn}/{title}/{author}/{publisher}/{type}", method = RequestMethod.POST)
    @ResponseBody
    public Book addBook(@PathVariable(name="id") String id,
                          @PathVariable(name="isbn") String isbn,
                          @PathVariable(name="title") String title,
                          @PathVariable(name="author") String author,
                          @PathVariable(name="publisher") String publisher,
                          @PathVariable(name="type") String type){

        int idParameter = Integer.parseInt(id);

        return memoryBookService.addBook(idParameter,isbn,title,author,publisher,type);

    }

    @RequestMapping(value = "/updateBook/{id}/{isbn}/{title}/{author}/{publisher}/{type}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable(name="id") String id,
                             @PathVariable(name="isbn") String isbn,
                             @PathVariable(name="title") String title,
                             @PathVariable(name="author") String author,
                             @PathVariable(name="publisher") String publisher,
                             @PathVariable(name="type") String type){

        int idparam = Integer.parseInt(id);

        memoryBookService.editBook(idparam, isbn, title, author, publisher, type);



        return "redirect:http://localhost:8080/books/listOfBooks";
    }





}
