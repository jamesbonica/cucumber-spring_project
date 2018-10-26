package dto;

import org.springframework.beans.factory.annotation.Autowired;

import config.CrossScenarioCache;
import services.BeanUtil;

public class UserDTO {

	private String username;
	private String fName;
	private String lName;
	private String institution;
	private String email;
	private String study_name;
	private String role_name;
	private String user_type;
	private String authorize_soap;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getInstitution() {
		if(institution != null) {
		return institution;
		} else {
			return "Brand Corporation";
		}
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudy_name() {
		CrossScenarioCache crossScenarioCache = BeanUtil.getBean(CrossScenarioCache.class);
		if(study_name != null) {
		return study_name;
		} else {
			return crossScenarioCache.getMainStudy().getStudyName();
		}
	}

	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getAuthorize_soap() {
		if(authorize_soap != null) {
		return authorize_soap;
		} else {
			return "false";
		}
	}

	public void setAuthorize_soap(String authorize_soap) {
		this.authorize_soap = authorize_soap;
	}

}
