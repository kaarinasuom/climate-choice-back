package fi.academy.climateswipe.entities;


import javax.persistence.*;

@Entity
public class Relations {
    @Id
    @GeneratedValue
    private int id;
    private String choice;
    @ManyToOne
    @JoinColumn
    private Users user_id;
    @ManyToOne
    @JoinColumn
    private Tasks task_id;

    public Relations() {
    }

    public Relations(String choice, Users user_id, Tasks task_id) {
        this.choice = choice;
        this.user_id = user_id;
        this.task_id = task_id;
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

//    public int getUsers() {
//        return Users;
//    }
//
//    public void setUsers(int users) {
//        Users = users;
//    }
//
//    public int getTasks() {
//        return Tasks.java;
//    }
//
//    public void setTasks(int tasks) {
//        Tasks.java = tasks;
//    }
}
