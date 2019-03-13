package model_rework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongPlayerModel extends Model {

	private Song currentSong;
	private List<Song> currentList;
	private List<Song> finishedList;
	private boolean repeating;
	private boolean shuffle;

	public SongPlayerModel () {
		currentSong = null;
		repeating = false;
		shuffle = false;
	}

	public void playSong(List<Song> currentList) {
		this.currentList = new ArrayList<>(currentList);
		finishedList = new ArrayList<>();
		currentSong = this.currentList.get(0);
		this.currentList.remove(0);
		Notify();
	}

	public boolean playNextSong() {

		finishedList.add(currentSong);

		if (!shuffle) {
			if (!currentList.isEmpty()) {
				currentSong = currentList.get(0);
				currentList.remove(0);
			} else if (currentList.isEmpty() && repeating) {
				repeatFinishedSongs();
				currentSong = currentList.get(0);
				currentList.remove(0);
			}
			else {
				return false;
			}
		} else {
			if (!currentList.isEmpty()) {
				int randomindex = getRandonIndexInCurList();
				currentSong = currentList.get(randomindex);
				currentList.remove(randomindex);
			}
			else {
				return false;
			}
		}
		Notify();

		return true;

	}

	private int getRandonIndexInCurList() {

		ArrayList randompool = new ArrayList();
		for (int i=0; i<currentList.size(); i++) {
			randompool.add(i);
		}
		Collections.shuffle(randompool);

		int selected = (Integer) randompool.get(0);

		return selected;
	}

	public boolean playPreviousSong() {

		if (!finishedList.isEmpty()) {
			currentList.add(0, currentSong);
			Song backsong = finishedList.get(finishedList.size() - 1);
			finishedList.remove(finishedList.size() - 1);
			currentSong = backsong;
		}
		else  {
			return false;
		}
		return true;
	}



	private void repeatFinishedSongs () {
		currentList = new ArrayList<>(finishedList);
		finishedList.clear();
	}

	public Song getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}

	public List<Song> getCurrentList() {
		return currentList;
	}


	public List<Song> getFinishedList() {
		return finishedList;
	}


	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(boolean repeating) {
		this.repeating = repeating;
	}

	public boolean isShuffle() {
		return shuffle;
	}

	public void setShuffle(boolean shuffled) {
		this.shuffle = shuffled;
	}




}
