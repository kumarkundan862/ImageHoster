package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment addComment(Comment comment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }

    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i", Comment.class);
            List<Comment> resultList = query.getResultList();
            return resultList;
        } catch (NoResultException nre) {
            return null;
        }
    }


        public List<Comment> getAllCommentsByImageId(Integer imageId){
            EntityManager em = emf.createEntityManager();
            try {
                TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i where i.image.id=:ParamImageId", Comment.class).setParameter("ParamImageId", imageId);
                List<Comment> resultList = query.getResultList();
                return resultList;
            } catch (NoResultException nre) {
                return null;
            }



    }



}