package org.example.app;

import org.example.controler.WiseSayingController;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
        //main에서 받은 스캐너 변수를 앱의 변수로 넣어서 공동으로 쓸수있도록함
    }
    public void run() {
        WiseSayingController wiseSayingController = new WiseSayingController(sc);
// 명언컨트롤 클래스에 스캐너 변수를 넣어서 쓸수있게함
        System.out.println("==명언 앱 실행==");

        while (true) { // 무한루프를 통해서 명령어를 받고 각 명령에 맞는 커맨드로 메서드 실행
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("등록")) {
                wiseSayingController.add();
            } else if (cmd.equals("목록")) {
                wiseSayingController.list();
            } else if (cmd.startsWith("상세보기")) {// 시작하는 단어로 찾는 string 메서드
                wiseSayingController.detail(cmd);
            } else if (cmd.startsWith("삭제")) {
                wiseSayingController.delete(cmd);
            } else if (cmd.startsWith("수정")) {
                wiseSayingController.modify(cmd);
            } else {
                System.out.println("다시입력");
                return;
            }
        }
    }

}
