/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Felicia
 */
public class Spesialis {
    private int idSpesialis;
    private String bidangSpesialis;

    public Spesialis(int idSpesialis, String bidangSpesialis) {
        this.idSpesialis = idSpesialis;
        this.bidangSpesialis = bidangSpesialis;
    }

    public int getIdSpesialis() {
        return idSpesialis;
    }

    public void setIdSpesialis(int idSpesialis) {
        this.idSpesialis = idSpesialis;
    }

    public String getBidangSpesialis() {
        return bidangSpesialis;
    }

    public void setBidangSpesialis(String bidangSpesialis) {
        this.bidangSpesialis = bidangSpesialis;
    }
    
    
}
