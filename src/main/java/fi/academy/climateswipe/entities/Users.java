package fi.academy.climateswipe.entities;




import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    private int id;
    private String name;
    private String oauth_id;

    public Users() {

    }

    public Users(int id, String name, String oauth_id) {
        this.id=id;
        this.name=name;
        this.oauth_id=oauth_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getOauth_id() {
        return oauth_id;
    }

    public void setOauth_id(String oauth_id) {
        this.oauth_id=oauth_id;
    }


}
