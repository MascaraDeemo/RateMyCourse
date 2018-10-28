package usyd.elec5619.ratemycourse.services;


import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.Wiki;
import java.util.List;

public interface WikiService {
    List<Wiki> findAll();

    void deleteById(int id);

    Wiki findById(int id);

    void saveOrUpdate(Wiki wiki);
}
