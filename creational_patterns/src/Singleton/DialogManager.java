package Singleton;

import javax.swing.*;

// Singleton Singleton.DialogManager class to manage dialog boxes
public class DialogManager {
    // Private static variable to hold the single instance of Singleton.DialogManager
    private static DialogManager instance;

    // Private constructor to prevent instantiation from outside the class
    private DialogManager() {
        // Constructor logic, if needed
    }

    // Public method to provide global access to the single instance
    public static DialogManager getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist yet
        if (instance == null) {
            instance = new DialogManager();
        }
        return instance;
    }

    // Method to display a simple information dialog box
    public void showInformationDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to display an error dialog box
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Runnable main method to demonstrate the usage of Singleton.DialogManager
    public static void main(String[] args) {
        // Create an instance of the Singleton.DialogManager
        DialogManager dialogManager = DialogManager.getInstance();

        // Show information and error dialogs using the Singleton.DialogManager
        dialogManager.showInformationDialog("This is an information message.");
        dialogManager.showErrorDialog("An error occurred. Please try again.");

    }
}
