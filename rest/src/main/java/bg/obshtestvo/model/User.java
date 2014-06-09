package bg.obshtestvo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user")
public class User {

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Item> items;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Answer> answers;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Vote> votes;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
	private List<Comment> comments;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Session> sessions;

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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
