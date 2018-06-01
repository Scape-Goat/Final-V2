public class STATS{
    static boolean  menu = true, play = false, end = false;

    public static void endGame(){
        end = true;
    }

    public static void startGame(){
        menu = false;
        play = true;
    }

    public static  boolean isMenu(){ return menu;}
    public static boolean isPlay(){ return play;}
    public static boolean isEnd(){ return end;}

}