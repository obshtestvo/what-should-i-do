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
		throw new UsernameNotFoundException("PENIS");
	}

}
