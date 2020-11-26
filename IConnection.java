
public interface IConnection {
	
	public void addNotification(NotificationModule newNotificationModule );
	public void readNotifications();
	public void removeNotificationByID(int ID);
	public NotificationModule geteNotificationByID(int ID );
	public int getSize();
}
