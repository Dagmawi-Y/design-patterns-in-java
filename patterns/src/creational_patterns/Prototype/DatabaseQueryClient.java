package creational_patterns.Prototype;

// Prototype interface representing the database query result
interface QueryResult extends Cloneable {
    void executeQuery();
    QueryResult clone();
}

// Concrete prototype class representing cached query result
class CachedQueryResult implements QueryResult {
    private String query;

    public CachedQueryResult(String query) {
        this.query = query;
        executeQuery(); // Simulating execution and caching of the query result
    }

    @Override
    public void executeQuery() {
        System.out.println("Executing query: " + query);
        // Simulating fetching data from the database and caching the result
        // In a real scenario, this would involve actual database interaction
        System.out.println("Cached query result for: " + query);
    }

    @Override
    public QueryResult clone() {
        try {
            return (QueryResult) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// Client code simulating database query caching
public class DatabaseQueryClient {
    public static void main(String[] args) {
        // Prototype object representing cached query result
        QueryResult cachedResultPrototype = new CachedQueryResult("SELECT * FROM users");

        // Cloning prototype to create new instances avoiding repeated costly queries
        QueryResult cachedResult1 = cachedResultPrototype.clone();
        QueryResult cachedResult2 = cachedResultPrototype.clone();

        // Executing queries using cloned cached results
        cachedResult1.executeQuery(); // Reuses cached result
        cachedResult2.executeQuery(); // Reuses cached result
    }
}
