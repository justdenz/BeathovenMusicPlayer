package dbservice;

import model.Playlist;

import java.util.List;

public class PlaylistDAODB implements PlaylistDAO {
    @Override
    public boolean addPlaylist(Playlist playlist) {
        return false;
    }

    @Override
    public boolean deletePlaylist(Playlist id) {
        return false;
    }

    @Override
    public boolean updatePlaylist(Playlist playlist) {
        return false;
    }

    @Override
    public List<Playlist> getPlaylists(int user_id) {
        return null;
    }

    @Override
    public List<Playlist> getFavoritePlaylists(int user_id) {
        return null;
    }
}