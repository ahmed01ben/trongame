



public class Model {
	
	public Model() {
	}

	public void clearGrid(int boxx1, int boxy1, int xDir1, int yDir1, int boxx2, int boxy2, int xDir2, int yDir2,
			int grid[][]) {
		for (int i = 0; i < 160; i++) {
			for (int j = 0; j < 108; j++) {
				grid[i][j] = 0;
			}
		}
		boxx1 = 170;
		boxy1 = 170;
		xDir1 = 1;
		yDir1 = 0;

		boxx2 = 630;
		boxy2 = 170; 
		xDir2 = -1;
		yDir2 = 0;
	}


	
	


			
			
	
	
	public int checkCollision(int boxx1, int boxy1, int boxx2, int boxy2, int grid[][]) { // 0:none
																							// , 1:
              //0:none , 1: p1 collide , 2: p2 collide
            for(int i=0;i<160;i++){
for(int j=0;j<108;j++){
            if(boxx1/5==i && (boxy1-60)/5==j){
                           if(grid[i][j]!=0){
                        	   				
                                          return 1;
                           }
            }
                           
}
}

for(int i=0;i<160;i++){
for(int j=0;j<108;j++){
            if(boxx2/5==i && (boxy2-60)/5==j){
                           if(grid[i][j]!=0){
                                          return 2;
                           }
            }
                           
}
}

return 0;
}


	
}
