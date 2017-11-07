public class SnakeDataStructure {


    public int[] snakeLocationX;
    public int[] snakeLocationY;

    //tells whether a copy just occurred for the snake.
    public boolean currentlyCopied = false;

    SnakeDataStructure(int x, int y){
        snakeLocationX[0] = x;
        snakeLocationY[0] = y;
    }

    public void increaseSnakeSize(){
        int copyX = snakeLocationX[snakeLocationX.length -1];
        int copyY = snakeLocationY[snakeLocationY.length -1];

        snakeLocationX[snakeLocationX.length] = copyX;
        snakeLocationY[snakeLocationY.length] = copyY;

    }

    public void move(String direction){

        //Condition for if the snake has just been copied.
        if(currentlyCopied){
            if(direction == "N"){
                snakeLocationY[snakeLocationY.length - 1] = (snakeLocationY[snakeLocationY.length - 1] -20);
            }
            else if(direction == "E"){
                snakeLocationX[snakeLocationX.length - 1] = (snakeLocationX[snakeLocationX.length - 1] +20);
            }
            else if(direction == "S"){
                snakeLocationY[snakeLocationY.length - 1] = (snakeLocationY[snakeLocationY.length - 1] +20);
            }
            else if(direction == "W"){
            }
            snakeLocationX[snakeLocationX.length - 1] = (snakeLocationX[snakeLocationX.length - 1] -20);


        }
        //A regular move.
        else{
            if(direction == "N"){
                snakeLocationY[snakeLocationY.length - 1] = (snakeLocationY[snakeLocationY.length - 1] -20);
            }
            else if(direction == "E"){
                snakeLocationX[snakeLocationX.length - 1] = (snakeLocationX[snakeLocationX.length - 1] +20);
            }
            else if(direction == "S"){
                snakeLocationY[snakeLocationY.length - 1] = (snakeLocationY[snakeLocationY.length - 1] +20);
            }
            else if(direction == "W"){
            }
            snakeLocationX[snakeLocationX.length - 1] = (snakeLocationX[snakeLocationX.length - 1] -20);

            for(int i = 0; i < snakeLocationX.length -1; i++){
                //replaces every x value except the last with its superior.
                snakeLocationX[i] = snakeLocationX[i+1];
                //replaces every y value except the last with its superior.
                snakeLocationY[i] = snakeLocationY[i+1];
            }
        }


    }


}
