package repository.custom.impl;

import model.Books;
import repository.custom.BooksDao;

import java.util.List;

public class BooksDaoImpl implements BooksDao {
    @Override
    public boolean save(Books entity) {
        return false;
    }

    @Override
    public boolean update(String s, Books entity) {
        return false;
    }

    @Override
    public Books search(String s) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Books> getAll() {
        return null;
    }
}
