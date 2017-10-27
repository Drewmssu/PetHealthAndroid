package pe.edu.upc.pethealth.repositories;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.models.Veterinary;

/**
 * Created by genob on 26/10/2017.
 */

public class VeterinariesRepository {
    public static List<Veterinary> getList(){
        List<Veterinary> veterinaries = new ArrayList<>();
        veterinaries.add(new Veterinary("1","Reino Animal","http://r.ddmcdn.com/s_f/o_1/cx_297/cy_0/cw_1194/ch_1194/w_720/APL/uploads/2014/10/dog-training-5173381.jpg","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("2","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("3","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("4","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("5","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("6","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("7","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("8","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("9","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        veterinaries.add(new Veterinary("10","Reino Animal","www.youtube.com","966991826","-12.092428","-77.053803","From: 8:00 AM to 7:00 PM"));
        return veterinaries;
    }
}
