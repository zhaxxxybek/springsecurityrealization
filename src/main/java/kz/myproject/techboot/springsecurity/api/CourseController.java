package kz.myproject.techboot.springsecurity.api;

import kz.myproject.techboot.springsecurity.Service.CourseService;
import kz.myproject.techboot.springsecurity.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {
    private final CourseService courseService;
    @GetMapping(value = "/get-course-list")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
    @PostMapping(value = "/add-course")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }




}
