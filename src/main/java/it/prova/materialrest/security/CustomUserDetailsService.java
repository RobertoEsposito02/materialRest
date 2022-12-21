package it.prova.materialrest.security;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.prova.materialrest.model.User;
import it.prova.materialrest.repository.user.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {


	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
		String userRoles = user.getRuolo().getCodice();
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

}
