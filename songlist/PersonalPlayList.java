package songlist;

public class PersonalPlayList extends PlayList {    // PlayList를 상속받으며 
    public void remove(Song song){                  // 노래를 제거하는 메소드 remove(Song)
        getTracks().remove(song);                   // track -> List<Song> 이므로, remove 메소드 가능
        getSingers().remove(song.getSinger());      // 
    }
}
