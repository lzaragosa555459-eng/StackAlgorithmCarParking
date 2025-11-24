import java.util.Arrays;

public class Stack{
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
	public void push(int car,String name) {
		if(isFull()) {
			System.out.println("Car Parking is Already full!");
		} else {
			
			stack[++top][0] = car;
			stack[top][1] = name;
			System.out.println("Plate: "+car+"\nName: "+name);
	
		}
	}
	public void pop(int moveCar) {
		if(isEmpty()) {
			System.out.println("Empty Cars! Nothing to move");
		} else {
			int index = 0;
			
			for(int i=0;i<stack.length;i++) {
				if(i != moveCar) {
					temp[index++]=stack[i];
				}
			}
			top--;
			
			for(int i=0;i<stack.length;i++) {
				for(int j=0;j < stack[i].length;j++) {
					
					stack[i][j] = temp[i][j];
				}
			}
			
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Empty Car parking. Nothing to peek here...");
		} else {
			System.out.println("Plate Number: "+stack[top][0]);
			System.out.println("Owner Name: "+stack[top][1]);
		}
	}
	public void display() {
		if(isEmpty()) {
			System.out.println("Car parking is empty");
		} else {
			System.out.println("--Car Parked for today--");
			for(int i=0;i<=top;i++) {
				System.out.print(Arrays.deepToString(stack[i])+" ");
			}
			System.out.println();
		}
	}
	public int gettop() {
		return top;
	}
}