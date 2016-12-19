package edu.sjsu.cmpe275.library.repository;

import edu.sjsu.cmpe275.library.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by aa001 on 12/4/16.
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findById(Long id);

    @Modifying
    @Transactional
    @Query("update BookEntity book set book.isbn=:qisbn, book.author=:qauthor, book.title=:qtitle, book.callNumber=:qcallNumber, book.publisher=:qpublisher, book.year=:qyear, book.location=:qlocation, book.numberOfCopies=:qnumberOfCopies, book.status=:qstatus, book.keywords=:qkeywords, book.coverUrl=:qcoverUrl")
    void updateBook(@Param("qisbn") String isbn, @Param("qauthor") String author, @Param("qtitle") String title, @Param("qcallNumber") String callNumber, @Param("qpublisher") String publisher, @Param("qyear") String year, @Param("qlocation") String location, @Param("qnumberOfCopies") String numberOfCopies, @Param("qstatus") String status, @Param("qkeywords") String keywords, @Param("qcoverUrl") String coverUrl);

}
