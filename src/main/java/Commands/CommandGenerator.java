package Commands;

import Common.Command;
import Common.Orientation;
import Exceptions.OutOfBoardException;
import Interfaces.ICar;
import Interfaces.ICommand;
import Interfaces.ICommandGenerator;
import Interfaces.IPrinter;

import java.util.Random;
import java.util.Scanner;

public class CommandGenerator implements ICommandGenerator {

    private ICommand command;
    private IPrinter printer;
    private ICar car;

    public CommandGenerator(ICar car, ICommand command, IPrinter printer)
    {
        this.car = car;
        this.command = command;
        this.printer = printer;
    }

    public void GenerateCommand()  {
        CreateCar();
        while (true){
            try{
                Random random = new Random();
                String commandMsg = Command.values()[random.nextInt(2)].toString();
                Thread.sleep(5000);
                printer.Print("Command: "+ commandMsg);
                printer.ChangeLine();

                command.Execute(commandMsg);

                String msg = "The Car is in position X =" + car.getPositionX() + " and Y = " + car.getPositionY()+" and facing "+car.getOrientation();
                printer.Print(msg);
                printer.ChangeLine();
            } catch (OutOfBoardException e){
                printer.Print("Car run out of boundary! Rest car to previous position!");
                printer.ChangeLine();
                String msg = "The Car is in position X =" + car.getPositionX() + " and Y = " + car.getPositionY()+" and facing "+car.getOrientation();
                printer.Print(msg);
                printer.ChangeLine();
            } catch (InterruptedException e){
                printer.Print(e.getMessage());
            }
        }
    }

    private void CreateCar(){
        Scanner input = new Scanner( System.in );
        printer.Print("Please input board width: ");
        int width = input.nextInt();
        printer.Print("Please input board height: ");
        int height = input.nextInt();

        //Assume default orientation is north;
        car.create(width, height, Orientation.East);

        printer.Print("The Car's start position is the top left corner!");
        printer.ChangeLine();
        printer.Print("The Car is in position X =" + car.getPositionX() + " and Y = " + car.getPositionY()+" and facing "+car.getOrientation());
        printer.ChangeLine();
    }
}

