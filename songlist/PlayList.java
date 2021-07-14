package songlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();  // key : 가수이름, value : 노래제목

    public void append(Song song){
        tracks.add(song);
        singers.put(song.getSinger(),song.getTitle());
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String,String> getSingers(){
        return singers;
    }
}
