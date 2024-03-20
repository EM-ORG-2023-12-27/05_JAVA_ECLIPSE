package Ch19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C12SelenumAPI {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "c:\\iotest\\chromedriver.exe"; // 드라이버 경로

	public static void main(String[] args) {

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		ChromeOptions options = new ChromeOptions();
		// 브라우저 보이지 않기
		// options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naver.com");

//		driver.findElement(By.name("q")).sendKeys("손흥민");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	     // 이미지 요소를 찾기 위해 XPath를 사용
        List<WebElement> imageElements = driver.findElements(By.xpath("//img"));

        // 이미지 URL 추출 및 출력
        for (WebElement imageElement : imageElements) {
            String imageUrl = imageElement.getAttribute("src");
            System.out.println("Image URL: " + imageUrl);
        }
        
        // 이미지 URL 추출 및 저장
        for (WebElement imageElement : imageElements) {
            String imageUrl = imageElement.getAttribute("src");
            try {
                saveImage(imageUrl, "c:\\iotest\\image" + System.currentTimeMillis() + ".jpg");
            } catch (IOException e) {
                System.out.println("이미지 저장 중 오류 발생: " + e.getMessage());
            }
        }
        
      
		// 브라우저 닫기
		if (driver != null) {
			// driver.close();
			// driver.quit();
		}

	}
	
	private static void saveImage(String imageUrl, String destinationPath) throws IOException {
        URL url = new URL(imageUrl);
        InputStream in = url.openStream();
        OutputStream out = new FileOutputStream(destinationPath);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();
    }
	

}
