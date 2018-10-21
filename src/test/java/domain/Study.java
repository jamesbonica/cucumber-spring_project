package domain;

public class Study {

	private String studyName;
	private String studyManager;
	private String studyOid;

	public Study(String studyName, String studyManager, String studyOid) {
		this.studyName = studyName;
		this.studyManager = studyManager;
		this.studyOid = studyOid;
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

}
