package com.bol.pageObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Jim Bonica
 *
 * Nov 16, 2018
 */
  
@Component
public class GSPageObjectFactory {

	@Autowired
	private ApplicationContext appContext;

	/**
	 * 
	 * @return
	 */
	public DrugsAssociatedWithMechanismPage getDrugsAssociatedWithMechanismPage() {
		return (DrugsAssociatedWithMechanismPage) appContext.getBean("drugsAssociatedWithMechanismPage");
	}
	
	public DrugDetailsPage getDrugDetailsPage() {
		return (DrugDetailsPage) appContext.getBean("drugDetailsPage");
	}

}
