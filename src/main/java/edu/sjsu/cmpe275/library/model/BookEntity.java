package edu.sjsu.cmpe275.library.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name="isbn")
    private String isbn;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "call_no")
    private String callNumber;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year")
    private String year;
    @Column(name = "location")
    private String location;
    @Column(name = "number")
    private String numberOfCopies;
    @Column(name = "status")
    private String status;
    @Column(name = "keywords")
    private String keywords;
    @Column(name = "cover")
    private String coverUrl;
    @ManyToOne()
    @JoinColumn(name = "cretate_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity createdBy;
    @ManyToOne()
    @JoinColumn(name = "update_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity updatedBy;
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Collection<CheckOutEntity> checkOut;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCallNumber() {
        return callNumber;
    }
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getNumberOfCopies() {
        return numberOfCopies;
    }
    public void setNumberOfCopies(String numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getCoverUrl() {
        return coverUrl;
    }
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public edu.sjsu.cmpe275.library.model.UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(edu.sjsu.cmpe275.library.model.UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public edu.sjsu.cmpe275.library.model.UserEntity getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(edu.sjsu.cmpe275.library.model.UserEntity updatedBy) {
        this.updatedBy = updatedBy;
    }

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

        BookEntity that = (BookEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (callNumber != null ? !callNumber.equals(that.callNumber) : that.callNumber != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (callNumber != null ? callNumber.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", callNumber='" + callNumber + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", location='" + location + '\'' +
                ", numberOfCopies='" + numberOfCopies + '\'' +
                ", status='" + status + '\'' +
                ", keywords='" + keywords + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", checkOut=" + checkOut +
                '}';
    }
}