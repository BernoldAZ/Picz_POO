package Posts.Room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;

import java.util.Date;

import Posts.iPostable;

@Entity (tableName = "Post")
public class PostRoom implements iPostable {
    @NonNull
    @PrimaryKey
    String name;

    String Comment;

    public PostRoom(@NonNull String name) {
        this.name = name;
    }
//Byte[] Photo; //Hay que convertirlo a un tipo de dato primitivo

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

    @Override
    public void savePost(PostDataBase db, PostRoom post) {
        db.PostDAO().insert(post);
    }
}
