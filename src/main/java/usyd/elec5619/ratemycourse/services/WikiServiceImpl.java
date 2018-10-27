package usyd.elec5619.ratemycourse.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.DAO.WikiDAO;
import usyd.elec5619.ratemycourse.domain.Wiki;

import java.util.List;

@Service("WikiService")
public class WikiServiceImpl implements WikiService{
    @Autowired
    private WikiDAO wikiDAO;

    @Override
    public List<Wiki> findAll() {
        return wikiDAO.findAll();
    }

//    @Override
//    public List<Wiki> findAllByCourseId(String courseId) {
//        return wikiDAO.findAllByCourseId(courseId);
//    }
}
