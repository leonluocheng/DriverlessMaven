package Interfaces;

import Common.Orientation;
import Exceptions.OutOfBoardException;

public interface ICar {
    void move(String command) throws OutOfBoardException;
    int getPositionX();
    int getPositionY();
    String getOrientation();
    void create(int width, int height, Orientation orientation);
}

