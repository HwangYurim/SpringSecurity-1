package com.securiry.study.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// AbstractSecurityWebApplicationInitializer �� �����Ͽ�, ��� ��û�� ���� ���ͼ�Ʈ�ϵ��� springSecurityFilterChain�� ���� �� ��. (������ �����ȱ״��{default����}�� ���)
@Order(1)
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer{

	public SecurityWebAppInitializer() {
		super();
	}
}
