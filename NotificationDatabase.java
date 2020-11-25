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
		System.out.println("Choose the language: Arabic-English-French-German-Italian");
		input=scanner.nextLine();
		Language obj;
		switch(input)
		{
		case "Arabic":  obj=Language.Arabic;
		case "English":  obj=Language.English;
		case "French":  obj=Language.French;
		case "German":	obj=Language.German;
		case "Italian": obj=Language.Italian;
		default: 	obj=Language.English;
		}
		System.out.println("Choose the Channel: SMS-email");
		input=scanner.nextLine();
		Channel obj2;
		switch(input)
		{
		case "SMS":  obj2=Channel.SMS;
		case "email": obj2=Channel.email;  
		default: obj2=Channel.email;
		}
		NotificationModule newNotificationModule=new NotificationModule(content,obj,obj2);
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
	db.Read();
	

}
}
