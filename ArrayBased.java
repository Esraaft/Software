import java.util.ArrayList;

public class ArrayBased implements IConnection {
	private ArrayList<NotificationModule> NotificatonModules=new ArrayList<NotificationModule>();
	public int getSize() {
		return NotificatonModules.size();
	}
	public void addNotification(NotificationModule newNotificationModule ) {
		NotificatonModules.add(newNotificationModule);
		//Size++;
	}
	public void readNotifications() {
		for(int i=0;i<NotificatonModules.size();i++) {
			System.out.println("Template "+(i+1)+"):");
			System.out.println("Subject: "+NotificatonModules.get(i).getSubject());
			System.out.println("Content: "+NotificatonModules.get(i).getContent());
			System.out.println("Supported Language: "+NotificatonModules.get(i).getLanguage());
			System.out.println("Channel used: "+NotificatonModules.get(i).getChannel());
		}
		if(NotificatonModules.size()==0)
			System.out.print("No Notification Modules available to read");
		
	}
	
	public void removeNotificationByID(int ID) {
		NotificatonModules.remove(ID);
		//Size--;
	}
	public NotificationModule geteNotificationByID(int ID ) {
		return NotificatonModules.get(ID);
	}
	
}
