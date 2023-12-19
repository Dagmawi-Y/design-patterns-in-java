package Factory;

import java.util.HashMap;
import java.util.Map;

// Interface for the localized resources
interface LocalizedResource {
    String getGreetings();
    String getFarewell();
}

// Concrete implementation of localized resources for English
class EnglishResource implements LocalizedResource {
    @Override
    public String getGreetings() {
        return "Hello!";
    }

    @Override
    public String getFarewell() {
        return "Goodbye!";
    }
}

// Concrete implementation of localized resources for French
class FrenchResource implements LocalizedResource {
    @Override
    public String getGreetings() {
        return "Bonjour !";
    }

    @Override
    public String getFarewell() {
        return "Au revoir !";
    }
}

// Factory interface for creating localized resources
interface LocalizedResourceFactory {
    LocalizedResource createLocalizedResource();
}

// Concrete factory for English resources
class EnglishResourceFactory implements LocalizedResourceFactory {
    @Override
    public LocalizedResource createLocalizedResource() {
        return new EnglishResource();
    }
}

// Concrete factory for French resources
class FrenchResourceFactory implements LocalizedResourceFactory {
    @Override
    public LocalizedResource createLocalizedResource() {
        return new FrenchResource();
    }
}

// Application class using localized resources
public class LocalizationExample {
    public static void main(String[] args) {
        // User's preferred language (e.g., obtained from user settings)
        String userLanguage = "French"; // Change this to "English" to see English output

        // Map of available factories for different languages
        Map<String, LocalizedResourceFactory> factories = new HashMap<>();
        factories.put("English", new EnglishResourceFactory());
        factories.put("French", new FrenchResourceFactory());

        // Get the factory based on the user's language
        LocalizedResourceFactory factory = factories.get(userLanguage);

        // Create localized resources based on the selected language
        LocalizedResource localizedResource = factory.createLocalizedResource();

        // Use the localized resources
        System.out.println(localizedResource.getGreetings());
        System.out.println(localizedResource.getFarewell());
    }
}
