package domain;

public class Study {

	private String studyId;
	private String studyName;
	private String studyManager;
	private String studyOid;
	private String principalInvestigator;
	private Integer enrollment;
	private String sponsor;
	private String protocolType;
	private String status;
	private String briefSummary;
	private String startDate;

	public Study(String studyId, String studyName, String studyManager, String studyOid) {
		this.studyId = studyId;
		this.studyName = studyName;
		this.studyManager = studyManager;
		this.studyOid = studyOid;
	}

	public String getStudyId() {
		return studyId;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getStudyManager() {
		return studyManager;
	}

	public void setStudyManager(String studyManager) {
		this.studyManager = studyManager;
	}

	public String getStudyOid() {
		return studyOid;
	}

	public void setStudyOid(String studyOid) {
		this.studyOid = studyOid;
	}

	public String getPrincipalInvestigator() {
		if (principalInvestigator != null) {
			return principalInvestigator;
		} else {
			return "Dr. Martin Van Nostrand";
		}
	}

	public void setPrincipalInvestigator(String principleInvestigator) {
		this.principalInvestigator = principleInvestigator;
	}

	public Integer getEnrollment() {
		if (enrollment != null) {
			return enrollment;
		} else {
			return 100;

		}
	}

	public void setEnrollment(Integer enrollment) {
		this.enrollment = enrollment;
	}

	public String getSponsor() {
		if (sponsor != null) {
			return sponsor;
		} else {
			return "Roxxon Energy Corporation";
		}
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getProtocolType() {
		if (protocolType != null) {
			return protocolType;
		} else {
			return "Observational";
		}
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	public String getStatus() {
		if (status != null) {
			return status;
		} else {
			return "available";
		}
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBriefSummary() {
		if (briefSummary != null) {
			return briefSummary;
		} else {
			return "This is a very brief summary of " + getStudyName() + ".";
		}

	}

	public void setBriefSummary(String briefSummary) {
		this.briefSummary = briefSummary;
	}

	public String getStartDate() {
		if(startDate != null) {
		return startDate;
		} else {
			return "today";
		}
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String assignUserRolesString() {
		return "{ \"username\": \"root\", \"role\": \"Data Manager\" }";
	}

}
