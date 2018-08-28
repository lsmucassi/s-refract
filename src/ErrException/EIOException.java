package ErrException;

public class EIOException extends java.io.IOException {

    public EIOException() {}

    public EIOException(String mes) {
        super(mes);
    }

    public void checkMovErr(String err) {

        if (err == "A") {
            System.out.println("Let's Play Again");
        } else if (err == "X") {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\t \033[31mExited \033[0m");
            System.out.println("-----------------------------------------------------------------------------------");
        } else if (err == "d") {
            System.out.println("\t\t\033[31m#########################################################################\033[0m");
            System.out.println("\033[31m\t\t\t\t\t\t\t $ Sorry You are dead now\033[0m");
            System.out.println("\t\t\033[31m#########################################################################\033[0m");
            System.out.println("------------------------------------------------------------------------------------");
        } else {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\t \033[31;1mInvalid Input [ Command Not Found ] \033[0m");
            System.out.println("-----------------------------------------------------------------------------------");
        }
}

    public void checkPlayErr(String err) {
        int e = Integer.parseInt(err);
        if (e > 7 || e < 0) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\t \033[31;1mInvalid Input [ Command Not Found ] \033[0m");
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
}
