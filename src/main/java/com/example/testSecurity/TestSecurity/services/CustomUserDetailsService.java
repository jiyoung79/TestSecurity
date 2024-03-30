package com.example.testSecurity.TestSecurity.services;

import com.example.testSecurity.TestSecurity.dto.CustomUserDetails;
import com.example.testSecurity.TestSecurity.entity.UserEntity;
import com.example.testSecurity.TestSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // CustomUserDetailsService에서 생성 후 변수 생성
        UserEntity userData = userRepository.findByUsername(username);
        // null이 아니면 로그인 진행
        if(userData != null){
            // CustomUserDetails는 DTO에 해당하기 때문에 DTO에서 클래스 생성,
            // import 후 같은 클래스에 userData의 생성자를 만들어주어야함
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
