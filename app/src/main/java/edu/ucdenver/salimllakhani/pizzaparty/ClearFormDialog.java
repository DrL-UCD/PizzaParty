package edu.ucdenver.salimllakhani.pizzaparty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class ClearFormDialog extends DialogFragment {

    private String title;
    private String message;
    private String positive;
    private String negative;

    public ClearFormDialog (String title, String message, String positive, String negative) {
        this.title = title;
        this.message = message;
        this.positive = positive;
        this.negative = negative;

    }

    public Dialog onCreateDialog (Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(title)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.clear();


                    }
                })
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });



        return builder.create();
    }
}
