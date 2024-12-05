package repository;

import entity.Member;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class MemberRepository {
    public List<Member> getAll() {
        File file = new File("src/csv/member.csv");
        List<Member> members = new LinkedList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Member member = new Member(
                            Integer.parseInt(data[0]),
                            data[1],
                            formatter.parse(data[2]),
                            data[3],
                            data[4]
                    );
                    members.add(member);
                } catch (ParseException e) {
                    System.out.println("Lỗi ngày sinh: " + data[2]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file " + "src/csv/member.csv");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file " + "src/csv/member.csv");
        }
        return members;
    }

    private void writeFile(List<Member> members, boolean append) {
        File file = new File("src/csv/member.csv");
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Member member : members) {
                bufferedWriter.write(member.getId() + "," + member.getName() + "," + member.getBirthDate() +
                        "," + member.getAddress() + "," + member.getPhone());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu");
        }
    }

    public void add(Member member) {
        List<Member> members = getAll();
        members.add(member);
        writeFile(members, true);
    }

    public void remove(int id) {
        List<Member> members = getAll();
        members.removeIf(member -> member.getId() == id);
        writeFile(members, false);
    }

    public void update(Member member) {

    }

    public Member findById(int id) {
        List<Member> members = getAll();
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public List<Member> searchByName(String name) {
        List<Member> members = getAll();
        List<Member> result = new LinkedList<>();
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(member);
            }
        }
        return result;
    }
}
