package kz.myproject.techboot.springsecurity.repository;

import kz.myproject.techboot.springsecurity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CourseRepostiory extends JpaRepository<Course,Long> {
}
