package dhbw.lectures.webe.controller;

import dhbw.lectures.webe.domain.Checklist;
import dhbw.lectures.webe.domain.Inspection;
import dhbw.lectures.webe.domain.InspectionStep;
import dhbw.lectures.webe.repository.InspectionRepository;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully found Inspections", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
    })
    public List<Inspection> getAllInspections() {
        return inspectionRepository.findAll();
    }
    
    @PostMapping
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully Created Inspections", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
    })
    public Inspection createInspection(@RequestBody Inspection inspection) {
        return inspectionRepository.save(inspection);
    }
    
    @PostMapping("/{id}/steps")
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully Created Inspectionstep", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
        @ApiResponse(responseCode = "404", description = "Inspection not found", content = @Content)
    })
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
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully Updated Inspectionstep", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
        @ApiResponse(responseCode = "404", description = "Inspection or StepID not found", content = @Content)
    })
    public Inspection updateStepInInspection(@PathVariable Long id, @PathVariable Long stepId, @RequestBody InspectionStep inspectionStep) {
        Optional<Inspection> inspection = inspectionRepository.findById(id);
        if (inspection.isPresent()) {
            Inspection i = inspection.get();
            for (int j = 0; j < i.getSteps().size(); j++) {
                if (i.getSteps().get(j).getId().equals(stepId)) {
                    InspectionStep existingStep = i.getSteps().get(j);
                    // Nur die relevanten Felder aktualisieren (ID bleibt unverändert)
                    existingStep.setStatus(inspectionStep.getStatus());
                    existingStep.setComment(inspectionStep.getComment());
                    existingStep.setPhotoPath(inspectionStep.getPhotoPath());
                    // checklistStep wird wahrscheinlich nicht geändert, aber falls nötig: existingStep.setChecklistStep(inspectionStep.getChecklistStep());
                    return inspectionRepository.save(i);
                }
            }
        }
        return null;
    }
    
    @DeleteMapping("/{id}/steps/{stepId}")
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully Deleted Inspectionstep", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
        @ApiResponse(responseCode = "404", description = "Inspection or StepID not found", content = @Content)
    })
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
