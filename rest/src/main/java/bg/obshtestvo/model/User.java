package bg.obshtestvo.model;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "users")
public class User implements Principal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long userId;

	@Column(name = "username", nullable = false, unique = true)
	@NotNull
	private String username;

	@Column(name = "password", nullable = false)
	@NotNull
	private String password;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	@Email
	private String email;

	@Column(name = "age")
	private Integer age;

	@OneToMany( mappedBy = "author", cascade = CascadeType.ALL)
	@OrderColumn(name = "ID")
	@LazyCollection(LazyCollectionOption.TRUE)
	@JsonIgnore
	private Set<Item> items;

	@OneToMany( mappedBy = "author", cascade = CascadeType.ALL)
	@OrderColumn(name = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<Answer> answers;


	@OneToMany( mappedBy = "userId", cascade = CascadeType.ALL)
	@OrderColumn(name = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<Vote> votes;

	@OneToMany(mappedBy = "author")
	@OrderColumn(name = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<Comment> comments;

	@OneToMany( mappedBy = "user")
	@OrderColumn(name = "ID")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<Session> sessions;

	@Column
	private String role;

	public User() {

	}

	public User(String username, String password, String firstName,
			String lastName, String email, Integer age) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.setAge(age);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	@Transient
	public String getName() {
		return username;
	}

}
