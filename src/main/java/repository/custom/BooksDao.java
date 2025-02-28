package repository.custom;

import model.Books;
import repository.CrudRepository;

public interface BooksDao extends CrudRepository<Books,String> {
}
