package src.Map;

public class Map{
	public static int xSize = 5; 
	public static int ySize = 5;
	
	private int[][] map = 	{{0,0,0,0,0}
							,{0,0,1,0,0}
							,{0,0,1,0,0}
							,{0,0,1,0,0}
							,{0,0,0,0,0}};
	public void Map(){};
	
	public void printMap(){
		for(int i = 0; i < xSize; i++){
			for(int section : map[i]){
				System.out.print(section);
			}
			System.out.println("");
		}
	}
	
	public void setSection(int xPos, int yPos, int type){
		map[xPos][yPos] = type;
	}
	
	public int getSection(int xPos,int yPos){
		return map[xPos][yPos];
	}	
}