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
    private Integer orderindex;
    
    // Constructor
    public ChecklistStep() {
    }
    
    public ChecklistStep(String description, String requirement, Integer orderindex) {
        this.description = description;
        this.requirement = requirement;
        this.orderindex = orderindex;
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
    
    public Integer getOrderindex() {
        return orderindex;
    }
    
    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }
}
