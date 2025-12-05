import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarParking s = new CarParking();

        s.load();

        loop: while (true) {
           
            System.out.println("--Menu--\n1]Add Car\n2]Pop Car\n3]Peek\n4]Display\n5]Exit\n\nChoose>>");
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
                    try{
                    System.out.println("Enter car plate");
                    int plate = sc.nextInt();
                    System.out.println("Enter Owner name");
                    String name = sc.next();
                    s.push(plate, name);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! You input a special key.");
                        sc.nextLine();
                        break;
                    }
                    break;
                case 2:
                    try{
                    System.out.println("What car to move? Input index 1-" + (s.gettop() + 1));
                    int chooseCar = sc.nextInt();
                    s.pop(chooseCar - 1);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! You input a special key.");
                        sc.nextLine();
                        break;
                    }
                    break;
                case 3:
                    s.peek();
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Exit Program...");
                    break loop;
                default:
                    System.out.println("Invalid Input. Enter numbers' 1 to 5 only.");
                    break;
              
            }
        
        
        }
        sc.close();
    }
}
