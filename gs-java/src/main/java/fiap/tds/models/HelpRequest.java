package fiap.tds.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Help_Request")
public class HelpRequest extends PanacheEntity {
    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(name= "timeStamp" , nullable = false)
    private LocalDateTime requestTimestamp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Lob //Lob is used for huge text fields
    private String notes;


    //Here we define the contact information
    // for the person requesting help.
    // It can be a phone number, email, or any other relevant contact detail.
    @Column(name= "contact_info")
    private String contactInfo;

    public HelpRequest() {
    }

    public HelpRequest(double latitude, double longitude, LocalDateTime requestTimestamp, Status status, String notes, String contactInfo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.requestTimestamp = requestTimestamp;
        this.status = status;
        this.notes = notes;
        this.contactInfo = contactInfo;
    }

    public String getGoogleMapsLink() {
        if (this.latitude != 0 || this.longitude != 0) { // Evita link para 0,0 se não definido
            return String.format("https://www.google.com/maps?q=%f,%f", this.latitude, this.longitude);

        }
        return null;
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

    public LocalDateTime getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(LocalDateTime requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
