package com.martiandeveloper.tictactoe.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.martiandeveloper.tictactoe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // UI Components
    // MaterialCardView
    @BindView(R.id.activity_main_firstCV)
    MaterialCardView activity_main_firstCV;
    @BindView(R.id.activity_main_secondCV)
    MaterialCardView activity_main_secondCV;
    @BindView(R.id.activity_main_thirdCV)
    MaterialCardView activity_main_thirdCV;
    @BindView(R.id.activity_main_fourthCV)
    MaterialCardView activity_main_fourthCV;
    @BindView(R.id.activity_main_fifthCV)
    MaterialCardView activity_main_fifthCV;
    @BindView(R.id.activity_main_sixthCV)
    MaterialCardView activity_main_sixthCV;
    @BindView(R.id.activity_main_seventhCV)
    MaterialCardView activity_main_seventhCV;
    @BindView(R.id.activity_main_eighthCV)
    MaterialCardView activity_main_eighthCV;
    @BindView(R.id.activity_main_ninthCV)
    MaterialCardView activity_main_ninthCV;
    // MaterialTextView
    @BindView(R.id.activity_main_turnTV)
    MaterialTextView activity_main_turnTV;
    @BindView(R.id.activity_main_bannerAdFL)
    FrameLayout activity_main_bannerAdFL;

    // String
    @BindString(R.string.your_turn)
    String your_turn;
    @BindString(R.string.androids_turn)
    String androids_turn;
    @BindString(R.string.you_win)
    String you_win;
    @BindString(R.string.android_win)
    String android_win;
    @BindString(R.string.equal)
    String equal;
    @BindString(R.string.app_link)
    String app_link;
    @BindString(R.string.tictactoe_main_banner)
    String tictactoe_main_banner;

    // Variables
    // Integer
    private int activePlayer, selectedId, winner;
    // List
    private List<Integer> player1SelectedList, player2SelectedList, availableCards;
    // MediaPLayer
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initialFunctions();
    }

    private void initialFunctions() {
        declareVariables();
        setActivePlayer();
        setPlayerTurn();
        setAds();
    }

    private void declareVariables() {
        // List
        player1SelectedList = new ArrayList<>();
        player2SelectedList = new ArrayList<>();
        availableCards = new ArrayList<>();
        // MediaPlayer
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.click);
    }

    private void setActivePlayer() {
        Random random = new Random();
        activePlayer = random.nextInt(2) + 1;
    }

    private void setPlayerTurn() {
        if (activePlayer == 1) {
            activity_main_turnTV.setText(your_turn);
            activity_main_turnTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        } else {
            activity_main_turnTV.setText(androids_turn);
            activity_main_turnTV.setTextColor(getResources().getColor(R.color.colorTwo));
            autoPlay();
        }
    }

    private void setAds() {
        MobileAds.initialize(this);
        AdView adView = new AdView(this);
        adView.setAdUnitId(tictactoe_main_banner);
        activity_main_bannerAdFL.addView(adView);

        AdRequest bannerAdRequest = new AdRequest.Builder().build();
        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);
        adView.loadAd(bannerAdRequest);
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }

    @OnClick(R.id.activity_main_firstCV)
    public void activity_main_firstCVClicked() {
        if (activePlayer == 1) {
            selectedId = 1;
            setStrokeColor(activity_main_firstCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_secondCV)
    public void activity_main_secondCVClicked() {
        if (activePlayer == 1) {
            selectedId = 2;
            setStrokeColor(activity_main_secondCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_thirdCV)
    public void activity_main_thirdCVClicked() {
        if (activePlayer == 1) {
            selectedId = 3;
            setStrokeColor(activity_main_thirdCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_fourthCV)
    public void activity_main_fourthCVClicked() {
        if (activePlayer == 1) {
            selectedId = 4;
            setStrokeColor(activity_main_fourthCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_fifthCV)
    public void activity_main_fifthCVClicked() {
        if (activePlayer == 1) {
            selectedId = 5;
            setStrokeColor(activity_main_fifthCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_sixthCV)
    public void activity_main_sixthCVClicked() {
        if (activePlayer == 1) {
            selectedId = 6;
            setStrokeColor(activity_main_sixthCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_seventhCV)
    public void activity_main_seventhCVClicked() {
        if (activePlayer == 1) {
            selectedId = 7;
            setStrokeColor(activity_main_seventhCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_eighthCV)
    public void activity_main_eighthCVClicked() {
        if (activePlayer == 1) {
            selectedId = 8;
            setStrokeColor(activity_main_eighthCV);

            startMusic();
        }
    }

    @OnClick(R.id.activity_main_ninthCV)
    public void activity_main_ninthCVClicked() {
        if (activePlayer == 1) {
            selectedId = 9;
            setStrokeColor(activity_main_ninthCV);

            startMusic();
        }
    }

    private void setStrokeColor(MaterialCardView materialCardView) {
        if (activePlayer == 1) {
            materialCardView.setStrokeWidth(4);
            materialCardView.setStrokeColor(getResources().getColor(R.color.colorPrimaryDark));

            player1SelectedList.add(selectedId);
            activePlayer = 2;

            if (!checkWinner()) {
                setPlayerTurn();
            }
        } else {
            materialCardView.setStrokeWidth(4);
            materialCardView.setStrokeColor(getResources().getColor(R.color.colorTwo));

            player2SelectedList.add(selectedId);
            activePlayer = 1;

            setPlayerTurn();

            checkWinner();
        }

        materialCardView.setEnabled(false);
    }

    private boolean checkWinner() {
        if (player1SelectedList.contains(1) && player1SelectedList.contains(2) && player1SelectedList.contains(3)) {
            winner = 1;
        } else if (player1SelectedList.contains(4) && player1SelectedList.contains(5) && player1SelectedList.contains(6)) {
            winner = 1;
        } else if (player1SelectedList.contains(7) && player1SelectedList.contains(8) && player1SelectedList.contains(9)) {
            winner = 1;
        } else if (player1SelectedList.contains(1) && player1SelectedList.contains(4) && player1SelectedList.contains(7)) {
            winner = 1;
        } else if (player1SelectedList.contains(2) && player1SelectedList.contains(5) && player1SelectedList.contains(8)) {
            winner = 1;
        } else if (player1SelectedList.contains(3) && player1SelectedList.contains(6) && player1SelectedList.contains(9)) {
            winner = 1;
        } else if (player1SelectedList.contains(1) && player1SelectedList.contains(5) && player1SelectedList.contains(9)) {
            winner = 1;
        } else if (player1SelectedList.contains(3) && player1SelectedList.contains(5) && player1SelectedList.contains(7)) {
            winner = 1;
        } else if (player2SelectedList.contains(1) && player2SelectedList.contains(2) && player2SelectedList.contains(3)) {
            winner = 2;
        } else if (player2SelectedList.contains(4) && player2SelectedList.contains(5) && player2SelectedList.contains(6)) {
            winner = 2;
        } else if (player2SelectedList.contains(7) && player2SelectedList.contains(8) && player2SelectedList.contains(9)) {
            winner = 2;
        } else if (player2SelectedList.contains(1) && player2SelectedList.contains(4) && player2SelectedList.contains(7)) {
            winner = 2;
        } else if (player2SelectedList.contains(2) && player2SelectedList.contains(5) && player2SelectedList.contains(8)) {
            winner = 2;
        } else if (player2SelectedList.contains(3) && player2SelectedList.contains(6) && player2SelectedList.contains(9)) {
            winner = 2;
        } else if (player2SelectedList.contains(1) && player2SelectedList.contains(5) && player2SelectedList.contains(9)) {
            winner = 2;
        } else if (player2SelectedList.contains(3) && player2SelectedList.contains(5) && player2SelectedList.contains(7)) {
            winner = 2;
        } else {
            List<Integer> enableCards = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                if (!player1SelectedList.contains(i) && !player2SelectedList.contains(i)) {
                    enableCards.add(i);
                }
            }

            if (enableCards.isEmpty()) {
                showFinishDialog(equal, getResources().getColor(R.color.colorAccent));
                return true;
            }
        }


        if (winner != 0) {
            if (winner == 1) {
                showFinishDialog(you_win, getResources().getColor(R.color.colorPrimaryDark));
                return true;
            } else {
                showFinishDialog(android_win, getResources().getColor(R.color.colorTwo));
                return true;
            }
        } else {
            return false;
        }
    }

    private void showFinishDialog(String winner, int color) {
        final AlertDialog dialog_finish = new AlertDialog.Builder(this).create();
        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.dialog_finish, null);

        MaterialTextView dialog_finish_winTV = view.findViewById(R.id.dialog_finish_winTV);
        MaterialButton dialog_finish_restartBTN = view.findViewById(R.id.dialog_finish_restartBTN);
        MaterialButton dialog_finish_exitBTN = view.findViewById(R.id.dialog_finish_exitBTN);

        dialog_finish_winTV.setText(winner);
        dialog_finish_winTV.setTextColor(color);

        dialog_finish_restartBTN.setOnClickListener(v -> {
            dialog_finish.dismiss();
            Intent intent = getIntent();
            MainActivity.this.finish();
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        dialog_finish_exitBTN.setOnClickListener(v -> {
            dialog_finish.dismiss();
            MainActivity.this.finish();
        });

        dialog_finish.setView(view);
        dialog_finish.setCanceledOnTouchOutside(false);
        dialog_finish.setCancelable(false);
        dialog_finish.show();
    }

    private void autoPlay() {
        new Handler().postDelayed(() -> {
            for (int i = 1; i < 10; i++) {
                if (!player1SelectedList.contains(i) && !player2SelectedList.contains(i)) {
                    availableCards.add(i);
                }
            }

            Random random = new Random();
            int randomIndex = random.nextInt(availableCards.size());
            int selected = availableCards.get(randomIndex);

            switch (selected) {
                case 1:
                    if (activity_main_firstCV.isEnabled()) {
                        selectedId = 1;
                        setStrokeColor(activity_main_firstCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 2:
                    if (activity_main_secondCV.isEnabled()) {
                        selectedId = 2;
                        setStrokeColor(activity_main_secondCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 3:
                    if (activity_main_thirdCV.isEnabled()) {
                        selectedId = 3;
                        setStrokeColor(activity_main_thirdCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 4:
                    if (activity_main_fourthCV.isEnabled()) {
                        selectedId = 4;
                        setStrokeColor(activity_main_fourthCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 5:
                    if (activity_main_fifthCV.isEnabled()) {
                        selectedId = 5;
                        setStrokeColor(activity_main_fifthCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 6:
                    if (activity_main_sixthCV.isEnabled()) {
                        selectedId = 6;
                        setStrokeColor(activity_main_sixthCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 7:
                    if (activity_main_seventhCV.isEnabled()) {
                        selectedId = 7;
                        setStrokeColor(activity_main_seventhCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 8:
                    if (activity_main_eighthCV.isEnabled()) {
                        selectedId = 8;
                        setStrokeColor(activity_main_eighthCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
                case 9:
                    if (activity_main_ninthCV.isEnabled()) {
                        selectedId = 9;
                        setStrokeColor(activity_main_ninthCV);

                        startMusic();
                    } else {
                        autoPlay();
                    }
                    break;
            }
        }, 1000);
    }

    private void startMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @OnClick(R.id.activity_main_aboutTV)
    public void activity_main_aboutTVClicked() {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.activity_main_rateUsTV)
    public void activity_main_rateUsTVClicked() {
        Uri open_uri = Uri.parse(app_link);
        Intent open_intent = new Intent(Intent.ACTION_VIEW, open_uri);
        startActivity(open_intent);
    }
}
