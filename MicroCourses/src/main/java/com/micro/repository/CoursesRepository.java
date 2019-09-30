package com.micro.repository;

import com.micro.model.Courses;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CoursesRepository extends ReactiveMongoRepository<Courses,String> {

}
