package Ch28_;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;



import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ImgCrowling {

	Connection conn;
	
	ImgCrowling() {
		// URL과 연결된 Jsoup.connection
	}
	public void setURL(String url) {
		conn = Jsoup.connect(url);
	}
	
	public ArrayList<String> Crowling() {

		
		ArrayList<String> list = new ArrayList();
		// DOM객체를 꺼내와 저장
		Document document = null;
		try {
			document = conn.get();
		} catch (IOException e1) {}

		// DOM객체 안에서 img태그요소만 추출
		Elements elements = document.getElementsByTag("img");

		String imgUrl = null;

		UUID uuid = UUID.randomUUID();
		File dir = new File("c:\\iotest\\"+uuid.toString());
		if(!dir.exists())
			dir.mkdir();
		
		for (int i = 0; i < elements.size(); i++) {
			try {
			if (elements.get(i).toString().contains("http")) {
				// elements안의 i번째 요소에서 src속성에 해당되는 값을 추출
				imgUrl = elements.get(i).getElementsByAttribute("src").attr("src");
			} else if (elements.get(i).toString().contains("//")) {
				imgUrl = "https:" + elements.get(i).getElementsByAttribute("src").attr("src");
			}

			System.out.println(imgUrl);

			// URL연결
			
				URL url = new URL(imgUrl);
				InputStream in = url.openStream();

				BufferedInputStream bin = new BufferedInputStream(in);
				byte[] buff = new byte[4096];
				String filename = "ImageFile";
				
				
				
				String filepath = "c:\\iotest\\"+uuid.toString()+"\\"+ filename + i + ".png";
				OutputStream out = new FileOutputStream(filepath);
				int data = 0;
				while (true) {
					data = bin.read(buff);
					if (data == -1) {
						break;
					}
					out.write(buff, 0, data);
					out.flush();
				}
				list.add(filepath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}