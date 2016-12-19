package edu.sjsu.cmpe275.library.repository;

import edu.sjsu.cmpe275.library.model.BookEntity;
import edu.sjsu.cmpe275.library.model.CheckOutEntity;
import edu.sjsu.cmpe275.library.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aa001 on 12/18/16.
 */
@Repository
public interface CheckOutRepository extends JpaRepository<CheckOutEntity, Long> {
    CheckOutEntity findByUserAndBook(UserEntity user, BookEntity book);
    CheckOutEntity findByUser_IdAndBook_Id(int uid, Long bid);
}
