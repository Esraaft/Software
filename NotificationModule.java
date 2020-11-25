
public class NotificationModule {
	private Content content;
	private Language language;
	private Channel channel;
	//constructor
	public NotificationModule(Content content,Language language,Channel channel) {
		this.content=content;
		this.language=language;
		this.channel=channel;
		
	}
	public String getContent() {
		return content.getTemplate();
	}
	public String getLanguage() {
		return language.toString();
	}
	public String getChannel() {
		return channel.toString();
	}
	
}
