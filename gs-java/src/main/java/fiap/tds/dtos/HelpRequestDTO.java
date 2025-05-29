package fiap.tds.dtos;

// This class will be used for the client to send help requests
public class HelpRequestDTO {
    private double latitude;
    private double longitude;
    private String notes;
    private String coontactInfo;

    public HelpRequestDTO(double latitude, double longitude, String notes, String coontactInfo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.notes = notes;
        this.coontactInfo = coontactInfo;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCoontactInfo() {
        return coontactInfo;
    }

    public void setCoontactInfo(String coontactInfo) {
        this.coontactInfo = coontactInfo;
    }
}
