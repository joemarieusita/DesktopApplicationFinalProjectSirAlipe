package api;

import com.google.gson.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableAPIExample {
    public void show(){
        // Correct API URL
        String apiUrl = "https://api.novergarin.com/show.php"; 
        
        // Fetch data from API
        String jsonData = fetchAPIData(apiUrl);
        
        if (jsonData != null) {
            // Parse JSON data
            Gson gson = new Gson();
            JsonArray jsonArray = JsonParser.parseString(jsonData).getAsJsonArray();
            
            // Prepare data for JTable
            Vector<Vector<String>> tableData = new Vector<>();
            Vector<String> columnNames = new Vector<>();
            columnNames.add("Email");
            columnNames.add("Password");
            
            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                Vector<String> row = new Vector<>();
                row.add(obj.get("email").getAsString());
                row.add(obj.get("password").getAsString());
                tableData.add(row);
            }
            
            // Create JTable
            DefaultTableModel model = new DefaultTableModel(tableData, columnNames);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            
            // Show the table in a JFrame
            JFrame frame = new JFrame("User Data");
            frame.add(scrollPane);
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to fetch data from API");
        }
    }

    // Fetch data from API
    public static String fetchAPIData(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                System.err.println("HTTP GET request failed with code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
