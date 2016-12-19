package edu.sjsu.cmpe275.library.repository;

import edu.sjsu.cmpe275.library.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by dzkan on 2016/3/8.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying
    @Transactional
    @Query("update UserEntity us set us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
    void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);

    UserEntity findByEmail(String email);
    Collection<UserEntity> findAllByUnivId(String univId);
    UserEntity findByVerificationToken(String token);
}
