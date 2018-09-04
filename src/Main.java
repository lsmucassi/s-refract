
import controller.ContListner;
import model.Heroes;
import view.CliView;


public class Main {

    public static void main(String[] args) {
        CliView cli = new CliView();
        Heroes hero = new Heroes();
        ContListner contListner =  new ContListner(cli, hero);

        contListner.playGame();
    }
}
