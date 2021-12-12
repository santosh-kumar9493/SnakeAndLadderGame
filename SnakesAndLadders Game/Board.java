import java.util.*;
import java.lang.*;
class Board{
	private int size;
	private int target;
	Board(int size){
		this.size=size;
		this.target = size*size;
	}
	public int getTarget(){
		return this.target;
	}
	public int getSize(){
		return this.size;
	}

}