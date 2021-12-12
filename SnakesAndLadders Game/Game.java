import java.util.*;
import java.lang.*;
class Game{
	private int noOfPlayers;
	private int noOfSnakes;
	private int noOfLadders;
	private Queue<Player> players;
	private HashMap<Integer,Jumper> jumpers;
	private Dice dice;
	private Board board;
	private List<Player> winners;
	Game(int noOfPlayers,int noOfSnakes,int noOfLadders,int boardSize,Dice dice,Queue<Player> players){
		this.noOfLadders=noOfLadders;
		this.noOfSnakes=this.noOfSnakes;
		this.noOfPlayers=noOfPlayers;
		this.players=players;
 		this.jumpers=new HashMap<>();
 		this.board = new Board(boardSize);
 		this.dice=dice;
		this.setBoard();
		this.winners=new ArrayList<>();
	}
	Game(int noOfPlayers,int noOfSnakes,int noOfLadders,int boardSize,Dice dice,Queue<Player>players,HashMap<Integer,Jumper> jumpers){
		this.noOfLadders=noOfLadders;
		this.noOfSnakes=this.noOfSnakes;
		this.noOfPlayers=noOfPlayers;
		this.players=players;
 		this.board = new Board(boardSize);
 		this.dice=dice;
 		this.jumpers = jumpers;
 		this.winners=new ArrayList<>();
	}
	public void setBoard(){

	
		HashSet<String> snakeAndLadderLocations=new HashSet<>();
		// snakes positions
		int count=0;
		while(count<this.noOfSnakes){
			int start = (int)(Math.random()*(this.board.getSize()*this.board.getSize())+1);
			int end = (int)(Math.random()*(this.board.getSize()*this.board.getSize())+1);
			if(end<start){
					String strEnd = start+" "+end;
					if(!snakeAndLadderLocations.contains(strEnd)){
						jumpers.put(start,new Snake(start,end));
					}
				count++;
			}
		}

		// ladder positions
		 count=0;
		while(count<this.noOfLadders){
			int start = (int)(Math.random()*(this.board.getSize()*this.board.getSize())+1);	
			int end = (int)(Math.random()*(this.board.getSize()*this.board.getSize())+1);
			if(end>start){
					String strEnd = start+" "+end;
					if(!snakeAndLadderLocations.contains(strEnd)){
						jumpers.put(start,new Ladder(start,end));
					}
				count++;
			}
		}
	}
	public  void startGame(){
		while(players.size()>1){
			Player currPlayer=players.poll();
			int currPosition = currPlayer.getLocation();
			int nextLocation = currPosition + this.dice.rollDice();
			if(nextLocation>board.getTarget()){
				players.add(currPlayer);
				 continue;
			}
			if(jumpers.containsKey(nextLocation)){
				if( jumpers.get(nextLocation) instanceof Snake){
					System.out.println("Sanke Bite for "+currPlayer.getName()+" :(");
				}
				else{
					System.out.println(currPlayer.getName()+" climbed the ladder :)");
				}
				nextLocation = jumpers.get(nextLocation).getEnd();
			}
			currPlayer.setLocation(nextLocation);
			System.out.println(currPlayer.getName()+" moved from "+currPosition+" to "+nextLocation);
			if(nextLocation == this.board.getTarget()){
				System.out.println("------------------------------------------------------");
				System.out.println("Winner ! "+currPlayer.getName()+" reached target ");
				currPlayer.setWinner();
				System.out.println("------------------------------------------------------");
				winners.add(currPlayer);
			}
			if(currPlayer.isWinner()) continue;
			players.add(currPlayer);

		}
		printWinners();
	}
	public void printWinners(){
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" Winners are  ..... :)");
		System.out.println(" Rank  \t  .. Name :)");
		for(int i=0;i<this.winners.size();i++){
			System.out.println( "  "+(i+1)+" \t\t "+winners.get(i).getName());
		}
	}
}