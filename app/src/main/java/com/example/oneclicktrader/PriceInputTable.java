package com.example.oneclicktrader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;



import androidx.appcompat.app.AppCompatDialogFragment;

public class PriceInputTable extends AppCompatDialogFragment {
    private EditText price;
    private PriceListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inf = getActivity().getLayoutInflater();
        View view = inf.inflate(R.layout.price_input_table, null);
        builder.setView(view).setTitle("Offer Price")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double priceOffered = Double.parseDouble(price.getText().toString());
                        listener.setOfferedPrice(priceOffered);
                    }
                });

        price = view.findViewById(R.id.offer);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (PriceListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "implement PriceListener");
        }

    }

    public interface PriceListener {
        void setOfferedPrice(double priceOffered);
    }
}
