import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DoctorsOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> queue = new ArrayList<>();
        Map<String, Integer> nameCount = new HashMap<>();

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Append":
                    String nameToAppend = tokens[1];
                    queue.add(nameToAppend);
                    nameCount.put(nameToAppend, nameCount.getOrDefault(nameToAppend, 0) + 1);
                    System.out.println("OK");
                    break;

                case "Insert":
                    int position = Integer.parseInt(tokens[1]);
                    if (position >= 0 && position <= queue.size()) {
                        String nameToInsert = tokens[2];
                        queue.add(position, nameToInsert);
                        nameCount.put(nameToInsert, nameCount.getOrDefault(nameToInsert, 0) + 1);
                        System.out.println("OK");
                    } else {
                        System.out.println("Error");
                    }
                    break;

                case "Find":
                    String nameToFind = tokens[1];
                    System.out.println(nameCount.getOrDefault(nameToFind, 0));
                    break;

                case "Examine":
                    int count = Integer.parseInt(tokens[1]);
                    if (count <= queue.size()) {
                        for (int i = 0; i < count; i++) {
                            String examinedName = queue.remove(0);
                            nameCount.put(examinedName, nameCount.get(examinedName) - 1);
                            System.out.print(examinedName + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Error");
                    }
                    break;
            }
        }
    }
}
