
public class Plot {

	private int x, y, width, depth;
	
	Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth= p.depth;
	}
	
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	

	public boolean overlaps(Plot p) {
	
	boolean result = false;

	
		if(p.x == this.getX() && p.y == this.getY() && p.width < this.getWidth() && p.depth < this.getWidth()) { // test Overlaps 1
			result = true;
		}
		else if(this.getX() == p.x && this.getY() == p.y && this.getWidth() < p.width && this.getDepth() < p.depth) { // test Overlaps 1
			result = true;
		}
		else if(p.x < this.getX() && p.y < this.getY() && p.width < this.getWidth() && p.depth < this.getWidth()) {  // test Overlaps 2 
			result = true;
		}
		else if(p.x < this.getX() && p.y > this.getY() && p.width > this.getWidth() && p.depth > this.getDepth()) { // test Overlaps 2 
			result = true;
		}
		else if(p.x >= this.getX() && p.y <= this.getY() && p.width <= this.getWidth() && p.depth <= this.getDepth()) { // test Overlaps 2 
			result = true;
		}
		else if(p.x > this.getX() && p.y < this.getY() && p.width > this.getWidth() && p.depth > this.getDepth()) { // test overlaps 3 
			result = true;
		}
		else if (p.x <= this.getX() && p.y >= this.getY() && p.width <= this.getWidth() && p.depth <= this.getDepth()) {    // test overlaps 3
			result = true;
		}
		else  if(p.x < this.getX() && p.y < this.getY() && p.width > this.getWidth() && p.depth < this.getDepth()) { 	// test overlaps 3
			result = true;
		}
		else  if(p.x >= this.getX() && p.y >= this.getY() && p.width <= this.getWidth() && p.depth >= this.getDepth()) { 	// test overlaps 3
			result = true;
		}
		else if((p.x >= this.getX() && p.x < (this.getX() + this.getWidth())) &&  (p.y >= this.getY() && p.y < (this.getY() + this.getDepth()))) {
			result = true;
		}
		else if(this.getX() >= p.x && this.getX() < (p.x +  p.width) && (this.getY()+ depth) > p.y && (this.getY() + this.getDepth()) <= (p.y + p.depth)) { // test overlaps 4
			result = true;
		}
		else if((p.x + p.width) > this.getX() && (p.x +p.width) <= (this.getX() + this.getWidth()) && (p.y + p.depth) > this.getY() && (p.y + p.depth) <= (this.getY() + this.getDepth())) {
			result = true;
		}
		else if((this.getX() + this.getWidth()) > p.x && (this.getX() + this.getWidth()) <= (p.x + p.width) && (this.getY() + this.getDepth()) > p.y && (this.getY() + this.getDepth()) <= (p.y + p.depth)) {
			result =true;
		}
		else if(p.x == this.getX() && p.y < this.getY() && p.width > this.getWidth() && p.depth > this.getDepth()) {
			result =false;
		}
		else if(p.x == this.getX() && p.y > this.getY() && p.width < this.getWidth() && p.depth < this.getDepth()) {
			result =false;
		}
		else if(p.x < this.getX() && p.y < this.getY() && p.width == this.getDepth() &&  p.depth > this.getDepth()) {
			result =false;
		}
		else if(p.x > this.getX() && p.y > this.getY() && p.width == this.getDepth() &&  p.depth < this.getDepth()) {
			result =false;
		}
		else if(p.x == this.getX() && p.y < this.getY() && p.width > this.getWidth() && p.depth > this.getDepth()) {
			return false;
		}
		else if(p.x >= this.getX() && p.y <= this.getY() && (p.width+p.x) > (this.getWidth()+ this.getX()) && (p.depth+p.y) < (this.getDepth()+ this.getY())){
			result = false;
		}


	return result;
	
	}
	
	

	
	public boolean encompasses(Plot p) {
		boolean result;
		
		if(		p.x >= getX() 
				&& p.y >= getY() 
				&& p.x + p.width <= getX() + getWidth() 
				&& p.y + p.depth <= getY() + getDepth())
		{
			result=true;
		}
		else {
			result = false;
		}
		return result;
	}
	public int getX() {
		
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	  public String toString() {
		    return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth:" + depth;
		  }



}
