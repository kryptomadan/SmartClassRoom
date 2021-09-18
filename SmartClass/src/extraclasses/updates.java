package extraclasses;

public class updates {

	public String topic;
	public String path;
	public updates(String topic, String path) {
		super();
		this.topic = topic;
		this.path = path;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "updates [topic=" + topic + ", path=" + path + "]";
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
