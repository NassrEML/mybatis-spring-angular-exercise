package com.nassreml.springchallenge.api;

import com.nassreml.springchallenge.model.Course;
import com.nassreml.springchallenge.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RequestMapping("api/v1/courses")
@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        try {
            return buildResponse(HttpStatus.CREATED, courseService.addCourse(course));
        } catch (Exception e) {
            return buildResponse(HttpStatus.CONFLICT, "{ \"message\": \"There was a problem, couldn't create course\" }");
        }
    }

    @GetMapping
    public ResponseEntity getAllCourses() {
        try {
            return buildResponse(HttpStatus.OK, courseService.getAllCourses());
        } catch (Exception e) {
            return buildResponse(HttpStatus.CONFLICT, "{ \"message\": \"Couldn't get courses\" }");
        }
    }

    private <T> ResponseEntity<T> buildResponse(HttpStatus _status, T _body) {
        return ResponseEntity.status(_status)
                .headers(setHeaders())
                .body(_body);
    }

    private HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return headers;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions( MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
