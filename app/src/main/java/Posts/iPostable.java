package Posts;

import android.media.Image;


import java.util.Date;

public interface iPostable {
    Date fecha = null;
    String Comment = null;
    Byte[] Photo = null;

    void savePost();
}
