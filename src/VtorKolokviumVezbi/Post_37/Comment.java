package VtorKolokviumVezbi.Post_37;

public class Comment extends Post {
    private String commentId;
    private String replyToId;
    private int likes;

    public Comment() {
    }

    public Comment(String username, String commentId, String content, String replyToId) {
        super(username, content);
        this.commentId = commentId;
        this.replyToId = replyToId;

        this.likes = 0;
    }

    public int getTotalLikes() {
        return likes + getCommentsSorted().stream().mapToInt(Comment::getTotalLikes).sum();
    }

    public String getCommentId() {
        return commentId;
    }

    public String getReplyToId() {
        return replyToId;
    }

    public int getLikes() {
        return likes;
    }

    public void like() {
        likes++;
    }

    @Override
    public void addComment(String username, String commentId, String content, String replyToId) {
        if (replyToId.equals(this.commentId)) {
            getComments().put(commentId,new Comment(username,commentId,content,replyToId));
        }else {
            getCommentsSorted().stream().forEach(comment1 -> comment1.addComment(username, commentId, content, replyToId));
        }
    }


    public String indentedToString(int level) {
        String indent = "    ".repeat(level);

        String newLine = "\n";
        StringBuilder sb = new StringBuilder();

        sb.append(indent).append("Comment: ").append(getpostContent()).append(newLine);
        sb.append(indent).append("Written by: ").append(getUsername()).append(newLine);
        sb.append(indent).append("Likes: ").append(getLikes()).append(newLine);

        getCommentsSorted().stream().forEach(comment -> sb.append(comment.indentedToString(level+1)));


        return sb.toString();
    }

    @Override
    public String toString() {
        String newLine = "\n";
        StringBuilder sb = new StringBuilder();

        sb.append("Comment: ").append(getpostContent()).append(newLine);
        sb.append("Written by: ").append(getUsername()).append(newLine);
        sb.append("Likes: ").append(getLikes());

        return sb.toString();
    }
}
