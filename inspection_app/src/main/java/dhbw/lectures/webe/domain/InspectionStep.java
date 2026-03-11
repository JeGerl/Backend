package dhbw.lectures.webe.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "inspection_steps")
public class InspectionStep {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String requirement;
    
    @Column(nullable = false)
    private Integer orderindex;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StepStatus status;
    
    @Column(columnDefinition = "TEXT")
    private String comment;
    
    @Column
    private String photoPath;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "checklist_step_id")
    private ChecklistStep checklistStep;
    
    // Constructor
    public InspectionStep() {
    }
    
    public InspectionStep(StepStatus status, String comment, String photoPath, ChecklistStep checklistStep) {
        this.status = status;
        this.comment = comment;
        this.photoPath = photoPath;
        this.checklistStep = checklistStep;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public StepStatus getStatus() {
        return status;
    }
    
    public void setStatus(StepStatus status) {
        this.status = status;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String getPhotoPath() {
        return photoPath;
    }
    
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    
    public ChecklistStep getChecklistStep() {
        return checklistStep;
    }
    
    public void setChecklistStep(ChecklistStep checklistStep) {
        this.checklistStep = checklistStep;
    }
}
