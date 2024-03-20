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
		//System.out.println(response.body());
		
		//STRING-> Class 변환
		ObjectMapper objectMapper = new ObjectMapper();
		
		Root responseData =objectMapper.readValue(response.body(), Root.class);
		
		System.out.println(responseData.getData().get(0).getMNU());
	}



	//--------------
	
	
	private static class Store{
	    public String Cnt;
	    public String OPENDATA_ID;
	    public String GNG_CS;
	    public String FD_CS;
	    public String BZ_NM;
	    public String TLNO;
	    public String MBZ_HR;
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
	    public String BUS;
		public String getCnt() {
			return Cnt;
		}
		public void setCnt(String cnt) {
			Cnt = cnt;
		}
		public String getOPENDATA_ID() {
			return OPENDATA_ID;
		}
		public void setOPENDATA_ID(String oPENDATA_ID) {
			OPENDATA_ID = oPENDATA_ID;
		}
		public String getGNG_CS() {
			return GNG_CS;
		}
		public void setGNG_CS(String gNG_CS) {
			GNG_CS = gNG_CS;
		}
		public String getFD_CS() {
			return FD_CS;
		}
		public void setFD_CS(String fD_CS) {
			FD_CS = fD_CS;
		}
		public String getBZ_NM() {
			return BZ_NM;
		}
		public void setBZ_NM(String bZ_NM) {
			BZ_NM = bZ_NM;
		}
		public String getTLNO() {
			return TLNO;
		}
		public void setTLNO(String tLNO) {
			TLNO = tLNO;
		}
		public String getNBZ_HR() {
			return MBZ_HR;
		}
		public void setNBZ_HR(String nBZ_HR) {
			MBZ_HR = nBZ_HR;
		}
		public String getSEAT_CNT() {
			return SEAT_CNT;
		}
		public void setSEAT_CNT(String sEAT_CNT) {
			SEAT_CNT = sEAT_CNT;
		}
		public String getPKPL() {
			return PKPL;
		}
		public void setPKPL(String pKPL) {
			PKPL = pKPL;
		}
		public String getHP() {
			return HP;
		}
		public void setHP(String hP) {
			HP = hP;
		}
		public String getPSB_FRN() {
			return PSB_FRN;
		}
		public void setPSB_FRN(String pSB_FRN) {
			PSB_FRN = pSB_FRN;
		}
		public String getBKN_YN() {
			return BKN_YN;
		}
		public void setBKN_YN(String bKN_YN) {
			BKN_YN = bKN_YN;
		}
		public String getINFN_FCL() {
			return INFN_FCL;
		}
		public void setINFN_FCL(String iNFN_FCL) {
			INFN_FCL = iNFN_FCL;
		}
		public String getBRFT_YN() {
			return BRFT_YN;
		}
		public void setBRFT_YN(String bRFT_YN) {
			BRFT_YN = bRFT_YN;
		}
		public String getDSSRT_YN() {
			return DSSRT_YN;
		}
		public void setDSSRT_YN(String dSSRT_YN) {
			DSSRT_YN = dSSRT_YN;
		}
		public String getMNU() {
			return MNU;
		}
		public void setMNU(String mNU) {
			MNU = mNU;
		}
		public String getSMPL_DESC() {
			return SMPL_DESC;
		}
		public void setSMPL_DESC(String sMPL_DESC) {
			SMPL_DESC = sMPL_DESC;
		}
		public String getSBW() {
			return SBW;
		}
		public void setSBW(String sBW) {
			SBW = sBW;
		}
		public String getbUS() {
			return BUS;
		}
		public void setbUS(String bUS) {
			this.BUS = bUS;
		}
		@Override
		public String toString() {
			return "Store [Cnt=" + Cnt + ", OPENDATA_ID=" + OPENDATA_ID + ", GNG_CS=" + GNG_CS + ", FD_CS=" + FD_CS
					+ ", BZ_NM=" + BZ_NM + ", TLNO=" + TLNO + ", MBZ_HR=" + MBZ_HR + ", SEAT_CNT=" + SEAT_CNT + ", PKPL="
					+ PKPL + ", HP=" + HP + ", PSB_FRN=" + PSB_FRN + ", BKN_YN=" + BKN_YN + ", INFN_FCL=" + INFN_FCL
					+ ", BRFT_YN=" + BRFT_YN + ", DSSRT_YN=" + DSSRT_YN + ", MNU=" + MNU + ", SMPL_DESC=" + SMPL_DESC
					+ ", SBW=" + SBW + ", BUS=" + BUS + "]";
		}
	    
	    //getter and setter
		//toString
		
		
	    
	}

	private static class Root{
	    public String status;
	    public String total;
	    public ArrayList<Store> data;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public ArrayList<Store> getData() {
			return data;
		}
		public void setData(ArrayList<Store> data) {
			this.data = data;
		}
	    
	    //getter and setter
	    
	}


	
	//--------------

}








