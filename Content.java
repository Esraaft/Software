import java.util.Map;

public class Content {
	private Map Placeholders;
	private String WholeText; // msg template without actual values
	public String getMessage() { // To be implemented later
		return null;
	}
	public Content(String WholeText) {
		this.WholeText=WholeText;
	}
	public String getTemplate() {
		return WholeText;
	}
}
