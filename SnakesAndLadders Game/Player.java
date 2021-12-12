import java.util.*;
class Player{
	private String name;
	private int location;
	private boolean winner=false;
	Player(String name){
		this.name=name;
		this.location=0;
	}
	public String getName(){
		return this.name;
	}
	public int getLocation(){
		return this.location;
	}
	public void setLocation(int location){
		this.location=location;
	}
	public boolean isWinner(){
		return winner==true;
	}
	public void setWinner(){
		this.winner=true;
	}
}