package M.R.Hajari;

public class Main{

    public static void main(String[] args) {
        EmailGenerate eml01 = new EmailGenerate("Kim", "Bauer");

        eml01.setAlternateEmail("karl.meuler@gmail.com");
        eml01.setMailboxCapacity(5);
        eml01.changePasswoard("A3*gztrdjkl");

        eml01.showInfo();
    }
}
