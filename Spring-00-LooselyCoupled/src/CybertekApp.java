import implementation.Mentor;
import services.FullTimeMentor;
import services.MentorAccount;
import services.PartTimeMentor;

public class CybertekApp {

    public static void main(String[] args) {

        Mentor fullTimeMentor = new FullTimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();
        MentorAccount mentor = new MentorAccount(fullTimeMentor);
        mentor.manageAccount();

        MentorAccount mentorAccount = new MentorAccount(partTimeMentor);
        mentorAccount.manageAccount();
    }
}
