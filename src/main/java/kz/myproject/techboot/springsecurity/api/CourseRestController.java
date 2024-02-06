package kz.myproject.techboot.springsecurity.api;


import kz.myproject.techboot.springsecurity.Service.CourseService;
import kz.myproject.techboot.springsecurity.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/course")
public class CourseRestController {
    private final CourseService courseService;
    @GetMapping
    public List<Course> courseList(){
        return courseService.getCourses();
    }


}
