package Ch39_PROJECTS_2023.GPT;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String key = "API KEY INSERT";
		GPT gpt = new GPT(key);
		try
		{
			
			while(true)
			{
				
				gpt.connect("https://api.openai.com/v1/chat/completions");
				
				Scanner scan = new Scanner(System.in);
				
				System.out.print("나: ");
				
			
				String msg = scan.nextLine();
				
				if(msg.equals("대화종료"))
					break;
				
				gpt.send(msg);
				String response = gpt.receive();
				
				//응답을 출력한다.
				System.out.println("AI:"+response);
			}	
	
		}catch(Exception ex)
		{
			
		}

		
		
	}

}
