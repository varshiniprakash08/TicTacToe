import board.Board;
import player.Player;
import game.Game;
public class App {
    public static void main(String[] args) throws Exception {
        Board b= new Board(3);
        b.printBoard();

        Player p1=new Player();
        p1.set_details("Varshini", "varshiniprakash@gmail.com", "Tumkur", "636138622", 'o',20);
        p1.get_details();
        System.out.println();
        Player p2=new Player();
        p2.set_details("Vaishnavi", "vaishnavimohan@gmail.com", "Nelamangala", "636388486", 'x',20);
        p2.get_details();
        Game game= new Game(new Player[] {p1,p2}, b);
        game.play();

    }
}
