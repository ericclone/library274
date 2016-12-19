package edu.sjsu.cmpe275.library.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dzkan on 2016/3/8.
 */
@Entity
@Table(name = "user", schema = "library", catalog = "")
public class UserEntity {
    private int id;
    private String email;
    private String nickname;
    private String password;
    private String firstName;
    private String lastName;
    private String univId;
    private String authority;
    private String verificationToken;
    private boolean enabled = false;
    private Collection<BookEntity> booksCreated;
    private Collection<BookEntity> booksUpdated;
    private Collection<CheckOutEntity> checkOut;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 45)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "univid", nullable = false, length = 9)
    public String getUnivId() {
        return univId;
    }

    public void setUnivId(String univId) {
        this.univId = univId;
    }

    @Basic
    @Column(name="authority", nullable = false)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "token", nullable = false)
    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.EAGER)
    public Collection<BookEntity> getBooksCreated() {
        return booksCreated;
    }

    public void setBooksCreated(Collection<BookEntity> booksCreated) {
        this.booksCreated = booksCreated;
    }

    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.EAGER)
    public Collection<BookEntity> getBooksUpdated() {
        return booksUpdated;
    }

    public void setBooksUpdated(Collection<BookEntity> booksUpdated) {
        this.booksUpdated = booksUpdated;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Collection<CheckOutEntity> getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Collection<CheckOutEntity> checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
