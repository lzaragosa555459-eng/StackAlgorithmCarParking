import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        loop: while (true) {
            System.out.println("--Menu--\n1]Add Car\n2]Pop Car\n3]Peek\n4]Display\n5]Exit\n\nChoose methods>>");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Enter car plate");
                    int plate = sc.nextInt();
                    System.out.println("Enter Owner name");
                    String name = sc.next();
                    s.push(plate, name);
                    break;
                case 2:
                    System.out.println("What car to move? Input index 1-" + (s.gettop() + 1));
                    int chooseCar = sc.nextInt();
                    s.pop(chooseCar - 1);
                    break;
                case 3:
                    s.peek();
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Exit");
                    break loop;
                default:
                    System.out.println("Invalid. Try again.");
                    break;
            }
        }
        sc.close();
    }
}