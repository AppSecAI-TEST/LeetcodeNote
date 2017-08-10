package com.algorithm.recursion;

/**
 * @Author: feipeixuan
 * @Version: �Թ���Ϸ
 * @Link: http://blog.csdn.net/u010809185/article/details/51511512
 * @From: Գ����
 */
public class StrappedGame {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        StrappedGame strappedGame = new StrappedGame();
        strappedGame.lookAround(array, new Location(0, 0));
    }

    public void lookAround(int[][] array, Location location) {
        int locationY = location.y;
        int locationX = location.x;
        int width=array[0].length;
        int height=array.length;

        if(locationX>=width || locationY>=height)
            return;

        /* right���� */
        for (;locationX<width && !isVisited(array,locationX,locationY);locationX++)
        {
            System.out.println(array[locationY][locationX]);
            array[locationY][locationX]=0;
        }
        locationX--;
        locationY++;

        /* down���� */
        for (;locationY<height && !isVisited(array,locationX,locationY);locationY++)
        {
            System.out.println(array[locationY][locationX]);
            array[locationY][locationX]=0;
        }
        locationY--;
        locationX--;

        /* left���� */
        for (;locationX>=0 && !isVisited(array,locationX,locationY);locationX--)
        {
            System.out.println(array[locationY][locationX]);
            array[locationY][locationX]=0;
        }
        locationX++;
        locationY--;

        /* up���� */
        for (;locationY>=0 && !isVisited(array,locationX,locationY);locationY--)
        {
            System.out.println(array[locationY][locationX]);
            array[locationY][locationX]=0;
        }

        lookAround(array,new Location(location.x+1,location.y+1));
    }

    public boolean isVisited(int [][] array,int x,int y){
        return array[y][x]<=0;
    }
}

/* ���� */
class Location {
    public int y, x;

    public Location(int locationX, int locationY) {
        this.x = locationX;
        this.y = locationY;
    }
}
