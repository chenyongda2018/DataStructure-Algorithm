package JVM;

import java.io.*;

public class TestSplit {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        File temp = File.createTempFile("temp", ".txt", file.getParentFile());
        String charset = "UTF-8";
        String delete = "Words in Unit";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp),charset));
        for (String line; (line = reader.readLine()) != null;) {
            if(line.equals("")) continue;
            if(line.contains(delete)) continue;
            line = line.replaceAll(" +",",");
            writer.println(line);
        }
        reader.close();
        writer.close();
        file.delete();
        temp.renameTo(file);
    }
}
