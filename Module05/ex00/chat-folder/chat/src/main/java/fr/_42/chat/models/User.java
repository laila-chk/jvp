package main.java.fr._42.chat.models;

import java.util.ArrayList;
import java.util.Objects;

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


  @Override
  public String toString() {
    return "User[id = " + id + ", login=" + login + ", password=" + password +
    ", createdRoomsList=" + createdRoomsList + ", joinedRoomsList=" + joinedRoomsList + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id == user.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
