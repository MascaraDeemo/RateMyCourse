package usyd.elec5619.ratemycourse.services;
import usyd.elec5619.ratemycourse.domain.Wiki;

public interface WikiService {
    void saveOrUpdate(Wiki wiki);
    Wiki findWikiByCourseId(String courseId);
    void saveHistory(Wiki wiki);
}
