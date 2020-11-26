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
		NotificationModule newNotificationModule=new NotificationModule();
		newNotificationModule.setContent(content);
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
	public boolean chechNotFound(int index){
		for (int i =0;i< NotificatonModules.size(); i++){
			if(index==i)
				return false;
		}
		return true;
	}
public void Update() {
		String takeInput;
	System.out.print("Which template you want to update : ");
	Scanner scanner =new Scanner(System.in);
	int TemplateNumber = Integer.parseInt(scanner.nextLine());
	while (chechNotFound(TemplateNumber-1)){
		System.out.println("Enter Correct choice");
		TemplateNumber = Integer.parseInt(scanner.nextLine());
	}
	while (true) {
		System.out.print("Choose what you want to update : \n"
				+ "1) Template Contant \n"
				+ "2) Supported Language \n"
				+ "3) Channel used \n"
				+ "Enter '4' to exit \n");
		int input = Integer.parseInt(scanner.nextLine());
		while(input >4 ||input<0){
			input = Integer.parseInt(scanner.nextLine());
		}
		if (input == 1) {
			System.out.print("Write your updated content \n");
			takeInput= scanner.nextLine();
			Content newContet = new Content(takeInput);
			NotificatonModules.get(TemplateNumber - 1).setContent(newContet);
		}
		else if (input == 2) {
			takeInput = scanner.nextLine();
			NotificatonModules.get(TemplateNumber - 1).setLanguage(takeInput);
		} else if (input == 3) {
			takeInput = scanner.nextLine();
			NotificatonModules.get(TemplateNumber - 1).setChannel(takeInput);
		}
		if (input == 4)
			break;
	}
	
}
public void Delete() {
	System.out.print("Eneter the number of template you want to delete : ");
	Scanner scanner=new Scanner(System.in);
	int input=scanner.nextInt();
	while (chechNotFound(input-1)){
		System.out.println("Enter Correct choice");
		input=scanner.nextInt();
	}
	NotificatonModules.remove(input-1);
	System.out.println("Your template is deleted successfully!");
	
}
public static void main(String args[]) throws IOException {

	Scanner scanner=new Scanner(System.in);
	NotificationDatabase db=new NotificationDatabase();
	while(true){
		System.out.print("Choose option: \n"
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

