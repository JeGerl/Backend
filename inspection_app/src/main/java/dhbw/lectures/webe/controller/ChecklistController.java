package dhbw.lectures.webe.controller;

import dhbw.lectures.webe.domain.Checklist;
import dhbw.lectures.webe.domain.ChecklistStep;
import dhbw.lectures.webe.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/checklists")
public class ChecklistController {
    
    @Autowired
    private ChecklistRepository checklistRepository;
    
    public ChecklistController() {
    }
    
    @GetMapping
    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }
    
    @PostMapping
    public Checklist createChecklist(@RequestBody Checklist checklist) {
        return checklistRepository.save(checklist);
    }
    
    @PostMapping("/{id}/steps")
    public Checklist addStepToChecklist(@PathVariable Long id, @RequestBody ChecklistStep checklistStep) {
        Optional<Checklist> checklist = checklistRepository.findById(id);
        if (checklist.isPresent()) {
            Checklist c = checklist.get();
            c.addStep(checklistStep);
            return checklistRepository.save(c);
        }
        return null;
    }
    
    @PutMapping("/{id}/steps/{stepId}")
    public Checklist updateStepInChecklist(@PathVariable Long id, @PathVariable Long stepId, @RequestBody ChecklistStep checklistStep) {
        Optional<Checklist> checklist = checklistRepository.findById(id);
        if (checklist.isPresent()) {
            Checklist c = checklist.get();
            for (int i = 0; i < c.getSteps().size(); i++) {
                if (c.getSteps().get(i).getId().equals(stepId)) {
                    c.getSteps().set(i, checklistStep);
                    return checklistRepository.save(c);
                }
            }
        }
        return null;
    }
    
    @DeleteMapping("/{id}/steps/{stepId}")
    public Checklist removeStepFromChecklist(@PathVariable Long id, @PathVariable Long stepId) {
        Optional<Checklist> checklist = checklistRepository.findById(id);
        if (checklist.isPresent()) {
            Checklist c = checklist.get();
            c.getSteps().removeIf(step -> step.getId().equals(stepId));
            return checklistRepository.save(c);
        }
        return null;
    }
}
