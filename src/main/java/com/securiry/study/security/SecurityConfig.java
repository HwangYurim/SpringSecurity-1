package com.securiry.study.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //�� ������̼��� �پ������� ��Ĺ�� ����Ǹ鼭 �������ϵ��� bean�� �÷��ش�.
@EnableWebSecurity //����ť��Ƽ�� ����ϰ���.
public class SecurityConfig extends WebSecurityConfigurerAdapter { //�����������ӿ�ũ�� ��ť��Ƽ�� �����ϴ� �߻�Ŭ������ ��� �޾� �������̵��Ͽ� ����ü�� ���� �� ��.
	
	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception{
		// �θ޸� ������� ������ �����Ѵ�.
		//TODO: ���Ŀ��� DB�� ����� ������ ������ ���ǿ� �ø� �� ��.
		auth.inMemoryAuthentication()
			.withUser("bae")
			.password("{noop}1234") // ��ť��Ƽ 5���� �̻���ʹ� 
			.roles("USER");
		
		/*
		 * spring-security-core : 5.0.0.RC1���� �⺻ PasswordEncoder�� DelegatingPasswordEncoder�� ����˴ϴ�. 
		 * ����ڸ� �޸𸮿� �����ϸ� �Ϲ� �ؽ�Ʈ�� ��ȣ�� �����ϰ� DelegatingPasswordEncoder���� 
		 * ��ȣ�� Ȯ���Ϸ��� ���ڴ��� �˻� �� �� ��ȣ�� �����ϴ� ����� ��ġ�ϴ� ��ȣ�� ã�� �� �����ϴ�.
		 * ����URL : https://cnpnote.tistory.com/entry/SPRING-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8-PasswordEncoder-%EC%98%A4%EB%A5%98
		 * TODO : ���Ŀ� ��ȣȭ �����Ѱ��� DB���� ��������� �ڿ������� �ذ�� �� ����. (������ �θ޸𸮹���̶� �ϴ��� �ǳʶڴ�.)
		 */
	}
	
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/**").access("hasRole('USER')") //��� ������ url������  USER��� ������ �ο����� ������ ������ �����ϵ��� ����
			.and().formLogin() 
			.and().httpBasic()//��ť��Ƽ���� �⺻������ �����ϴ� �α����� ( TODO: ���Ŀ��� �α����������� ���� ������ �� . )
			.and().logout()
			.and().csrf().disable(); //å���� ���Ŀ� �ٷ�ٰ���
	}
	
	
	
}
