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

    @Override
    public Wiki findById(int id) {
        return wikiDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        wikiDAO.deleteById(id);
    }

    @Override
    public void saveOrUpdate(Wiki wiki) {
        wikiDAO.save(wiki);
    }
}
