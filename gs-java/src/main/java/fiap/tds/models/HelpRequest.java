package fiap.tds.models;

import java.time.LocalDateTime;
import java.util.Objects;


public class HelpRequest {

    private Long id;
    private String cep;
    private double latitude;
    private double longitude;
    private LocalDateTime requestTimestamp;
    private Status status; //
    private String notes;
    private String enderecoAproximado;
    private String contactInfo;


    public HelpRequest() {
    }


    public HelpRequest(Long id, String cep, double latitude, double longitude, LocalDateTime requestTimestamp,
                       Status status, String notes, String enderecoAproximado, String contactInfo) {
        this.id = id;
        this.cep = cep;
        this.latitude = latitude;
        this.longitude = longitude;
        this.requestTimestamp = requestTimestamp;
        this.status = status;
        this.notes = notes;
        this.enderecoAproximado = enderecoAproximado;
        this.contactInfo = contactInfo;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getEnderecoAproximado() {
        return enderecoAproximado;
    }

    public void setEnderecoAproximado(String enderecoAproximado) {
        this.enderecoAproximado = enderecoAproximado;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HelpRequest that = (HelpRequest) o;
        return Double.compare(getLatitude(), that.getLatitude()) == 0 && Double.compare(getLongitude(), that.getLongitude()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getCep(), that.getCep()) && Objects.equals(getRequestTimestamp(), that.getRequestTimestamp()) && getStatus() == that.getStatus() && Objects.equals(getNotes(), that.getNotes()) && Objects.equals(getEnderecoAproximado(), that.getEnderecoAproximado()) && Objects.equals(getContactInfo(), that.getContactInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCep(), getLatitude(), getLongitude(), getRequestTimestamp(), getStatus(), getNotes(), getEnderecoAproximado(), getContactInfo());
    }

    @Override
    public String toString() {
        return "HelpRequest{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                // ... outros campos
                '}';
    }
}