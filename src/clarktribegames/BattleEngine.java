package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class BattleEngine {
    
    static String[] team0;
    static String[] team1;
//    static String saveName;
//    static String saveToons;
//    static String saveMax;
    static int[][] tTrack = new int[2][3];
    volatile static boolean battleDone = false;
    
    public static void battleEngine(List<String> toons)
        throws SQLException, IOException, InterruptedException{
        battleDone = false;
//        saveName = save;
//        saveToons = savetoons;
//        saveMax = savemax;
        battleTime(toons);
    }
    
    private static void battleTime(List<String> toons) throws SQLException, 
        IOException, InterruptedException {
        int opponent = 0;
        int totalToons = MemoryBank.savToons.size();
//                GetData.dataQuery("*", savetoons, "toonID", "*", 
//            true,false,null,null).size();
        opponent = randomOpponent(Integer.parseInt(MainControls.selectedToon), 
            totalToons);
        if(String.valueOf(opponent).equals(MainControls.selectedToon)) {
            battleTime(toons);
        }
        team0 = new String[] {MainControls.selectedToon};
        team1 = new String[] {String.valueOf(opponent)};
        
//        GetData.buildBattle(MainControls.currentgame);
//                save, Converters.capFirstLetter(saveToons.substring(
//            3,saveToons.length()).replace("Toons", "")));
        VersusGUI.main(null);
    }
        
    private static int randomOpponent(int toonid, int max) {
        Random rand = new Random();
        List<Integer> exclude = new ArrayList<>();
        exclude.add(toonid);
        int random = rand.nextInt(max) ;
        
        for(int i = 0; i < exclude.size(); i++) { 
            if(!exclude.contains(random)) {
                return random;
            }
            random ++;
        }
        return random;
    }
    
    public static void battleStart(List<String> toons) 
        throws SQLException, InterruptedException {
        battleOpener(Converters.fetchfromTable(toons,team0[0],0,1),
            Converters.fetchfromTable(toons,team1[0],0,1));
//                GetData.dataQuery("*",btoons,"toonID",
//            team0[0],false,false,null,null).get(1),
//                GetData.dataQuery("*",btoons,
//            "toonID",team1[0],false,false,null,null).get(1)
//        );
    }
    
    private static void battleOpener(String team0lead, String team1lead) throws
        SQLException, InterruptedException {
        if(team0.length > 1) {
            team0lead = "Team " + team0lead;
        }
        if(team1.length > 1) {
            team1lead = "Team " + team1lead;
        }
        Random rand = new Random();
        int t0start=(int)((double)((Integer.parseInt((String) BattleGUI.getTable
            (0).getValueAt(7,1))+(((rand.nextInt(100))*.01)*(Integer.parseInt((
            String)BattleGUI.getTable(0).getValueAt(15,1)))))));
        int t1start=(int)((double)((Integer.parseInt((String) BattleGUI.getTable
            (1).getValueAt(7,1))+(((rand.nextInt(100))*.01)*(Integer.parseInt((
            String)BattleGUI.getTable(1).getValueAt(15,1)))))));
        String whosfirst;
        tTrack[0][0] = Integer.parseInt(team0[0]);
        tTrack[1][0] = Integer.parseInt(team1[0]);
        int a;
        int b;
        if(t0start > t1start) { 
            tTrack[0][1] = 0;
            tTrack[1][1] = 100;
            a = 0;
            b = 1;
            whosfirst = team0lead;
        } else {
            b = 0;
            a = 1;
            tTrack[0][1] = 100;
            tTrack[1][1] = 0;
            whosfirst = team1lead;
        }
        double t0sp=Integer.parseInt((String)BattleGUI.getTable(0).getValueAt(8,
            1));
        double t1sp=Integer.parseInt((String)BattleGUI.getTable(1).getValueAt(8,
            1));
        //t0rate
        tTrack[0][2] = (int)(double)(((t0sp/(t0sp+t1sp))*50)+rand.nextInt(50));
        //t1rate
        tTrack[1][2] = (int)(double)(((t1sp/(t0sp+t1sp))*50)+rand.nextInt(50));
        String opening = "Begin Battle: " + team0lead + " vs. " + team1lead + "\n";
        opening += team0lead + " start: " + (int) t0start + " / " + team1lead + " start: " + (int) t1start + "\n";
        opening += team0lead + " rate: " + tTrack[0][2] + " / " + team1lead + " rate: " + tTrack[1][2] + "\n";
        opening += whosfirst + " is first." + "\n";
        updateHidden();
        BattleGUI.writeBattle(opening);
        Thread.sleep(1500);
    }
    
    private static void updateHidden() {
        BattleGUI.getHidden(0).setText("Counter: " + tTrack[0][1] + " / Rate: " + tTrack[0][2]);
        BattleGUI.getHidden(1).setText("Counter: " + tTrack[1][1] + " / Rate: " + tTrack[1][2]);
    }
    
    private static void battleTurn(List<String> toons,int a,int b) throws 
        SQLException, InterruptedException {
        String player=Converters.fetchfromTable(toons,String.valueOf(tTrack[a]
            [0]),0,1);
//                GetData.dataQuery("*",btoons,"toonID",String.valueOf(
//            tTrack[a][0]),false,false,null,null).get(1);
        String target=Converters.fetchfromTable(toons,String.valueOf(tTrack[b]
            [0]),0,1);
//                GetData.dataQuery("*",btoons,"toonID",String.valueOf(
//            tTrack[b][0]),false,false,null,null).get(1);
        System.out.println("Player: " + player + ":" + a + " is attacking.");
        tTrack[a][1] = 0;
        tTrack[b][1] += tTrack[b][2];
        if(tTrack[b][1] > 100) {
            tTrack[b][1] = 100;
        }
        String turnhappenings = "This would be " + player + "'s turn with " + target + " being the target.\n";
        //simulating battle
        Random rand = new Random();
        if(a == 1) {
            int damage = (int) (Integer.parseInt((String) BattleGUI.getTable(1).getValueAt(4,1)) * (rand.nextInt(100) * 0.01));
            turnhappenings += player + " attacks " + target + " for " + damage + " damage.\n";
            int hp = Integer.parseInt((String) BattleGUI.getTable(0).getValueAt(1,1)) - damage;
            if(hp<0) {
                hp = 0;
            }
            BattleGUI.getTable(0).setValueAt(String.valueOf(hp), 1, 1);
        } else {
            int damage = (int) (Integer.parseInt((String) BattleGUI.getTable(0).getValueAt(4,1)) * (rand.nextInt(100) * 0.01));
            turnhappenings += player + " attacks " + target + " for " + damage + " damage.\n";
            int hp = Integer.parseInt((String) BattleGUI.getTable(1).getValueAt(1,1)) - damage;
            if(hp<0) {
                hp = 0;
            }
            BattleGUI.getTable(1).setValueAt(String.valueOf(hp), 1, 1);
        }
        updateHidden();        
        BattleGUI.writeBattle(turnhappenings);
    }
    
    private static int whosturnisIt() {
        if(tTrack[0][1] > tTrack[1][1]) { 
            return 0;
        } else {
            return 1;
        }
    }
    
    public static void nextTurn(List<String> toons) throws SQLException, 
        InterruptedException, Exception {
        betweenTurns(toons);
//        betweenTurns(BattleEngine.saveName, BattleEngine.saveToons.replaceAll("sav"
//            ,"battle"),BattleEngine.saveMax.replaceAll("sav", "battle"));
    }
    
    private static void betweenTurns(List<String> toons) throws SQLException, InterruptedException, Exception {
        int hp0 = Integer.parseInt((String) BattleGUI.getTable(0).getValueAt(1,1));
        int hp1 = Integer.parseInt((String) BattleGUI.getTable(1).getValueAt(1,1));
        if(hp0 > 0 && hp1 > 0) {
            int turn = whosturnisIt();
            int a;
            int b;
            if(turn==1) {
                a = 1;
                b = 0;
            } else {
                a = 0;
                b = 1;
            }
            System.out.println(a + ":" + b);
            battleTurn(toons,a,b);
        } else {
            if(hp1 <= 0) {
                BattleGUI.writeBattle(Converters.fetchfromTable(toons,String.
                    valueOf(tTrack[0][0]),0,1)
//                        GetData.dataQuery("*",btoons,"toonID",String.valueOf(
//            tTrack[0][0]),false,false,null,null).get(1) 
                + " is the winner!");
                MPlayer.stopMedia();
                MainControls.turnonMusic(MainControls.checkforcustMusic("win"), "win");
                battleDone = true;
            } else {
                BattleGUI.writeBattle(Converters.fetchfromTable(toons,String.valueOf(tTrack[1][0]),0,1)
//                BattleGUI.writeBattle(GetData.dataQuery("*",btoons,"toonID",String.valueOf(
//            tTrack[1][0]),false,false,null,null).get(1)
                + " is the winner!");
                MPlayer.stopMedia();
                MainControls.turnonMusic(MainControls.checkforcustMusic("lose"), "lose");
                battleDone = true;
            }
        }
    }
    
}
