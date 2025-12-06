import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CarParking {
    private int size = 5;
    private Object[][] stack = new Object[size][2];
    private int top = -1;
    private Object[][] temp = new Object[stack.length][stack[0].length];

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
            save(car, name);
            logAction("Parked", car, name);
        }
    }

    public void pop(int moveCar) {
        Object PlateNumber = stack[moveCar][0];
        Object OwnerName = stack[moveCar][1];
		if(isEmpty()) {
			System.out.println("Empty Cars! Nothing to pop.");
		} else {
			int index = 0;
			
			for(int i=0;i<stack.length;i++) {
				if(i != moveCar) {
					temp[index++]=stack[i];
                    if((stack[index][0] != null) && (index > moveCar)){
                     logAction("Moved", Integer.parseInt(stack[index][0].toString()), stack[index][1].toString());
                     continue;
                    }
				}
			}
            
			top--;
			
			for(int i=0;i<stack.length;i++) {
				for(int j=0;j < stack[i].length;j++) {
					
					stack[i][j] = temp[i][j];
				}
			}
            System.out.println("Car Popped successfully!");
			update();
            logAction("Exit", Integer.parseInt(PlateNumber.toString()), OwnerName.toString());
		}
	}

    public void peek() {
        if (isEmpty()) {
            System.out.println("Empty Car parking. Nothing to peek here...");
        } else {
            System.out.println("Plate Number: " + stack[top][0]);
            System.out.println("Owner Name: " + stack[top][1]);
        }
        System.out.println();
    }
    public void totalCars(){
        int sum = 0;

        for(int i = 0; i <= top; i++){
            ++sum;
        }
        System.out.println("Total Cars parked: "+sum);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Car parking is Empty! Nothing to display.");
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

//////FILE HANDLING AREA ////////


    private void save(int carPlate, String ownerName) { // SAVE TO CAR STORAGE
        String fileName = "CarStorage.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {

            writer.write(carPlate + "," + ownerName + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void load(){// LOAD CURRENT VALUES INSIDE THE STACK ARRAY
        try(BufferedReader reader = new BufferedReader(new FileReader("CarStorage.csv"))){
        
            String line;

            while((line = reader.readLine()) != null){
            
            String[] values = line.split(",");
            stack[++top][0] = values[0];
            stack[top][1] = values[1];
                
            }
            reader.close();
                }catch(IOException e){
                    System.out.println("There is something wrong reading your file.");
                }
    }

    public void update(){//UPDATE VALUES IN THE FILE CARSTORAGE WHEN DELETING OR POPPING A VALUE
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("CarStorage.csv"))){

            for (int i = 0; i <= top; i++) {
                writer.write(stack[i][0] + "," + stack[i][1] + "\n");
            }

        } catch (IOException e){
            System.out.println("Error! There is something wrong with updating the file.");
        }
    }

    
    private void logAction(String action, int carPlate, String ownerName) {//TRACKS THE MOVEMENTS OR LOGS OF EVERY CAR PARKED
        String fileName = "parking_log.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(action + " - " + carPlate + "," + ownerName + "\n");
            writer.write("-----------------------\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
