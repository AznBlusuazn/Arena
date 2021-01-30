package clarktribegames;

// <editor-fold defaultstate="collapsed" desc="credits">

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class MemoryBank {
    
    //settings
    static List<String> mainSettings;
    
    //active game
    static List<String> savToons;
    static List<String> genToons;
    static List<String> altToons;    
    static List<String> savTemp;
    static List<String> savTime;

    //active cache
    static String currentDb="";
    static String currentGame="";
    static String currentSave="";
    static boolean currentlyTyping=false;
    static boolean musicPlaying=false;
    static Thread currentSong;
    static String threadName="";
    static String[][] newgametoonList;
    static boolean ingame=false;
    static boolean created=false;
    static boolean justswitch=false;
    static String passiveDestinyID="1";
    static String UID="";
    static String db1="jdbc:ucanaccess://"+MainControls.defaultDb;

    //db cache
    static List<String> dbAbl;
    static List<String> dbAblType;
    static List<String> dbAge;
    static List<String> dbAlias;
    static List<String> dbAlign;
    static List<String> dbArea;
    static List<String> dbClass;
    static List<String> dbCustM;
    static List<String> dbDestiny;
    static List<String> dbEffects;
    static List<String> dbEffectsType;
    static List<String> dbGender;
    static List<String> dbGeneric;
    static List<String> dbItems;
    static List<String> dbItemType;
    static List<String> dbJobs;
    static List<String> dbPhrases;
    static List<String> dbRace;
    static List<String> dbSize;
    static List<String> dbStatus;
    static List<String> dbToons;
    static int dbTime;
    
    public static void fillMemory(boolean newgame) throws SQLException, 
        IOException {

        dbTabletoMem(dbAbl,GetData.dataQuery("*","dbAbl","ablID",null,true,false
            ,null,null).size(),"dbAbl","ablID");
        dbTabletoMem(dbAblType,GetData.dataQuery("*","dbAblType","abtID",null,
            true,false,null,null).size(),"dbAblType","abtID");
        dbTabletoMem(dbAge,GetData.dataQuery("*","dbAge","ageID",null,true,false
            ,null,null).size(),"dbAge","ageID");
        dbTabletoMem(dbAlias,GetData.dataQuery("*","dbAlias","aliasID",null,true
            ,false,null,null).size(),"dbAlias","aliasID");
        dbTabletoMem(dbAlign,GetData.dataQuery("*","dbAlign","alignID",null,true
            ,false,null,null).size(),"dbAlign","alignID");
        dbTabletoMem(dbArea,GetData.dataQuery("*","dbArea","areaID",null,true
            ,false,null,null).size(),"dbArea","areaID");
        dbTabletoMem(dbClass,GetData.dataQuery("*","dbClass","classID",null,true
            ,false,null,null).size(),"dbClass","classID");
        dbTabletoMem(dbDestiny,GetData.dataQuery("*","dbDestiny","destinyID",
            null,true,false,null,null).size(),"dbDestiny","destinyID");
        dbTabletoMem(dbEffects,GetData.dataQuery("*","dbEffects","effID",null,
            true,false,null,null).size(),"dbEffects","effID");
        dbTabletoMem(dbEffectsType,GetData.dataQuery("*","dbEffectsType",
            "effTypeID",null,true,false,null,null).size(),"dbEffectsType",
            "effTypeID");
        dbTabletoMem(dbGender,GetData.dataQuery("*","dbGender","genderID",null,
            true,false,null,null).size(),"dbGender","genderID");
        dbTabletoMem(dbGeneric,GetData.dataQuery("*","dbGeneric","genericID",
            null,true,false,null,null).size(),"dbGeneric","genericID");
        dbTabletoMem(dbItems,GetData.dataQuery("*","dbItems","itemID",null,true,
            false,null,null).size(),"dbItems","itemID");
        dbTabletoMem(dbItemType,GetData.dataQuery("*","dbItemType","itemtypeID",
            null,true,false,null,null).size(),"dbItemType","itemtypeID");
        dbTabletoMem(dbJobs,GetData.dataQuery("*","dbJobs","jobID",null,true,
            false,null,null).size(),"dbJobs","jobID");
        dbTabletoMem(dbPhrases,GetData.dataQuery("*","dbPhrases","phraseID",null
            ,true,false,null,null).size(),"dbPhrases","phraseID");
        dbTabletoMem(dbRace,GetData.dataQuery("*","dbRace","raceID",null,true,
            false,null,null).size(),"dbRace","raceID");
        dbTabletoMem(dbSize,GetData.dataQuery("*","dbSize","sizeID",null,true,
            false,null,null).size(),"dbSize","sizeID");
        dbTabletoMem(dbStatus,GetData.dataQuery("*","dbStatus","statusID",null,
            true,false,null,null).size(),"dbStatus","statusID");
        dbTabletoMem(dbToons,GetData.dataQuery("*","dbToons","toonID",null,true,
            false,null,null).size(),"dbToons","toonID");
        if(!newgame && ingame) {
            dbTime=Integer.parseInt(GetData.dataQuery("*","saveSettings",
                "savesetName","rawtime",false,false,null,null).get(2));
        } else {
            dbTime = 0;
        }
    }
    
    private static void dbTabletoMem (List<String> list,int rows,String table,
        String id) throws SQLException {
        
        for(int i=0;i<rows;i++) {
            list.add(Arrays.toString(GetData.dataQuery("*",table,id,String.
                valueOf(i),false,false,null,null).toArray()));
        }
        
    }
    
    public static void shortMemory(String type) throws SQLException {
        switch(type) {
            case "loadsave":
                dbTabletoMem(dbAge,GetData.dataQuery("*","dbAge","ageID",null,
                    true,false,null,null).size(),"dbAge","ageID");          
                dbTabletoMem(dbGender,GetData.dataQuery("*","dbGender",
                    "genderID",null,true,false,null,null).size(),"dbGender",
                    "genderID");
                dbTabletoMem(dbRace,GetData.dataQuery("*","dbRace","raceID",null
                    ,true,false,null,null).size(),"dbRace","raceID");
                dbTabletoMem(dbClass,GetData.dataQuery("*","dbClass","classID",
                    null,true,false,null,null).size(),"dbClass","classID");
                break;
            default:
                break;
        }
    }

    public static void clearMemory() {
        
        ingame = false;
        
        savToons = new ArrayList<>();
        genToons = new ArrayList<>();
        altToons = new ArrayList<>();    
        savTemp = new ArrayList<>();
        savTime = new ArrayList<>();

        dbAbl = new ArrayList<>();
        dbAblType = new ArrayList<>();
        dbAge = new ArrayList<>();
        dbAlias = new ArrayList<>();
        dbAlign = new ArrayList<>();
        dbClass = new ArrayList<>();
        dbCustM = new ArrayList<>();
        dbDestiny = new ArrayList<>();
        dbEffects = new ArrayList<>();
        dbEffectsType = new ArrayList<>();
        dbGender = new ArrayList<>();
        dbGeneric = new ArrayList<>();
        dbItems = new ArrayList<>();
        dbItemType = new ArrayList<>();
        dbJobs = new ArrayList<>();
        dbPhrases = new ArrayList<>();
        dbRace = new ArrayList<>();
        dbSize = new ArrayList<>();
        dbStatus = new ArrayList<>();
        dbToons = new ArrayList<>();
        
        dbTime = 0;
    }
    
}
