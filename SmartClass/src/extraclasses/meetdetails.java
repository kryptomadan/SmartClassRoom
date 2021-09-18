package extraclasses;

public class meetdetails {

	public String topic = null;
	public String dandt =null;
	public String link = null;
	public String tid=null;
	public String subid = null;
	public meetdetails(String topic, String dandt, String link, String tid, String subid) {
		super();
		this.topic = topic;
		this.dandt = dandt;
		this.link = link;
		this.tid = tid;
		this.subid = subid;
	}
	@Override
	public String toString() {
		return "meetdetails [topic=" + topic + ", dandt=" + dandt + ", link=" + link + ", tid=" + tid + ", subid="
				+ subid + "]";
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	
	
	
	
}
