package org.example;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastId=0;
        List<Motivation> motivations = new ArrayList<>();
        System.out.println("== 명언 앱 실행 ==");

        while(true) {

            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();


            if (cmd.equals("등록")) {
                int id = lastId + 1;
                System.out.print("명언 : ");
                String title = sc.nextLine().trim();
                System.out.print("작가 : ");
                String body = sc.nextLine().trim();
                LocalDateTime date = LocalDateTime.now();
                LocalDateTime upDate = LocalDateTime.now();


                Motivation motivation = new Motivation(id, title, body, date, upDate);
                motivations.add(motivation);
                System.out.println(id+"번 명언이 등록되었습니다.");
                lastId++;

            } else if (cmd.equals("목록")) {
                System.out.println("번호  /  작가   /   명언");
                System.out.println("===========================");

                if (motivations.size() == 0) {
                    System.out.println("등록된 글 없음");
                } else {
                    for (int i = motivations.size() - 1; i >= 0; i--) {
                        Motivation motivation = motivations.get(i);
                        System.out.printf("%d  /   %s   /   %s \n", motivation.getId(), motivation.getTitle(), motivation.getBody());
                    }
                }
            }else if(cmd.startsWith("삭제")) {
                String[] bits = cmd.split("=");
                int id = Integer.parseInt(bits[1]);
                Motivation finfId = null;
                for (Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        finfId = motivation;
                    }
                }
                motivations.remove(finfId);
                System.out.println(id + "번 글이 삭제되었습니다");

            }else if(cmd.startsWith("수정")){
                String[] bits = cmd.split("=");
                int id = Integer.parseInt(bits[1]);
                Motivation finfId = null;
                for (Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        finfId = motivation;
                    }else finfId = null;
                }
                if (finfId == null) {
                    System.out.println(id+"번 명언은 존재하지않습니다.");
                }else {
                    for (int i = motivations.size() - 1; i >= 0; i--) {
                        if(finfId==motivations.get(i)) {
                        Motivation motivation = motivations.get(i);
                        System.out.printf("%d  /   %s   /   %s \n", motivation.getId(), motivation.getTitle(), motivation.getBody());
                        }
                    }
                }

            } else if(cmd.startsWith("상세보기")){
                String[] bits = cmd.split("=");
                int id = Integer.parseInt(bits[1]);
                Motivation finfId = null;
                for(Motivation motivation : motivations) {
                    if (motivation.getId() == id) {
                        finfId = motivation;
                    }
                    motivations.get(id);
                    System.out.println("번호: " + finfId.getId());
                    System.out.println("날짜: " + finfId.getUpDate());
                    System.out.println("작가: " + finfId.getTitle());
                    System.out.println("내용: " + finfId.getBody());
                }

            }
        }
    }
}
class Motivation {
    private int id;
    private String title;
    private String body;
    private LocalDateTime date;
    private LocalDateTime upDate;

    public Motivation(int id, String title, String body, LocalDateTime date, LocalDateTime upDate){
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.upDate = upDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getUpDate() {
        return upDate;
    }

    public void setUpDate(LocalDateTime upDate) {
        this.upDate = upDate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }
}



