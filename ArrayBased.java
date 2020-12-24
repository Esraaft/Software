import java.util.ArrayList;

public class ArrayBased implements INotificationDatabase {
	private ArrayList<NotificationModule> NotificatonModules=new ArrayList<NotificationModule>();
	public int getSize() {
		return NotificatonModules.size();
	}
	public void addTemplate(NotificationModule newNotificationModule ) {
		NotificatonModules.add(newNotificationModule);

	}
	public NotificationModule getTemplate(int ID ) {
		return NotificatonModules.get(ID);
	}
	public  ArrayList<NotificationModule> getAllTemplates() {
		return NotificatonModules;
		
	}
	
	public boolean deleteTemplate(int ID) {
		if(NotificatonModules.contains(ID)) {
			NotificatonModules.remove(ID);
			return true;
		}
		return false;
	}
	public void updateTemplate(NotificationModule existingNotificationModule) {
		return ;
	}
	
	
}
