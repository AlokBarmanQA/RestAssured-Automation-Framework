package pojos;

public class PostAPIPojo {

	private String FirstName;
	private String LastName;
	private int SubjectID;
	private int id;
	
	public PostAPIPojo(String FirstName, String LastName, int SubjectID, int id) {
		
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.SubjectID = SubjectID;
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public int getSubjectID() {
		return SubjectID;
	}

	public void setSubjectID(int SubjectID) {
		this.SubjectID = SubjectID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PostAPIPojo [FirstName=" + FirstName + ", LastName=" + LastName + ", SubjectID=" + SubjectID + ", id="
				+ id + "]";
	}
	
}
