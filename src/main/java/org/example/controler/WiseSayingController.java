package org.example.controler;

import org.example.util.Util;
import org.example.winseSayingw.WiseSayingw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    List<WiseSayingw> wiseSayings = new ArrayList<WiseSayingw>();
    int lastId = 0;
    Scanner sc;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void add () {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        String regDate = Util.getdatetime();
        int id = lastId + 1;
        lastId++;

        WiseSayingw ws = new WiseSayingw(id, content, author, regDate);
        wiseSayings.add(ws);
        System.out.println(id+"번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호  /  작각  /  명언  ");
        System.out.println("==================================");
        if(wiseSayings.size() == 0) {
            return;
        }
        for (WiseSayingw ws : wiseSayings) {
            System.out.printf("%d  /   %s   /  %s    %s\n", ws.getId(), ws.getContent(), ws.getAuthor());
            break;
        }
    }

    public void detail(String cmd) {
        int id = Integer.parseInt(cmd.split("=")[1]);
        WiseSayingw findws = null;
        for (WiseSayingw ws : wiseSayings) {
            if (ws.getId() == id) {
                findws = ws;
                break;
            }
        }if(findws == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }

        System.out.printf("번호 : %d\n", findws.getId());
        System.out.printf("날짜 : %s\n", findws.getContent());
        System.out.printf("작가 : %s\n", findws.getAuthor());
        System.out.printf("내용 : %s\n", findws.getContent());

    }

    public void delete(String cmd) {
        int id = Integer.parseInt(cmd.split("=")[1]);
        WiseSayingw findws = null;
        for (WiseSayingw ws : wiseSayings) {
            if (ws.getId() == id) {
                findws = ws;
                break;
            }
        }if(findws == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }

        System.out.printf("%d번 명언이 삭제되었습니다.", findws.getId());
        wiseSayings.remove(findws);


    }

    public void modify(String cmd) {
        int id = Integer.parseInt(cmd.split("=")[1]);
        WiseSayingw findws = null;
        for (WiseSayingw ws : wiseSayings) {
            if (ws.getId() == id) {
                findws = ws;
                break;
            }
        }
        if(findws == null) {
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }

        System.out.println("명언(기존) : " + findws.getContent());
        System.out.println("작가(기존) : " + findws.getAuthor());
        System.out.print("명언 : ");
        String mewcontent = sc.nextLine();
        System.out.print("작가 : ");
        String mewauthor = sc.nextLine();
        String regDate = Util.getdatetime();

        findws.setContent(mewcontent);
        findws.setAuthor(mewauthor);
        findws.setRegDate(regDate);

        System.out.printf("%d번 명언이 수정되었습니다.", findws.getId());

    }

}
