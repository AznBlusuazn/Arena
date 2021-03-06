package clarktribegames;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingWorker;


// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class MainControls {

    //Main Controls Variables
    static String appName="Limitless";
    static String appVer="0.0.045";
    static String limitV="0.0.045";
    static String appTitle=appName+" [ALPHA "+appVer+"]";
    static String defaultIntro="sounds/intro.mp3";
    static String defaultBattle="sounds/battle.mp3";
    static String defaultWin="sounds/victory.mp3";
    static String defaultLose="sounds/loss.mp3";
    static String musicPath=defaultIntro;
    static String custommusicPath="custom/music";
    static String custIntro="null";
    static String custBattle="null";
    static String custWin="null";
    static String custLose="null";
    static String custommusicSounds="custom/sounds";
    static String custdbDir="custom/db";
    static String defaultogDb="data.mdb";
    static String dbExt=".limit";
    static String saveExt=".save";
    static String dbDir="db/";
    static String defaultDb=dbDir+"default"+dbExt;
    static String savesDir="saves/";
    static String imageDir="avatars/";
    public URL iconURL=getClass().getResource("/clarktribegames/icon.png");
    public ImageIcon imageIcon=new ImageIcon(iconURL);
    static String selectedToon="";
    static String price="";
    static String dagger="";
    //Color Mode
    static Color backColor=Color.BLACK;
    static Color textColor=Color.WHITE;
    //Date and Time
    static int gameWeek=1;
    static int gameDay=1;
    static int gameMonth=1;
    static int gameYear=1;
    static int gameHour=0;
    static int gameMin=0;
    //Settings.ini
    static boolean darkOn=true;
    static boolean musicOn=true;
    static boolean custommusicOn=false;
    static boolean soundOn=true;
    static boolean samedbOn=true;
    static String defaultdbSetting=defaultDb;

    public static void main(String[] args) throws Exception {
        lookandfeelSettings();
        startupChecks();
        Limitless.main(args);
    }
    
    private static void startupChecks() throws IOException, Exception {
        try {
            defaultInitialization();
            checkVersion(appName,appVer);
            firstCheck();
            checkSaves();
            checkSettings();
        } catch(IOException ex) {
            LogWriter.logFile("severe",("Startup Check IOException: "+ex
                .toString()));
        }
    }

    private static void defaultInitialization() {
        MemoryBank.currentDb=MainControls.defaultDb;
        appTitle=appName+" [ALPHA v"+appVer+"]";
        defaultDb=dbDir+"default"+dbExt;
        defaultdbSetting=defaultDb;
        musicPath=defaultIntro;
    }

    
    private static void firstCheck() throws IOException, InterruptedException, 
        Exception {
        try {
            ChecksBalances.newdirCheck(imageDir,false);
            ChecksBalances.newdirCheck(custommusicPath,false);
            ChecksBalances.newdirCheck(custommusicSounds,false);
            ChecksBalances.newdirCheck(custdbDir,false);
            ChecksBalances.fileCheck("_empty_.png",(imageDir+"_empty_.png"),true
                ,false);
            boolean libResult=(CmpImporter.cmpImport("lib"));
          boolean soundsResult=(CmpImporter.cmpImport("sounds"));
            if(!libResult||!soundsResult) {
                String[] opts=new String[] {"Patreon","PayPal","Maybe Later"};
                String title="Alert!";
                String message="Welcome to Limitless!\n\n"+
                    "This title is still in development.  Please be patient.\n"+
                    "\nYou can become a Patreon or Donate if you want to\n"+
                    "help support the cause.\n\n"+
                    "Thanks! ~ Geoff @ ClarkTribeGames";
                int choice=Popups.optPopup(opts, title, message);
                switch(choice) {
                    case 0:
                        GoToWeb.openWeb("https://www.patreon.com/clarktribegame"
                           +"s");
                        break;
                    case 1:
                        GoToWeb.openWeb("https://www.paypal.me/aznblusuazn");
                        break;
                    default:
                        break;
                }
            }
            dagger=Converters.resourcefileToList("all.cmp").get(0);
            price=Converters.resourcefileToList("magic.cmp").get(0);
        } catch(IOException ex) {
            LogWriter.logFile("severe","Donate Popup Error.  Exception: "+ex);
        }
    }

    private static void checkSaves() throws IOException, Exception {
        try {
            ChecksBalances.newdirCheck("./"+dbDir,true);
            ChecksBalances.newdirCheck("./"+savesDir,false);
            String ogPath=defaultogDb;
            String dbPath=defaultDb;
            ChecksBalances.fileCheck(ogPath,dbPath,true,true);
        } catch(Exception ex) {
            LogWriter.logFile("severe",("Saves Check Exception: "+ex.toString())
                );
        }
    }

    private static void checkSettings() throws IOException, SQLException {
        MemoryBank.mainSettings=fetchSettings();
        if(ChecksBalances.isNullOrEmpty(findSetting("uid"))||!(findSetting("uid"
            )).equals(
            MemoryBank.UID)) {
            try {
                updateSettings();
            } catch (Exception ex) {
                //
            }
        }
        if(ChecksBalances.isNullOrEmpty(findSetting("version"))) {
            try {
                updateSettings();
            } catch (Exception ex) {
                //
            }
        }
        if(findSetting("dark").equals("0")) {
            darkOn=false;
            backColor=Color.WHITE;
            textColor=Color.BLACK;
        }
        if(findSetting("music").equals("0")) {
            musicOn=false;
        }
        custIntro=findSetting("custi");
        custBattle=findSetting("custb");
        custWin=findSetting("custw");
        custLose=findSetting("custl");
        if(findSetting("custm").equals("1")) {
            custommusicOn=true;
            musicPath=custommusicPath+"/"+custIntro.replaceAll("[Intro] ","")+
                ".mp3";
            if(custIntro.equals("") || custIntro.isEmpty()) {
                musicPath=defaultIntro;
            }
        }
        if(findSetting("sound").equals("0")) {
            soundOn=false;
        }
        if(findSetting("samedb").equals("0")) {
            samedbOn=false;
            defaultdbSetting=defaultDb;
        } 
        if(!(ChecksBalances.isNullOrEmpty(findSetting("lastdb"))||findSetting(
            "lastdb").equals(defaultDb))) {
            MemoryBank.currentDb=findSetting("lastdb");
            if(!(new File(MemoryBank.currentDb).exists())) {
                MemoryBank.currentDb=defaultDb;
            }
        } else {
            MemoryBank.currentDb=defaultDb;
        }
    }
    
    private static String findSetting(String settings) throws SQLException {
        int size=0;
        try {
            size=MemoryBank.mainSettings.size();
        } catch (NullPointerException ex) {
            size=GetData.dataQuery("*","mainSettings","settingID",null,
                true,false,null,null).size();
        }
        String retval="";
        for(int i=0;i<size;i++){
            String search=i+":"+settings+":";
            try {
                if(MemoryBank.mainSettings.get(i).startsWith(search)) {
                    retval=MemoryBank.mainSettings.get(i).replaceAll(search,"");
                }
            } catch (NullPointerException ex) {
                if(GetData.dataQuery("*","mainSettings","settingID",String.
                    valueOf(i),false,false,null,null).get(1).startsWith(settings
                    )) {
                    try {
                        retval=GetData.dataQuery("*","mainSettings","settingID",
                            String.valueOf(i),false,false,null,null).get(2);
                    } catch (NullPointerException ex2) {
                        retval="null";
                    }
                }
            }
        }
        return retval;
    }
    
    public static void updateSettings() throws IOException,InterruptedException,
        Exception{
        for(int i=0;i<determineSettings().size();i++) {
            String[] setting=determineSettings().get(i).split(":");
            try {
            GetData.dataUpdateSingle("mainSettings","settingConfig",setting[2]
                ,"settingID",setting[0]);
            } catch (ArrayIndexOutOfBoundsException ex2) {
                GetData.dataUpdateSingle("mainSettings","settingConfig","null"
                    ,"settingID",setting[0]);
            }
        }
        try {
            if(!musicOn) {
                MPlayer.stopMedia();
            }
        } catch (IOException ex) {
            LogWriter.logFile("severe","Update Settings.  EX: " +ex.toString());
        }
    }
    
    private static List<String> fetchSettings() throws SQLException {
        List<String> retList=new ArrayList<>();
        int settingscount=GetData.dataQuery("*","mainSettings","settingID",null,
            true,false,null,null).size();
        for(int i=0;i<settingscount;i++) {
            retList.add(Arrays.toString(GetData.dataQuery("*","mainSettings",
                "settingID",String.valueOf(i),false,false,null,null).toArray()).
                replaceAll("\\[","").replaceAll("\\]","").replaceAll(", ",":"));
        }
        return retList;
    }
    
    private static List<String> determineSettings() {
        List<String> newSets=new ArrayList<>();
        newSets.add("0:uid:"+MemoryBank.UID);
        newSets.add("1:version:"+appVer);
        newSets.add("2:dark:"+ChecksBalances.trueorfalseNum(darkOn));
        newSets.add("3:music:"+ChecksBalances.trueorfalseNum(musicOn));
        newSets.add("4:custm:"+ChecksBalances.trueorfalseNum(custommusicOn));
        newSets.add("5:custi:"+custIntro);
        newSets.add("6:custb:"+custBattle);
        newSets.add("7:custw:"+custWin);
        newSets.add("8:custl:"+custLose);
        newSets.add("9:sound:"+ChecksBalances.trueorfalseNum(soundOn));
        newSets.add("10:samedb:"+ChecksBalances.trueorfalseNum(samedbOn));
        newSets.add("11:defaultdb:"+defaultdbSetting);
        newSets.add("12:lastdb:"+MemoryBank.currentDb);
        return newSets;
    }

    public static void turnonMusic(String trackPath, String trackType) {
        musicPath=trackPath;
        if(!(new File(musicPath).exists())) {
            musicPath=defaultMusic(trackType);
        }
        SwingWorker<Void,Void> worker=new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                MPlayer.mediaPlayer(musicOn);
                return null;
            }
        };
        if(!MemoryBank.musicPlaying) {
        MemoryBank.musicPlaying=true;
        worker.execute();
        }
    }
    
    public static String checkforcustMusic(String type) {
        switch(type) {
            case "battle" :
                if(!custommusicOn) {
                    return defaultBattle;
                } else {
                    if(ChecksBalances.isNullOrEmpty(custBattle)) { 
                        return defaultBattle;
                    } else {
                        return custommusicPath+"/"+custBattle+".mp3";
                    }
            }
            case "intro" :
                if(!custommusicOn) {
                    return defaultIntro;
                } else {
                    return custommusicPath+"/"+custIntro+".mp3";
                }
            case "win" :
                if(!custommusicOn) {
                    return defaultWin;
                } else {
                    if(ChecksBalances.isNullOrEmpty(custWin)) {
                        return defaultWin;
                    } else {
                        return custommusicPath+"/"+custWin+".mp3";
                    }
                }
                
            case "lose" :
                if(!custommusicOn) {
                    return defaultLose;
                } else {
                    if(ChecksBalances.isNullOrEmpty(custLose)) {
                        return defaultLose;
                    } else {
                        return custommusicPath+"/"+custLose+".mp3";
                    }
                }                
            default :
                return defaultIntro;
        }
    }
    
    private static String defaultMusic(String type) {
        switch(type) {
            case "battle" :
                return defaultBattle;
            case "intro" :
                return defaultIntro;
            default :
                return defaultIntro;
        }
    }
    
    private static void lookandfeelSettings () {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.
                    UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
    
    //When New Game Button Is Pressed From Limitless Menu Panel
    public static void startNewGame() {
        try {
            MemoryBank.newgame=true;
            MemoryBank.clearMemory();
//            MemoryBank.shortMemory("temp");
            //create reset variables method
            Limitless.welcomeText.setText("");
            MemoryBank.ingame=false;
            MemoryBank.created=false;
            //this is temp for now
            if(!samedbOn) {
                limitSelect();
            } else {
                MemoryBank.currentDb=findSetting("lastdb");
            }
            boolean continueon=false;
            Limitless.loadingLabel.setText("Game World Is Building...");            
            MemoryBank.currentGame=Limitless.ngText.getText().toLowerCase();
            MemoryBank.currentSave=savesDir+MemoryBank.currentGame+saveExt;
            continueon=ChecksBalances.newGame(MemoryBank.currentGame);
            if(continueon) {
                MemoryBank.ingame=true;
                loadingScreen();
            }
            if(continueon) {
                //method to change screen here
                Popups.infoPopup("Building Save Game","Your new game world will"
                   +" now be built.  Please be patient.");
                backgroundBuild();
                while(!MemoryBank.created) {
                    Thread.sleep(1);
                }
                Areas.findActiveAreas();
                Calculator.buildDateTime();
                Limitless.setLoadingAvatars();
                Limitless.loadingLabel.setText("Game World Has Been Built!");
                Popups.infoPopup("Save Game Built",
                    "Your new game world has been built.  Thank you for your "
                   +"patience.");
                Thread.sleep(1500);
                Limitless.showNewGameList();
                newgamelistMenu();
            } else {
                MemoryBank.currentSave="";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void limitSelect() throws IOException {
        String title="New Game Database Selection";
        String message="Select a Database for the New Game:\n\n";
        DefaultComboBoxModel limitdml=new DefaultComboBoxModel();
        JComboBox dboptions=new JComboBox();
        popLimit(dboptions,limitdml);
        if(dboptions.getItemCount()>1) {
            String selection=Popups.comboboxPopup(title,message,dboptions,null);
            if(ChecksBalances.isNullOrEmpty(selection)) {
                //
            } else {
                MemoryBank.currentDb=custdbDir+selection.toLowerCase()+dbExt;
                String confirmMessage=selection+" Loaded";
                Popups.infoPopup(confirmMessage,confirmMessage+"!");
            }
        } else {
            MemoryBank.currentDb=defaultDb;
        }
    }
    
    private static void popLimit(JComboBox box,DefaultComboBoxModel dml) throws 
        IOException {
        try {
            List<String> dblist=(Converters.foldertoList(custdbDir,dbExt)).
                stream().map(Object::toString).collect(Collectors.toList());
            fillLimit(box,dblist,dml);
        } catch (IOException ex) {
            LogWriter.logFile("severe","SAV Select Error.\nEx: "+ex.toString());
        }
    }
    
    private static void fillLimit(JComboBox<String> save,List<String> list,
        DefaultComboBoxModel dml) {
        Font font=save.getFont();
        DefaultListCellRenderer lrCenter;
        lrCenter=new DefaultListCellRenderer();
        lrCenter.setHorizontalAlignment(DefaultListCellRenderer.LEFT);
        lrCenter.setFont(font.deriveFont(Font.BOLD));
        for(int i=0;i<list.size();i++) {
            String x=(list.get(i));
            String y=Converters.capFirstLetter(x.substring(x.indexOf("\\")+1).
                replaceAll(dbExt,""));
            dml.addElement(y);
        }
        save.setModel(dml);
        save.setRenderer(lrCenter);
    }
    
    private static void loadingScreen() {
        SwingWorker<Void,Void> worker=new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Limitless.menuPanel.setVisible(false);
                Limitless.loadingPanel.setVisible(true);
                Limitless.setLoadingAvatars();
                return null;
            }
        };
        worker.execute();
    }
    
    private static void backgroundBuild() {
        SwingWorker<Void,Void> worker=new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                MemoryBank.fillMemory(MemoryBank.newgame);
                if(MemoryBank.dbToons.isEmpty()) {
                    Thread.sleep(1);
                }
                if(MemoryBank.newgame) {
                    GetData.createnewSave();
                }
                if(!MemoryBank.created) {
                    MemoryBank.created=true;
                }
                return null;
            }
        };
        worker.execute();
    }

    public static void newgamelistMenu() throws IOException, SQLException {
        popNewGameToonList();
        worldtextInfo();
    }
    
    private static void popNewGameToonList() throws IOException, SQLException {
        List<String> newgameToonList=GetData.getNewGameToonList();
        DefaultListModel newtlDml=new DefaultListModel();
        if(newgameToonList.size() <= 0) {
            Limitless.newgameList.setEnabled(false);
            newtlDml.removeAllElements();
            newtlDml.addElement("<No Toons Available>");
        } else {
            MemoryBank.newgametoonList=new String[newgameToonList.size()][2];
            for(int i=0;i < newgameToonList.size();i++) {
                MemoryBank.newgametoonList[i][0]=newgameToonList.get(i);
                MemoryBank.newgametoonList[i][1]=String.valueOf(i);
            }
            Arrays.sort(MemoryBank.newgametoonList, new Comparator<String[]>() {
                @Override
                public int compare(final String[] entry1,final String[] entry2){
                    final String toon1=entry1[0];
                    final String toon2=entry2[0];
                    return toon1.compareTo(toon2);
                }
            });
            for (final String[] s : MemoryBank.newgametoonList) {
                newtlDml.addElement(s[0]);
            }
            Limitless.altName.setVisible(false);
            Limitless.newgameList.setModel(newtlDml);
            Limitless.newgameList.setEnabled(true);
            try {
                MemoryBank.passiveDestinyID=Converters.fetchfromTable(MemoryBank
                    .dbDestiny,"Passive",1,0);
            } catch (Exception ex) {
                MemoryBank.passiveDestinyID="1";
            }
        }
    }    
    
    private static void worldtextInfo() throws SQLException {
        //add game date method here
        Calculator.buildDateTime();
        //above it temp date
        int count=MemoryBank.savToons.size();
        List<Integer> exps=new ArrayList<>();
        for(int expcount=0;expcount<count;expcount++) {
            exps.add(Integer.parseInt(Converters.fetchfromTable(MemoryBank.
                savToons,String.valueOf(expcount),0,21)));
        }
        int toplv=Integer.MIN_VALUE;
        int topidx=-1;

        for (int l=0; l < exps.size(); l++) {
            int val=exps.get(l);
            if (val > toplv) {
                toplv=val;
                topidx=l;
            }
        }

        String toptoon[]=MemoryBank.savToons.get(topidx).replaceAll(", ",",").
            split(",");
        String topplayer=toptoon[1];

        String alignment=Converters.fetchfromTable(MemoryBank.dbAlign,Calculator.
            getAlign(Integer.parseInt(toptoon[4])),0,6);
        String age=Calculator.getAge(Integer.parseInt(toptoon[7]),toptoon[2]);
        String gender=Converters.fetchfromTable(MemoryBank.dbGender,toptoon[6],0
            ,1);
        String race=Converters.fetchfromTable(MemoryBank.dbRace,toptoon[2],0,7);
        String clas=Converters.fetchfromTable(MemoryBank.dbClass,toptoon[3],0,4);
        String size=Calculator.getSize(Converters.fetchfromTable(MemoryBank.
            dbRace,toptoon[2],0,1),age);
        int activeareas=Areas.activeAreas.size();
        String areatext;
        switch(activeareas) {
            case 0:
                areatext="are currently no active areas";
                break;
            case 1:
                areatext="is currently 1 active area";
                break;
            default:
                areatext="are currently "+activeareas+" active areas";
        }
        String text="This world starts at Year "+gameYear+", Month "+
            gameMonth+", Week "+gameWeek+", Day "+gameDay+" at Hour " 
           +gameHour+" Minute "+gameMin +".\n\nCurrently, there are " 
           +count+" characters in the world.\n\nThe highest level character"
           +" is "+topplayer+", who is a "+alignment+" "+age+" " 
           +gender+" that is "+size+" "+race+" "+clas+" at Level "
           +Calculator.getLevel("curlv", String.valueOf(toplv))+".\n\n"
           +"There "+areatext+" available.\n"
           +"\nYour possiblities are Limitless!\n\nSelect your character and "
           +"then click Start New Game to begin your journey.";
        new TypeEffect(Limitless.welcomeText,text,10,false,null,null).start();
        Limitless.newgameList.setSelectedIndex((int) (Math.random() * count));
    }
    
    public static void ngToonSelect(String selectedToonID) throws SQLException, 
        IOException {
        String[] selectedToon=MemoryBank.savToons.get(Integer.parseInt(
            selectedToonID)).replaceAll(", ",",").split(",");
        Limitless.charName.setText(selectedToon[1]);
        Avatars.setAvatar(Limitless.charToon, selectedToon[1],selectedToon[10]);
        
        Limitless.charStat01.setText(Converters.fetchfromTable(MemoryBank.
            dbAlign,Calculator.getAlign(Integer.parseInt(selectedToon[4])),0,1))
            ;
        Limitless.charStat01.setFont(new Font(Limitless.charStat01.getFont().
            getName(),Font.BOLD,Limitless.charStat01.getFont().getSize()));
        Limitless.charStat01.setForeground((Converters.figureoutColor(GetStats.
            getalignColor(Integer.parseInt((selectedToon[4]))))));
        Limitless.charStat01.setToolTipText(Limitless.charStat01.getText()+": "+
            Converters.fetchfromTable(MemoryBank.dbAlign,Calculator.getAlign(
            Integer.parseInt(selectedToon[4])),0,2));
        
        String ageName=(Calculator.getAge(Integer.parseInt(selectedToon[7]), 
            selectedToon[2]));
        String gendName=Converters.fetchfromTable(MemoryBank.dbGender,
            selectedToon[6],0,1);
        Limitless.charStat02.setText(ageName+" • "+gendName);
        Limitless.charStat02.setToolTipText(ageName+": "+(Converters.
            fetchfromTable(MemoryBank.dbAge,ageName,1,3))+" • "+gendName+": "+
            Converters.fetchfromTable(MemoryBank.dbGender,selectedToon[6],0,2));
        String sizeID=selectedToon[22];
        String sizeName=Converters.fetchfromTable(MemoryBank.dbSize,sizeID,0,1);
        String raceName=Converters.fetchfromTable(MemoryBank.dbRace,selectedToon
            [2],0,1);
        Limitless.charStat03.setText(sizeName+" • "+raceName);
        Limitless.charStat03.setToolTipText(sizeName+": "+Converters.
            fetchfromTable(MemoryBank.dbSize,sizeID,0,2)+ " • "+raceName+": "+
            Converters.fetchfromTable(MemoryBank.dbRace,selectedToon[2],0,2));
        String UID=selectedToon[5];
        if(UID.startsWith("7")) {
            String ogID=UID.replace("7x", "");
            String[] ogToon=MemoryBank.savToons.get(Integer.parseInt(ogID)).
                replaceAll(", ",",").split(",");
            String jobID=Converters.fetchfromTable(MemoryBank.dbAlias,ogToon[18]
                ,0,6);
            String className=Converters.fetchfromTable(MemoryBank.dbJobs,jobID,0
                ,1);
            Limitless.charStat04.setText(className+" • Level "+selectedToon[8]);
            Limitless.charStat04.setToolTipText(className+": "+Converters.
                fetchfromTable(MemoryBank.dbJobs,jobID,0,4)+" • Level "+
                selectedToon[8]);  
        } else {
            String className=Converters.fetchfromTable(MemoryBank.dbClass,
                selectedToon[3],0,1);
            Limitless.charStat04.setText(className+" • Level "+selectedToon[8]);
            Limitless.charStat04.setToolTipText(className+": "+Converters.
                fetchfromTable(MemoryBank.dbClass,selectedToon[3],0,2)+
                " • Level "+selectedToon[8]);        
        }

        // add in status decoder here (can be method in GetStats)

        String statusname=Converters.fetchfromTable(MemoryBank.dbStatus,"Normal"
            ,1,1);
        String statuscolor=Converters.fetchfromTable(MemoryBank.dbStatus,
            "Normal",1,2);
        String statusdesc=Converters.fetchfromTable(MemoryBank.dbStatus,"Normal"
            ,1,3);
        String statusbio=Converters.fetchfromTable(MemoryBank.dbStatus,"Normal",
            1,4);

//        if(ChecksBalances.isNullOrEmpty(statuscode) || statuscode.equals("0"))
//            {
//            //put normal status here
//        }

        Font charstat05Font=new Font(Limitless.charStat05.getFont().getName(),
            Font.BOLD,Limitless.charStat05.getFont().getSize());
        Limitless.charStat05.setText(statusname);
        Limitless.charStat05.setFont(charstat05Font);
        Limitless.charStat05.setForeground((Converters.figureoutColor
            (statuscolor)));
        Limitless.charStat05.setToolTipText(statusdesc);
        if(selectedToon[19].equals(MemoryBank.passiveDestinyID)||selectedToon[5]
            .equals("1")) {
            Limitless.ngstartButton.setEnabled(false);
        } else {
            Limitless.ngstartButton.setEnabled(true);
        }
        ngToonSelectButtons("bio");
    }
    
    public static void ngToonSelectButtons(String option) throws SQLException, 
        IOException {
        String selectedToonID=MemoryBank.newgametoonList[Limitless.newgameList
            .getSelectedIndex()][1];
        String[] selectedToon=MemoryBank.savToons.get(Integer.parseInt(
            selectedToonID)).replaceAll(", ",",").split(",");
        if(!ChecksBalances.isNullOrEmpty(selectedToon[18])) {
            Limitless.altName.setVisible(true);
        } else {
            Limitless.altName.setVisible(false);
        }
        
        switch(option) {
            case "stats" :
                ngToonSelectStats(selectedToon);
                break;
            case "effs" :
                ngToonSelectEffs(selectedToon);
                break;
            case "abls" :
                ngToonSelectAbls(selectedToon);
                break;
            case "equip" :
                ngToonSelectEquip(selectedToon);
                break;
            default :
                ngToonSelectBio(selectedToon);
                break;
        }
    }
    
    private static void ngToonSelectStats(String[] selectedToon) throws 
        SQLException, IOException {
        String importstats=MemoryBank.savTemp.get(Integer.parseInt(
            selectedToon[0]));
        String[] newstats=importstats.split(",");
        String statsinfo="["+selectedToon[1]+" Stats]\n\n"
           +" Health Points:  "+newstats[9]+"\n"
           +" Mystic Points:  "+newstats[10]+"\n"
           +"Ability Points:  "+newstats[11]+"\n"
           +"  Attack Power:  "+newstats[12]+"\n"
           +"      Strength:  "+newstats[13]+"\n"
           +"       Defense:  "+newstats[14]+"\n"
           +"       Stamina:  "+newstats[15]+"\n"
           +"         Speed:  "+newstats[16]+"\n"
           +"         Evade:  "+newstats[17]+"\n"
           +"     Dexterity:  "+newstats[18]+"\n"
           +"  Mystic Power:  "+newstats[19]+"\n"
           +"Mystic Defense:  "+newstats[20]+"\n"
           +"  Mystic Evade:  "+newstats[21]+"\n"
           +"     Willpower:  "+newstats[22]+"\n"
           +"          Luck:  "+newstats[23]+"\n"
           +"      Charisma:  "+newstats[24]+"\n"
           +"  Intelligence:  "+newstats[25]+"\n\n"
           +" Fatigue (Hid):  "+newstats[26]+"\n"
           +" Soul (Hidden):  "+newstats[27]+"\n"
           +"Decay (Hidden):  "+newstats[28]+"\n"
           +"WeightMod(Hid):  "+newstats[29]+"\n"
           +"  Rep (Hidden):  "+newstats[30];
        Limitless.charStatText.setText(statsinfo);
    }
    
    private static void ngToonSelectEffs(String[] selectedToon) throws 
        SQLException, IOException {
        String[] effStats=GetStats.getAEStats("Effects",selectedToon);
        String statuscode=(((Arrays.toString(effStats)).replaceAll
            ("MASTER, ", "").replaceAll(",", "-")).replaceAll("[^\\d+\\-]",""));
        if(statuscode.length() <= 0) {
            statuscode="0";
        }
        String effsinfo="["+selectedToon[1]+" Starting Effects]\n\n"+
            GetStats.getitemsfromIDtoString(GetStats.getAEStats("Effects",
            selectedToon),MemoryBank.dbEffects,0,1)
            +"\n\n(Hidden) Status Code: "+statuscode;
        Limitless.charStatText.setText(effsinfo);
    }

    private static void ngToonSelectAbls(String[] selectedToon) throws 
        SQLException, IOException {
        String ablsinfo="["+selectedToon[1]+" Abilities]\n\n"+GetStats.
            getitemsfromIDtoString(GetStats.getAEStats("Abls",selectedToon),
            MemoryBank.dbAbl,0,1);
        Limitless.charStatText.setText(ablsinfo);
    }

    private static void ngToonSelectEquip(String[]  selectedToon) 
        throws SQLException {
        String equipinfo="["+selectedToon[1]+"]\n\n"+
            "[Equipment Held]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[13].split("x")),MemoryBank.dbItems,0,1)
            +"\n\n"+
            "[Wearables Equipped]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[14].split("x")),MemoryBank.dbItems,0,1)
            +"\n\n"+
            "[Charms Equipped]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[15].split("x")),MemoryBank.dbItems,0,1)
            +"\n\n"+
            "[Starting Inventory]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[16].split("x")),MemoryBank.dbItems,0,1);
        Limitless.charStatText.setText(equipinfo);
    }

    private static void ngToonSelectBio(String[] selectedToon) throws 
        SQLException, IOException {
        String bioInfo=Converters.capFirstLetter(Converters.fetchfromTable(
            MemoryBank.dbGender,selectedToon[6],0,5))+" is a "+Converters.
            fetchfromTable(MemoryBank.dbAlign,(Calculator.getAlign(Integer.
            parseInt(selectedToon[4]))),0,6)+" "+(Calculator.getAge(Integer.
            parseInt(selectedToon[7]),selectedToon[2]))+" "+Converters.
            fetchfromTable(MemoryBank.dbGender,selectedToon[6],0,1)+" that is "+
            Converters.fetchfromTable(MemoryBank.dbSize,Converters.
            fetchfromTable(MemoryBank.dbSize,selectedToon[22],0,1),1,4) +" "+
            Converters.fetchfromTable(MemoryBank.dbRace,selectedToon[2],0,7)+" "
            ;
        String UID=selectedToon[5];
        if(UID.startsWith("7x")) {
            Limitless.altName.setVisible(true);
            String ogID=UID.replace("7x", "");
            String[] ogToon=MemoryBank.savToons.get(Integer.
                parseInt(ogID)).replaceAll(", ",",").split(",");
            String jobID=Converters.fetchfromTable(MemoryBank.dbAlias,ogToon[18]
                ,0,6);
            bioInfo +=Converters.fetchfromTable(MemoryBank.dbJobs,jobID,0,1);
        } else {
            bioInfo +=Converters.fetchfromTable(MemoryBank.dbClass,selectedToon
                [3],0,4);
        }
        bioInfo += " and "+Converters.fetchfromTable(MemoryBank.dbStatus,
            Limitless.charStat05.getText(),1,4)+".\n\n"+selectedToon[9];
        if(UID.startsWith("7x")) {
            String ogID=UID.replace("7x", "");
            String[] ogToon=MemoryBank.savToons.get(Integer.parseInt(ogID)).
                replaceAll(", ",",").split(",");
            if(!(ChecksBalances.isNullOrEmpty(ogToon[18]))) {
                String[] ogAlias=getAliasInfo(ogToon[18]);
                if(ogAlias[2].equals("0") || ogAlias[2].equals("1")) {
                    //and og 18 is either 0 or 1
                    //name is the identity of xyz known to the public   
                    bioInfo+="\n\n"+Converters.capFirstLetter(Converters.
                        fetchfromTable(MemoryBank.dbGender,selectedToon[6],0,5))
                        +" is also " +ogToon[1]+" as known to the public.";
                    Limitless.altName.setVisible(true);
                }
                if(!ogAlias[2].equals("0") && !ogAlias[2].equals("1")) {
                    Limitless.altName.setVisible(false);  
                }
            } else {
                Limitless.altName.setVisible(false);
            }
        } else {
            
            if(ChecksBalances.isNullOrEmpty(selectedToon[18])) {
                Limitless.altName.setVisible(false);
                //do nothing with alias here
            } else {
                Limitless.altName.setVisible(true);
                String[] toonAlias=getAliasInfo(selectedToon[18]);
                //0 name only no secret -- nothing
                //1 transformation no secret
                if(toonAlias[2].equals("0") || toonAlias[2].equals("1"))
                    {
                        bioInfo+="\n\n"+Converters.capFirstLetter(Converters.
                            fetchfromTable(MemoryBank.dbGender,selectedToon[6],0
                            ,5))+" has a known alias as "+Converters.
                            fetchfromTable(MemoryBank.dbAlias,selectedToon[18],0
                            ,1)+" when "+Converters.fetchfromTable(MemoryBank.
                            dbGender,selectedToon[6],0,5)+" is not "+
                            selectedToon[1]+".";
                        if(toonAlias[2].equals("0")) {
                            MemoryBank.justswitch=true;
                        } else {
                            MemoryBank.justswitch=false;
                        }
                    } else {
                    Limitless.altName.setVisible(false);
                }
                //2 secret with fake stats
                //3 secret with transformation
                if(toonAlias[2].equals("2") || toonAlias[2].equals("3"))
                    {
                        Limitless.altName.setVisible(false);
                        bioInfo+="\n\n"+Converters.capFirstLetter(Converters.
                            fetchfromTable(MemoryBank.dbGender,selectedToon[6],0
                            ,5))+" has a Secret Identity that is not known to "+
                            "the public.";
                    }
            }
        }
        if(selectedToon[5].equals("1")) {
            bioInfo+="\n\n"+
                "***This character is generated generic character.  You cannot "
               +"start a game with this character.***";
        }
        if(selectedToon[19].equals(MemoryBank.passiveDestinyID) && !selectedToon
            [5].equals("1")) {
            bioInfo+="\n\n"+
                "***This character is set to Passive.  You cannot start a game "
               +"with this character.***";
        }
        //update health status above
        Limitless.charStatText.setText(bioInfo);
    }
    
    public static void altnameButton(String opt) throws IOException, 
        SQLException {
        String selectedToonID=MemoryBank.newgametoonList[Limitless.newgameList
            .getSelectedIndex()][1];
        String[] selectedToon=MemoryBank.savToons.get(Integer.parseInt(
            selectedToonID)).replaceAll(", ",",").split(",");
        switch(opt) {
            case "Change" :
                if(!ChecksBalances.isNullOrEmpty(selectedToon[18])) {
                    String[] toonAlias=getAliasInfo(selectedToon[18]);
                    if(toonAlias[2].equals("1")) {
                        for(int i=0;i<Limitless.newgameList.getModel().getSize()
                            ;i++) {
                            if(Limitless.newgameList.getModel().getElementAt(i).
                                contains(toonAlias[1])) {
                                Limitless.newgameList.setSelectedIndex(i);
                            }
                        }
                    }
                } else {
                    if(selectedToon[5].startsWith("7x")) {
                        String[]ogToon=MemoryBank.savToons.get(Integer.parseInt(
                        selectedToon[5].replaceAll("7x",""))).replaceAll(", ",
                        ",").split(",");
                        for(int i=0;i<Limitless.newgameList.getModel().getSize()
                            ;i++) {
                            if(Limitless.newgameList.getModel().getElementAt(i).
                                contains(ogToon[1])) {
                                Limitless.newgameList.setSelectedIndex(i);
                            }
                        }
                    }
                }
                break;
            case "Switch" :
                if(!ChecksBalances.isNullOrEmpty(selectedToon[18])) {
                    String[] toonAlias=getAliasInfo(selectedToon[18]);
                    if(toonAlias[2].equals("0")) {
                        Avatars.setAvatar(Limitless.charToon, toonAlias[1],
                            toonAlias[8]);
                        Limitless.charName.setText(toonAlias[1]);
                    }
                }
                break;
            case "Revert" :
                if(!ChecksBalances.isNullOrEmpty(selectedToon[18])) {
                    String[] toonAlias=getAliasInfo(selectedToon[18]);
                    if(toonAlias[2].equals("0")) {
                        Avatars.setAvatar(Limitless.charToon, selectedToon[1],
                            selectedToon[10]);
                        Limitless.charName.setText(selectedToon[1]);
                    }
                }
                break;
            default :
                //
                break;
        }
    }

    public static void ngStartButton(String toonID) throws SQLException, 
        IOException, InterruptedException {
        selectedToon=Converters.fetchfromTable(MemoryBank.savToons,String.
            valueOf(toonID),0,0);
        boolean yesno=Popups.yesnoPopup("Character Selection", "You've selected"
            +" "+Converters.fetchfromTable(MemoryBank.savToons,String.valueOf
            (toonID),0,1)+" as your character.\n\n"+"Are you sure you want to "
           +"start the game?");
        if(yesno) {
            GetData.dataUpdateSingle("saveSettings","savesetConfig",MemoryBank.
                currentSave,"savesetID","0");
            GetData.dataUpdateSingle("saveSettings","savesetConfig",MainControls
                .limitV,"savesetID","1");
            GetData.dataUpdateSingle("saveSettings","savesetConfig",selectedToon
                ,"savesetID","2");
            GetData.dataUpdateSingle("saveSettings","savesetConfig",String.
                valueOf(MemoryBank.dbTime),"savesetID","3");
            GetData.dataUpdateSingle("saveSettings","savesetConfig",String.
                valueOf(Arrays.toString(Randomizer.usedGenericNumbers.toArray())
                .replaceAll(", ","x").replaceAll("\\[","").replaceAll("\\]",""))
                ,"savesetID","4");
            System.gc();
            StartGame.startGame();
        } else {
            selectedToon="";
        }
    }
    
    public static void saveGameMenu() throws IOException {
        popSaveGameList();
    }
    
    private static void popSaveGameList() throws IOException {
        List<String> savegameList=ChecksBalances.getSavedGames();
        DefaultListModel lgDml=new DefaultListModel();
        if(savegameList.size() <= 0) {
            Limitless.lgList.setEnabled(false);
            lgDml.removeAllElements();
            lgDml.addElement("<No Saved Games>");
            Limitless.lgyesButton.setEnabled(false);
            Limitless.lgdelButton.setEnabled(false);
        } else {
            Limitless.lgyesButton.setEnabled(true);
            Limitless.lgdelButton.setEnabled(true);
            lgDml.removeAllElements();
            for(int i=0; i < savegameList.size(); i++) {
                Limitless.lgList.setEnabled(true);
                lgDml.addElement(Converters.capFirstLetter(savegameList.get(i).
                    substring(savegameList.get(i).indexOf("\\")+1).replaceAll(
                    saveExt,"")));
            }
        }
        Limitless.lgList.setModel(lgDml);
    }
    
    public static void loadSavedGame() {
        try {
            MemoryBank.newgame=false;
            MemoryBank.created=false;
            MemoryBank.currentSave=savesDir+Limitless.lgList.getSelectedValue().
                toLowerCase()+saveExt;
            Limitless.setLoadingAvatars();
            Limitless.loadingLabel.setText("Game World is Loading...");
            loadingScreen();
            Popups.infoPopup("Loading Your Save Game","Your Save Game "+
                Limitless.lgList.getSelectedValue()+" will now load.");
            System.out.println("HERE");
            MemoryBank.ingame=true;
//            MemoryBank.fillMemory(false);
            backgroundBuild();
            while(!MemoryBank.created) {
                Thread.sleep(1);
            }
            selectedToon=GetData.dataQuery("*","saveSettings","savesetName",
                "playertoon",false,false,null,null).get(2);
            MemoryBank.dbTime=Integer.parseInt(GetData.dataQuery("*",
                "saveSettings","savesetName","rawtime",false,false,null,null).
                get(2));
            Randomizer.usedGenericNumbers=new HashSet<>();
            for (String usedGenericNumbersinArray : (GetData.dataQuery("*",
                "saveSettings","savesetName","usedgenpool",false,false,null,null
                ).get(2).split("x"))) {
                Randomizer.usedGenericNumbers.add(Integer.parseInt(
                    usedGenericNumbersinArray));
            }
            Limitless.setLoadingAvatars();
            Limitless.loadingLabel.setText("Game World Has Loaded!");
            Popups.infoPopup("Save Game Loaded","Your Save Game "+Limitless.
                lgList.getSelectedValue()+" has loaded.\n\nThank you for your "+
                "patience.");
            Calculator.buildDateTime();
            StartGame.startGame();
        } catch (IOException | InterruptedException | SQLException ex) {
            //
        }
    }
    
    public static void delSavedGame() {
        String title=("Are you sure you want to delete "+Limitless.lgList
            .getSelectedValue());
        String message="Are you sure you want to delete\n the save game "+
            Limitless.lgList.getSelectedValue()+"?";
        boolean deleteChoice=Popups.yesnoPopup(title,message);
        if(deleteChoice == true) {
            try {
                ChecksBalances.ifexistDelete(savesDir+Limitless.lgList.
                    getSelectedValue().toLowerCase()+saveExt);
            } catch (IOException | InterruptedException ex) {
                //
            }
        }
    }
    
    public static void badSave(String reason,String game) throws IOException, 
        SQLException {
        Limitless.lgyesButton.setEnabled(false);
        String badsaveTitle="Save "+Converters.capFirstLetter(reason)+" Error!";
        String badsaveMsg="Your save "+Converters.capFirstLetter(game);
        switch(reason) {
            case "version" :
                String savVer=GetData.dataQuery("*","saveSettings","savesetName"
                    ,"limitversion",false,false,null,null).get(2);
                badsaveMsg+=" has a database with version "+savVer+".\n"+
                    "The lowest compatiable save database version that\n"+
                    "will work with this release of "+MainControls.appName+
                    " is database version "+MainControls.limitV+".\n\n"+
                    "It is recommended to delete this save.";
                break;
            default :
                badsaveMsg+=" is corrupted and cannot be used.\n\n"+
                    "It is recommended to delete this save.";
                break;
        }
        String[] badsaveOpts={"Delete Save","Not Now"};
        int badsaveResp=Popups.optPopup(badsaveOpts,badsaveTitle,
            badsaveMsg);
        switch(badsaveResp) {
            case 0:
                delSavedGame();
                MemoryBank.ingame=false;
                saveGameMenu();
                break;
            default:
                MemoryBank.ingame=false;
                break;
        }
    }
    
    private static String[] getAliasInfo (String aID) throws SQLException {
        return MemoryBank.dbAlias.get(Integer.parseInt(aID)).replaceAll(", ",","
            ).split(",");
    }

    public static void exitGame () throws IOException, Exception {
        try {
            String title=("Exit the Game?");
            String message="Are you sure you want to exit?";
            boolean exitChoice=Popups.yesnoPopup(title, message);
            if(exitChoice == true) {
                try{
                    updateSettings();
                } catch (ArrayIndexOutOfBoundsException ex2) {
                    ex2.printStackTrace();
                }
                System.gc();
                System.exit(0);
            } else {
                //
            }
        } catch (IOException | InterruptedException ex) {
            LogWriter.logFile("severe","Exit Game Error.  Exception: "+ex);
        }
    }
    
    private static void checkVersion (String name, String ver) throws 
        IOException, InterruptedException, SQLException {
        MemoryBank.UID=(InetAddress.getLocalHost().getHostName().toLowerCase());
        try {
            if((VersionCheck.checkVersion(name, ver))) {
                Updater.updateMessage(false,appName,appVer);
            }
        } catch (Exception ex) {
                    //
        }
        if(new File(defaultDb).exists()) {
            if(ChecksBalances.isNullOrEmpty(findSetting("version")) || 
                (!(findSetting("version").toLowerCase()).equals(appVer))) {
                try {
                    Updater.updateMessage(true,appName,appVer);
                } catch (IOException | InterruptedException ex) {
                    Popups.warnPopup("Unexpected Warning","Please reinstall.\n"+
                        "\n"+ex.toString());
                    System.exit(0);
                }
            }
        }
    }
}