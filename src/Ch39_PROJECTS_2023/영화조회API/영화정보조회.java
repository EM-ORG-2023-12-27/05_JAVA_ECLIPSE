package Ch39_PROJECTS_2023.영화조회API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class 영화정보조회 {

	public static void main(String[] args) {

		String apiKey = "YOUR_AUTHENTICATION_KEY"; // 발급받은 인증키를 입력하세요.

		try {
			String movieTitle = "기생충"; // 검색할 영화 제목을 입력하세요.
			String encodedTitle = URLEncoder.encode(movieTitle, "UTF-8");

			String apiUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";
			String query = "?key=" + apiKey + "&movieNm=" + encodedTitle;

			URL url = new URL(apiUrl + query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuilder response = new StringBuilder();

				while ((line = br.readLine()) != null) {
					response.append(line);
				}
				br.close();

				System.out.println(response.toString());
			} else {
				System.out.println("API 요청에 실패하였습니다. 응답 코드: " + responseCode);
			}
		} catch (Exception e) {
			System.out.println("영화 정보 조회 중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
