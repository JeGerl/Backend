package dhbw.lectures.webe.controller;

import dhbw.lectures.webe.domain.Checklist;
import dhbw.lectures.webe.domain.ChecklistStep;
import dhbw.lectures.webe.repository.ChecklistRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of checklists", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
    })
    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }
    
    @PostMapping
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully created of checklists", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
    })
    public Checklist createChecklist(@RequestBody Checklist checklist) {
        return checklistRepository.save(checklist);
    }
    
    @PostMapping("/{id}/steps")
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of checklists", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
        @ApiResponse(responseCode = "404", description = "Checklist not found", content = @Content)
    })
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
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully updated Checkliststep", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
        @ApiResponse(responseCode = "404", description = "Checklist or Step not found", content = @Content)
    })
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
    @ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Successfully removed Checkliststep", content=@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Checklist.class)))),
        @ApiResponse(responseCode = "404", description = "Checklist or Step not found", content = @Content)
    })
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
