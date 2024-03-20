package Ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class C10JsoupMain {

	
	public static void main(String[] args) throws Exception {
		
		//URL 연결
//		Connection conn = Jsoup.connect("https://www.op.gg/champions");
		Connection conn = Jsoup.connect("https://www.musinsa.com/categories/item/001005");
//		Connection conn = Jsoup.connect("https://www.auction.co.kr/??pid=867&gclid=EAIaIQobChMIzZKBye-BhQMVplwPAh3eOweBEAAYASAAEgLs2PD_BwE&cosemkid=go16897633308650003&gate_id=8395e334-8cb8-42ae-9f14-02f88c8c695d&redirect=1");
		
		//DOM객체 가져오기
		Document document = conn.get();
		//System.out.println(document);
		
		//Img 태그 받아오기
		Elements elements =  document.getElementsByTag("img");
//		System.out.println(elements.size());
//		System.out.println(elements);
		
		//src 값 추출하기
		String img_url =null;
		
		for(Element el : elements) {
			
			//System.out.println(el.getElementsByAttribute("src").attr("src")  );
			img_url =  el.getElementsByAttribute("data-original").attr("data-original");
			System.out.println(img_url);
			
			 
			//System.out.println(img_url.indexOf("//"));
			if(img_url.indexOf("//")==0) {
				img_url="https:"+img_url;
			}
			if(!img_url.equals("")) {
				URL url = new URL(img_url);
				InputStream in = url.openStream();
				BufferedInputStream bin = new BufferedInputStream(in);
				OutputStream out = new FileOutputStream("c:\\tmp_io\\"+UUID.randomUUID().toString()+".png");
				
				byte [] buff = new byte[4096];
				int data=0;
				while(true) {
					data =bin.read(buff);
					if(data==-1)
						break;
					out.write(buff,0,data);
					out.flush();
				}
				bin.close();
				in.close();
				out.close();
			}

			
		}
		
		
	}
	
}
