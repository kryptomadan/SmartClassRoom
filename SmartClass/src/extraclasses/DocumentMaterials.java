package extraclasses;

public class DocumentMaterials {

	public String subid;
	public String subname;
	public String path;
	public String topic;
	public String dandt;
	public DocumentMaterials(String subid, String subname, String path, String topic, String dandt) {
		super();
		this.subid = subid;
		this.subname = subname;
		this.path = path;
		this.topic = topic;
		this.dandt = dandt;
	}
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDandt() {
		return dandt;
	}
	public void setDandt(String dandt) {
		this.dandt = dandt;
	}
	@Override
	public String toString() {
		return "VideoMaterials [subid=" + subid + ", subname=" + subname + ", path=" + path + ", topic=" + topic
				+ ", dandt=" + dandt + "]";
	}
	
}
