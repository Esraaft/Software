import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class NotificationDatabase {
	private ArrayList<NotificationModule> NotificatonModules=new ArrayList<NotificationModule>();
	public void Create() {
		System.out.println("Enter the message template you want to create (with placeholders being placed in curly brackets).");
		Scanner scanner=new Scanner(System.in);
		String input=scanner.nextLine();
		Content content=new Content(input);
		NotificationModule newNotificationModule=new NotificationModule(content);
		System.out.println("Choose the language: Arabic-English-French-German-Italian");
		input=scanner.nextLine();
		newNotificationModule.setLanguage(input);
		System.out.println("Choose the Channel: SMS-email");
		input=scanner.nextLine();
		newNotificationModule.setChannel(input);
		//add to the array list
		NotificatonModules.add(newNotificationModule);
		System.out.println("Your template is created successfully!");
	}
public void Read() {
		for(int i=0;i<NotificatonModules.size();i++) {
			System.out.println("Template "+(i+1)+"):");
			System.out.println(NotificatonModules.get(i).getContent());
			System.out.println("Supported Language: "+NotificatonModules.get(i).getLanguage());
			System.out.println("Channel used: "+NotificatonModules.get(i).getChannel());
		}
	}
public void Update() {
	
}
public void Delete() {
	
}
public static void main(String args[]) throws IOException {
	
	NotificationDatabase db=new NotificationDatabase();
	db.Create();
	db.Create();
	db.Read();

}
}
