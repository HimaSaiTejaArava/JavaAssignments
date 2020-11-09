package Assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Assignment3 {

    public void ping() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Host Address");
        String host = bufferedReader.readLine();
        System.out.println(findMedian(host));
    }

    public static double findMedian(String host) {
        Runtime runtime = Runtime.getRuntime();
        String pingCommand = "ping " + host + " -c 5";
        double median=0.0;
        try {
            Process process = runtime.exec(pingCommand);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String output;
            List<Double> packet = new ArrayList<Double>();

            while (input.readLine() != null) {
                output = input.readLine();
                int timeIndex = output.indexOf("time=");
                if (timeIndex != -1) {
                    packet.add(Double.parseDouble(output.substring(timeIndex + 5, output.lastIndexOf("ms") - 1)));
                }
            }

            int size = packet.size();

            if (size == 0) {
                System.out.println("Given host address is not reachable");
                System.exit(0);
            }

            Collections.sort(packet);

            if (size % 2 == 0)
                median= ((Double) packet.get(size / 2) + (Double) packet.get(size / 2 - 1)) / 2;
            else
                median = (Double) packet.get(size / 2);

        }
        catch (Exception e) {
            System.out.println("Given host address does not exist or unreachable");
        }
        return median;
    }
}
