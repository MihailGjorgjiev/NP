package VtorKolokviumVezbi.Post_37;

import java.util.*;
import java.util.stream.Collectors;

public class Post {
    private String username;
    private String postContent;
    private Map<String,Comment> comments;
    public Post() {
        this.comments=new LinkedHashMap<>();
    }

    public Post(String username, String postContent) {
        this();
        this.username = username;
        this.postContent = postContent;
    }

    public String getUsername() {
        return username;
    }

    public String getpostContent() {
        return postContent;
    }

    public List<Comment> getCommentsSorted() {
        return comments.values().stream()
                .sorted(Comparator.comparing(
                        Comment::getTotalLikes,Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }


    public void addComment (String username, String commentId, String content, String replyToId){
        if(replyToId == null){
            comments.put(commentId,new Comment(username,commentId,content,replyToId));
        }else{
            getCommentsSorted().stream().forEach(comment1 -> comment1.addComment(username, commentId, content, replyToId));
        }
    }

    public Map<String, Comment> getComments() {
        return comments;
    }

    public void likeComment (String commentId){
        Comment comment = comments.getOrDefault(commentId, null);
        if(comment == null){
            getCommentsSorted().stream().forEach(comment1 -> comment1.likeComment(commentId));
        }else {
            comment.like();
        }
    }

    @Override
    public String toString() {
        int indent=0;
        String newLine="\n";
        StringBuilder sb=new StringBuilder();
        sb.append("Post: ").append(postContent).append(newLine);
        sb.append("Written by: ").append(username).append(newLine);
        sb.append("Comments:").append(newLine);
        getCommentsSorted().stream()
                .sorted(Comparator.comparing(Comment::getTotalLikes,Comparator.reverseOrder()))
                .forEach(comment -> sb.append(comment.indentedToString(indent+2)));


        return sb.toString();

    }
}
