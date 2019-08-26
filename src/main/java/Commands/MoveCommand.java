package Commands;

import Exceptions.OutOfBoardException;
import Interfaces.ICar;
import Interfaces.ICommand;

public class MoveCommand implements ICommand {

    private ICar car;

    public MoveCommand(ICar car){
        this.car = car;
    }

    public void Execute(String command) throws OutOfBoardException {
        car.move(command);
    }
}
