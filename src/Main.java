import controller.ContListner;
import model.Hereos;
import view.CliView;

public class Main {

    public static void main(String[] args) {
        CliView cli = new CliView();
        Hereos hero = new Hereos();

        ContListner contListner =  new ContListner(cli, hero);

        contListner.startGame();
    }
}
