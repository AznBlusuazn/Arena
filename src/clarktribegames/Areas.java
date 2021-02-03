package clarktribegames;

import java.util.List;







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
        String rawArea[] = areaBuilder();
        
    }
    
    private static String[] areaBuilder() {
        //finalresult is:
        //id,name,loc (0-2),space(3-4),ground(5-6),under(7-8),hell(9-10),
        //spaceexist(11),hellexist(12),null(13),undexist(14),ceiingexist(15)
        
        //rawarea[]
        //id(0),name(1),loc(2),Xunits(3),Yunits(4),Zunits(5),active(6),space(7),
        //hell(8),null(9),under(10),ceiling(11)
        String rawarea[]=allAreas.get(selectedArea).replaceAll(", ",",").
            split(",");
        
        //id(0),name(1),loc(2),spcxyzmin(3),spcxyzmax(4),grdxyzmin(5),
        //grdxyzmax(6),undxyzmin(7),undxyzmax(8),helxyzmin(9),helxyzmax(10)
        String xyMax=(Integer.parseInt(rawarea[3])-1)+"x"+(Integer.parseInt(
            rawarea[4])-1);
        int groundZ=Integer.parseInt(rawarea[5]);
        int underZmin=groundZ+1;
        int underZmax=underZmin+Integer.parseInt(rawarea[10]);
        int hellZ=underZmax+1;
        //spc (3-4)
        String space="0x0x0"+":"+xyMax+"x0";
        //spc x min=0
        //spc y min=0
        //spc z min=0
        //spc x max=Integer.parseInt(rawarea[3])-1
        //spc y max=Integer.parseInt(rawarea[4])-1
        //spc z max=0

        //gnd (5-6)
        String ground="0x0x1"+":"+xyMax+"x"+groundZ;
        //gnd x min=0
        //gnd y min=0
        //gnd z min=1 (top)
        //gnd x max=Integer.parseInt(rawarea[3])-1
        //gnd y max=Integer.parseInt(rawarea[4])-1
        //gnd z max=Integer.parseInt(rawarea[5]) 

        //und (7-8)
        String under="0x0x"+underZmin+":"+xyMax+"x"+underZmax;
        //und x min=0
        //und y min=0
        //und z min=Integer.parseInt(rawarea[5])+1
        //und x max=Integer.parseInt(rawarea[3])-1
        //und y max=Integer.parseInt(rawarea[4])-1
        //und z max=Integer.parseInt(rawarea[5])+1+Integer.parseInt(rawarea[10])
        
        //hel (9-10)
        String hell="0x0x"+hellZ+":"+xyMax+"x"+hellZ;
        //hel x min=0
        //hel y min=0
        //hel z min=Integer.parseInt(rawarea[5])+Integer.parseInt(rawarea[10])+2
        //hel x max=Integer.parseInt(rawarea[3])-1
        //hel y max=Integer.parseInt(rawarea[4])-1
        //hel z max=Integer.parseInt(rawarea[5])+Integer.parseInt(rawarea[10])+2
        
         //id,name,loc (0-2),space(3-4),ground(5-6),under(7-8),hell(9-10),
         //spaceexist(11),hellexist(12),null(13),undexist(14),ceiingexist(15)
        return (rawarea[0]+":"+rawarea[1]+":"+rawarea[2]+":"+space+":"+ground+
            ":"+under+":"+hell+":"+rawarea[7]+":"+rawarea[8]+":"+rawarea[9]+":"+
            rawarea[10]+":"+rawarea[11]).split(":");

    }
    
    
    
    
}
