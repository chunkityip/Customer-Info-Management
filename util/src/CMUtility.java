import java.util.Scanner;

/*
CMUtility class: Encapsulate different functions as methods, that is,
you can use its functions directly by calling the method without considering the specific function
implementation details.

 */
public class CMUtility {

    //we set static because we need this scanner to different method
    private static Scanner scanner = new Scanner(System.in);


    /*
    Used for interface menu selection. This method reads the keyboard.
    If the user types any character from '1'-'5', the method returns.
    The return value is the character typed by the user.

     */
    public static char readMenuSelection() {
        char c;
        //we can also use for(;;)
        while (true) {
            String s = readKeyBoard(1, false);
            c = s.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("No such of option , Please try again: ");
            } else {
                break;
            }
        }
        return c;
    }

    /*
    Read a character from the keyboard and use it as the return value of the method.

     */
    public static char readChar() {
        String s = readKeyBoard(1, false);
        return s.charAt(0);
    }

    /*
    Read a character from the keyboard and use it as the return value of the method.
    If the user does not enter a character and press Enter, the method will use defaultValue as
    the return value.
     */
    public static char readChar(char defaultValue) {
        String s = readKeyBoard(1, true);
        return (s.length() == 0) ? defaultValue : s.charAt(0);
    }

    /*
      Read an integer with a length of no more than 2 digits from the keyboard and use
      it as the return value of the method

     */
    public static int readInt() {
        int n;
        while (true) {
            String s = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Number incorrect , Please enter again: ");
            }
        }
        return n;
    }

    /*

    Read an integer with a length of no more than 2 digits from the keyboard and use
    it as the return value of the method.
    If the user does not enter a character and press Enter, the method will use defaultValue as
    the return value.

     */
    public static int readInt(int defaultValue) {
        int n;
        while (true) {
            String s = readKeyBoard(2, true);
            if ("".equals(s)) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Number incorrect , Please enter again: ");
            }
        }
        return n;
    }

    /*
    Read a string that does not exceed limit from
    the keyboard and use it as the return value of the method

     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /*
    Read a string that does not exceed limit from
    the keyboard and use it as the return value of the method
    If the user does not enter a character and press Enter, the method will use defaultValue as
    the return value.

     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return "".equals(str) ? defaultValue : str;
    }

    /*
    Used to confirm the selected input.
    method reads ‘Y’ or ‘N’ from the keyboard and uses it as the return value of the method

     */
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String s = readKeyBoard(1, false).toUpperCase();
            c = s.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Error, Please enter again: ");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("The length of input " + limit + "error , Please eneter again: ");
                continue;
            }
            break;
        }
        return line;
    }
}

