package fi.academy.climateswipe.Entities;

import javax.persistence.*;

@Entity
public class Relations {
    @Id @GeneratedValue
    private int id;
    private String choice;
    @ManyToOne
    @JoinColumn
    private int Users user_id;
    @ManyToOne
    @JoinColumn
    private int Tasks task_id;

    public Relations() {
    }

    public Relations(String choice, int users, int tasks) {
        this.choice = choice;
        Users = users;
        Tasks = tasks;
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

    public int getUsers() {
        return Users;
    }

    public void setUsers(int users) {
        Users = users;
    }

    public int getTasks() {
        return Tasks;
    }

    public void setTasks(int tasks) {
        Tasks = tasks;
    }
}
