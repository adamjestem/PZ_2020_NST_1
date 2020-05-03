package org.budowa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "buildings", schema = "budowa")
public class Building {
    private int id;
    private String name;
    private String customer;
    private String startDate;
    private String endDate;
    private String description;
    private String additionalNotes;
    private String address;
    private BuildingStatus status;
    private BuildingPriority priority;
    private Timestamp createdAt;
    private Collection<User> workers;
    private User manager;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 45)
    public BuildingStatus getStatus() {
        return status;
    }

    public void setStatus(BuildingStatus status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false, length = 45)
    public BuildingPriority getPriority() {
        return priority;
    }

    public void setPriority(BuildingPriority priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "customer", nullable = false, length = 1000)
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Basic
    @Column(name = "start_date", nullable = false, length = 1000)
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false, length = 1000)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 1000)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "additional_notes", nullable = false, length = 1000)
    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
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
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, createdAt);
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @ManyToMany
    @JoinTable(
            name = "workers_buildings",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Collection<User> getWorkers() {
        return workers;
    }

    public void setWorkers(Collection<User> workers) {
        this.workers = workers;
    }
}
