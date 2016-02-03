package com.kursach.salvadora2;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AssociationDialogFragment extends DialogFragment {

    EditText etAssociationDialog;
    ImageView nextButtonAssociation;

    public AssociationDialogFragment() {

    }

    @Override
    public void onResume() {
        //Удаляю фон
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
        super.onResume();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);

        //Отключаем фон
        dialog.requestWindowFeature(DialogFragment.STYLE_NO_TITLE);

        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_association, null);

        dialog.setContentView(v);
        dialog.setCancelable(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        });
        dialog.setCanceledOnTouchOutside(false);

        final GameActivity activity = (GameActivity) getActivity();

        etAssociationDialog = (EditText) v.findViewById(R.id.etAssociationDialog);
        nextButtonAssociation = (ImageView) v.findViewById(R.id.nextButtonAssociation);

        nextButtonAssociation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(etAssociationDialog.getText().toString().equals(""))) {
                    activity.setAssociation(etAssociationDialog.getText().toString());
                    activity.nextStep();
                    dismiss();
                }
            }
        });

        return dialog;
    }
}
