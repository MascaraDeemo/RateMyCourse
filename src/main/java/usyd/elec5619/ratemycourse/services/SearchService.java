package usyd.elec5619.ratemycourse.services;

import usyd.elec5619.ratemycourse.domain.Course;

import java.util.List;

public interface SearchService {
    List<Course> searchById(String searchText);
    List<Course> searchByPhrase(String searchText);
}
