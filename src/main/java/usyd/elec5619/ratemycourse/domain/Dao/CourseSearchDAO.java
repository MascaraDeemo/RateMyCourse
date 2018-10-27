package usyd.elec5619.ratemycourse.domain.Dao;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import usyd.elec5619.ratemycourse.domain.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseSearchDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> searchCourseNameByKeyword(String text){
        Query keywordQuery = getQueryBuilder()
                .keyword()
                .onField("courseName")
                .matching(text)
                .createQuery();
        List<Course> result = getJpaQuery(keywordQuery).getResultList();
        return result;
    }

    public List<Course> searchCourseDescByPhrase(String text){
        Query phraseQuery = getQueryBuilder()
                .phrase()
                .withSlop(1)
                .onField("courseDesc")
                .sentence(text)
                .createQuery();
        List<Course> results = getJpaQuery(phraseQuery).getResultList();
        return results;
    }

    private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        return fullTextEntityManager.createFullTextQuery(luceneQuery,Course.class);
    }

    private QueryBuilder getQueryBuilder(){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Course.class)
                .get();
    }
}
