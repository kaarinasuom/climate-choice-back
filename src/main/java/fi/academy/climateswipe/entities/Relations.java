package fi.academy.climateswipe.entities;


import javax.persistence.*;

@Entity
public class Relations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    private int id;
    private String choice;
    @ManyToOne @JoinColumn
    private Users user;
    @ManyToOne @JoinColumn
    private Tasks task;

    public Relations() {
    }

    public Relations(String choice, Users user, Tasks task) {
        this.choice = choice;
        this.user = user;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }
}
