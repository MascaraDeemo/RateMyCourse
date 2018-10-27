package usyd.elec5619.ratemycourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.DAO.WikiDAO;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.interfaces.WikiService;

@Service(value="WikiDAO")
public class WikiServiceImpl implements WikiService {
    @Autowired
    WikiDAO wikiDAO;

    public Wiki findWikiByCourseId(String CourseID) {
        return wikiDAO.findByCourseID(CourseID);
    }
}
