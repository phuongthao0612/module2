import java.io.*;


public class FileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Cung cấp tệp nguồn và tệp đích ");
            return;
        }
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại ");
            return;
        }
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại ");
            return;
        }
        try (FileReader fr = new FileReader(sourceFile);
             FileWriter fw = new FileWriter(targetFile);) {
            int character;
            int count = 0;
            while ((character = fr.read()) != -1) {
                fw.write(character);
                count++;
            }
            System.out.println("Copy thành công! Số ký tự trong tệp: " + count);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
