package bg.obshtestvo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import bg.obshtestvo.config.security.AuthorizationRequestContext;
import bg.obshtestvo.config.security.AuthorizationService;
import bg.obshtestvo.model.User;
import bg.obshtestvo.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService, AuthorizationService {

	@Resource
	private UserRepository userRepository;

	@Override
	public User createOrUpdateUser(User user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(user.getPassword() != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		return userRepository.save(user);
	}

	@Override
	public void removeUser(int id) {
		userRepository.delete((long) id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(int id) {
		return userRepository.findOne((long) id);
	}

	@Override
	public User authorize(
			AuthorizationRequestContext auth) {
		if (auth.getAuthorizationToken() == null) {
			return null;
		}
		byte[] decoded = Base64.decode(auth.getAuthorizationToken().getBytes());
		String decodedToken = new String(decoded);
		String[] userAndPass = decodedToken.split(":");
		User user = userRepository.findByUsername(userAndPass[0]);
		boolean matches = new BCryptPasswordEncoder().matches(userAndPass[1], user.getPassword());
		return matches ? user : null;
	}
}
