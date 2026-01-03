package ChamberSimulator;

public class Main {
    public static void main(String[] args) {
        // 1. Create the Shared Memory
        SensorData sharedSensors = new SensorData();

        // 2. Setup the Simulator (The Pump)
        SensorSimulator simulatorTask = new SensorSimulator(sharedSensors);
        Thread simThread = new Thread(simulatorTask);
        simThread.start(); // This starts the background 
        
        // 3. Run the Controller (The Brain)
        ChamberController controller = new ChamberController(sharedSensors);
        controller.runCycle();
    }
}
