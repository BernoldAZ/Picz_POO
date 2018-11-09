package Posts;

import android.media.Image;


import java.util.Date;

import Posts.Room.PostDataBase;
import Posts.Room.PostRoom;

public interface iPostable {

     void savePost(PostDataBase db, PostRoom post);
     // {
      //  db.PostDAO().insert(post);
        // return post;

}
