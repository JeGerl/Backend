package dhbw.lectures.webe.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "checklist_steps")
public class ChecklistStep {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String requirement;

    @Column(nullable = false)
    private Integer orderIndex;

    // Constructor
    public ChecklistStep() {
    }

    public ChecklistStep(String description, String requirement, Integer orderIndex) {
        this.description = description;
        this.requirement = requirement;
        this.orderIndex = orderIndex;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
