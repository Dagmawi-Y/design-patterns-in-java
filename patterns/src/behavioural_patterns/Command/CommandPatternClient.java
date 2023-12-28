package behavioural_patterns.Command;

interface ActionListenerCommand {
    void execute();
}

class Document {
    void open() {
        System.out.println("Document Opened");
    }

    void save() {
        System.out.println("Document Saved");
    }
}

class ActionOpen implements ActionListenerCommand {
    private final Document doc;

    ActionOpen(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.open();
    }
}

class ActionSave implements ActionListenerCommand {
    private final Document doc;

    ActionSave(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.save();
    }
}

class MenuOptions {
    private final ActionListenerCommand clickOpen;
    private final ActionListenerCommand clickSave;

    MenuOptions(ActionListenerCommand clickOpen, ActionListenerCommand clickSave) {
        this.clickOpen = clickOpen;
        this.clickSave = clickSave;
    }

    void clickOpen() {
        clickOpen.execute();
    }

    void clickSave() {
        clickSave.execute();
    }
}

public class CommandPatternClient {
    public static void main(String[] args) {
        Document doc = new Document();

        ActionListenerCommand clickOpen = new ActionOpen(doc);
        ActionListenerCommand clickSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions(clickOpen, clickSave);

        menu.clickOpen();
        menu.clickSave();
    }
}
