package edu.sjsu.cmpe275.library.model;

public interface BookDao {
    public void insert(BookEntity b);
    public void deleteById(Long id);
    public void update(BookEntity b);
    public BookEntity findById(Long id);
}
