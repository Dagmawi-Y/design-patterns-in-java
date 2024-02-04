package structural_patterns.adapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Third-party button with a different interface
class ThirdPartyButton {
    // Third-party button has a different method for handling clicks
    public void differentClick() {
        System.out.println("Third-party button clicked!");
    }
}

// Adapter interface to make the ThirdPartyButton compatible with standard ActionListener
interface ActionListenerAdapter {
    void actionPerformed();
}

// Adapter class implementing ActionListenerAdapter and adapting the ThirdPartyButton
class ThirdPartyButtonAdapter implements ActionListenerAdapter {
    private ThirdPartyButton thirdPartyButton;

    // Adapter constructor takes a ThirdPartyButton instance
    public ThirdPartyButtonAdapter(ThirdPartyButton thirdPartyButton) {
        this.thirdPartyButton = thirdPartyButton;
    }

    // Implements the actionPerformed method using the differentClick method of ThirdPartyButton
    @Override
    public void actionPerformed() {
        thirdPartyButton.differentClick();
    }
}

// Standard GUI button that works with ActionListener
class StandardButton extends JButton implements ActionListener {
    // Standard button constructor
    public StandardButton(String label) {
        super(label);
        addActionListener(this); // Registering the ActionListener
    }

    // Standard actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Standard button clicked!");
    }
}

// GUI frame that integrates both standard and third-party buttons
class GUIFrame extends JFrame {
    // GUIFrame constructor
    public GUIFrame() {
        setTitle("GUI Components Integration Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a ThirdPartyButton instance
        ThirdPartyButton thirdPartyButton = new ThirdPartyButton();

        // Creating an adapter to make ThirdPartyButton compatible with ActionListener
        ActionListenerAdapter adapter = new ThirdPartyButtonAdapter(thirdPartyButton);

        // Creating a standard JButton
        StandardButton standardButton = new StandardButton("Standard Button");

        // Adding the standard button to the frame
        add(standardButton);

        // Adding a separator
        add(new JSeparator());

        // Creating a JButton that uses the adapter for the ThirdPartyButton
        JButton thirdPartyButtonAsStandard = new JButton("Third-Party Button");
        thirdPartyButtonAsStandard.addActionListener(e -> adapter.actionPerformed());

        // Adding the adapted third-party button to the frame
        add(thirdPartyButtonAsStandard);

        // Setting layout and size
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(300, 150);
        setLocationRelativeTo(null);
    }
}

public class GUIComponentsIntegrationExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIFrame().setVisible(true);
        });
    }
}
