package services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Jim Bonica
 *
 *         Oct 25, 2018
 * 
 *         Added to use beans in classes that are not managed by Spring like
 *         DTOs
 */

@Service
public class BeanUtil implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		context = applicationContext;

	}

	public static <T> T getBean(Class<T> beanClass) {

		return context.getBean(beanClass);

	}

}
