package main.java.fr._42.chat.models;

import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

  @Id
  private long id;
  private String login;
  private String password;
  private ArrayList<Room> createdRoomsList;
  private ArrayList<Room> joinedRoomsList;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public ArrayList<Room> getCreatedRoomsList() {
    return createdRoomsList;
  }
  public void setCreatedRoomsList(ArrayList<Room> createdRoomsList) {
    this.createdRoomsList = createdRoomsList;
  }
  public ArrayList<Room> getJoinedRoomsList() {
    return joinedRoomsList;
  }
  public void setJoinedRoomsList(ArrayList<Room> joinedRoomsList) {
    this.joinedRoomsList = joinedRoomsList;
  }

}
