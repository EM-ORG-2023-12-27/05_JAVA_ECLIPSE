package Ch23;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class IncrementThread2 implements Runnable {
	private static int counter = 0;

	// lock추가 - 임계영역에 접근 여부를 판단하는 기준(wait() , notifyall())
	private static final Object lock = new Object();

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {

			// 임계영역지정- 한스레드가 들어오면 다른스레드는 접근 제한
			synchronized (lock) {
				//작업내용
				counter++; // 공유변수값증가
				System.out.println(Thread.currentThread().getName() + "s counter : " + counter);

			
				lock.notifyAll(); // 값증가 이후 다른 스레드에게 권한 양보
				
				try {
					if (i < 99999) {
						lock.wait();	//i가 99999이하(반복을 벗어나지않으면)잠깐대기
										//다른스레드가 1증가하고 나올때까지 기다림
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	//임계영역끝

		}
	}
}

public class C05ThreadMain_Ex_임계영역설정 {

	public static void main(String[] args) throws InterruptedException {

		Object obj = new Object();
		
		
		IncrementThread2 incrementThread1 = new IncrementThread2();
		IncrementThread2 incrementThread2 = new IncrementThread2();

		Thread thread1 = new Thread(incrementThread1);
		Thread thread2 = new Thread(incrementThread2);

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("Final value: " + incrementThread1.getCounter());


	}
}
