
public class NotificationModule {
	private Content content;
	private Language language;
	private Channel channel;
	//constructor
	public NotificationModule(Content content) {
		this.content=content;
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
	public void setLanguage(String input) {
		System.out.println("input is "+input);
		switch(input)
		{
		case "Arabic":  language=Language.Arabic;break;
		case "English":  language=Language.English;break;
		case "French":  language=Language.French;break;
		case "German":	language=Language.German;break;
		case "Italian": language=Language.Italian;break;
		default: 	language=Language.English;
		}
	}
	public void setChannel(String input) {
		switch(input)
		{
		case "SMS":  channel=Channel.SMS;break;
		case "email": channel=Channel.email;  break;
		default: channel=Channel.email;
		}
	}
	
}
