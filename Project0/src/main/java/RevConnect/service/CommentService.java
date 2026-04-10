package RevConnect.service;

import java.util.List;
import RevConnect.CustomExceptions.*;
import RevConnect.dao.CommentDAOImp;
import RevConnect.model.Comment;
import RevConnect.dao.LikeDAOImp;

public class CommentService {

    CommentDAOImp commentDAO = new CommentDAOImp();
    LikeDAOImp likeDAO = new LikeDAOImp(); 

    public String addComment(Comment comment) throws PostNotFoundException {

        try {
            if (!likeDAO.postExists(comment.getPostId())) {
                throw new PostNotFoundException("Post does not exist!");
            }

            commentDAO.addComment(comment);
            return "Comment added!";

        } catch (PostNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding comment!";
        }
    }

    public List<Comment> viewComments(int postId) throws PostNotFoundException {

        try {
            if (!likeDAO.postExists(postId)) {
                throw new PostNotFoundException("Post does not exist!");
            }
            return commentDAO.getCommentsByPost(postId);
        } catch (PostNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String deleteComment(int commentId, int userId) throws CommentNotFoundException, UnauthorizedException {

        try {
            if (!commentDAO.commentExists(commentId)) {
                throw new CommentNotFoundException("Comment not found!");
            }
            int rows=commentDAO.deleteComment(commentId, userId);

            if (rows==0) {
                throw new UnauthorizedException("You can only delete your own comment!");
            }

            return "Comment deleted!";

        } catch (CommentNotFoundException | UnauthorizedException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting comment!";
        }
    }
}
