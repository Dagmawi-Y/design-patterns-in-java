package behavioural_patterns.Observer;

import java.util.Observable;
import java.util.Observer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ResponseHandler1 implements Observer {
    private String resp;
    private final int handlerNumber;

    public ResponseHandler1(int handlerNumber) {
        this.handlerNumber = handlerNumber;
    }

    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            System.out.println("\nResponseHandler" + handlerNumber + " - Received Response: " + resp);
        }
    }
}

class ResponseHandler2 implements Observer {
    private String resp;
    private final int handlerNumber;

    public ResponseHandler2(int handlerNumber) {
        this.handlerNumber = handlerNumber;
    }

    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            System.out.println("\nResponseHandler" + handlerNumber + " - Received Response: " + resp);
        }
    }
}

class EventSource extends Observable implements Runnable {
    @Override
    public void run() {
        try {
            final InputStreamReader isr = new InputStreamReader(System.in);
            final BufferedReader br = new BufferedReader(isr);
            while (true) {
                String response = br.readLine();
                setChanged();
                notifyObservers(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ObserverPatternClient {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        ResponseHandler1 handler1 = new ResponseHandler1(1);
        ResponseHandler2 handler2 = new ResponseHandler2(2);

        eventSource.addObserver(handler1);
        eventSource.addObserver(handler2);

        Thread eventThread = new Thread(eventSource);
        eventThread.start();
    }
}
