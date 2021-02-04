package clarktribegames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




// z is still incorrect


// <editor-fold defaultstate="collapsed" desc="credits">


/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class Areas {
    
    static List<String> allAreas;
    static List<String> allSections;
    static int selectedArea;

    public static void buildArea () {
        String[] rawArea;
        try {
            rawArea=areaBuilder(selectedArea);
        } catch (NullPointerException ex) {
            rawArea=areaBuilder(0);
        }
//        int[] minC=getCoords(rawArea[3]);
//        int[] maxC=getCoords(rawArea[10]);
        List<String> defaultSect=new ArrayList<>();
        List<String> rawSections=sectionPre(rawArea,defaultSect);
        //sectionid(0),sectionname(1),newsectstartxyz(2),newsectendxyz(3),
        //envid(4),envname(5),enveffs(6),envdesc(7),envnull(8),
        //sectioncolor(9),sectiondesc(10),sectionspawn(11),sectionnull(12)
        //item delimiter is ":"
        rawSections.forEach(rawSection -> {
            System.out.println(rawSection);
        });
        
    }
    
    private static String[] areaBuilder(int areaid) {
        //finalresult is:
        //id(0),name(1),loc(2),space(3-4),ground(5-6),under(7-8),hell(9-10),
        //airunits(11),spaceexist(12),hellexist(13),null(14),undexist(15),
        //ceiingexist(16),desc(17)
        
        //rawarea[]
        //id(0),name(1),loc(2),desc(3),Xunits(4),Yunits(5),Zunits(6),active(7),
        //space(8),hell(9),null(10),under(11),ceiling(12)
        String rawarea[]=allAreas.get(areaid).replaceAll(", ",",").split(",");
        
        //id(0),name(1),loc(2),spcxyzmin(3),spcxyzmax(4),grdxyzmin(5),
        //grdxyzmax(6),undxyzmin(7),undxyzmax(8),helxyzmin(9),helxyzmax(10)
        String xyMax=(Integer.parseInt(rawarea[4])-1)+"x"+(Integer.parseInt(
            rawarea[5])-1);
        int groundZ=Integer.parseInt(rawarea[6]);
        int underZmin=groundZ+1;
        int underZmax=underZmin+Integer.parseInt(rawarea[11]);
        int hellZ=underZmax+1;
        //spc (3-4)
        String space="0x0x0"+":"+xyMax+"x0";
        //spc x min=0
        //spc y min=0
        //spc z min=0
        //spc x max=Integer.parseInt(rawarea[4])-1
        //spc y max=Integer.parseInt(rawarea[5])-1
        //spc z max=0

        //gnd (5-6)
        String ground="0x0x1"+":"+xyMax+"x"+groundZ;
        //gnd x min=0
        //gnd y min=0
        //gnd z min=1 (top)
        //gnd x max=Integer.parseInt(rawarea[4])-1
        //gnd y max=Integer.parseInt(rawarea[5])-1
        //gnd z max=Integer.parseInt(rawarea[6]) 

        //und (7-8)
        String under="0x0x"+underZmin+":"+xyMax+"x"+underZmax;
        //und x min=0
        //und y min=0
        //und z min=Integer.parseInt(rawarea[6])+1
        //und x max=Integer.parseInt(rawarea[4])-1
        //und y max=Integer.parseInt(rawarea[5])-1
        //und z max=Integer.parseInt(rawarea[6])+1+Integer.parseInt(rawarea[11])
        
        //hel (9-10)
        String hell="0x0x"+hellZ+":"+xyMax+"x"+hellZ;
        //hel x min=0
        //hel y min=0
        //hel z min=Integer.parseInt(rawarea[6])+Integer.parseInt(rawarea[11])+2
        //hel x max=Integer.parseInt(rawarea[4])-1
        //hel y max=Integer.parseInt(rawarea[5])-1
        //hel z max=Integer.parseInt(rawarea[6])+Integer.parseInt(rawarea[11])+2
        
        //id,name,loc (0-2),space(3-4),ground(5-6),under(7-8),hell(9-10),
        //airunits(11),spaceexist(12),hellexist(13),null(14),undexist(15),
        //ceiingexist(16),desc(17)
        return (rawarea[0]+":"+rawarea[1]+":"+rawarea[2]+":"+space+":"+ground+
            ":"+under+":"+hell+":"+String.valueOf(Integer.parseInt(rawarea[6])-1
            )+rawarea[8]+":"+rawarea[9]+":"+rawarea[10]+":"+rawarea[11]+":"+
            rawarea[12]+":"+rawarea[3]).replaceAll("\\[","").replaceAll("\\]",
            "").split(":");
    }
    
    private static List<String> sectionPre(String[]rawarea,List<String>defsect){
        List<String> sectionprelist=new ArrayList<>();
        List<String> extracoords=new ArrayList<>();
        List<String> defcoords=new ArrayList<>();
        defcoords.addAll(Arrays.asList("0x0x2","0x1x2","0x2x2","1x0x2","1x1x2",
            "1x2x2","2x0x2","2x1x2","2x2x2"));
        //rawarea[11]=airunits
        for(int i=0;i<allSections.size();i++) {
            String tmpsection[]=Converters.expListtoArray(allSections.get(i));
            if(tmpsection[1].equals(rawarea[0]) && !(rawarea[0].equals("0"))) {
                if(tmpsection[3].endsWith("x2")) {
                    String tempCoords=tmpsection[3];
                    for(int j=0;j<defcoords.size();j++) {
                        if(!(tempCoords.equals(defcoords.get(j)))) {
                            extracoords.add(tempCoords);
                        }
                    }
                }
                sectionprelist.add(getSectionString(tmpsection,rawarea));

                //sectionid(0),sectionname(1),newsectstartxyz(2),
                //newsectendxyz(3),envid(4),envname(5),enveffs(6),envdesc(7),
                //envnull(8),sectioncolor(9),sectiondesc(10),sectionspawn(11),
                //sectionnull(12)
            }
            if(tmpsection[1].equals("0")) {
                String deftemp=getSectionString(tmpsection,rawarea);
                defsect.add(deftemp);
                if(rawarea[0].equals("0")) {
                    String rawtemp=getSectionString(tmpsection,rawarea);
                    sectionprelist.add(rawtemp);
                }
            }
            if(extracoords.size()>0) {
                for(int k=0;k<extracoords.size();k++) {
                    if(tmpsection[1].equals("0") && tmpsection[3].equals(
                        extracoords.get(k))) {
                        sectionprelist.add(getSectionString(tmpsection,rawarea));
                    }
                }
            }
        }
        return sectionprelist;
    }
    
    private static String getSectionString(String[]tmpsection,String[]rawarea) {
        String[] tmpStart=tmpsection[3].split("x");
        //1x1x2
        //z=2 = returns 5,6
        //rawarea[5] = ground min (xyz) 0x0x1?
        //String[] newStart=rawarea[whichZ(tmpStart[2])[0]].split("x");                
        //1x1x2
        //z=2 = return 5,6
        //rawarea[6] = ground max (xyz)
        String[] tmpEnd=tmpsection[4].split("x");
        String[] newEnd=rawarea[whichZ(tmpEnd[2])[1]].split("x");
        String tmpStartZ=tmpStart[2];
        if(tmpStart[2].equals("1") || tmpStart[2].equals("3")) {
            tmpStartZ=tmpStart[2]+"S";
        }
        String tmpEndZ=tmpEnd[2];
        if(tmpEnd[2].equals("1") || tmpEnd[2].equals("3")) {
            tmpEndZ=tmpEnd[2]+"E";
        }
        if(tmpStart[2].equals("1")&&(Integer.parseInt(rawarea[11])<2)) {
            tmpStartZ=tmpStart[2];
        }
        if(tmpStart[2].equals("3")&&(Integer.parseInt(rawarea[15])<2)) {
            tmpStartZ=tmpStart[2];
        }
        String newStartC[]=getC(tmpStart[0],tmpStart[1],tmpStartZ,
            Integer.parseInt(newEnd[0]),Integer.parseInt(newEnd[1]),
            Integer.parseInt(newEnd[2]));
        String newEndC[]=getC(tmpEnd[0],tmpEnd[1],tmpEndZ,Integer.
            parseInt(newEnd[0]),Integer.parseInt(newEnd[1]),Integer.
            parseInt(newEnd[2]));
        String tmpEnv[]=Converters.expListtoArray(MemoryBank.dbEnv.get(
            Integer.parseInt(tmpsection[5])));
        int totalunits=getUnits(newStartC,newEndC);
        return (tmpsection[0]+":"+tmpsection[2]+":"+newStartC[0]+"x"+
            newStartC[1]+"x"+newStartC[2]+":"+newEndC[0]+"x"+newEndC[1]+"x"+
            newEndC[2]+":"+totalunits+":"+tmpEnv[0]+":"+tmpEnv[1]+":"+tmpEnv[2]+
            ":"+tmpEnv[3]+":"+tmpEnv[4]+":"+tmpsection[6]+":"+tmpsection[7]+":"+
            tmpsection[8]+":"+tmpsection[9]);
        //sectionid(0),sectionname(1),newsectstartxyz(2),newsectendxyz(3),
        //totalunits(4),envid(5),envname(6),enveffs(7),envdesc(8),envnull(9),
        //sectioncolor(10),sectiondesc(11),sectionspawn(12),sectionnull(13)
    }
    
    private static String[] getC(String x,String y,String z,int mx,int my,int mz
        ) {
        int newX=0;
        int newY=0;
        int newZ=0;
        if(x.equals("1")) {
            newX=mx/2;
        }
        if(x.equals("2")) {
            newX=mx;
        }
        if(y.equals("1")) {
            newY=my/2;
        }
        if(y.equals("2")) {
            newY=my;
        }
        if(z.equals("1") || z.equals("1S")) {
            newZ=1;
        }
        if(z.equals("1E")) {
            newZ=(mz/2)-1;
        }
        if(z.equals("2")) {
            newZ=mz/2;
        }
        if(z.equals("3") || z.equals("3S")) {
            newZ=(mz/2)+1;
        }
        if(z.equals("3E")) {
            newZ=mz-1;
        }
        if(z.equals("4")) {
            newZ=mz;
        }
        return new String[]{String.valueOf(newX),String.valueOf(newY),String.
            valueOf(newZ)};
    }
    
    private static int[] whichZ(String z) {        
        //space(3-4),ground(5-6),under(7-8),hell(9-10),
        switch(z) {
            case "0":
                return new int[]{3,4};
            case "1":
                return new int[]{5,6};
            case "2":
                return new int[]{5,6};
            case "3":
                return new int[]{7,8};
            case "4":
                return new int[]{9,10};
            default:
                 return new int[]{5,6};
       }
    }
    
    private static int getUnits(String[] start, String[] end) {
        return (Integer.parseInt(end[0])+1-Integer.parseInt(start[0]))+
        (Integer.parseInt(end[1])+1-Integer.parseInt(start[1]))+
        (Integer.parseInt(end[2])+1-Integer.parseInt(start[2]));
    }
    
    private static int[] getCoords (String coords) {
        String[] coordarray=coords.split("x");
        return new int[]{Integer.parseInt(coordarray[0]),Integer.parseInt(
            coordarray[1]),Integer.parseInt(coordarray[2])};
    }
    
//    private static int[] sectionCoords(String[] rawCoords) {
//        
//    }
    
    
}
