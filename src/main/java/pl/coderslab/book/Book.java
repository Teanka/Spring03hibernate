package pl.coderslab.book;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.author.Author;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(groups = {PropositionGroupValidator.class})
    @Size(min=5,groups = {PropositionGroupValidator.class, BookGroupValidator.class})
    private String title;
    @Min(value=1, groups = BookGroupValidator.class)
    @Max(value =10, groups = BookGroupValidator.class)
    private int rating;
    @NotBlank(groups = {PropositionGroupValidator.class})
    @Size(max=600,groups = {PropositionGroupValidator.class, BookGroupValidator.class})
    private String description;
    //    @JoinTable(name = "BOOKS_AUTHORS",
//    join)
    @NotNull(groups = BookGroupValidator.class)
    @ManyToOne //(cascade = CascadeType.ALL)
    private Publisher publisher;
    private Date createdate;

    @NotEmpty(groups = BookGroupValidator.class)
    @ManyToMany//(fetch=FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();
    @Min(value=1,groups = BookGroupValidator.class)
    private int pages;
    private boolean proposition;//domyślnie false
    @ManyToOne
    private Category category;

//    Dla encji Book ustaw następujące ograniczenia:
//    title - minimum 5 znaków
//    rating - w przedziale 1 do 10
//    description - maksymalnie 600 znaków
//    author - pole wymagane
//    publisher - pole wymagane
//    Rozbuduj encję o pole:
//    pages - większe od 1
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
