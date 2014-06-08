package bg.obshtestvo.service;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import bg.obshtestvo.repository.UserSecurityDetailsRepository;

@Component
public class UserSecurityDetailsServiceImpl implements UserDetailsService {

	@Resource
	private UserSecurityDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		throw new UsernameNotFoundException("PUTKA");
	}
	
/*	public void registerUser(String username, String password, String firstName, String lastName, String email, Date birthDate) {
		UserSecurityDetails user = new UserSecurityDetails(username, password, firstName, lastName, email, birthDate);
		userDetailsRepository.save(user);
	}
*/
}
