	package tiles;
	
	import javax.swing.JLabel;
	
	public abstract class Square extends JLabel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int x;
		private int y;
		private int dimension;
		
		public Square(int x, int y, int dimension){
			
			this.x = x;
			this.y = y;
			this.dimension = dimension;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public int getDimension(){
			return dimension;
		}
	}
