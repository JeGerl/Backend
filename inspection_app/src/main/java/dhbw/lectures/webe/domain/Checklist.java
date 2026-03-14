package dhbw.lectures.webe.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String plantName;

    @Column(columnDefinition = "TEXT")
    private String recommendations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checklist_id")
    private List<ChecklistStep> steps = new ArrayList<>();

    // Constructor
    public Checklist() {
    }

    // Main Constructor for Checklist
    public Checklist(String name, String plantName, String recommendations) {
        this.name = name;
        this.plantName = plantName;
        this.recommendations = recommendations;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public List<ChecklistStep> getSteps() {
        return steps;
    }

    public void setSteps(List<ChecklistStep> steps) {
        this.steps = steps;
    }

    public void addStep(ChecklistStep step) {
        this.steps.add(step);
    }

    public void removeStep(ChecklistStep step) {
        this.steps.remove(step);
    }
}
