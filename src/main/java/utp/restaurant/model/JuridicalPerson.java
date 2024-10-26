package utp.restaurant.model;

import java.util.Random;

public class JuridicalPerson extends Person{
    
    protected long id_juridicalPerson;
    protected long ruc;
    protected String socialReason;
    protected String type;
    protected String economicActivity;
    protected String typeBilling;

    public JuridicalPerson(long ruc, String socialReason, String type, String economicActivity, String typeBilling, int phoneNumber, String email, String address) {
        super(phoneNumber, email, address);
        this.ruc = ruc;
        this.socialReason = socialReason;
        this.type = type;
        this.economicActivity = economicActivity;
        this.typeBilling = typeBilling;
    }
    

    public JuridicalPerson() {
    }

    public long getId_juridicalPerson() {
        return id_juridicalPerson;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEconomicActivity() {
        return economicActivity;
    }

    public void setEconomicActivity(String economicActivity) {
        this.economicActivity = economicActivity;
    }

    public String getTypeBilling() {
        return typeBilling;
    }

    public void setId_juridicalPerson(long id_juridicalPerson) {
        this.id_juridicalPerson = id_juridicalPerson;
    }
    
    

    public void setTypeBilling(String typeBilling) {
        this.typeBilling = typeBilling;
    }
    
    //metodo abstracto
    @Override
    public String fullData() {
        return socialReason;
    }
    
    @Override
    public String toString() {
        return fullData();
    }

}
