package extraclasses;

public class viewassignments 
{
	public String assid;
	public String path;
	public String roll;
	public String stdname;
	public String donelate;
	public viewassignments(String assid, String path, String roll, String stdname, String donelate) {
		super();
		this.assid = assid;
		this.path = path;
		this.roll = roll;
		this.stdname = stdname;
		this.donelate = donelate;
	}
	public String getAssid() {
		return assid;
	}
	public void setAssid(String assid) {
		this.assid = assid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getDonelate() {
		return donelate;
	}
	public void setDonelate(String donelate) {
		this.donelate = donelate;
	}
	@Override
	public String toString() {
		return "viewassignments [assid=" + assid + ", path=" + path + ", roll=" + roll + ", stdname=" + stdname
				+ ", donelate=" + donelate + "]";
	}
	
	
	
}
