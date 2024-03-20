package Ch19;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class C11RestRequestMain {
	
	
	public static void main(String[] args) throws Exception{
	
		
		//URL 지정 + 파라미터 지정
		String mode = "json";
		String addr = "중구";
		String url = "https://www.daegufood.go.kr/kor/api/tasty.html";
		
		url=url+"?"+"mode="+mode+"&addr="+addr;
		
		//HTTP 요청 단위 생성
		HttpRequest httpRequest=HttpRequest.newBuilder()
								.uri(URI.create(url))
								.GET()
								.build();
		
		//HTTP 요청
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
		//STRING->JSON 변환
		ObjectMapper objectMapper = new ObjectMapper();
		
	}

}



class Store{
    public String Cnt;
    public String OPENDATA_ID;
    public String GNG_CS;
    public String FD_CS;
    public String BZ_NM;
    public String TLNO;
    public String NBZ_HR;
    public String SEAT_CNT;
    public String PKPL;
    public String HP;
    public String PSB_FRN;
    public String BKN_YN;
    public String INFN_FCL;
    public String BRFT_YN;
    public String DSSRT_YN;
    public String MNU;
    public String SMPL_DESC;
    public String SBW;
    public String bUS;
}

class Root{
    public String status;
    public String total;
    public ArrayList<Store> data;
}






