/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pemeriksaan;
import java.util.ArrayList;

/**
 *
 * @author Felicia
 */
public class ManagerFunctions {
    
    public double lihatTotalPendapatanRS(){
        ArrayList<Pemeriksaan> listAllPemeriksaan = new ArrayList<>();
        listAllPemeriksaan = Controller.getAllPemeriksaan();
        double totalPendapatan = 0;
        
        for(Pemeriksaan pemeriksaan : listAllPemeriksaan){
            totalPendapatan += pemeriksaan.getBiaya();
        }
        
        return totalPendapatan;
        
    }
    
    public double lihatPendapatanDokter(String _firstName, String _lastName){
        
    }
    
    public double lihatPendapatanPerSpesialis(int _idSpesialis){
        
    }
    
    public int lihatTotalTransaksi(){
        
    }
}
