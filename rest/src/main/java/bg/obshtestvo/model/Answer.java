package bg.obshtestvo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "number_of_votes")
	private Integer numberOfVotes;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserSecurityDetails author;

	@ManyToMany(mappedBy = "answers")
	private List<Item> items;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "answer")
	private List<Comment> comments;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserSecurityDetails getAuthor() {
		return author;
	}

	public void setAuthor(UserSecurityDetails author) {
		this.author = author;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
