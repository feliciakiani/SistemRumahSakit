package Model;


public class Spesialis {
    private int idSpesialis;
    private String bidangSpesialis;

    public Spesialis() {
    }

    
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
