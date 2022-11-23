import java.util.Scanner;
public class SecurePassword {
    // instance variable
    private String password;
    private Scanner scan;

    // constructor
    public SecurePassword(String password) {
        this.password = password;
        scan = new Scanner(System.in);
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public boolean isSecure() {
        if(isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol()){
            return true;
        }
        return false;
    }

    public String status() {
        String status = "";
        if(isSecure()){
            status = "Password is secure";
        }else {
            status = "Your password is missing these requirements ";
            if (!isLongEnough()) {

                status += "\n- Is at least 8 characters long";
            }
            if (!containsUppercase()) {
                status += "\n- Contains at least one uppercase letter";
            }
            if (!containsLowercase()) {
                status += "\n- Contains at least one lowercase letter";
            }
            if (!containsDigit()) {
                status += "\n- Contains at least one numeric digit";
            }
            if (!containsSpecialSymbol()) {
                status += "\n- Contains at least one of these symbols: ! @ # $ % ^ & * ?";
            }
        }
        return status;
    }

    private boolean isLongEnough() {
        if(password.length() >= 8){
            return true;
        }
        return false;
    }

    private boolean containsUppercase() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }

    private boolean containsLowercase() {
        String lowerCaseLetters = "abcdefghijklmnopqurstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    private boolean containsDigit() {
        String numbers = "0123456789";
        return checkString(numbers);
    }

    private boolean containsSpecialSymbol() {
        String specialSymbols = "!@#$%^&*?";
        return checkString(specialSymbols);
    }

    private boolean checkString(String characterString) {
        for(int i = 0; i < password.length(); i++){
            for(int j = 0; j < characterString.length(); j++){
                if(password.substring(i, i+1).equals(characterString.substring(j, j+1))){
                    return true;
                }
            }
        }
        return false;
    }

    public void runSecurePassword(){
        System.out.println("Choose a secure password that meets these requirements:");
        System.out.println("- Is at least 8 characters long");
        System.out.println("- Contains at least one uppercase letter");
        System.out.println("- Contains at least one lowercase letter");
        System.out.println("- Contains at least one numeric digit");
        System.out.println("- Contains at least one of these symbols: ! @ # $ % ^ & * ?");

        while(!isSecure()) {
            System.out.print("\nEnter your secure password: ");
            String password = scan.nextLine();
            setPassword(password);
            System.out.println(status());
        }

    }
}
