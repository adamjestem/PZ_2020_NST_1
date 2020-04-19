package entities;

import org.budowa.entities.BuildingStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "buildings", schema = "budowa")
public class Building {
    private int id;
    private String name;
    private String description;
    private BuildingStatus status;
    private int managerId;
    private Timestamp createdAt;
    private Collection<Attachment> attachmentById;
    private User userByManagerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public BuildingStatus getStatus() {
        return status;
    }

    public void setStatus(BuildingStatus status) {
        this.status = status;
    }

    @Basic
    @Column(name = "manager_id", nullable = false, insertable = false, updatable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building that = (Building) o;
        return id == that.id &&
                managerId == that.managerId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, managerId, createdAt);
    }

    @OneToMany(mappedBy = "buildingsByBuildingId")
    public Collection<Attachment> getAttachmentById() {
        return attachmentById;
    }

    public void setAttachmentById(Collection<Attachment> attachmentById) {
        this.attachmentById = attachmentById;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    public User getUserByManagerId() {
        return userByManagerId;
    }

    public void setUserByManagerId(User userByManagerId) {
        this.userByManagerId = userByManagerId;
    }
}
