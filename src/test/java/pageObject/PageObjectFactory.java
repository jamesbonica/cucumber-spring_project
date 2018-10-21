package pageObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PageObjectFactory {

	@Autowired
	private ApplicationContext appContext;

	public LoginPage getLoginPage() {
		return (LoginPage) appContext.getBean("loginPage");
	}
}
