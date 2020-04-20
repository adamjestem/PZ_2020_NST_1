package org.budowa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "budowa")
public class User {
    private int id;
    private String username;
    private String password;
    private UserRole userRole;
    private String fullName;
    private Collection<Attachment> attachmentById;
    private Collection<Building> buildingById;
    private Role roleByRoleId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role_id", nullable = false, insertable = false, updatable = false)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 45)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                userRole == that.userRole &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, userRole, fullName);
    }

    @OneToMany(mappedBy = "userId")
    public Collection<Attachment> getAttachmentById() {
        return attachmentById;
    }

    public void setAttachmentById(Collection<Attachment> attachmentById) {
        this.attachmentById = attachmentById;
    }

    @OneToMany(mappedBy = "managerId")
    public Collection<Building> getBuildingById() {
        return buildingById;
    }

    public void setBuildingById(Collection<Building> buildingById) {
        this.buildingById = buildingById;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
