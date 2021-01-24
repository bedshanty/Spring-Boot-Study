package io.makeon.springboottest.config.auth;

import io.makeon.springboottest.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
// Spring Security 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // h2-console 화면 사용을 위해 해당 옵션들 disable
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                // URL 별 권환 관리 설정 옵션의 시작점
                .authorizeRequests()
                // 지정된 URL 들을 permitAll() 을 통해 전체 열람 권한
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                // 지정된 URL 들은 USER 권한을 가진 사람에게만 열람 가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                // anyRequest() => 지정되지 않은 나머지 URL 들
                // authenticated() 를 통해 모두 인증(로그인)된 사용자 들에게만 허용
                .anyRequest().authenticated()
                .and()
                // 로그아웃 기능에 대한 설정의 진입점
                .logout()
                // 로그아웃 성공시 해당 URL 로 이동
                .logoutSuccessUrl("/")
                .and()
                // OAuth2 로그인 기능에 대한 설정의 진입점
                .oauth2Login()
                // OAuth2 로그인 성공 이후 사용자 정보 가져오는 설정 담당
                .userInfoEndpoint()
                // 로그인 성공 후 후속 처리를 진행할 UserService 구현체 등록
                .userService(customOAuth2UserService);
    }
}
