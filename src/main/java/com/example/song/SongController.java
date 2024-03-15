/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.song;

import com.example.song.SongService;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class SongController {
    SongService service = new SongService();


    @DeleteMapping("/songs/{songId}")

    public void delSongs(@PathVariable("songId") int songId){
        service.delSongs(songId);
    }


    @PutMapping("/songs/{songId}")
    public Song putSongs(@PathVariable("songId") int songId, @RequestBody Song s) {
        return service.putSongs(songId, s);
    }

    @PostMapping("/songs")
    public Song addSongs(@RequestBody Song sing) {
        return service.addSongs(sing);
    }

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return service.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongbyId(@PathVariable("songId") int songId) {
        return service.getSongbyId(songId);
    }

}
