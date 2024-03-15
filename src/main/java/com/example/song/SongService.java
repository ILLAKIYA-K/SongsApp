/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniquId = 6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    @Override

    public void delSongs(int songId) {
        Song k = playlist.get(songId);
        if (k == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

    @Override
    public Song putSongs(int songId, Song s) {
        Song ks = playlist.get(songId);
        if (ks == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (s.getSongName() != null) {
            ks.setSongName(s.getSongName());
        }

        if (s.getLyricist() != null) {
            ks.setLyricist(s.getLyricist());
        }

        if (s.getMusicDirector() != null) {
            ks.setMusicDirector(s.getMusicDirector());
        }
        if (s.getSinger() != null) {
            ks.setSinger(s.getSinger());
        }
        return ks;
    }

    @Override

    public Song addSongs(Song sing) {
        sing.setSongId(uniquId);
        playlist.put(uniquId, sing);
        uniquId += 1;
        return sing;
    }

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> arr = new ArrayList<>(songCollection);
        return arr;
    }

    @Override

    public Song getSongbyId(int songId) {
        Song k = playlist.get(songId);
        if (k == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return k;
    }

}