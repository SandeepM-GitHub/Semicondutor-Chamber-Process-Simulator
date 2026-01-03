package ChamberSimulator;

public class ChamberController {
    private State currentState = State.IDLE;
    private final SensorData sensors;

    // Constructor: Connects the brain to the sensors
    public ChamberController(SensorData sensors) {
        this.sensors = sensors;
    }

    private void transitionTo(State newState) {
        System.out.println("State Transition: " + currentState + " -> " + newState);
        this.currentState = newState;
    }

    // Main loop of the machine
    public void runCycle() {
        try {
            System.out.println("--- Starting Cycle ---");

            // 1. Start pumping
            transitionTo(State.PUMPING_DOWN);

            // 2. Wait for vacuum ("The Safety Lock")
            // Keep Looping WHILE the pressure is unsafe (greater than 50)
            while (sensors.pressure.get() > 50) {
                System.out.println("Pressure is " + sensors.pressure.get() + ". Waiting for vacuum...");
                Thread.sleep(500); // Pause for half a second instead of spamming the console
            }

            // 3. Process 
            transitionTo(State.PROCESSING);
            System.out.println("Plasma ON. Processing wafer...");
            Thread.sleep(2000); // Simulate the actual work taking 2 seconds

            //4. Vent (Return to atmospheric Pressure)
            transitionTo(State.VENTING);
            System.out.println("Returning to atmospheric pressure...");

            // 5. Done
            transitionTo(State.IDLE);
            System.out.println("--- Cycle Complete ---");
        } catch (Exception e) {
            transitionTo(State.ERROR);
            e.printStackTrace();
        }
    }
}



