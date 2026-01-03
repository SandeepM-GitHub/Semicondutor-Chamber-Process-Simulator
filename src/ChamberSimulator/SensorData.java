package ChamberSimulator;
import java.util.concurrent.atomic.AtomicInteger;

public class SensorData {
    public AtomicInteger pressure = new AtomicInteger(760);
    public AtomicInteger temperature = new AtomicInteger(25);
}
