package ChamberSimulator;

public class SensorSimulator implements Runnable {
    private final SensorData sensors;

    public SensorSimulator(SensorData sensors) {
        this.sensors = sensors;
    }

    @Override
    public void run() {
        // This code runs in a background thread
        while(true) {
            // 1. Get current pressure
            int currentP = sensors.pressure.get();

            // 2. Simulate Pump: If pressure is above 0, reduce it
            if (currentP > 0) {
                // we use
                sensors.pressure.addAndGet(-20);
                System.out.println("[SIM] Pressure dropped to: " + sensors.pressure.get());
            }

            try {
                Thread.sleep(200); // Wait 0.2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
