abstract class Jumper{
	protected int start;
	protected int end;
	public int getEnd(){
		return this.end;
	}
}
class Snake extends Jumper{
	Snake(int start,int end){
		this.start=start;
		this.end=end;
	}
}
class Ladder extends Jumper{
	Ladder(int start,int end){
		this.start=start;
		this.end=end;
	}
}