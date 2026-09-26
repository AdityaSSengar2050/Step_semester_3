import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Problem2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);
        System.out.println("Song Count: " + p.getSongCount());
    }
}
