/*
 * 좀비 게임
 * 주인공이 좀비를 피해 오른쪽 끝으로 이동하게 된다면 승리
 * 
 * 기본 맵은 0으로 표시, 주인공 1, 좀비는 2 : 좀비의 수는 2개로 고정
 * 
 * 숫자 1 입력 시 주인공 왼쪽으로 한 칸 이동
 * 숫자 2 입력 시 주인공 오른쪽 한 칸 이동
 * 숫자 3 입력 시 주인공 오른쪽 두 칸 이동
 * 
 * 좀비 위치는 처음 10, 18 랜덤으로 이동 시킴 
 * 
 * 
 * 
 */
  
 import java.util.Random;
 import java.util.Scanner;
 
 
 public class ZombiGame { 
 
 
     int heroLocation(int[] map) {
         int check = 0;
 
         for(int i = 0; i < map.length; i++) {
             if(map[i] == 1) {
                 check = i;
             }
         }
 
         return check;
     }
 
     int zom1Location(int[] map) {
         int check = 0;
 
         for(int i = 0; i < map.length; i++) {
             if(map[i] == 2) {
                 check = i;
             }
         }
 
         return check;
     }
 
     int zom2Location(int[] map) {
         int check = 0;
 
         for(int i = 0; i < map.length; i++) {
             if(map[i] == 3) {
                 check = i;
             }
         }
 
         return check;
     }
 
 
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZombiGame zombiGame = new ZombiGame();
        Random rand = new Random();

    
        int[] map = new int[20];
        int hero = 1;
        int zom1 = 2, zom2 = 3;
        int heroL = 0;
        int zom1L = 9;
        int zom2L = 17;
        boolean gameLoop = true;


        
        map[heroL] = hero;
        map[zom1L] = zom1;
        map[zom2L] = zom2;

        for (int i : map) {
            System.out.print(i);
        } 
        System.out.println();

        while(gameLoop) {
            System.out.print(">> ");
            int move = scanner.nextInt();

            if(heroL == 1) {
                if(move == 2) {
                    continue;
                }
            }

            switch(move) {
                case 1: {
                    heroL = zombiGame.heroLocation(map);
                    map[heroL] = 0;
                    map[heroL+1] = hero;
                    break;
                } 
                case 2: {
                    heroL = zombiGame.heroLocation(map);
                    map[heroL] = 0;
                    map[heroL-1] = hero;
                    break; 
                }
                case 3: {
                    heroL = zombiGame.heroLocation(map);
                    map[heroL] = 0;
                    map[heroL+2] = hero;
                    break; 
                }
                default: {
                    System.out.println("다시 입력해주세요.");
                    break;
                } 
            }

            if(zombiGame.heroLocation(map) == zombiGame.zom1Location(map)) {
                for (int i : map) {
                    System.out.print(i);
                } 
            }


            for (int i : map) {
                System.out.print(i);
            } 
            System.out.println();
 
 
             
 
         }
 
 
 
         
 
 
     }
 }
 