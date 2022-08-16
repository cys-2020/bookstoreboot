package com.cys.boot.service;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Qualifier;
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, FIELD, METHOD, CONSTRUCTOR })
@Qualifier//��������չ����Ϊһ���޶���ע��
public @interface StatusForUser {
	//�Զ���ע�����ڶ�ʵ����ע��ʱ�����֣���ǣ������ǲ���ɨ��
}
