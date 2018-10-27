package usyd.elec5619.ratemycourse.interfaces;

import usyd.elec5619.ratemycourse.domain.Wiki;

public interface WikiService {
    Wiki findWikiByCourseId(String CourseID);
}
