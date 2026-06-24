import java.util.Scanner;

class EWaste {
    int id;
    String itemName;
    double weight;

    EWaste(int id, String itemName, double weight) {
        this.id = id;
        this.itemName = itemName;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EWaste[] records = new EWaste[100];
        int count = 0;

        while (true) {
            System.out.println("\n===== E-Waste Collection Management System =====");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter E-Waste ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String item = sc.nextLine();

                    System.out.print("Enter Weight (kg): ");
                    double weight = sc.nextDouble();

                    records[count] = new EWaste(id, item, weight);
                    count++;

                    System.out.println("Record Inserted Successfully!");
                    break;

                case 2:
                    System.out.print("Enter ID to Update: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;

                    for (int i = 0; i < count; i++) {
                        if (records[i].id == updateId) {
                            sc.nextLine();

                            System.out.print("Enter New Item Name: ");
                            records[i].itemName = sc.nextLine();

                            System.out.print("Enter New Weight: ");
                            records[i].weight = sc.nextDouble();

                            updated = true;
                            System.out.println("Record Updated Successfully!");
                            break;
                        }
                    }

                    if (!updated)
                        System.out.println("Record Not Found!");
                    break;

                case 3:
                    System.out.print("Enter ID to Delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;

                    for (int i = 0; i < count; i++) {
                        if (records[i].id == deleteId) {

                            for (int j = i; j < count - 1; j++) {
                                records[j] = records[j + 1];
                            }

                            count--;
                            deleted = true;
                            System.out.println("Record Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted)
                        System.out.println("Record Not Found!");
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No Records Available!");
                    } else {
                        System.out.println("\n--- E-Waste Records ---");
                        for (int i = 0; i < count; i++) {
                            System.out.println(
                                    "ID: " + records[i].id +
                                    ", Item: " + records[i].itemName +
                                    ", Weight: " + records[i].weight + " kg");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}