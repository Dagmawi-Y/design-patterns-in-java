package creational_patterns.Builder;

// DialogBox class representing the product to be constructed
class DialogBox {
    private String title;
    private String message;
    private String[] buttons;
    private boolean isClosable;

    // Private constructor to enforce object creation through the builder
    private DialogBox() {}

    // Getters for dialog box properties
    // (Omitted setters for brevity as they are part of the builder)

    public void display() {
        System.out.println("Dialog Title: " + title);
        System.out.println("Message: " + message);
        System.out.println("Buttons: " + String.join(", ", buttons));
        System.out.println("Closable: " + isClosable);
        // Display logic for the dialog box
    }

    // Builder class to construct the DialogBox object step by step
    static class Builder {
        private DialogBox dialogBox;

        Builder() {
            dialogBox = new DialogBox();
        }

        Builder setTitle(String title) {
            dialogBox.title = title;
            return this;
        }

        Builder setMessage(String message) {
            dialogBox.message = message;
            return this;
        }

        Builder setButtons(String... buttons) {
            dialogBox.buttons = buttons;
            return this;
        }

        Builder setClosable(boolean isClosable) {
            dialogBox.isClosable = isClosable;
            return this;
        }

        DialogBox build() {
            return dialogBox;
        }
    }
}

// Client code demonstrating the use of the Builder pattern for constructing a dialog box
public class DialogBoxClient {
    public static void main(String[] args) {
        DialogBox dialog = new DialogBox.Builder()
                .setTitle("Alert")
                .setMessage("This is an important message.")
                .setButtons("OK", "Cancel")
                .setClosable(false)
                .build();

        dialog.display();
    }
}
