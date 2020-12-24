import java.util.ArrayList;

public interface INotificationDatabase {
	public void addTemplate(NotificationModule newNotificationModule);
	public void updateTemplate(NotificationModule existinfNotificationModule);
	public NotificationModule getTemplate(int ID);
	public boolean deleteTemplate(int ID);
	public ArrayList<NotificationModule> getAllTemplates();
}
