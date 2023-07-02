package ru.tvn.springcourse.FirstRestApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tvn.springcourse.FirstRestApp.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
