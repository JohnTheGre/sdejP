public class AdapterPatter {
    // Target Interface (what the client expects)
    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // Adaptee (existing class with incompatible interface)
    static class AdvancedMediaPlayer {
        public void playMp4(String fileName) {
            System.out.println("Playing MP4 file: " + fileName);
        }

        public void playVlc(String fileName) {
            System.out.println("Playing VLC file: " + fileName);
        }
    }

    // Adapter (makes AdvancedMediaPlayer compatible with MediaPlayer)
    static class MediaAdapter implements MediaPlayer {
        private AdvancedMediaPlayer advancedPlayer;

        public MediaAdapter(String audioType) {
            advancedPlayer = new AdvancedMediaPlayer();
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp4")) {
                advancedPlayer.playMp4(fileName);
            } else if (audioType.equalsIgnoreCase("vlc")) {
                advancedPlayer.playVlc(fileName);
            }
        }
    }

    // Client (uses the Target interface)
    static class AudioPlayer implements MediaPlayer {
        private MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {
            // Built-in support for mp3
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing MP3 file: " + fileName);
            }
            // Use adapter for other formats
            else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media type: " + audioType);
            }
        }
    }
}
