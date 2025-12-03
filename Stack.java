import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileReader;

public class Stack {
    private int size = 5;
    private Object[][] stack = new Object[size][2];
    private int top = -1;
    private Object[][] temp = new Object[stack.length][stack[0].length];

    public Stack() {
        initializeLogFile();
    }

  
    private void initializeLogFile() {
        String fileName = "parking_log.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("Action,CarPlate,OwnerName\n");
            System.out.println("Parking log file initialized: " + fileName);
        } catch (IOException e) {
            System.err.println("Error initializing log file: " + e.getMessage());
        }
    }


    private void logAction(String action, int carPlate, String ownerName) {
        String fileName = "parking_log.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(action + "," + carPlate + "," + ownerName + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int car, String name) {
        if (isFull()) {
            System.out.println("Car Parking is Already full!");
        } else {
            stack[++top][0] = car;
            stack[top][1] = name;
            System.out.println("Plate: " + car + "\nName: " + name);
            logAction("PARKED", car, name);
        }
    }

    public void pop(int moveCar) {
        if (isEmpty()) {
            System.out.println("Empty Cars! Nothing to move");
        } else {
            int index = 0;
            
            
            int removedCar = (int) stack[moveCar][0];
            String removedOwner = (String) stack[moveCar][1];
            
            for (int i = 0; i < stack.length; i++) {
                if (i != moveCar) {
                    temp[index++] = stack[i];
                }
            }
            top--;
            
            for (int i = 0; i < stack.length; i++) {
                for (int j = 0; j < stack[i].length; j++) {
                    stack[i][j] = temp[i][j];
                }
            }
            
            logAction("REMOVED", removedCar, removedOwner);
            System.out.println("Car removed - Plate: " + removedCar + ", Owner: " + removedOwner);
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Empty Car parking. Nothing to peek here...");
        } else {
            System.out.println("Plate Number: " + stack[top][0]);
            System.out.println("Owner Name: " + stack[top][1]);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Car parking is empty");
        } else {
            System.out.println("--Car Parked for today--");
            for (int i = 0; i <= top; i++) {
                System.out.print(Arrays.deepToString(stack[i]) + " ");
            }
            System.out.println();
        }
    }

    public int gettop() {
        return top;
    }
}
