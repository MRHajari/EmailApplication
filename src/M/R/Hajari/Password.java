package M.R.Hajari;

import java.util.Random;

public class Password {

    private int defaultPasswordLength = 10;
    private String password;

    //constructor
    public Password() {
        // mthod --> returns random passwoard
        this.password = randomPassword(defaultPasswordLength);
    }

    // Generate a random password
    private String randomPassword(int lenght) {
        Random rand = new Random();
        String strPassowd = "";
        int randToChar;

        do {
            randToChar = rand.nextInt(123);
            if ((randToChar >= 33 && randToChar <= 38) ||
                    (randToChar >= 48 && randToChar <= 59) ||
                    (randToChar >= 65 && randToChar <= 90) ||
                    (randToChar >= 97 && randToChar <= 122) ||
                    (randToChar == 63)) {

                strPassowd = strPassowd.concat(String.valueOf((char) randToChar));
            }
        } while (strPassowd.length() <= lenght);

        return strPassowd;
    }


    // Change the password
    public void changePasswoard(String password) {

        if (passwordValueCeack(password) == true){
            this.password = password;
            System.out.println("----------------------------------");
            System.out.println("New password: " + password);

        } else {
            System.out.println("Oops! Password is wrong . Try again...");
        }
    }

    // Change the password
    public void deletePasswoard() {
        this.password = null;
    }

    public String getPassword() {
        return password;
    }



    public boolean passwordValueCeack(String passwoard){
        // length check
        boolean passwordCeackLength = false;
        if(passwoard.length() >= 8) {
            passwordCeackLength = true;
        }

        // check it has number &
        boolean passwordCeackIsNumeric = false;
        for (int i = 0; i < passwoard.length(); i++){
            if (isNumeric((passwoard.charAt(i))) == true){
                passwordCeackIsNumeric = true;
                break;
            }
        }

        // check it has lowercase character
        boolean passwordCeackIsLowerCase = false;
        for (int i = 0; i < passwoard.length(); i++){
            if ( isLowerCaseCheck(passwoard.charAt(i)) == true ){
                passwordCeackIsLowerCase = true;
                break;
            }
        }

        // check it has uppercase character
        boolean passwordCeackIsUpperCase = false;
        for (int i = 0; i < passwoard.length(); i++){
            if ( isUpperCaseCheck(passwoard.charAt(i)) == true ){
                passwordCeackIsUpperCase = true;
                break;
            }
        }

        // check it has special character
        boolean passwordCeackIsSpecialChars = false;
        for (int i = 0; i < passwoard.length(); i++){
            if ( isSpecialChars(passwoard.charAt(i)) == true ){
                passwordCeackIsSpecialChars = true;
                break;
            }
        }

        if  (passwordCeackLength == true &&
                passwordCeackIsNumeric == true &&
                passwordCeackIsLowerCase == true &&
                passwordCeackIsUpperCase == true &&
                passwordCeackIsSpecialChars == true){
            return true;
        } else {
            return false;
        }
    }


    public boolean isNumeric(char strNum) {
        double d;
        try {
            d = Double.parseDouble(String.valueOf(strNum));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public boolean isLowerCaseCheck(char chr){
        try {
            if (Character.isLowerCase(chr)) {return true;}
            else {return false;}
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


    public boolean isUpperCaseCheck(char chr){
        try {
            if (Character.isUpperCase(chr)) {return true;}
            else {return false;}
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


    public boolean isSpecialChars(char chr){
        boolean flagIsSpecialChars = false;
        char[] specialCh = {'!','@',']','#','$','%','^','&','*'};
        for (Character c : specialCh) {

            if (chr == c){
                flagIsSpecialChars = true;
                break;
            }else{
                flagIsSpecialChars =  false;
            }
        }
        return flagIsSpecialChars;
    }
}
