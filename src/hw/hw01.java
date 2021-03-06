package hw;

/*
 * Topic: 某間學校舉辦英文檢定測驗，若是學生通過該測驗，則能通過畢業門檻。老師準備的 英文測驗中分為三個項目當作考試，分別是聽力、閱讀、口說。每一個項目測驗滿分 皆為 100 分，總分為 300 分。想要通過測驗有兩種方式。方式一:若是三個項目分 數皆為 60 分以上 ( 包含 60 分 ) 即為通過測驗。方式二:若三個項目中有其中一 個項目分數未滿 60 分，但三個項目分數總合超過 220 分，也可算通過測驗。若三 個項目中有其中一個項目分數未滿 60 分，而三個項目分數總合也沒能超過 220 分，可獲得補考機會。若是三個項目中有兩個項目不及格，但另一個項目成績高於 80 分 ( 包含 80 分 ) ，也可獲得補考的機會。其餘皆判定為無法通過測驗。
 說明: 第一行為一個整數 N ，代表共有 N 組測試資料。之後有 N 行，每一行有 3 個非 負整數 ( 範圍皆為 0 到 100), 分別代表該名學生聽力、閱讀、口說的測驗分數。
 若是通過測驗，則輸出 ”P” 。若是需要補考，則輸出 ”M” 。若是無法通過測驗， 則輸出 ”F” 

 * Date: 2016/12/05
 * Author: 105021056 王家恩
 */
import java.util.Scanner;
import java.util.ArrayList;

public class hw01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		ArrayList<String> count = new ArrayList<String>();
		int n = scn.nextInt();
		int sum = 0;
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < n; i++) {
			while (sum == 0) {
				a = scn.nextInt();// 聽力
				if (a <= 100 && a >= 0) {
					a = a;
					sum++;
				} else {
					System.out.println("請重新輸入成績");
				}
			}
			sum=0;
			while (sum == 0) {
				b = scn.nextInt();// 閱讀
				if (b <= 100 && b >= 0) {
					b = b;
					sum++;
				} else {
					System.out.println("請重新輸入成績");
				}
			}
			sum=0;
			while (sum == 0) {
				c = scn.nextInt();// 口試
				if (c <= 100 && c >= 0) {
					c = c;
					sum++;
				} else {
					System.out.println("請重新輸入成績");
				}
			}
			sum=0;
		
			// 上方判斷是否0~100
			int x = a + b + c;
			if (x >= 220) {
				count.add("P");
			} else if (((a >= 60 && b >= 60 && c < 60) && x >= 220)
					|| ((a >= 60 && b < 60 && c >= 60) && x >= 220)
					|| ((a < 60 && b >= 60 && c >= 60) && x >= 220)) {
				count.add("P");
			} else if (a >= 60 && b >= 60 && c >= 60) {
				count.add("P");
			} else if ((((a >= 60 && b >= 60 && c < 60) && x < 220)
					|| ((a >= 60 && b < 60 && c >= 60) && x < 220) || ((a < 60
					&& b >= 60 && c >= 60) && x < 220))) {
				count.add("M");
			} else if (a >= 80 && b < 60 && c < 60) {
				count.add("M");
			} else if (a < 60 && b >= 80 && c < 60) {
				count.add("M");
			} else if (a < 60 && b < 60 && c >= 80) {
				count.add("M");
			} else {
				count.add("F");
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(count.get(i));
		}
		System.out.println();
	}
}
