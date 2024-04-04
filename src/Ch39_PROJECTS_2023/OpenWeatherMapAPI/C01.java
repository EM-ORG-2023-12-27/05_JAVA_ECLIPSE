package Ch39_PROJECTS_2023.OpenWeatherMapAPI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.openqa.selenium.support.Colors;

public class C01 {
	public static void main(String[] args) {
		
	     JFrame frame = new JFrame("Weather Icon Example");
	        frame.setSize(300, 300);
	        
	        JPanel panel = new JPanel();
	        
	        panel.setLayout(null);
	        
	        JLabel weatherIconLabel = new JLabel();
	        ImageIcon icon = new ImageIcon("C:\\임베디드웹과정임시공유폴더\\eclipse\\LocalWorkspace\\JAVA20230523\\src\\Ch99_Project\\OpenWeatherMapAPI\\weather-icon.png"); // 날씨 아이콘 이미지 파일 경로
	        
	        Image image = icon.getImage();
	        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 이미지 크기 조정
	        
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);
	        weatherIconLabel.setIcon(scaledIcon);
	        weatherIconLabel.setBounds(30,30,100,100);
	        panel.add(weatherIconLabel);
	        
	       
	        panel.setBackground(Color.WHITE);
	        frame.add(panel);
	        
	        
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	}
}
