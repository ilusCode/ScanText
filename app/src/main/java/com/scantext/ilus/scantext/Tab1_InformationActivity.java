package com.scantext.ilus.scantext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Tab1_InformationActivity extends Fragment {

    Bitmap bmp;
    ImageView img;
    Intent i;
    static int cons=0;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab1_information, container, false);

        //init(v);
        ImageButton btnFacebook=(ImageButton) v.findViewById(R.id.btnFacebook);
        ImageButton btnWEP=(ImageButton) v.findViewById(R.id.btnPaginaWEP);
        ImageButton btnTwietter=(ImageButton) v.findViewById(R.id.btnTwietter);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int id=view.getId();
                switch (id){
                    case R.id.btnFacebook:
                        Uri uri1 = Uri.parse("fb://page/142916543042834");
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                        startActivity(intent1);
                        break;
                }
            }
        });
       /* btnWEP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int id=view.getId();
                switch (id){
                    case R.id.btnPaginaWEP:
                         Uri uri2 = Uri.parse("https://www.scantext.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri2);
        startActivity(intent);

                        break;
                }
            }
        });*/
        btnTwietter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int id=view.getId();
                switch (id){
                    case R.id.btnTwietter:
                        Uri uri3 = Uri.parse("https://twitter.com/IlusCode");
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                        startActivity(intent3);
                        break;
                }
            }
        });

        return v;
    }

}
