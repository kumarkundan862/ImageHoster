package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Date;



@Controller
public class CommentController {


    @Autowired
    private ImageService imageService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments")
    public String commentSubmit(@PathVariable("imageId") Integer imageId,@PathVariable("imageTitle") String imageTitle,
                                @RequestParam("comment") String  comment, HttpSession session) {

        User user = (User) session.getAttribute("loggeduser");
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setText(comment);
        newComment.setDate(new Date());
        Image image = imageService.getImage(imageId);
        newComment.setImage(image);
        commentService.addComment(newComment);

        return ("redirect:/images" +"/" + imageId+"/" +imageTitle);
    }
}
