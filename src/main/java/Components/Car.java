package Components;

import Common.Command;
import Common.Orientation;
import Exceptions.OutOfBoardException;
import Interfaces.ICar;

public class Car implements ICar {

    private int positionX;
    private int positionY;
    private Orientation orientation;

    private int previousPositionX;
    private int previousPositionY;
    private Orientation previousOrientation;

    private Orientation defaultOrientation;

    private int width;
    private int height;

    private int board[][];

    public Car(){

    }

    public void move(String command) throws OutOfBoardException {
        if(command == Command.forward.toString()) forward();

        if (command == Command.turn.toString()) turn();
    }

    private void forward() throws OutOfBoardException {
        try {
            previousPositionX = positionX;
            previousPositionY = positionY;
            previousOrientation = orientation;

            //Y -1
            if (orientation == Orientation.North)
            {
                board[positionX][positionY] = 0;
                board[positionX] [--positionY] = 1;
            }

            //Y + 1
            if (orientation == Orientation.South)
            {
                board[positionX][positionY] = 0;
                board[positionX][++positionY] = 1;
            }

            //X -1
            if (orientation == Orientation.West)
            {
                board[positionX][positionY] = 0;
                board[--positionX][positionY] = 1;
            }

            //X +1
            if (orientation == Orientation.East)
            {
                board[positionX][positionY] = 0;
                board[++positionX][positionY] = 1;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            resetCarPosition();
            throw new OutOfBoardException();
        }
    }

    private void turn(){
        previousOrientation = orientation;
        if (orientation == Orientation.North)
        {
            orientation = Orientation.East;
            return;
        }

        if(orientation == Orientation.East)
        {
            orientation = Orientation.South;
            return;
        }

        if(orientation == Orientation.South)
        {
            orientation = Orientation.West;
            return;
        }

        if(orientation == Orientation.West)
        {
            orientation = Orientation.North;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getOrientation() {
        return orientation.toString();
    }

    public void create(int width, int height, Orientation orientation) {
        this.width = width;
        this.height = height;
        board = new int[width][height];
        defaultOrientation = orientation;
        initializePosition();
    }

    private void resetCarPosition()
    {
        board[previousPositionX] [previousPositionY] = 1;
        positionX = previousPositionX;
        positionY = previousPositionY;
        orientation = previousOrientation;
    }

    private void initializePosition()
    {
        initializeBoard();
        board[0] [0] = 1;
        positionX = 0;
        positionY = 0;
        orientation = defaultOrientation;
        previousOrientation = defaultOrientation;
        previousPositionX = 0;
        previousPositionY = 0;
    }

    private void initializeBoard()
    {
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                board[i][j] = 0;
            }
        }
    }
}
