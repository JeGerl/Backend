package dhbw.lectures.webe.controller;

import dhbw.lectures.webe.domain.Inspection;
import dhbw.lectures.webe.domain.InspectionStep;
import dhbw.lectures.webe.repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inspections")
public class InspectionController {
    
    @Autowired
    private InspectionRepository inspectionRepository;
    
    @GetMapping
    public List<Inspection> getAllInspections() {
        return inspectionRepository.findAll();
    }
    
    @PostMapping
    public Inspection createInspection(@RequestBody Inspection inspection) {
        return inspectionRepository.save(inspection);
    }
    
    @PostMapping("/{id}/steps")
    public Inspection addStepToInspection(@PathVariable Long id, @RequestBody InspectionStep inspectionStep) {
        Optional<Inspection> inspection = inspectionRepository.findById(id);
        if (inspection.isPresent()) {
            Inspection i = inspection.get();
            i.addStep(inspectionStep);
            return inspectionRepository.save(i);
        }
        return null;
    }
    
    @PutMapping("/{id}/steps/{stepId}")
    public Inspection updateStepInInspection(@PathVariable Long id, @PathVariable Long stepId, @RequestBody InspectionStep inspectionStep) {
        Optional<Inspection> inspection = inspectionRepository.findById(id);
        if (inspection.isPresent()) {
            Inspection i = inspection.get();
            for (int j = 0; j < i.getSteps().size(); j++) {
                if (i.getSteps().get(j).getId().equals(stepId)) {
                    i.getSteps().set(j, inspectionStep);
                    return inspectionRepository.save(i);
                }
            }
        }
        return null;
    }
    
    @DeleteMapping("/{id}/steps/{stepId}")
    public Inspection removeStepFromInspection(@PathVariable Long id, @PathVariable Long stepId) {
        Optional<Inspection> inspection = inspectionRepository.findById(id);
        if (inspection.isPresent()) {
            Inspection i = inspection.get();
            i.getSteps().removeIf(step -> step.getId().equals(stepId));
            return inspectionRepository.save(i);
        }
        return null;
    }
}
