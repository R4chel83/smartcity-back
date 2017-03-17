package mx.infotec.smartcity.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Erik Valdivieso
 */
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    
    private String email;
    private String name;
    private String familyName;
    private Date birthDate;
    private Gender gender;
    
    private String group;
    private String idOrion;
    private String registerType;
    private Date registerDate;
    private Date lastEntry;
    private Date lastProfileUpdate;
    
    private List<HealthProfile> healthProfiles;
    private List<Address> addresses;
    private List<Vehicle> vehicles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getIdOrion() {
        return idOrion;
    }

    public void setIdOrion(String idOrion) {
        this.idOrion = idOrion;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastEntry() {
        return lastEntry;
    }

    public void setLastEntry(Date lastEntry) {
        this.lastEntry = lastEntry;
    }

    public Date getLastProfileUpdate() {
        return lastProfileUpdate;
    }

    public void setLastProfileUpdate(Date lastProfileUpdate) {
        this.lastProfileUpdate = lastProfileUpdate;
    }

    public List<HealthProfile> getHealthProfiles() {
        return healthProfiles;
    }

    public void setHealthProfiles(List<HealthProfile> healthProfiles) {
        this.healthProfiles = healthProfiles;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
