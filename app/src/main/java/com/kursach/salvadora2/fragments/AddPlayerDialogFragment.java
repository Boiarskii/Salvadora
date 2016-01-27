package com.kursach.salvadora2.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.kursach.salvadora2.GameInfo;
import com.kursach.salvadora2.R;


public class AddPlayerDialogFragment extends DialogFragment {

    private static final String PLAYER_NUMBER = "playerNumber";
    private static final String PORTRAIT_NUMBER = "portraitNumber";

    private EditText etAddPlayer;
    private ImageView nextButtonAddPlayer;

    private int playerNumber;
    private int portraitNumber;

    private GameInfo gameInfo;


    public AddPlayerDialogFragment() {

    }

    public static AddPlayerDialogFragment newInstance(int playerNumber, int portraitNumber) {
        AddPlayerDialogFragment addPlayerDialogFragment = new AddPlayerDialogFragment();
        Bundle args = new Bundle();
        args.putInt(PLAYER_NUMBER, playerNumber);
        args.putInt(PORTRAIT_NUMBER, portraitNumber);
        addPlayerDialogFragment.setArguments(args);
        return addPlayerDialogFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Удаляю фон
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Dialog dialog = super.onCreateDialog(savedInstanceState);

        //Отключаем фон
        dialog.requestWindowFeature(DialogFragment.STYLE_NO_TITLE);


        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_add_player, null);
        dialog.setCancelable(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(v);


        etAddPlayer = (EditText) v.findViewById(R.id.etAddPlayer);
        nextButtonAddPlayer = (ImageView) v.findViewById(R.id.nextButtonAddPlayer);

        playerNumber = getArguments().getInt(PLAYER_NUMBER);
        portraitNumber = getArguments().getInt(PORTRAIT_NUMBER);

        gameInfo = GameInfo.getInstance();

        nextButtonAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((etAddPlayer.getText() != null) && !(etAddPlayer.getText().toString().equals(""))) {
                    //Если это первый выбранный персонаж, он становится ведущим
                    if (playerNumber == 1) {
                        gameInfo.addPlayer(etAddPlayer.getText().toString(), portraitNumber, true);
                        dismiss();
                    } else if (playerNumber < gameInfo.getPlayersCount()) {
                        gameInfo.addPlayer(etAddPlayer.getText().toString(), portraitNumber, false);
                        dismiss();
                    } else {
                        gameInfo.addPlayer(etAddPlayer.getText().toString(), portraitNumber, false);
                        //Старт нового активити
                        dismiss();
                        getActivity().finish();
                    }
                }
            }
        });

        return dialog;
    }


}
