
public interface INotificationModule {
	public String getContent();
	public String getLanguage() ;
	public String getChannel() ;
	public String getSubject();
	public int getID() ;
	public void setContent(Content content) ;
	public void setLanguage(String input) ;
	public void setChannel(String input);
	public void setID(int ID);
	public void setSubject(String subject) ;
}
