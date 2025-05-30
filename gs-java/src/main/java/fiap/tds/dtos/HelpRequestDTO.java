package fiap.tds.dtos;

// This class will be used for the client to send help requests
public class HelpRequestDTO {
    private double latitude;
    private double longitude;
    private String notes;
    private String contactInfo;

    public HelpRequestDTO(double latitude, double longitude, String notes, String contactInfo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.notes = notes;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
