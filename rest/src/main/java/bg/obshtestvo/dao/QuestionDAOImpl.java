package bg.obshtestvo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.obshtestvo.models.Question;

@Component
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public void insertQuestion() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Question> getQuestionsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuestion(Question question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Question getQuestion(int id) {
		String sql = "select * from questions where id=?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		Question question = new Question();
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				question.setId(rs.getInt("id"));
				question.setQuestionName(rs.getString("question"));
				question.setAnswer(rs.getString("answer"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return question;

	}

}
