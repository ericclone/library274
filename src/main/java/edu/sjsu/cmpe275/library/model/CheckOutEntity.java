package edu.sjsu.cmpe275.library.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aa001 on 12/18/16.
 */
@Entity
@Table(name = "checkout")
public class CheckOutEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private BookEntity book;
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @Temporal(TemporalType.DATE)
    @Column(name = "due")
    private Date dueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckOutEntity that = (CheckOutEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return dueDate != null ? dueDate.equals(that.dueDate) : that.dueDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }
}
