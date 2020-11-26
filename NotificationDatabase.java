import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class NotificationDatabase implements INotificationDatabase {
	private IConnection dbConnection;
	public NotificationDatabase(IConnection obj) {
		dbConnection=obj;
	}
	public void Create() {
		System.out.println("Enter the message template you want to create (with placeholders being placed in curly brackets).");
		Scanner scanner=new Scanner(System.in);
		String input=scanner.nextLine();
		Content content=new Content(input);
		NotificationModule newNotificationModule=new NotificationModule();
		newNotificationModule.setContent(content);
		System.out.println("Enter template subject");
		input=scanner.nextLine();
		newNotificationModule.setSubject(input);
		System.out.println("Choose the language: Arabic-English-French-German-Italian");
		input=scanner.nextLine();
		newNotificationModule.setLanguage(input);
		System.out.println("Choose the Channel: SMS-email");
		input=scanner.nextLine();
		newNotificationModule.setChannel(input);
		//set ID to the template
		newNotificationModule.setID(dbConnection.getSize());
		//add to the database
		dbConnection.addNotification(newNotificationModule);
		System.out.println("Your template is created successfully!");
	}
public void Read() {
		dbConnection.readNotifications();
	}
public void Update() {
	if(dbConnection.getSize()==0)
		System.out.print("No Notification Modules available to update");
	else {
		String takeInput;
	System.out.print("Which template you want to update :(Enter ID) ");
	Scanner scanner =new Scanner(System.in);
	int TemplateNumber = Integer.parseInt(scanner.nextLine());
	while (checkNotFound(TemplateNumber)){
		System.out.println("Enter Valid choice");
		TemplateNumber = Integer.parseInt(scanner.nextLine());
	}
	while (true) {
		System.out.print("Choose what you want to update : \n"
				+ "1) Template Content \n"
				+ "2) Supported Language \n"
				+ "3) Channel used \n"
				+ "4) Subject  \n"
				+ "Enter '5' to exit \n");
		int input = Integer.parseInt(scanner.nextLine());
		while(input >5 ||input<0){
			System.out.print("Invalid choice");
			input = Integer.parseInt(scanner.nextLine());
		}
		if (input == 1) {
			System.out.print("Write your updated content \n");
			takeInput= scanner.nextLine();
			Content newContet = new Content(takeInput);
			dbConnection.geteNotificationByID(TemplateNumber).setContent(newContet);
		}
		else if (input == 2) {
			System.out.print("Write your updated Language \n");
			takeInput = scanner.nextLine();
			dbConnection.geteNotificationByID(TemplateNumber).setLanguage(takeInput);
		} else if (input == 3) {
			System.out.print("Write your updated channel \n");
			takeInput = scanner.nextLine();
			dbConnection.geteNotificationByID(TemplateNumber).setChannel(takeInput);
		}
		else if(input==4) {
			System.out.print("Write your updated subject \n");
			takeInput = scanner.nextLine();
			dbConnection.geteNotificationByID(TemplateNumber).setSubject(takeInput);
		}
		else if (input == 5)
			break;
	}
	}
	
}
public void Delete() {
	if(dbConnection.getSize()==0)
		System.out.print("No Notification Modules available to delete");
	else {
	System.out.print("Enter template ID you want to delete : ");
	Scanner scanner=new Scanner(System.in);
	int input=scanner.nextInt();
	while (checkNotFound(input)){
		System.out.println("Enter Correct choice");
		input=scanner.nextInt();
	}
	dbConnection.removeNotificationByID(input);
	System.out.println("Your template is deleted successfully!");
	}
}
public boolean checkNotFound(int index){
	for (int i =0;i< dbConnection.getSize(); i++){
		if(index==i)
			return false;
	}
	return true;
}
public static void main(String args[]) throws IOException {

	Scanner scanner=new Scanner(System.in);
	ArrayBased a=new ArrayBased();
	NotificationDatabase db=new NotificationDatabase(a);
	while(true){
		System.out.print("\nChoose option: \n"
				+"1) Create Template  \n"
				+"2) Read Templates \n"
				+"3) Update Template \n"
				+"4) Delete Template \n"
				+"Enter '5' to exit \n");
		int input = scanner.nextInt();
		while (input<0||input>5){
			System.out.println("Enter Correct choice");
			input = scanner.nextInt();
		}

		if(input ==1)
			db.Create();
		else if(input==2)
			db.Read();
		else if(input==3)
			db.Update();
		else if(input==4)
			db.Delete();
		else if(input==5)
			break;

	}
}

}
