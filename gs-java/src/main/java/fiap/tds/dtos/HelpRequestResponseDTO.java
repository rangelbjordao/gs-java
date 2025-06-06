package fiap.tds.dtos;

public class HelpRequestResponseDTO {
    private String cep;
    private String notes;
    private String contactInfo;
    private double latitude;
    private double longitude;


    public HelpRequestResponseDTO() {
    }

    public HelpRequestResponseDTO(String cep, String notes, String contactInfo, double latitude, double longitude) {
        this.cep = cep;
        this.notes = notes;
        this.contactInfo = contactInfo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
}
