package Main;

import Commands.CommandGenerator;
import Commands.MoveCommand;
import Components.Car;
import Components.Printer;
import Interfaces.ICar;
import Interfaces.ICommand;
import Interfaces.ICommandGenerator;
import Interfaces.IPrinter;

public class Main {

    public static void main(String[] args) {
        ICar car = new Car();
        IPrinter printer = new Printer();
        ICommand command = new MoveCommand(car);
        ICommandGenerator generator = new CommandGenerator(car,command, printer);

        generator.GenerateCommand();
    }
}
