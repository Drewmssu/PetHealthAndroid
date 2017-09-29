package pe.edu.upc.pethealth.models;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.R;

/**
 * Created by genob on 28/09/2017.
 */

public class MyTipsRepository {
    public static List<MyTip> getMyTips(){
        List<MyTip> myTips = new ArrayList<>();
        myTips.add(new MyTip(1, R.mipmap.ic_launcher,"Tip 1","Description 1"));
        myTips.add(new MyTip(2, R.mipmap.ic_launcher,"Tip 2","Description 2"));
        myTips.add(new MyTip(3, R.mipmap.ic_launcher,"Tip 3","Description 3"));
        myTips.add(new MyTip(4, R.mipmap.ic_launcher,"Tip 4","Description 4"));
        myTips.add(new MyTip(5, R.mipmap.ic_launcher,"Tip 5","Description 5"));
        myTips.add(new MyTip(6, R.mipmap.ic_launcher,"Tip 6","Description 6"));
        myTips.add(new MyTip(7, R.mipmap.ic_launcher,"Tip 7","Description 7"));
        myTips.add(new MyTip(8, R.mipmap.ic_launcher,"Tip 8","Description 8"));
        myTips.add(new MyTip(9, R.mipmap.ic_launcher,"Tip 9","Description 9"));
        myTips.add(new MyTip(10, R.mipmap.ic_launcher,"Tip 10","Description 10"));
        return myTips;
    }

}
