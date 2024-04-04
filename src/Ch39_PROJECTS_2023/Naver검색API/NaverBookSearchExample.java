package Ch39_PROJECTS_2023.Naver검색API;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverBookSearchExample {
    public static void main(String[] args) {
        String clientId = "5RsCotNjdotWr3GrU6yP"; // 네이버 개발자 센터에서 발급받은 클라이언트 아이디
        String clientSecret = "4Rspu4j5VX"; // 네이버 개발자 센터에서 발급받은 클라이언트 시크릿

        try {
            String query = "JAVA"; // 검색할 도서의 검색어
            int displayCount = 10; // 출력할 검색 결과 수

            String encodedQuery = URLEncoder.encode(query, "UTF-8");

            
            // 요청 URL 생성
            String apiUrl = "https://openapi.naver.com/v1/search/book.json?query="
                    + encodedQuery 
                    +"&display=" + displayCount;
            		
             
            
            // HTTP GET 요청 보내기
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = conn.getResponseCode();

            BufferedReader br;
            if (responseCode == 200) { // 정상 응답을 받은 경우
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else { // 에러 응답을 받은 경우
                br = new BufferedReader(new 
                		InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            System.out.println(response);
            // JSON 파싱하여 도서 정보 추출
            JSONObject json = new JSONObject(response.toString());
            JSONArray items = json.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                String title = item.getString("title");
                String author = item.getString("author");
                String publisher = item.getString("publisher");
                String pubDate = item.getString("pubdate");

                System.out.println("도서 제목: " + title);
                System.out.println("저자: " + author);
                System.out.println("출판사: " + publisher);
                System.out.println("출판일: " + pubDate);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

