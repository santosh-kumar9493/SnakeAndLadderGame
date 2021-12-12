import java.util.*;
import java.lang.*;
abstract class Dice{
	private int noOfDice;
	public abstract int rollDice();
	public void setNoOfDice(int n){
		this.noOfDice=n;
	}
	public int getNoOfDice(){
		return this.noOfDice;
	}
}
class NormalDice extends Dice{
	NormalDice(int noOfDice){
		this.setNoOfDice(noOfDice);
	}
	public int rollDice(){
		int random_int = (int)(Math.random()*(6*this.getNoOfDice()-this.getNoOfDice())+this.getNoOfDice());
		return random_int;
	}

}