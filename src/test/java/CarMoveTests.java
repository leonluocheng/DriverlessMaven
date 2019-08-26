import Commands.MoveCommand;
import Common.Command;
import Common.Orientation;
import Components.Car;
import Exceptions.OutOfBoardException;
import Interfaces.ICar;
import Interfaces.ICommand;
import org.junit.Assert;
import org.junit.Test;

public class CarMoveTests {
    private ICar car;
    private int width = 5;
    private int height = 5;
    private ICommand command;

    @Test(expected = OutOfBoardException.class)
    public void ShouldThrowExceptionAndRestToPreviousPositionIfCarRunOutOfBoundary() throws OutOfBoardException
    {
        car = new Car();
        command = new MoveCommand(car);
        car.create(width, height, Orientation.East);

        for (int i = 0; i < 5; i++){
            command.Execute(Command.forward.toString());
        }
    }

    @Test
    public void CarShouldMoveToTheCorrectPosition() throws OutOfBoardException
    {
        car = new Car();
        command = new MoveCommand(car);
        car.create(width, height, Orientation.East);

        command.Execute(Command.forward.toString());
        command.Execute(Command.turn.toString());
        command.Execute(Command.forward.toString());
        command.Execute(Command.forward.toString());
        command.Execute(Command.forward.toString());
        command.Execute(Command.turn.toString());
        command.Execute(Command.turn.toString());

        Assert.assertEquals(Orientation.North.toString(),car.getOrientation());
        Assert.assertEquals(1, car.getPositionX());
        Assert.assertEquals(3, car.getPositionY());
    }
}
