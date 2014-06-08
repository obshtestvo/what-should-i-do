package bg.obshtestvo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

import bg.obshtestvo.utils.CollectionToCSVBridge;

@Entity
@Indexed
@Table(name = "items")
public class Item {

	@DocumentId
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "date_created")
	private Date dateCreated;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserSecurityDetails author;

	@IndexedEmbedded
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@ManyToMany
	private List<Answer> answers;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name="alias")
	private String alias;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column (name = "tags")
	@ElementCollection
	@FieldBridge(impl = CollectionToCSVBridge.class)
	private List<String> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public UserSecurityDetails getAuthor() {
		return author;
	}

	public void setAuthor(UserSecurityDetails author) {
		this.author = author;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
