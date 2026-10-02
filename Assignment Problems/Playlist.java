import java.util.Scanner;

public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        Playlist p = new Playlist(capacity);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String song = sc.nextLine();
            p.addSong(song);
        }
        String[] songsList = p.getSongs();
        for (int i = 0; i < songsList.length; i++) {
            System.out.println(songsList[i]);
        }
        System.out.println(p.getSongCount());
        sc.close();
    }
}