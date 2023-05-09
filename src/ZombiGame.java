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
 
 
    int[] unitLocation(int[] map) {
        int[] check = new int[3];

        for(int i = 0; i < map.length; i++) {
            if(map[i] == 1) {
                check[0] = i;
            } else if(map[i] == 2) {
                check[1] = i;
            } else if(map[i] == 3) {
                check[2] = i;
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

        int afterHeroMove = 0;
        int afterZom1Move = 0;
        int afterZom2Move = 0;

        
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

            if(!((move == 1) || (move == 2) || (move == 3))) {
                System.out.println("다시 입력해 주세요.");
                continue;
            }

            int randMove1 = rand.nextInt(3);
            int randMove2 = rand.nextInt(3);
            
            int[] nowLocation = zombiGame.unitLocation(map);
            
            heroL = nowLocation[0]; 
            zom1L = nowLocation[1]; 
            zom2L = nowLocation[2];

            switch(move) {
                case 1: {
                    map[heroL] = 0;
                    map[heroL+1] = hero;
                    afterHeroMove = heroL+1;
                    break;
                } 
                case 2: {
                    map[heroL] = 0;
                    map[heroL-1] = hero;
                    afterHeroMove = heroL-1;
                    break; 
                }
                case 3: {
                    map[heroL] = 0;
                    map[heroL+2] = hero;
                    afterHeroMove = heroL+2;
                    break; 
                } 
            }
 
            switch(randMove1) {
                case 1: {
                    map[zom1L] = 0;
                    map[zom1L+1] = zom1;
                    afterZom1Move = zom1L+1;
                    break;
                } 
                case 2: {
                    map[zom1L] = 0;
                    map[zom1L-1] = zom1;
                    afterZom1Move = zom1L-1;
                    break; 
                }
                case 3: {
                    map[zom1L] = zom1; 
                    afterZom1Move = zom1L;
                    break; 
                } 
            }

            switch(randMove2) {
                case 1: {
                    map[zom2L] = 0;
                    if(zom2L+1 > 19) {
                        map[zom2L] = zom2; 
                        afterZom2Move = zom2L;
                    } else {
                        map[zom2L+1] = zom2;
                        afterZom2Move = zom2L+1;
                    } 
                    break;
                } 
                case 2: {
                    map[zom2L] = 0;
                    map[zom2L-1] = zom2;
                    afterZom2Move = zom2L-1;
                    break; 
                }
                case 3: {
                    map[zom2L] = zom2; 
                    afterZom2Move = zom2L;
                    break; 
                } 
            }
 

            if((afterHeroMove == afterZom1Move) || (afterHeroMove == afterZom2Move)) {
                System.out.println("죽었습니다.");
            }


            for (int i : map) {
                System.out.print(i);
            } 
            System.out.println();
 
         }
  
     }
 }
 