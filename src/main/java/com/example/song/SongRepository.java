// Write your code here

package com.example.song;

import java.util.*;

public interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongbyId(int songId);

    Song addSongs(Song sing);

    Song putSongs(int songId, Song s);

    void delSongs(int songId);
}