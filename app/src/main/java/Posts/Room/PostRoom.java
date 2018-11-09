package Posts.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "Post")
public class PostRoom {
    @NonNull
    @PrimaryKey
    String name;

    String Comment;

    Long date;

    //Byte[] Photo;

    public PostRoom(@NonNull String name) {
        this.name = name;
    }
 //Hay que convertirlo a un tipo de dato primitivo

    /*@NonNull
    public Date getFecha() {
        return fecha;
    }*/

    public void setComment(String comment) {
        Comment = comment;
    }

    @NonNull
    public String getName() {

        return name;
    }

    public void setName(@NonNull String name) {

        this.name = name;
    }

    public String getComment() {
        return Comment;
    }

    public void savePost(PostDataBase db, PostRoom post) {
        db.PostDAO().insert(post);
    }
}
