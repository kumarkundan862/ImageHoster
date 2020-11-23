package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        return commentRepository.addComment(comment);
    }

    public List<Comment> getAllCommentsByImageId(Integer imageId) {
        return commentRepository.getAllCommentsByImageId(imageId);
    }
}