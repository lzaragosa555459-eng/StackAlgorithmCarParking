# Car Parking Algorithm Project

## Project Description
The **Car Parking Algorithm Project** is a backend-focused software project that simulates and manages a single-lane car parking lot using a **stack-based algorithm**. The system handles parking and exiting of cars efficiently, following the **LIFO (Last-In, First-Out)** principle.  

Cars that are blocked by others are temporarily moved using a secondary stack, inspired by the **Tower of Hanoi problem**, ensuring smooth entry and exit operations without conflicts. This project emphasizes **algorithm design, data structure usage, and logical problem solving** rather than a graphical user interface.

## Features
- Park new cars using a **main stack** (LIFO principle).  
- Handle exiting cars even if blocked, using a **temporary stack**.  
- Maintain a **real-time view** of the parking lot status.  
- Record all parking, exiting, and movements in a **CSV log file** for auditing.  
- Display all currently parked cars with their license plate and owner name.  

## Purpose
The main goal of this project is to **demonstrate the practical use of stacks in managing real-world problems**, like single-lane parking. It reduces manual errors, optimizes space usage, and provides a clear method to track car movements for auditing or analysis.  

## Technologies Used
- Programming Language: **Java**  
- Data Structures: **Stack, 2D Array**  
- Core Concepts: **LIFO operations, file handling, encapsulation, algorithm design**  

## How to Run
1. Open the project folder.  
2. Compile the Java code (e.g., `javac Main.java`).  
3. Run the program (e.g., `java Main`).  
4. Follow the console menu to park, exit, display cars, or exit the system.  

## System Flow
1. **Initialization:** The program creates an empty main stack representing the parking lane.  
2. **User Menu:** Options include parking a car, removing a car, displaying cars, or exiting.  
3. **Parking (Push):** User enters license plate and owner name; car is pushed onto the main stack.  
4. **Exiting (Pop):** If the target car is blocked, cars above it are temporarily moved to a temp stack. After removing the target, cars are returned.  
5. **Display:** Lists all parked cars in order.  
6. **Exit:** Closes the program.  

