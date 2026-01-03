# Semiconductor Chamber Process Simulator (Java)

A multithreaded Java simulation of a semiconductor vacuum chamber process,
modeled using real-world equipment control concepts.

## Features
- Multithreaded sensor simulation
- Shared memory using AtomicInteger
- Finite State Machine (FSM)
- Safety interlock based on pressure threshold
- Controller–Subsystem architecture

## Architecture
- **SensorSimulator** runs as a background thread
- **ChamberController** manages state transitions
- **SensorData** acts as shared memory
- **State** enum defines valid chamber states

## Tech Stack
- Java 21
- Multithreading
- Concurrency (Atomic variables)

## How to Run
```bash
javac -d out src/ChamberSimulator/*.java
java -cp out ChamberSimulator.Main
