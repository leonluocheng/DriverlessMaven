package Components;

import Interfaces.IPrinter;

public class Printer implements IPrinter {

    public void Print(String msg) {
        System.out.print(msg);
    }

    public void ChangeLine() {
        System.out.println();
    }
}
