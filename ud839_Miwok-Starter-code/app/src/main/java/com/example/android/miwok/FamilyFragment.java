package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    private final ArrayList<Word> FamilyMembers = new ArrayList<Word>();
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback because your Audio Focus was
                        // As we are listening to pronunciation we want it to start
                        // from the beginning and the same with the Transine_Can_Duck case
                        //even in lower sounds we want it to pause and resume by playing from the
                        // and go back to initial position
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                        // temporarily stolen, but will be back soon.
                        // i.e. for a phone call
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Stop playback, because you lost the Audio Focus.
                        // i.e. the user started some other playback app
                        // Remember to unregister your controls/buttons here.
                        // And release the kra — Audio Focus!
                        // You’re done.
                        releaseMediaPlayer();

                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback, because you hold the Audio Focus
                        // again!
                        // i.e. the phone call ended or the nav directions
                        // are finished
                        // If you implement ducking and lower the volume, be
                        // sure to return it to normal here, as well.
                        mMediaPlayer.start();
                    }
                }
            };




    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mAudioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        View rootView = inflater.inflate(R.layout.word_list, container, false);
        FamilyMembers.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        FamilyMembers.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        FamilyMembers.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        FamilyMembers.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        FamilyMembers.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        FamilyMembers.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        FamilyMembers.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        FamilyMembers.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        FamilyMembers.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        FamilyMembers.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdaptor FamilyAdaptor = new WordAdaptor(getActivity(),FamilyMembers,R.color.category_family);
        ListView FamilyView = (ListView)rootView.findViewById(R.id.list);
        FamilyView.setAdapter(FamilyAdaptor);

        FamilyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word family = FamilyMembers.get(position);

                //Release the existing media file if we are about to play a different file.
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request temporary focus as our audio files are very small.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mMediaPlayer = MediaPlayer.create(getActivity(), family.getmAudioResourceId());
                    mMediaPlayer.start();

                    /*
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                    }
                    });
                    has finished playing
                    */

                    /*
                    or if we don't want to create object every single time we can define it at the top
                    as global variable
                    Set up the listener so that we can release and stop the audio file once the sound
                    */
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }


            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            //abandon the audio focus when the media file is released
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

}
