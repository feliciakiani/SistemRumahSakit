/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dokter;
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
        Dokter dokter = new Dokter();
        dokter = Controller.getDokter(_firstName, _lastName);
        
        return dokter.getPendapatan();
    }
    
    public double lihatPendapatanPerSpesialis(int _idSpesialis){
        ArrayList<Dokter> listAllDokter = new ArrayList<>();
        listAllDokter = Controller.getAllDokter();
        double pendapatan = 0;
        
        for(Dokter dokter : listAllDokter){
            if(dokter.getIdSpesialis() == _idSpesialis){
                pendapatan += dokter.getPendapatan();
            }
        }
        
        return pendapatan;
        
    }
    
    public int lihatTotalTransaksi(){
        
        return Controller.getAllPemeriksaan().size();
        
    }
}
