package songlist;

public class PersonalPlayList extends PlayList {
    public void remove(Song song){
        getTracks().remove(song);
    }
}
