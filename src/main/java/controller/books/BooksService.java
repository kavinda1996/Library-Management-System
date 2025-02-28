package controller.books;

import model.Books;

import java.util.List;

public interface BooksService {
    boolean addItem();
    boolean updateItem();
    boolean deleteItem();
    Books searchItem(String code);
    List<Books> getAll();
}
