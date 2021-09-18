package extraclasses;
// this class is used to store the available assignments for the subject
public class AssigmnetAvailable {

	public String topic;
	public String desc;
	public String dandt;
	public String assid;
	public AssigmnetAvailable(String topic, String desc, String dandt, String assid) {
		super();
		this.topic = topic;
		this.desc = desc;
		this.dandt = dandt;
		this.assid = assid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDandt() {
		return dandt;
	}
	public void setDandt(String dandt) {
		this.dandt = dandt;
	}
	public String getAssid() {
		return assid;
	}
	public void setAssid(String assid) {
		this.assid = assid;
	}
	@Override
	public String toString() {
		return "AssigmnetAvailable [topic=" + topic + ", desc=" + desc + ", dandt=" + dandt + ", assid=" + assid + "]";
	}
	
}
