import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarParking s = new CarParking();

        s.load();

        loop: while (true) {
           
            System.out.println("--Main Menu--\n[1]Park car\n[2]Exit Car\n[3]View top car & Total Cars\n[4]Display\n[5]Exit\n\n<?>Choose option<?>");
            int choose;

            try{
            choose = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid Input! Enter number only.");
            sc.nextLine();
            continue;
        }


            switch (choose) {
                case 1:
                    if(s.isFull()){
                        System.out.println("The Car Parking is already Full! Nothing to add here...");
                    } else {
                    try{
                    System.out.println("Enter car plate");
                    int plate = sc.nextInt();
                    System.out.println("Enter Owner name");
                    String name = sc.next();
                    s.push(plate, name);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Enter number only.");
                        sc.nextLine();
                        break;
                    }
                }
                    break;
                case 2:
                    if(s.isEmpty()){
                        System.out.println("Car Parking is Empty! nothing to pop.");
                    } else {
                    try{
                    System.out.println("What car to move? Input index 1-" + (s.gettop() + 1));
                    int chooseCar = sc.nextInt();
                    s.pop(chooseCar - 1);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Enter number only.");
                        sc.nextLine();
                        break;
                    }
                }
                    break;
                case 3:
                    System.out.println("\n-----Top Car-----------");
                    s.peek();
                    System.out.println("-----Total Cars--------");
                    s.totalCars();
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Exit Parking Lot Stack Simulator...");
                    break loop;
                default:
                    System.out.println("Invalid Input. Enter numbers' 1 to 5 only.");
                    break;
              
            }
        }
        sc.close();
    }
}
