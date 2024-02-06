package kz.myproject.techboot.springsecurity.Service;

import kz.myproject.techboot.springsecurity.model.Course;
import kz.myproject.techboot.springsecurity.repository.CourseRepostiory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepostiory courseRepostiory;
    public List<Course> getCourses(){
        return courseRepostiory.findAll();
    }
    public Course addCourse(Course course){
        return courseRepostiory.save(course);
    }
}
