package dhbw.lectures.webe.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inspections")
public class Inspection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String plantName;
    
    @Column(nullable = false)
    private LocalDateTime inspectionDate;
    
    @Column
    private String status;
    
    @Column(columnDefinition = "TEXT")
    private String generalComment;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "inspection_id")
    private List<InspectionStep> steps = new ArrayList<>();
    
    // Constructor
    public Inspection() {
    }
    
    public Inspection(String title, String plantName, LocalDateTime inspectionDate, String status, String generalComment) {
        this.title = title;
        this.plantName = plantName;
        this.inspectionDate = inspectionDate;
        this.status = status;
        this.generalComment = generalComment;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getPlantName() {
        return plantName;
    }
    
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
    
    public LocalDateTime getInspectionDate() {
        return inspectionDate;
    }
    
    public void setInspectionDate(LocalDateTime inspectionDate) {
        this.inspectionDate = inspectionDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getGeneralComment() {
        return generalComment;
    }
    
    public void setGeneralComment(String generalComment) {
        this.generalComment = generalComment;
    }
    
    public List<InspectionStep> getSteps() {
        return steps;
    }
    
    public void setSteps(List<InspectionStep> steps) {
        this.steps = steps;
    }
    
    public void addStep(InspectionStep step) {
        this.steps.add(step);
    }
    
    public void removeStep(InspectionStep step) {
        this.steps.remove(step);
    }
}
