import java.util.*;
import java.lang.*;
class App{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue<Player> players = new LinkedList();
		System.out.println("Lets Start the Game ... :)");

		System.out.println("Enter Board Size");
		int boardSize = sc.nextInt();

		System.out.println("Enter Number of Players");
		int nPlayers = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter names of Players");
		for(int i=0;i<nPlayers;i++){
			String name = sc.nextLine();
			players.add(new Player(name));
		}

		System.out.println("Enter Number of Dices");
		int noOfDice = sc.nextInt();
		Dice dice = new NormalDice(noOfDice);
		System.out.println("Enter Number of Snakes");
		int nSnakes = sc.nextInt();
		System.out.println("Enter Number of Ladders");
		int nLadders = sc.nextInt();

		System.out.println("--------------------------------------------------------");
		System.out.println("Do you want to enter positions for Snakes and ladder(Y/N)?");
		sc.nextLine();
		String yesOrNo = sc.nextLine();

		boolean isUserInput = yesOrNo.equals("Y");


		
		Game game;
		if(!isUserInput){ 
			game = new Game(nPlayers,nSnakes,nLadders,boardSize,dice,players);
		}
		else{
			HashMap<Integer,Jumper> jumpers = new HashMap<>();

			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Make Sure that Both Snake and Ladder donot start and end at same locations");
			System.out.println("----------------------------------------------------------------------------------");


			System.out.println("Enter Start and End Positions of Snakes");
			int count = 0;
			while(count<nSnakes){
				String[] in =sc.nextLine().split(" ");
				jumpers.put(Integer.parseInt(in[0]),new Snake(Integer.parseInt(in[0]),Integer.parseInt(in[1])));
				count++;
			}
			count = 0;
			System.out.println("Enter Start and End Positions of Ladder");

			while(count<nLadders){
				String[] in =sc.nextLine().split(" ");
				jumpers.put(Integer.parseInt(in[0]),new Ladder(Integer.parseInt(in[0]),Integer.parseInt(in[1])));
				count++;
			}
			game = new Game(nPlayers,nSnakes,nLadders,boardSize,dice,players,jumpers);
		}

			game.startGame();
		

	}
}