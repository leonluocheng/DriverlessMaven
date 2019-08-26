package Interfaces;

import Exceptions.OutOfBoardException;

public interface ICommand {
    void Execute(String command) throws OutOfBoardException;
}