package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersFragment extends Fragment {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releseMediaPlayer();
            }
        }
    };

    public NumbersFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container,false);

        mAudioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Lutti","One", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Otiiko","Two",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Tolookosu","Three",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Oyyisa","Four",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Massokka","Five",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Temmokka","Six",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("Kenekaku","Seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("Kawinta","Eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("Wo'e","Nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("Na'aacha","Ten",R.drawable.number_ten,R.raw.number_ten));

        //LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

//        for(int i = 0; i < words.size(); i++){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        WordAdapter itemsAdapter = new WordAdapter(getActivity(),words,R.color.category_numbers);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer = MediaPlayer.create(getActivity(),word.getmAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


        return rootView;
    }

    private void releseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releseMediaPlayer();
    }
}
