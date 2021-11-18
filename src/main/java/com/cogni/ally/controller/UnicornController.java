package com.cogni.ally.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.ally.exception.ResourceNotFoundException;
import com.cogni.ally.model.Unicorn;
import com.cogni.ally.repository.IdentifiableMarkRepository;
import com.cogni.ally.repository.UnicornRepository;

@RestController
@RequestMapping()
public class UnicornController {
	
	@Autowired
    private UnicornRepository unicornRepository;
	
	@Autowired
    private IdentifiableMarkRepository identifiableMarkRepository;

    @GetMapping("/unicorns")
    public List < Unicorn > getAllUnicorns() {
        return unicornRepository.findAll();
    }

    @GetMapping("/unicorns/{id}")
    public ResponseEntity < Unicorn > getUnicornById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Unicorn unicorn = unicornRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Unicorn not found for this id :: " + id));
        return ResponseEntity.ok().body(unicorn);
    }
    
    @PostMapping(path="/unicorns", produces = "application/json")
    public ResponseEntity<Object> createUnicorn(@RequestBody Unicorn unicorn) {
  	
    	if( unicorn.getIdentifiableMarks().size() > 0 )
        {
            unicorn.getIdentifiableMarks().stream().forEach( im -> {
                im.setUnicorn(unicorn);
            } );
        }
        Unicorn ucorn=unicornRepository.save(unicorn);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "unicornId", ucorn.getUnicornId()));
    }

    @PutMapping("/unicorns/{id}")
    public ResponseEntity < Unicorn > updateUnicorn(@PathVariable(value = "id") Long id,
        @RequestBody Unicorn unicornDetails) throws ResourceNotFoundException {
        Unicorn unicorn = unicornRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Unicorn not found for this id :: " + id));
        
        identifiableMarkRepository.findByUnicornUnicornId(id).forEach(im -> {
        	im.setUnicorn(null);
        	identifiableMarkRepository.save(im);});
        
        unicorn.setUnicornId(id);

        unicorn.setName(unicornDetails.getName());
        unicorn.setHairColor(unicornDetails.getHairColor());
        unicorn.setHornLength(unicornDetails.getHornLength());
        unicorn.setHornColor(unicornDetails.getHornColor());
        unicorn.setEyeColor(unicornDetails.getEyeColor());
        unicorn.setHeight(unicornDetails.getHeight());
        unicorn.setHeightUnit(unicornDetails.getHeightUnit());
        unicorn.setWeight(unicornDetails.getWeight());
        unicorn.setWeightUnit(unicornDetails.getWeightUnit());
        unicorn.setIdentifiableMarks(unicornDetails.getIdentifiableMarks());
        if( unicorn.getIdentifiableMarks().size() > 0 )
        {
            unicorn.getIdentifiableMarks().stream().forEach( im -> {
                im.setUnicorn(unicorn);
            } );
        }
        
        final Unicorn updatedUnicorn = unicornRepository.save(unicorn);
        return ResponseEntity.ok(updatedUnicorn);
    }
	

}
