package behavioural_patterns.Command;

import java.util.Stack;

// Command Interface
interface Command {
    void execute();
    void undo();
}

// Concrete Command
class TurnOnLightCommand implements Command {
    private LightReceiver light;

    public TurnOnLightCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// Receiver
class LightReceiver {
    public void turnOn() {
        System.out.println("Light is turned on");
    }

    public void turnOff() {
        System.out.println("Light is turned off");
    }
}

// Invoker
class RemoteControl {
    private Command command;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public RemoteControl() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Clear redo stack after executing a new command
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command undoneCommand = undoStack.pop();
            undoneCommand.undo();
            redoStack.push(undoneCommand);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command redoneCommand = redoStack.pop();
            redoneCommand.execute();
            undoStack.push(redoneCommand);
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}

// Client
public class RemoteControlClient {
    public static void main(String[] args) {
        LightReceiver light = new LightReceiver();
        Command turnOnCommand = new TurnOnLightCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOnCommand);

        // Press the button to turn on the light
        remote.pressButton();

        // Undo the last action (turn off the light)
        remote.undo();

        // Redo the action (turn on the light again)
        remote.redo();
    }
}
