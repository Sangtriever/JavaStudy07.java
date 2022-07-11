// 제로베이스 과제 07번
// 로또 당첨 프로그램
// 작성자 : 이상현

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class 과제7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int 입력숫자;

        System.out.println("[로또 당첨 프로그램]");
        System.out.println( );
        System.out.print("로또 개수를 입력해 주세요. (숫자 1 ~ 10) : ");
        입력숫자 = in.nextInt();
        if(입력숫자>10 || 입력숫자<=0){
            System.out.println("숫자를 다시 입력해 주세요.");
            return;
        }

        String[] name = new String[]{"A","B","C","D","E","F","G","H","I","j"};
        int[][] lotto = new int[입력숫자+1][6];

        for(int i = 0; i <=입력숫자; i++){
            for(int j = 0; j < 6; j++) {
                int ran = random.nextInt(45)+1;
                lotto[i][j] = ran;
                for(int l = 0; l < j; l++){
                    if(lotto[i][j] == lotto[i][l]){
                        j--;
                        break;
                    }
            }
            }
        }
        for (int i = 0; i< lotto.length; i++){
            int[] arrays = lotto[i];
            Arrays.sort(arrays);
            lotto[i] = arrays;

        }
        for (int i = 0; i<입력숫자; i++){
                System.out.println(String.format("%s  %02d, %02d, %02d, %02d, %02d, %02d ",name[i],lotto[i][0],lotto[i][1],lotto[i][2],lotto[i][3],lotto[i][4],lotto[i][5]));
        }

        System.out.println("\n[당첨 번호 발표]");
        int[] winning = new int[6];
        for(int i = 0; i<6 ; i++) {
            winning[i] = random.nextInt(45)+1;
            for(int j = 0 ; j<i ; j++){
                if (winning[i] == winning[j]){
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(winning);
        System.out.println(String.format("   %02d, %02d, %02d, %02d, %02d, %02d \n", winning[0],winning[1],winning[2],winning[3],winning[4],winning[5]));

        System.out.println("[내 로또 결과]");
        int count=0;
        for (int i = 0; i<입력숫자; i++){
            for (int j = 0; j<6; j++){
                for (int l = 0; l< 6; l++){
                    if(lotto[i][j] == winning[l]){
                        count++;
                    }
                }
            }

            System.out.println(String.format("%s  %02d, %02d, %02d, %02d, %02d, %02d => %d개 일치", name[i],lotto[i][0],lotto[i][1],lotto[i][2],lotto[i][3],lotto[i][4],lotto[i][5],count));
            count=0;
        }




    }



}

