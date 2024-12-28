package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.course;
import com.example.demo.repository.Courserepository;

@RestController
@RequestMapping("/api/v1")

@CrossOrigin(origins = "http://localhost:4200")

public class Coursecontroller {
	@Autowired
	private Courserepository courserepository;
	@GetMapping("/course")
	public List<course> getALLcourses() {
	    try {
	        return courserepository.findAll();
	    } catch (Exception e) {
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching courses", e);
	    }
	}
	
	
	// get course by id

			@GetMapping("/course/{id}")
			public ResponseEntity<course> getcourseById(@PathVariable long id) {
			    course course = courserepository.findById(id)
			        .orElseThrow( );
			    return ResponseEntity.ok(course);
			}
			// creer cours
			@PostMapping("/course")
			public ResponseEntity<course> createCourse(@RequestBody course course) {
			    if (course.getId() != null && courserepository.existsById(course.getId())) {
			        throw new IllegalArgumentException("Course already exists");
			    }
			    return ResponseEntity.ok(courserepository.save(course));
			}
	// modifier cours
	@PutMapping("/course/{id}")
	public ResponseEntity<course> updatecourse(  @PathVariable  long id, @RequestBody course coursedetails){
    
		   course course = courserepository.findById(id)
				  
			        .orElseThrow( );
			   course.setTitle(coursedetails.getTitle());
			   course.setDescription(coursedetails.getDescription());
			   course.setPrice(coursedetails.getPrice());
			   course.setImageUrl(coursedetails.getImageUrl());
			  
			course updatedcourse =courserepository.save(course);
			   return ResponseEntity.ok(updatedcourse);
				   }    
	@DeleteMapping("/course/{id}")
    public ResponseEntity<Map<String, Boolean>> deletecourse(@PathVariable long id) {
		  course course = courserepository.findById(id)
				  
			        .orElseThrow( );

		  courserepository.delete(course);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
	  
	
	
	

}


