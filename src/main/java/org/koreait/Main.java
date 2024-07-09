package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Article> articles = new ArrayList<Article>();

        int LastId = 1;
        System.out.println("== 명언 앱 실행 ==");

        while (true){
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")){
                System.out.println("== 종료 ==");
                break;
            }
            else if(cmd.length() == 0) {
                System.out.println("명령어 입력 필요");
                continue;
            }

            if (cmd.equals("등록")){
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                String regDate = Util.getNow();

                Article article = new Article(LastId, content, author, regDate);
                articles.add(article);

                System.out.println(LastId + "번 명언이 등록되었습니다.");
                LastId++;
            }

            if (cmd.equals("목록")){
                System.out.println("  번호   /   작가   /   명언");
                if (articles.size() == 0) {
                    System.out.println("목록이 비어있음");
                }
                    for (int i = articles.size() - 1; i >= 0; i--) {
                        Article article = articles.get(i);
                        System.out.printf("  %d   /   %s   /   %s  \n", article.getId(), article.getAuthor(), article.getContent());
                    }


            }

           if (cmd.startsWith("상세보기?id=")){
               int id = Integer.parseInt(cmd.split("=")[1]);

               Article foundArticle = null;

               for (Article article : articles) {
                   if (article.getId() == id) {
                       foundArticle = article;
                       break;
                   }
               }

               if (foundArticle == null) {
                   System.out.println("해당 명언은 없습니다");
                   continue;
               }
               System.out.println("번호 : " + foundArticle.getId());
               System.out.println("날짜 : " + foundArticle.getRegDate());
               System.out.println("작가 : " + foundArticle.getAuthor());
               System.out.println("내용 : " + foundArticle.getContent());
           }

            if (cmd.startsWith("수정?id=")){
                int id = Integer.parseInt(cmd.split("=")[1]);

                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.println("해당 명언은 없습니다");
                    continue;
                }
                System.out.println("명언(기존) : " + foundArticle.getContent());
                System.out.println("작가(기존) : " + foundArticle.getAuthor());
                System.out.print("명언 : ");
                String newContent = sc.nextLine();
                System.out.print("작가 : ");
                String newAuthor = sc.nextLine();

                foundArticle.setContent(newContent);
                foundArticle.setAuthor(newAuthor);

                System.out.println(id + "번 명언이 수정되었습니다.");
            }

            if (cmd.startsWith("삭제?id=")){
                int id = Integer.parseInt(cmd.split("=")[1]);

                Article foundArticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.println("해당 명언은 없습니다");
                    continue;
                }

                articles.remove(foundArticle);
                System.out.println(id + "번 명언이 삭제되었습니다");
            }
        }

    }
}