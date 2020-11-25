
public enum Channel {
	SMS,email;
	public String toString() {
	switch(this)
	{
	case SMS: return "SMS";
	case email: return "email";
	default: return "emial";
	}
	}
}
