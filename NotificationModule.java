public class NotificationModule implements INotificationModule{
	private Content content;
	private Language language;
	private Channel channel;
	private String subject;
	private int ID;

	
	public String getContent() {
		return content.getTemplate();
	}
	public String getLanguage() {
		return language.toString();
	}
	public String getChannel() {
		return channel.toString();
	}
	public String getSubject() {
		return subject;
	}
	public int getID() {
		return ID;
	}
	public void setContent(Content content) {
		this.content=content;
	}
	public void setLanguage(String input) {
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
	public void setID(int ID) {
		this.ID=ID;
	}
	public void setSubject(String subject) {
		this.subject=subject;
	}
	
}